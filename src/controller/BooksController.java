package controller;

import dto_entities.Book;
import events.BooksEvents;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BookModel;
import view.BooksView;

/**
 *
 * @author LauraTD
 */
public class BooksController {

    private static BooksView view;
    BookModel model;
    Book book;
    DefaultTableModel table;
    BooksEvents events;

    public BooksController(MainController mainController) throws SQLException {
        if (view == null) {
            view = new BooksView();
            events = new BooksEvents(this);
            mainController.getView().getDesktop().add(view).setVisible(true);
            initializeButtons();
            model = new BookModel();
        }
    }

    public static BooksView getView() {
        return view;
    }

    private void initializeButtons() {
        view.getjButton_alta().addActionListener(events);
        view.getjButton_baja().addActionListener(events);
        view.getjButton_modificar().addActionListener(events);
        view.getjButton_listar().addActionListener(events);
        view.getjButton_limpiar().addActionListener(events);
    }

    private void loadBook() {
        book = new Book();
        book.setCode(Integer.parseInt(view.getjTextField_code().getText()));
        book.setTitle(view.getjTextField_title().getText());
        book.setAuthor(view.getjTextField_author().getText());
        book.setPublisher(view.getjTextField_publisher().getText());
        book.setSubject(view.getjTextField_subject().getText());
        book.setCondition(view.getjTextField_condition().getText());
    }

    public void alta() {
        if (verifyFields()) {
            loadBook();
            model.add(book);
            JOptionPane.showMessageDialog(view, "Libro añadido con éxito.");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(view, "Debe rellenar todos los campos obligatorios.");
        }
    }

    public void baja() {
        if (verifyCode()) {
            model.delete(Integer.parseInt(view.getjTextField_code().getText()));
            limpiar();
            JOptionPane.showMessageDialog(view, "El libro fue eliminado con éxito.");
        } else {
            JOptionPane.showMessageDialog(view, "Debe indicar un código válido del libro que desea dar de baja.");
        }
    }

    public void modificar() {
        if (verifyCode()) {
            loadBook();
            model.updateInfo(book);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(view, "Debe indicar un código válido del libro que desea modificar.");
        }
    }

    public void limpiar() {
        clearFields();
        clearTable();
    }

    private void clearFields() {
        view.getjTextField_code().setText("");
        view.getjTextField_title().setText("");
        view.getjTextField_author().setText("");
        view.getjTextField_publisher().setText("");
        view.getjTextField_subject().setText("");
        view.getjTextField_condition().setText("");
    }

    private void clearTable() {
        table = (DefaultTableModel) view.getjTable_books().getModel();
        table.setRowCount(0);
    }

    public void addTableRows() {
        try {
            clearTable();
            model.search(view.getjTextField_searchBar().getText());
            while (model.getQuery().getResultset().next()) {
                String codigo = model.getQuery().getResultset().getString("codigo");
                String titulo = model.getQuery().getResultset().getString("titulo");
                String autor = model.getQuery().getResultset().getString("autor");
                String editorial = model.getQuery().getResultset().getString("editorial");
                String asignatura = model.getQuery().getResultset().getString("asignatura");
                String estado = model.getQuery().getResultset().getString("estado");

                table.addRow(new Object[]{codigo, titulo, autor, editorial, asignatura, estado});
            }
            model.getQuery().closeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //verificar datos obligatorios
    private boolean verifyFields() {
        boolean valid = true;
        if (view.getjTextField_code().getText().isBlank()
                || view.getjTextField_title().getText().isBlank()
                || view.getjTextField_author().getText().isBlank()) {
            valid = false;
        }
        return valid;
    }

    private boolean verifyCode() {
        boolean valid = true;
        if (view.getjTextField_code().getText().isBlank()) {
            valid = false;
        } else {
            try {
                Integer.parseInt(view.getjTextField_code().getText());
            }catch (NumberFormatException nfe){
                valid = false;
            }
        }
        return valid;
    }

}
