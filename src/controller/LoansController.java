package controller;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import view.LoansView;


/**
 *
 * @author LauraTD
 */
public class LoansController {

    private static LoansView view;
    //LoansModel model;
    DefaultTableModel table;
    //LoansEvents events;

    public LoansController(MainController mainController) throws SQLException {
        if (view == null) {
            view = new LoansView();
            //events = new BooksEvents(this);
            mainController.getView().getDesktop().add(view).setVisible(true);
            initializeButtons();
            //model = new BookModel();
        }
    }

    public static LoansView getView() {
        return view;
    }

    private void initializeButtons() {
        //view.getjButton_listar().addActionListener(events);
        //view.getjButton_limpiar().addActionListener(events);
    }

    
}
