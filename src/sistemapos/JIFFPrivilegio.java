package sistemapos;

import java.sql.*;
import javax.swing.*;


public class JIFFPrivilegio extends javax.swing.JInternalFrame {

    //CREAMOS VARIABLES
    boolean editar = false;
    
    //INSTANCIA DE LA CLASE ConexionSQL
    ConexionSQL conexion = new ConexionSQL();
    
    public JIFFPrivilegio() {
        initComponents();
        ultimoValor();
    }
    
    //METODO PARA INGRESAR DATOS EN JIIFUsuarios
    public void insertar() {
        try{
            conexion.conectar();
            String privilegio = jTFPrivilegio.getText();
            String result = "insert into tbl_privilegios values ('0','"+privilegio+"')";
            conexion.st.execute(result);
            conexion.cn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error ingresando datos\n" + e);
        }
    }
    
    //ULTIMO VALOR REGISTRADO
    public void ultimoValor() {
        try {
            conexion.conectar();
            int idprivilegio;
            String privilegio;
            conexion.rs = conexion.st.executeQuery("select * from tbl_privilegios order by id_privilegio asc");
            if(conexion.rs.last()){
                idprivilegio = Integer.parseInt(conexion.rs.getString("id_privilegio"));
                jTFIDPrivilegio.setText(idprivilegio+"");
                privilegio = conexion.rs.getString("nombre_privilegio");
                jTFPrivilegio.setText(privilegio);
            }
            conexion.cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error consultando tabla\n" + e);
        }
    }
    
    //METODO PARA RETROCEDER EN LAS CONSULTAS
    public void retroceder() {
        try {
            conexion.conectar();
            int idprivilegio;
            String privilegio;
            if(conexion.rs.previous()){
                idprivilegio = Integer.parseInt(conexion.rs.getString("id_privilegio"));
                jTFIDPrivilegio.setText(idprivilegio+"");
                privilegio = conexion.rs.getString("nombre_privilegio");
                jTFPrivilegio.setText(privilegio);
            }else{
                conexion.rs.next();
                JOptionPane.showMessageDialog(null, "No hay mas registros");
            }
            conexion.cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error consultando tabla\n" + e);
        }
    }
    
    //METODO PARA AVANZAR EN LAS CONSULTAS
    public void avanzar() {
        try {
            conexion.conectar();
            int idprivilegio;
            String privilegio;
            if(conexion.rs.next()){
                idprivilegio = Integer.parseInt(conexion.rs.getString("id_privilegio"));
                jTFIDPrivilegio.setText(idprivilegio+"");
                privilegio = conexion.rs.getString("nombre_privilegio");
                jTFPrivilegio.setText(privilegio);
            }else{
                conexion.rs.previous();
                JOptionPane.showMessageDialog(null, "No hay mas registros");
            }
            conexion.cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error consultando tabla\n" + e);
        }
    }
    
    //METODO PARA EDITAR
    public void editar() {
        try{
            conexion.conectar();
            //int idrol = Integer.parseInt(jTFIDRol.getText());
            //String rol = jTFRol.getText();
            //String result = "update tbl_roles set nombre_rol = '"+rol+"' where id_rol = "+idrol;
            //conexion.st.execute(result);
            conexion.cn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al editar\n" + e);
        }
    }
    
    //METODO PARA ELIMINAR
    public void eliminar() {
        try{
            conexion.conectar();
            int opcion = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar este registro");
            if(opcion == 0){
                /*int idrol = Integer.parseInt(rs.getString("id_rol"));
                String result = "delete from tbl_roles where id_rol = "+idrol;
                st.execute(result);*/
            }
            conexion.cn.close();
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
        jLIDPrivilegio = new javax.swing.JLabel();
        jLPrivilegio = new javax.swing.JLabel();
        jTFIDPrivilegio = new javax.swing.JTextField();
        jTFPrivilegio = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Módulo De Privilegios");
        setPreferredSize(new java.awt.Dimension(550, 300));
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

        jLIDPrivilegio.setText("ID Privilegio:");
        getContentPane().add(jLIDPrivilegio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLPrivilegio.setText("Privilegio:");
        getContentPane().add(jLPrivilegio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jTFIDPrivilegio.setEnabled(false);
        jTFIDPrivilegio.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jTFIDPrivilegio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        jTFPrivilegio.setEnabled(false);
        jTFPrivilegio.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jTFPrivilegio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarNuevoActionPerformed
        // GUARDAR Y NUEVO:

        insertar();
        jTFPrivilegio.setText("");

    }//GEN-LAST:event_jBGuardarNuevoActionPerformed

    private void jBGuardarCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarCerrarActionPerformed
        // GUARDAR Y CERRAR:

        if(editar){
            editar();
        }else{
            insertar();
        }
        this.show(false);

    }//GEN-LAST:event_jBGuardarCerrarActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        // AGREGAR:

        jTFPrivilegio.setEnabled(true);
        jBGuardarNuevo.setEnabled(true);
        jBGuardarCerrar.setEnabled(true);
        jBAgregar.setEnabled(false);
        jBEliminar.setEnabled(false);
        jBRetroceder.setEnabled(false);
        jBAvanzar.setEnabled(false);
        jBEditar.setEnabled(false);
        jTFIDPrivilegio.setText("");
        jTFPrivilegio.setText("");

    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // ELIMINAR:

        eliminar();

    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRetrocederActionPerformed
        // RETROCEDER:

        retroceder();

    }//GEN-LAST:event_jBRetrocederActionPerformed

    private void jBAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAvanzarActionPerformed
        // AVANZAR:

        avanzar();

    }//GEN-LAST:event_jBAvanzarActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        // EDITAR:

        jTFPrivilegio.setEnabled(true);
        jBGuardarNuevo.setEnabled(false);
        jBGuardarCerrar.setEnabled(true);
        jBAgregar.setEnabled(false);
        jBEliminar.setEnabled(false);
        jBRetroceder.setEnabled(false);
        jBAvanzar.setEnabled(false);
        jBEditar.setEnabled(false);
        editar = true;

    }//GEN-LAST:event_jBEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBAvanzar;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardarCerrar;
    private javax.swing.JButton jBGuardarNuevo;
    private javax.swing.JButton jBRetroceder;
    private javax.swing.JLabel jLIDPrivilegio;
    private javax.swing.JLabel jLPrivilegio;
    private javax.swing.JTextField jTFIDPrivilegio;
    private javax.swing.JTextField jTFPrivilegio;
    // End of variables declaration//GEN-END:variables

}
