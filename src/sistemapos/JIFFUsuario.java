package sistemapos;

import java.sql.*;
import javax.swing.*;


public class JIFFUsuario extends javax.swing.JInternalFrame {

    //CREAMOS VARIABLES PARA MANIPULAR LA BASE DE DATOS
    static Connection cn;
    static Statement st;
    static ResultSet rs;
    static ResultSet rsaux;
    boolean editar = false;
    
    //INSTANCIA DE LA CLASE ConexionSQL
    ConexionSQL conexion = new ConexionSQL();
    
    public JIFFUsuario() {
        initComponents();
        listaRoles();
        listaEmpresas();
    }
    
    //METODO PARA LA LISTA DE ROLES
    public void listaRoles() {
        try {
            conexion.conectar();
            String roles = "";
            rs = st.executeQuery("select * from tbl_roles order by id_rol asc");
            while(rs.next()){
                roles = rs.getString("id_rol")+".-"+rs.getString("nombre_rol");
                jCBRol.addItem(roles);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error consultando tabla\n" + e);
        }
    }
    
    //METODO PARA LA LISTA DE EMPRESAS
    public void listaEmpresas() {
        try {
            conexion.conectar();
            String empresas = "";
            rs = st.executeQuery("select * from tbl_empresas order by id_empresa asc");
            while(rs.next()){
                empresas= rs.getString("id_empresa")+".-"+rs.getString("nombre_empresa");
                jCBEmpresa.addItem(empresas);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error consultando tabla\n" + e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBGuardarNuevo = new javax.swing.JButton();
        jBGuardarCerrar = new javax.swing.JButton();
        jBAgregar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBRetroceder = new javax.swing.JButton();
        jBAvanzar = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jLDescripcion = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLPassword = new javax.swing.JLabel();
        jLCPassword = new javax.swing.JLabel();
        jLRol = new javax.swing.JLabel();
        jLEmpresa = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jCBRol = new javax.swing.JComboBox<>();
        jCBEmpresa = new javax.swing.JComboBox<>();
        jPFPassword = new javax.swing.JPasswordField();
        jPFConfirmarPW = new javax.swing.JPasswordField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Módulo Usuario");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBGuardarNuevo.setText("Guardar y Nuevo");
        jBGuardarNuevo.setPreferredSize(new java.awt.Dimension(120, 32));
        getContentPane().add(jBGuardarNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jBGuardarCerrar.setText("Guardar y Cerrar");
        jBGuardarCerrar.setPreferredSize(new java.awt.Dimension(120, 32));
        getContentPane().add(jBGuardarCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jBAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        jBAgregar.setPreferredSize(new java.awt.Dimension(32, 32));
        getContentPane().add(jBAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        jBEliminar.setPreferredSize(new java.awt.Dimension(32, 32));
        getContentPane().add(jBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 20, -1, -1));

        jBRetroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retroceder.png"))); // NOI18N
        jBRetroceder.setPreferredSize(new java.awt.Dimension(32, 32));
        getContentPane().add(jBRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 20, -1, -1));

        jBAvanzar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/avanzar.png"))); // NOI18N
        jBAvanzar.setPreferredSize(new java.awt.Dimension(32, 32));
        getContentPane().add(jBAvanzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 20, -1, -1));

        jBEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        jBEditar.setPreferredSize(new java.awt.Dimension(32, 32));
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jBEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 20, -1, -1));

        jLDescripcion.setText("Llenar todos los campos");
        getContentPane().add(jLDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLNombre.setText("Nombre:");
        getContentPane().add(jLNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLPassword.setText("Contraseña:");
        getContentPane().add(jLPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLCPassword.setText("Confirmar contraseña:");
        getContentPane().add(jLCPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLRol.setText("Rol:");
        getContentPane().add(jLRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLEmpresa.setText("Empresa autorizada:");
        getContentPane().add(jLEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jTFNombre.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 150, -1, -1));

        jCBRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno" }));
        jCBRol.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jCBRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 300, -1, -1));

        jCBEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno" }));
        jCBEmpresa.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jCBEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 350, -1, -1));

        jPFPassword.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jPFPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 200, -1, -1));

        jPFConfirmarPW.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jPFConfirmarPW, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 250, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBAvanzar;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardarCerrar;
    private javax.swing.JButton jBGuardarNuevo;
    private javax.swing.JButton jBRetroceder;
    private javax.swing.JComboBox<String> jCBEmpresa;
    private javax.swing.JComboBox<String> jCBRol;
    private javax.swing.JLabel jLCPassword;
    private javax.swing.JLabel jLDescripcion;
    private javax.swing.JLabel jLEmpresa;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLPassword;
    private javax.swing.JLabel jLRol;
    private javax.swing.JPasswordField jPFConfirmarPW;
    private javax.swing.JPasswordField jPFPassword;
    private javax.swing.JTextField jTFNombre;
    // End of variables declaration//GEN-END:variables
}
