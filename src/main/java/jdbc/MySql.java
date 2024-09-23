package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class MySql {

    public static void main(String[] args) {
        // Connection details
        String url = "jdbc:mysql://localhost:3306/sample_db";  // Replace with your DB URL
        String username = "root";  // Replace with your MySQL username
        String password = "Root12345.";  // Replace with your MySQL password

        // JDBC connection
        Connection conn = null;

        try {
            // 1. Load the JDBC driver (optional for modern Java versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create a connection to the database
            conn = DriverManager.getConnection(url, username, password);

            // 3. Create a statement object to execute queries
            Statement stmt = conn.createStatement();

            // 4. Execute a query and get the results
            String query = "SELECT * FROM users";  // Replace with your query
            ResultSet rs = stmt.executeQuery(query);

            // 5. Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 6. Close the connection
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
