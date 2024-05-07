/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scan_personel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
    // JDBC URL, username, dan password database
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db_arsippersonel";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // Metode untuk membuat koneksi ke database
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Mendaftarkan driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Membuat koneksi
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Database connection established.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
        return connection;
    }

    // Metode untuk menutup koneksi ke database
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}