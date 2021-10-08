package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.StudentsView;

/**
 *
 * @author LauraTD
 */
public class StudentsController implements ActionListener {

    private static StudentsView view;
    //StudentsModel model;
    //Student student;

    public StudentsController(){
        if (view != null){
            view.dispose();
        }
        view = new StudentsView();
        MainController.getView().getDesktop().add(view).setVisible(true);
        
        //initializeButtons();
        //model = new StudentsModel();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    /*   private void initializeButtons() {
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
    view.dispose();
    new MainController();
    }
    }
    
    private void cancelar() {
    view.getjPasswordField_pass().setText("");
    view.getjTextField_user().setText("");
    }*/
}
