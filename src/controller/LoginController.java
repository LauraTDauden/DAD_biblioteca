package controller;

import dto_entities.User;
import events.LoginEvents;
import java.sql.SQLException;
import model.LoginModel;
import view.LoginView;

/**
 *
 * @author LauraTD
 */
public class LoginController {

    private LoginView view;
    private LoginModel model;
    private User user;
    private MainController mainController;
    private LoginEvents events;

    public LoginController() throws SQLException {
        view = new LoginView();
        events = new LoginEvents(this);
        initializeButtons();
        model = new LoginModel();       
    }

    public LoginView getView() {
        return view;
    }
        
    public MainController getMainController() {
        return mainController;
    }
   
    private void initializeButtons() {
        view.getjButton_Aceptar().addActionListener(events);
        view.getjButton_Cancelar().addActionListener(events);
    }

    private void loadUser() {
        user = new User();
        user.setUserName(view.getjTextField_user().getText());
        user.setPass(String.valueOf(view.getjPasswordField_pass().getPassword())); //hay que parsear, ya que la contraseña se guarda como un array de tipo char
    }

    public void aceptar() {
        loadUser();
        if (model.validateUserPassword(user)) {
            view.dispose();
            mainController = new MainController();
        }
    }

    public void cancelar() {
        view.getjPasswordField_pass().setText("");
        view.getjTextField_user().setText("");

        //acceso rápido sin contraseña para facilitar las pruebas en el desarrollo
        view.dispose();
        mainController = new MainController();
    }
}
