import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocationController {
    private Connection connection;

    public LocationController(Connection connection) {
        this.connection = connection;
    }

    public void createLocation(Locations location) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Locations (address, city, state, country, zip_code) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, location.getAddress());
            statement.setString(2, location.getCity());
            statement.setString(3, location.getState());
            statement.setString(4, location.getCountry());
            statement.setInt(5, location.getZipCode());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Locations getLocationById(int locationId) {
        Locations location = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Locations WHERE location_id = ?");
            statement.setInt(1, locationId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                location = new Locations(
                        resultSet.getInt("location_id"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getString("country"),
                        resultSet.getInt("zip_code")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return location;
    }

    public List<Locations> getAllLocations() {
        List<Locations> locations = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Locations");
            while (resultSet.next()) {
                Locations location = new Locations(
                        resultSet.getInt("location_id"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getString("country"),
                        resultSet.getInt("zip_code")
                );
                locations.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }

    public void updateLocation(Locations location) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Locations SET address = ?, city = ?, state = ?, country = ?, zip_code = ? " +
                            "WHERE location_id = ?");
            statement.setString(1, location.getAddress());
            statement.setString(2, location.getCity());
            statement.setString(3, location.getState());
            statement.setString(4, location.getCountry());
            statement.setInt(5, location.getZipCode());
            statement.setInt(6, location.getLocationId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLocation(int locationId) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM Locations WHERE location_id = ?");
            statement.setInt(1, locationId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}