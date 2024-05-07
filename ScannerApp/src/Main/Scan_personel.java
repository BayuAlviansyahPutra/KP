package Main;

import java.sql.Connection;
import java.sql.SQLException;
import Database.connect;
import java.sql.PreparedStatement;

public class Scan_personel {
    public static void main(String[] args) {
        Connection connection = null;
                PreparedStatement preparedStatement = null;
//        con = new connect;
        try {
            // Membuat koneksi ke database
            connection = connect.getConnection();
            // Lakukan operasi database di sini...
            String query = "INSERT INTO personel (PERSONEL, NAMA, TGLLHR, PANGKATID, KORPSID, ORGID) VALUES (?, ?, ?, ?, ?, ?)";
            // Membuat objek PreparedStatement
            preparedStatement = connection.prepareStatement(query);
            // Mengisi nilai parameter pada query
            preparedStatement.setInt(1, 2); // PERSONEL
            preparedStatement.setString(2, "FEBRIAN"); // NAMA
            preparedStatement.setDate(3, java.sql.Date.valueOf("2024-05-07")); // TGLLHR
            preparedStatement.setString(4, "Epic"); // PANGKATID
            preparedStatement.setString(5, "Sus"); // KORPSID
            preparedStatement.setString(6, "Al"); // ORGID
            // Eksekusi query
            preparedStatement.executeUpdate();
            System.out.println("Data berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Menutup koneksi ke database setelah selesai digunakan
            connect.closeConnection(connection);}}}