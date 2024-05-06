import java.sql.*;
public class RoomController {
    //Controls Room Avalibility
    private Connection connection;

    public RoomController(Connection connection) {
        this.connection = connection;
    }
    public boolean isRoomAvailable(Room room, Date date) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT rooms_available FROM Room_Availability WHERE hotel_id = ? AND date = ?");
            statement.setInt(1, room.getHotelId());
            statement.setDate(2, date);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int roomsAvailable = resultSet.getInt("rooms_available");
                return roomsAvailable > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkIn(Room room, Date date) {
        try {
            if (isRoomAvailable(room, date)) {
                PreparedStatement updateStatement = connection.prepareStatement(
                        "UPDATE Room_Availability SET rooms_available = rooms_available - 1 " +
                                "WHERE hotel_id = ? AND date = ?");
                updateStatement.setInt(1, room.getHotelId());
                updateStatement.setDate(2, date);
                int rowsUpdated = updateStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    // Room successfully booked
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}