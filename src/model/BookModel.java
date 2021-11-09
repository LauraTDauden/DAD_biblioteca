package model;

import connection.DataQueries;
import dto_entities.Book;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
            query.prepareSQL("INSERT INTO libros"
                    + "(codigo, titulo, autor, editorial, asignatura, estado)"
                    + "VALUES (?,?,?,?,?,?)");
            query.getPreparedStatement().setInt(1, book.getCode());
            query.getPreparedStatement().setString(2, book.getTitle());
            query.getPreparedStatement().setString(3, book.getAuthor());
            query.getPreparedStatement().setString(4, book.getPublisher());
            query.getPreparedStatement().setString(5, book.getSubject());
            query.getPreparedStatement().setString(6, book.getCondition());
            query.SQLUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //ELIMIAR LIBRO   
    public void delete(int code) {
        try {
            query.prepareSQL("DELETE FROM alumnos WHERE codigo =?");
            query.getPreparedStatement().setInt(1, code);
            query.SQLUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    //MODIFICAR LIBRO       
    private void updateTitle(Book book) throws SQLException {
        query.prepareSQL("UPDATE libros SET titulo=?"
                + "WHERE codigo = ?");
        query.getPreparedStatement().setString(1, book.getTitle());
        query.getPreparedStatement().setInt(2, book.getCode());
        query.SQLUpdate();
    }

    private void updateAuthor(Book book) throws SQLException {
        query.prepareSQL("UPDATE libros SET autor=?"
                + "WHERE codigo = ?");
        query.getPreparedStatement().setString(1, book.getAuthor());
        query.getPreparedStatement().setInt(2, book.getCode());
        query.SQLUpdate();
    }

    private void updatePublisher(Book book) throws SQLException {
        query.prepareSQL("UPDATE libros SET editorial=?"
                + "WHERE codigo = ?");
        query.getPreparedStatement().setString(1, book.getPublisher());
        query.getPreparedStatement().setInt(2, book.getCode());
        query.SQLUpdate();
    }

    private void updateSubject(Book book) throws SQLException {
        query.prepareSQL("UPDATE libros SET asignatura=?"
                + "WHERE codigo = ?");
        query.getPreparedStatement().setString(1, book.getSubject());
        query.getPreparedStatement().setInt(2, book.getCode());
        query.SQLUpdate();
    }

    private void updateCondition(Book book) throws SQLException {
        query.prepareSQL("UPDATE libros SET estado=?"
                + "WHERE codigo = ?");
        query.getPreparedStatement().setString(1, book.getCondition());
        query.getPreparedStatement().setInt(2, book.getCode());
        query.SQLUpdate();
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
            System.out.println(ex.getMessage());
        }
    }

    //LISTAR LIBRO (y buscar)
    public void search(String fieldText) {
        try {
            query.prepareSQL("SELECT * FROM libros WHERE titulo LIKE ? "
                    + "OR autor LIKE ? "
                    + "OR editorial LIKE ? "
                    + "OR asignatura LIKE ?"
                    + "OR estado LIKE ?");
            for (int i = 1; i < 6; i++) {
                query.getPreparedStatement().setString(i, "%" + fieldText + "%");
            }
            query.SQLQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //TABLA
    public void populateTable(String text, DefaultTableModel table) {
        search(text);
        try {
            while (query.getResultset().next()) {
                String codigo = query.getResultset().getString("codigo");
                String titulo = query.getResultset().getString("titulo");
                String autor = query.getResultset().getString("autor");
                String editorial = query.getResultset().getString("editorial");
                String asignatura = query.getResultset().getString("asignatura");
                String estado = query.getResultset().getString("estado");

                table.addRow(new Object[]{codigo, titulo, autor, editorial, asignatura, estado});
            }
            query.closeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
