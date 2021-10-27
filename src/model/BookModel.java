package model;

import connection.DataQueries;
import dto_entities.Book;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Laura
 */
public class BookModel {

    private DataQueries query;

    public BookModel() throws SQLException {
        query = new DataQueries();
    }

    public DataQueries getQuery() {
        return query;
    }

    //AÑADIR LIBRO   
    public void add(Book book) {
        try {
            query.SQLUpdate("INSERT INTO libros"
                    + "(codigo, titulo, autor, editorial, asignatura, estado)"
                    + "VALUES ('" + book.getCode() + "','" + book.getTitle()
                    + "', '" + book.getAuthor()
                    + "','" + book.getPublisher() + "', '"
                    + book.getSubject() + "', '"
                    + book.getCondition() + "')");
        } catch (SQLException ex) {
            //Logger.getLogger(BookModel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    //ELIMIAR LIBRO   
    public void delete(int code) {
        try {
            query.SQLUpdate("DELETE FROM libros WHERE codigo ='" + code + "'");
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //MODIFICAR LIBRO       
    private void updateTitle(Book book) throws SQLException {
        query.SQLUpdate("UPDATE libros SET titulo='" + book.getTitle() + "'"
                + "WHERE codigo = '" + book.getCode() + "'");
    }

    private void updateAuthor(Book book) throws SQLException {
        query.SQLUpdate("UPDATE libros SET autor='" + book.getAuthor() + "'"
                + "WHERE codigo = '" + book.getCode() + "'");
    }

    private void updatePublisher(Book book) throws SQLException {
        query.SQLUpdate("UPDATE libros SET editorial='" + book.getPublisher() + "'"
                + "WHERE codigo = '" + book.getCode() + "'");
    }

    private void updateSubject(Book book) throws SQLException {
        query.SQLUpdate("UPDATE libros SET asignatura='" + book.getSubject() + "'"
                + "WHERE codigo = '" + book.getCode() + "'");
    }

    private void updateCondition(Book book) throws SQLException {
        query.SQLUpdate("UPDATE libros SET estado='" + book.getCondition() + "'"
                + "WHERE codigo = '" + book.getCode() + "'");
    }

    public void updateInfo(Book book) {
        boolean changes = false;
        try {
            if (!book.getTitle().isBlank()) {
                updateTitle(book);
                changes = true;
            }
            if (!book.getAuthor().isBlank()) {
                updateAuthor(book);
                changes = true;
            }
            if (!book.getPublisher().isBlank()) {
                updatePublisher(book);
                changes = true;
            }
            if (!book.getSubject().isBlank()) {
                updateSubject(book);
                changes = true;
            }
            if (!book.getCondition().isBlank()) {
                updateCondition(book);
                changes = true;
            }
            if (changes) {
                JOptionPane.showMessageDialog(null, "Datos actualizados con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No ha introducido ningún dato para modificar.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //LISTAR LIBRO (y buscar)
    public void search(String fieldText) {
        try {
            query.SQLQuery("SELECT * FROM libros WHERE titulo LIKE '%" + fieldText + "%'"
                    + "OR autor LIKE '%" + fieldText + "%'"
                    + "OR editorial LIKE '%" + fieldText + "%'"
                    + "OR asignatura LIKE '%" + fieldText + "%'"
                    + "OR estado LIKE '%" + fieldText + "%'");
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
