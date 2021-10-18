package controller;

import java.sql.SQLException;
import view.UsersView;

/**
 *
 * @author LauraTD
 */
public class UsersController {

    private static UsersView view;
    //UsersModel model;
    //User user;
    //DefaultTableModel table;
    //UsersEvents events;

    public UsersController(MainController mainController) throws SQLException {
        if (view == null) {
            view = new UsersView();
            //events = new UsersEvents(this);
            mainController.getView().getDesktop().add(view).setVisible(true);
            //initializeButtons();
            //model = new UsersModel();
        }
    }
 
    public UsersView getView() {
        return view;
    }
       
    /* private void initializeButtons() {
    view.getjButton_nuevo().addActionListener(events);
    view.getjButton_eliminar().addActionListener(events);
    view.getjButton_modificar().addActionListener(events);
    view.getjButton_listar().addActionListener(events);
    view.getjButton_limpiar().addActionListener(events);
    }*/

   

}
