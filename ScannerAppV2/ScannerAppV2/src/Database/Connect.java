package Database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.*;
import javax.swing.JOptionPane;


public class Connect{
    
    //private final String url = "jdbc:mysql://localhost/db_arsippersonel";
    private final String username = "root";
    private final String pass = "";
    
    static Connection koneksi;
    
    public static Connection connection() {
        if(koneksi == null){
        MysqlDataSource data= new MysqlDataSource();
        data.setDatabaseName("db_arsippersonel");
        data.setUser("root");
        data.setPassword("");
            try {
                koneksi = data.getConnection();
                System.out.println("Koneksi Berhasil");
                
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Koneksi Gagal");
            }
        }
        return koneksi;
    }
}
