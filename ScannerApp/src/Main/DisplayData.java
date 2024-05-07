package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Database.connect;

public class DisplayData {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            // Membuat koneksi ke database
            connection = connect.getConnection();
            // Membuat objek Statement
            statement = connection.createStatement();
            // Query untuk mengambil data dari tabel personel
            String query = "SELECT * FROM personel";
            // Eksekusi query
            resultSet = statement.executeQuery(query);
            
            // Menampilkan data
            System.out.println("Data dalam tabel personel:");
            System.out.println("--------------------------------------------------");
            System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s%n", "PERSONEL", "NAMA", "TGLLHR", "PANGKATID", "KORPSID", "ORGID");
            System.out.println("--------------------------------------------------");
            
            while(resultSet.next()) {
                int personel = resultSet.getInt("PERSONEL");
                String nama = resultSet.getString("NAMA");
                java.sql.Date tanggalLahir = resultSet.getDate("TGLLHR");
                String pangkatId = resultSet.getString("PANGKATID");
                String korpsId = resultSet.getString("KORPSID");
                String orgId = resultSet.getString("ORGID");
                
                System.out.printf("%-10d %-20s %-10s %-10s %-10s %-10s%n", personel, nama, tanggalLahir, pangkatId, korpsId, orgId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Menutup koneksi ke database dan objek statement setelah selesai digunakan
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                connect.closeConnection(connection);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
