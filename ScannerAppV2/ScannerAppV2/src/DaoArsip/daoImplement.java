/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoArsip;


import java.util.List;
import Model.*;

public interface daoImplement {
    public  void insert(ModelPertama mp);
//    public  void update(ModelPertama mp);
//    public  void delete(int id);
//    public  void search(ModelPertama mp);
    public List<ModelPertama> getAll();

//    public void cari(int id);
}

