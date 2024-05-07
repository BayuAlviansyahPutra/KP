package Model;

public class ModelPertama {
    private String Nama;
    private String NRP;
    private String Tgl;
    private String Pangkat;
    private String Korps;
    private String Kesatuan;
    
//    public ModelPertama (String Nama, String NRP, String Tgl, String Pangkat, String Korps, String Kesatuan)
//    {
//        this.Nama = Nama;
//        this.NRP = NRP;
//        this.Tgl = Tgl;
//        this.Pangkat = Pangkat;
//        this.Korps = Korps;
//        this.Kesatuan = Kesatuan;
//    }
    
    public String getNama(){
        return Nama;
    }
    
    public void setNama(String Nama){
        this.Nama = Nama;
    }
    
    public String getNRP(){
        return NRP;
    }
    
    public void setNRP(String NRP){
        this.NRP = NRP;
    }
    
    public String getTgl(){
        return Tgl;
    }
    
    public void setTgl(String Tgl){
        this.Tgl = Tgl;
    }
    
    public String getPangkat(){
        return Pangkat;
    }
    
    public void setPangkat(String Pangkat){
        this.Pangkat = Pangkat;
    }
    
    public String getKorps(){
        return Korps;
    }
    
    public void setKorps(String Korps){
        this.Korps = Korps;
    }
    
    public String getKesatuan(){
        return Kesatuan;
    }
    
    public void setKesatuan(String Kesatuan){
        this.Kesatuan = Kesatuan;
    }
    
}
