package Controller;
import DaoArsip.daoArsip;
import com.sun.source.tree.CatchTree;
import java.sql.*;
import javax.swing.JOptionPane;
import Database.Connect;
import java.util.ArrayList;
import View.UserInterface_KP;
import Model.ModelPertama;
import java.util.List;
import DaoArsip.daoImplement;

public class ControllerPertama {
    
    UserInterface_KP UI;
    daoImplement impdata;
    List<ModelPertama> mp;

    public ControllerPertama(UserInterface_KP UI) {
        this.UI = UI;
        impdata = new daoArsip();
        mp = impdata.getAll();
    }
//    
//    public void tampil(){
//        db = impdata.getAll();
//        mtabelbuku mt = new mtabelbuku(db);
//        frame.getJtabel().setModel(mt);
//        
//    }
    
    public void insert(){
        ModelPertama mp = new ModelPertama();
        int NRP = Integer.parseInt(UI.tfNRP.getText());
        mp.setNama(UI.tfNama.getText());
        mp.setTgl(UI.tfTgl.getText());
        mp.setPangkat(UI.tfPangkat.getText());
        mp.setKorps(UI.tfKorps.getText());
        mp.setKesatuan(UI.tfKesatuan.getText()); 
        impdata.insert(mp);
   }
}
