package Controller;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import Main.Personel;
import Model.ModelPertama;
import View.UserInterface_KP;
import java.awt.Container;

public class ControllerPertama {
    private ArrayList<Personel> list;
    private String Nama;
    private String NRP;
    private String Tgl;
    private String Pangkat;
    private String Korps;
    private String Kesatuan;
    
    public ControllerPertama (UserInterface_KP view, ModelPertama model){
        if(model.isContainPersonel()){
            list = model.getPersonel();
            String [][] data = convertData(list);
            view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
        }else{
            JOptionPane.showMessageDialog(null, "Error");
        }
        view.input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String Nama = view.getNama();
               String NRP = view.getNRP();
               String Tgl = view.getTgl();
               String Pangkat = view.getPangkat();
               String Korps = view.getKorps();
               String Kesatuan = view.getKesatuan();
               Personel personel = new Personel(Nama, NRP, Tgl, Pangkat, Korps, Kesatuan);
               model.insertData(personel);
               list = model.getPersonel();
               System.out.println(list.get(0).getNRP());
               String [][] data = convertData(list);
               view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
               view.tfNama.setText("");
                view.tfNRP.setText("");
                view.tfTgl.setText("");
                view.tfPangkat.setText("");
                view.tfKorps.setText("");
                view.tfKesatuan.setText("");
            }
        });
        
//         view.btnUpdate.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               System.out.println("btnUpdate");
//               Nama = view.getNama();
//               NIM = view.getNIM();
//               Prodi = view.getProdi();
//               Kelas = view.getKelas();
//               Asal = view.getAsal();
//               mahasiswa mahasiswa = new mahasiswa(Nama, NIM, Prodi, Kelas, Asal);
//               model.updatemahasiswa(mahasiswa);
//               list = model.getMahasiswa();
//               String [][] data = convertData(list);
//               view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
//               view.tfNama.setText("");
//                view.tfNIM.setText("");
//                view.tfProdi.setText("");
//                view.tfKelas.setText("");
//                view.tfAsal.setText("");
//            }
//        });
//         
//         view.btnDelete.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String NIM = view.getNIM();
//                model.deletemahasiswa(NIM);
//                list = model.getMahasiswa();
//                String[][] data = convertData(list);
//                view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
//                view.tfNama.setText("");
//                view.tfNIM.setText("");
//                view.tfProdi.setText("");
//                view.tfKelas.setText("");
//                view.tfAsal.setText("");
//            }
//        });
//         
//         view.tabel.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//                int baris = view.tabel.getSelectedRow();
//                int kolom = view.tabel.getSelectedColumn();
//                Nama = view.tabel.getValueAt(baris, 0).toString(); 
//                NIM = view.tabel.getValueAt(baris, 1).toString();
//                Prodi = view.tabel.getValueAt(baris, 2).toString();
//                Kelas = view.tabel.getValueAt(baris, 3).toString();
//                Asal = view.tabel.getValueAt(baris, 4).toString();
//                
//                view.tfNama.setText(Nama);
//                view.tfNIM.setText(NIM);
//                view.tfProdi.setText(Prodi);
//                view.tfKelas.setText(Kelas);
//                view.tfAsal.setText(Asal);
//            }
//            
//        });
//        
//        view.btnReset.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                view.tfNama.setText("");
//                view.tfNIM.setText("");
//                view.tfProdi.setText("");
//                view.tfKelas.setText("");
//                view.tfAsal.setText("");
//            }
//        }); 
    }

    
    private String[][] convertData(ArrayList<Personel> list) {    
        String[][] data = new String[list.size()][6];
        
        for(int i=0; i<list.size();i++)
        {
            data[i][0] = list.get(i).getNama();
            data[i][1] = list.get(i).getNRP();
            data[i][2] = list.get(i).getTgl();
            data[i][3] = list.get(i).getPangkat();
            data[i][4] = list.get(i).getKorps();
            data[i][5] = list.get(i).getKesatuan();            
        }
        return data;
    }

}
