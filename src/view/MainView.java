package view;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;

public class MainView extends javax.swing.JFrame {

    public MainView() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public JMenu getjMenu_Alumnos() {
        return jMenu_Alumnos;
    }

    public JMenu getjMenu_Libros() {
        return jMenu_Libros;
    }

    public JMenu getjMenu_Prestamos() {
        return jMenu_Prestamos;
    }

    public JMenu getjMenu_Usuarios() {
        return jMenu_Usuarios;
    }

    public JDesktopPane getDesktop() {
        return Desktop;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_Usuarios = new javax.swing.JMenu();
        jMenu_Libros = new javax.swing.JMenu();
        jMenu_Alumnos = new javax.swing.JMenu();
        jMenu_Prestamos = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tu Biblioteca");
        setMaximumSize(new java.awt.Dimension(850, 655));

        Desktop.setBackground(new java.awt.Color(222, 234, 232));
        Desktop.setPreferredSize(new java.awt.Dimension(1018, 569));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bib.jpg"))); // NOI18N

        Desktop.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(242, 247, 246));

        jMenu_Usuarios.setBackground(new java.awt.Color(222, 234, 232));
        jMenu_Usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user2.png"))); // NOI18N
        jMenu_Usuarios.setText("Usuarios");
        jMenu_Usuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu_Usuarios);

        jMenu_Libros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/libros.png"))); // NOI18N
        jMenu_Libros.setText("Libros");
        jMenu_Libros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu_Libros);

        jMenu_Alumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alumno2.png"))); // NOI18N
        jMenu_Alumnos.setText("Alumnos");
        jMenu_Alumnos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu_Alumnos);

        jMenu_Prestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prestamo.png"))); // NOI18N
        jMenu_Prestamos.setText("Préstamos");
        jMenu_Prestamos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu_Prestamos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenu_Alumnos;
    private javax.swing.JMenu jMenu_Libros;
    private javax.swing.JMenu jMenu_Prestamos;
    private javax.swing.JMenu jMenu_Usuarios;
    // End of variables declaration//GEN-END:variables
}
