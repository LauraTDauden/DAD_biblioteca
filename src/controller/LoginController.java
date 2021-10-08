package controller;

import dto_entities.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import model.LoginModel;
import view.LoginView;
import view.MainView;

/**
 *
 * @author Laura
 */
public class LoginController implements ActionListener {

    LoginView view;
    LoginModel model;
    User user;

    public LoginController() throws SQLException {
        view = new LoginView();
        initializeButtons();
        model = new LoginModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getjButton_Aceptar())) {
            aceptar();
        }

        if (e.getSource().equals(view.getjButton_Cancelar())) {
            cancelar();
        }
    }

    private void initializeButtons() {
        view.getjButton_Aceptar().addActionListener(this);
        view.getjButton_Cancelar().addActionListener(this);
    }

    private void loadUser() {
        user = new User();
        user.setUserName(view.getjTextField_user().getText());
        user.setPass(String.valueOf(view.getjPasswordField_pass().getPassword())); //hay que parsear, ya que la contraseña se guarda como un array de tipo char
    }

    private void aceptar() {
        loadUser();
        if (model.validateUserPassword(user)) {
            MainView view2 = new MainView();
            view.dispose();
        }
    }

    private void cancelar() {
        view.getjPasswordField_pass().setText("");
        view.getjTextField_user().setText("");
    }
}
