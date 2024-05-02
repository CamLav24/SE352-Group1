import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelController {
    private Connection connection;

    public HotelController(Connection connection) {
        this.connection = connection;
    }

    public void createHotel(Hotel hotel) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Hotels (name, location_id, price, rooms_left, description) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, hotel.getName());
            statement.setInt(2, hotel.getLocationId());
            statement.setBigDecimal(3, hotel.getPrice());
            statement.setInt(4, hotel.getRoomsLeft());
            statement.setString(5, hotel.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Hotel getHotelById(int hotelId) {
        Hotel hotel = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Hotels WHERE hotel_id = ?");
            statement.setInt(1, hotelId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                hotel = new Hotel(
                        resultSet.getInt("hotel_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("location_id"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getInt("rooms_left"),
                        resultSet.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotel;
    }

    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Hotels");
            while (resultSet.next())
