package Main;

import Database.connect;
import View.UserInterface_KP;
import Model.ModelPertama;
import Controller.ControllerPertama;       
import java.sql.SQLException;
public class Main {

    public static void main(String[] args) throws SQLException{
          UserInterface_KP view = new UserInterface_KP();
          ModelPertama model = new ModelPertama();
          ControllerPertama control = new ControllerPertama(view, model);
    }
    
}
