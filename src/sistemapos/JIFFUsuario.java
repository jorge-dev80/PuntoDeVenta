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
    
    //METODO PARA INGRESAR DATOS EN JIIFUsuarios
    public void insertar(){
        try{
            conexion.conectar();
            String nombre = jTFNombre.getText();
            String con = jPFPassword.getText();
            String contra = jPFConfirmarPW.getText();
            String rol = (String) jCBRol.getSelectedItem();
            String empresa = (String) jCBEmpresa.getSelectedItem();
            
            int idrol = validarID(rol);
            int idempresa = validarID(empresa);
            
            if(con.equals(contra)){
                String result = "insert into tbl_registro values ('0','"+nombre+"','"+con+"','"+idrol+"','"+idempresa+"')";
                st.execute(result);
                cn.close();
            }else{
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                cn.close();
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error ingresando datos\n" + e);
        }
    }
    
    //METODO PARA VALIDAR EL ID
    public int validarID(String cadena){
        
        //VARIABLES PARA FUNCIONES DE VALIDACION
        String cad = "";
        int valorID;
        int puntero = 0;
        char caracter;
        
        caracter = cadena.charAt(puntero);

        while(caracter != '.'){
            cad = cad+""+caracter;
            puntero = puntero + 1;
            caracter = cadena.charAt(puntero);
        }
        
        valorID = Integer.parseInt(cad);
        return valorID;
    }
    
    //ULTIMO VALOR REGISTRADO
    public void ultimoValor() {
        try {
            conexion.conectar();
            String usuario, password;
            int rol, empresa;
            rs = st.executeQuery("select * from tbl_registro order by id_usuario asc");
            if(rs.last()){
                usuario = rs.getString("id_usuario")+".-"+rs.getString("usuario");
                jTFNombre.setText(""+usuario);
                password = rs.getString("password");
                jPFPassword.setText(password);
                jPFConfirmarPW.setText(password);
                rol = Integer.parseInt(rs.getString("id_rol"));
                jCBRol.setSelectedIndex(rol);
                empresa = Integer.parseInt(rs.getString("id_empresa"));
                jCBEmpresa.setSelectedIndex(empresa);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error consultando tabla\n" + e);
        }
    }
    
    //METODO PARA RETROCEDER EN LAS CONSULTAS
    public void retroceder() {
        try {
            conexion.conectar();
            String usuario, password;
            int rol, empresa;
            if(rs.previous()){
                usuario = rs.getString("id_usuario")+".-"+rs.getString("usuario");
                jTFNombre.setText(""+usuario);
                password = rs.getString("password");
                jPFPassword.setText(password);
                jPFConfirmarPW.setText(password);
                rol = Integer.parseInt(rs.getString("id_rol"));
                jCBRol.setSelectedIndex(rol);
                empresa = Integer.parseInt(rs.getString("id_empresa"));
                jCBEmpresa.setSelectedIndex(empresa);
            }else{
                rs.next();
                JOptionPane.showMessageDialog(null, "No hay mas registros");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error consultando tabla\n" + e);
        }
    }
    
    //METODO PARA AVANZAR EN LAS CONSULTAS
    public void avanzar() {
        try {
            conexion.conectar();
            String usuario, password;
            int rol, empresa;
            if(rs.next()){
                usuario = rs.getString("id_usuario")+".-"+rs.getString("usuario");
                jTFNombre.setText(""+usuario);
                password = rs.getString("password");
                jPFPassword.setText(password);
                jPFConfirmarPW.setText(password);
                rol = Integer.parseInt(rs.getString("id_rol"));
                jCBRol.setSelectedIndex(rol);
                empresa = Integer.parseInt(rs.getString("id_empresa"));
                jCBEmpresa.setSelectedIndex(empresa);
            }else{
                rs.previous();
                JOptionPane.showMessageDialog(null, "No hay mas registros");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error consultando tabla\n" + e);
        }
    }
    
    //METODO PARA EDITAR
    public void editar() {
        try{
            conexion.conectar();
            String nombre = jTFNombre.getText();
            String con = jPFPassword.getText();
            String contra = jPFConfirmarPW.getText();
            String rol = (String) jCBRol.getSelectedItem();
            String empresa = (String) jCBEmpresa.getSelectedItem();
            
            int idrol = validarID(rol);
            int idempresa = validarID(empresa);
            int idusuario = Integer.parseInt(rs.getString("id_usuario"));
            
            if(con.equals(contra)){
                String result = "update tbl_registro set usuario = '"+nombre+"', password = '"+con+"', id_rol = '"+idrol+"', id_empresa = '"+idempresa+"' where id_usuario = "+idusuario;
                st.execute(result);
            }else{
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al editar\n" + e);
        }
    }
    
    //METODO PARA ELIMINAR
    public void eliminar() { 
        try{
            int opcion = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar este registro");
            if(opcion == 0){
                /*int idusuario = Integer.parseInt(rs.getString("id_usuario"));
                String result = "delete from tbl_registro where id_usuario = "+idusuario;
                st.execute(result);*/
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar\n" + e);
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
        jBGuardarNuevo.setEnabled(false);
        jBGuardarNuevo.setPreferredSize(new java.awt.Dimension(120, 32));
        jBGuardarNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(jBGuardarNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jBGuardarCerrar.setText("Guardar y Cerrar");
        jBGuardarCerrar.setEnabled(false);
        jBGuardarCerrar.setPreferredSize(new java.awt.Dimension(120, 32));
        jBGuardarCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(jBGuardarCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jBAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        jBAgregar.setPreferredSize(new java.awt.Dimension(32, 32));
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(jBAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        jBEliminar.setPreferredSize(new java.awt.Dimension(32, 32));
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 20, -1, -1));

        jBRetroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retroceder.png"))); // NOI18N
        jBRetroceder.setPreferredSize(new java.awt.Dimension(32, 32));
        jBRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRetrocederActionPerformed(evt);
            }
        });
        getContentPane().add(jBRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 20, -1, -1));

        jBAvanzar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/avanzar.png"))); // NOI18N
        jBAvanzar.setPreferredSize(new java.awt.Dimension(32, 32));
        jBAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAvanzarActionPerformed(evt);
            }
        });
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

        jTFNombre.setEnabled(false);
        jTFNombre.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 150, -1, -1));

        jCBRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno" }));
        jCBRol.setEnabled(false);
        jCBRol.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jCBRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 300, -1, -1));

        jCBEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno" }));
        jCBEmpresa.setEnabled(false);
        jCBEmpresa.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jCBEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 350, -1, -1));

        jPFPassword.setEnabled(false);
        jPFPassword.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jPFPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 200, -1, -1));

        jPFConfirmarPW.setEnabled(false);
        jPFConfirmarPW.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jPFConfirmarPW, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 250, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        // EDITAR:
        
        
        
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBGuardarCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarCerrarActionPerformed
        // GUARDAR Y CERRAR:
        
        
        
    }//GEN-LAST:event_jBGuardarCerrarActionPerformed

    private void jBGuardarNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarNuevoActionPerformed
        // GUARDAR Y NUEVO:
        
        
        
    }//GEN-LAST:event_jBGuardarNuevoActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        // AGREGAR:
        
        jTFNombre.setEnabled(true);
        jPFPassword.setEnabled(true);
        jPFConfirmarPW.setEnabled(true);
        jCBRol.setEnabled(true);
        jCBEmpresa.setEnabled(true);
        jBGuardarNuevo.setEnabled(true);
        jBGuardarCerrar.setEnabled(true);
        jBAgregar.setEnabled(false);
        jBEliminar.setEnabled(false);
        jBRetroceder.setEnabled(false);
        jBAvanzar.setEnabled(false);
        jBEditar.setEnabled(false);
        jTFNombre.setText("");
        jPFPassword.setText("");
        jPFConfirmarPW.setText("");
        jCBRol.setSelectedIndex(0);
        jCBEmpresa.setSelectedIndex(0);
        
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // ELIMINAR:
        
        
        
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRetrocederActionPerformed
        // RETROCEDER:
        
        
        
    }//GEN-LAST:event_jBRetrocederActionPerformed

    private void jBAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAvanzarActionPerformed
        // AVANZAR:
        
        
        
    }//GEN-LAST:event_jBAvanzarActionPerformed


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
