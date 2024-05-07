package DaoArsip;
import java.sql.*;
import Database.Connect;
import Model.ModelPertama;
import java.util.ArrayList;
import java.util.List;

public class daoArsip implements daoImplement{
    Connection con;
    
    public daoArsip(){
    con = Connect.connection();
    PreparedStatement pstm = null;
    }
    @Override
    public void insert (ModelPertama modelpertama){
        String query = "insert into personel(NRP, NAMA, TGLLHR, PANGKAT, KORPS, KESATUAN) values (?,?,?,?,?,?);";
        con = Connect.connection();
        PreparedStatement pstm = null;
        
        try {
            //con = Connect.connection();
            pstm = con.prepareStatement(query );
            pstm.setString(0, modelpertama.getNRP());
            pstm.setString(1, modelpertama.getNama());
            pstm.setString(2, modelpertama.getTgl());
            pstm.setString(3, modelpertama.getPangkat());
            pstm.setString(4, modelpertama.getKorps());
            pstm.setString(5, modelpertama.getKesatuan());
            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
//    public void deletemahasiswa (String NIM){
//        String query = "delete from mahasiswa where NIM = ?";
//        PreparedStatement pstm;
//        
//        try{
//            pstm = con.koneksi.prepareStatement(query);
//            pstm.setString(1, NIM);
//            pstm.executeUpdate();
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//    
//    public void updatemahasiswa (mahasiswa mahasiswa){
//        String query = "Update mahasiswa SET Nama=?, Prodi=?, Kelas=?, Asal=? WHERE NIM=?";
//        PreparedStatement pstm;
//        
//        try{
//            con.statement = con.koneksi.createStatement();
//            pstm = con.koneksi.prepareStatement(query);
//            pstm.setString(1, mahasiswa.getNama());
//            pstm.setString(2, mahasiswa.getProdi());
//            pstm.setString(3, mahasiswa.getKelas());
//            pstm.setString(4, mahasiswa.getAsal());
//            pstm.setString(5, mahasiswa.getNIM());
//            pstm.executeUpdate();
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//    
//    public ArrayList<mahasiswa> getMahasiswa(){
//        System.out.println("getMahasiswa()");
//        String query = "Select * from mahasiswa";
//        PreparedStatement pstm;
//        
//        try{
//            con.statement = con.koneksi.createStatement();
//            pstm = con.koneksi.prepareStatement(query);
//            ResultSet rs = pstm.executeQuery();
//            ArrayList<mahasiswa> list = new ArrayList<>();
//            mahasiswa mahasiswa;
//            while (rs.next()){
//                mahasiswa = new mahasiswa(
//                rs.getString("Nama"),
//                rs.getString("NIM"),
//                rs.getString("Prodi"),
//                rs.getString("Kelas"),
//                rs.getString("Asal")
//                );
//                list.add(mahasiswa);
//            } return list;
//        } catch (SQLException e){
//            System.out.println(e.getMessage());
//        } return null;
//    }
    
//    public boolean isContainPersonel(){
//        System.out.println("isContainPersonel()");
//        try{
//            String query = "Select count(*) as num from personel";
//            PreparedStatement pstm = con.koneksi.prepareStatement(query);
//            con.statement = con.koneksi.createStatement();
//            ResultSet rs = pstm.executeQuery(query);
//            rs.next();
//            if(rs.getInt("num")>0) return true;
//        } catch(SQLException e){
//            System.err.println(e.getMessage());
//        }return false;
//    }
@Override
    public List<ModelPertama> getAll() {
       List<ModelPertama> mp = null;
        try {
             mp = new ArrayList<ModelPertama>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from personel;");
            while (rs.next()) {
                ModelPertama mod = new ModelPertama();
                mod.setNRP(rs.getString("NRP"));
                mod.setNama(rs.getString("Nama"));
                mod.setTgl(rs.getString("TglLhr"));
                mod.setPangkat(rs.getString("Pangkat"));
                mod.setKorps(rs.getString("Korps"));
                mod.setKesatuan(rs.getString("Kesatuan"));
                mp.add(mod);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mp;
    }

}
