package Model;

import Database.connect;
import java.sql.*;
import java.util.ArrayList;
import Main.Personel;

public class ModelPertama {
    Connection con;

    public ModelPertama() throws SQLException {
        con = connect.getConnection();
    }

    public void insertData(Personel Personel) {
        String query = "insert into personel (PERSONEL, NAMA, TGLLHR, PANGKATID, KORPSID, ORGID) values (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setString(1, Personel.getNama());
            pstm.setString(2, Personel.getNRP());
            pstm.setString(3, Personel.getTgl());
            pstm.setString(4, Personel.getPangkat());
            pstm.setString(5, Personel.getKorps());
            pstm.setString(6, Personel.getKesatuan());
            pstm.executeUpdate();
            System.out.println("Data berhasil disimpan.");
        } catch (SQLException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    public void deleteData(String NRP) {
        String query = "delete from personel where PERSONEL = ?";
        try (PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setString(1, NRP);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateData(Personel Personel) {
        String query = "Update personel SET NAMA=?, TGLLHR=?, PANGKATID=?, KORPSID=?, ORGID=? WHERE PERSONEL=?";
        try (PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setString(1, Personel.getNama());
            pstm.setString(2, Personel.getPangkat());
            pstm.setString(3, Personel.getKorps());
            pstm.setString(4, Personel.getKesatuan());
            pstm.setString(5, Personel.getNRP());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Personel> getPersonel() {
        System.out.println("getPersonel()");
        String query = "Select * from personel";
        try (PreparedStatement pstm = con.prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            ArrayList<Personel> list = new ArrayList<>();
            while (rs.next()) {
                Personel personel = new Personel(
                        rs.getString("PERSONEL"),
                        rs.getString("NAMA"),
                        rs.getString("TGLLHR"),
                        rs.getString("PANGKATID"),
                        rs.getString("KORPSID"),
                        rs.getString("ORGID")
                );
                list.add(personel);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean isContainPersonel() {
        System.out.println("isContainPersonel()");
        try {
            String query = "Select count(*) as num from personel";
            try (PreparedStatement pstm = con.prepareStatement(query); ResultSet rs = pstm.executeQuery()) {
                rs.next();
                return rs.getInt("num") > 0;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
