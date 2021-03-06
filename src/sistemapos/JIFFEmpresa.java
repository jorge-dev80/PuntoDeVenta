package sistemapos;

import java.sql.*;
import javax.swing.*;


public class JIFFEmpresa extends javax.swing.JInternalFrame {

    //CREAMOS VARIABLES
    boolean editar = false;
    
    //INSTANCIA DE LA CLASE ConexionSQL
    ConexionSQL conexion = new ConexionSQL();
    
    public JIFFEmpresa() {
        initComponents();
        ultimoValor();
    }
    
    //METODO PARA INGRESAR DATOS EN JIIFUsuarios
    public void insertar() {
        try{
            conexion.conectar();
            String nombre = jTFNombre.getText();
            String rfc = jTFRFC.getText();
            String giro = jTFGiro.getText();
            String result = "insert into tbl_empresas values ('0','"+nombre+"','"+rfc+"','"+giro+"')";
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
            int idempresa;
            String nombre, rfc, giro;
            conexion.rs = conexion.st.executeQuery("select * from tbl_empresas order by id_empresa asc");
            if(conexion.rs.last()){
                idempresa = Integer.parseInt(conexion.rs.getString("id_empresa"));
                jTFIDEmpresa.setText(idempresa+"");
                nombre = conexion.rs.getString("nombre_empresa");
                jTFNombre.setText(nombre);
                rfc = conexion.rs.getString("rfc");
                jTFRFC.setText(rfc);
                giro = conexion.rs.getString("giro");
                jTFGiro.setText(giro);
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
            String nombre, rfc, giro;
            int idempresa;
            if(conexion.rs.previous()){
                idempresa = Integer.parseInt(conexion.rs.getString("id_empresa"));
                jTFIDEmpresa.setText(idempresa+"");
                nombre = conexion.rs.getString("nombre_empresa");
                jTFNombre.setText(nombre);
                rfc = conexion.rs.getString("rfc");
                jTFRFC.setText(rfc);
                giro = conexion.rs.getString("giro");
                jTFGiro.setText(giro);
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
            String nombre, rfc, giro;
            int idempresa;
            if(conexion.rs.next()){
                idempresa = Integer.parseInt(conexion.rs.getString("id_empresa"));
                jTFIDEmpresa.setText(idempresa+"");
                nombre = conexion.rs.getString("nombre_empresa");
                jTFNombre.setText(nombre);
                rfc = conexion.rs.getString("rfc");
                jTFRFC.setText(rfc);
                giro = conexion.rs.getString("giro");
                jTFGiro.setText(giro);
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
            int idempresa = Integer.parseInt(jTFIDEmpresa.getText());
            String nombre = jTFNombre.getText();
            String rfc = jTFRFC.getText();
            String giro = jTFGiro.getText();
            String result = "update tbl_empresas set nombre_empresa = '"+nombre+"', rfc = '"+rfc+"', giro = '"+giro+"' where id_empresa = "+idempresa;
            conexion.st.execute(result);
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
                /*int idempresa = Integer.parseInt(conexion.rs.getString("id_empresa"));
                String result = "delete from tbl_empresas where id_empresa = "+idempresa;
                conexion.st.execute(result);*/
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
        jLIDEmpresa = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLRFC = new javax.swing.JLabel();
        jLGiro = new javax.swing.JLabel();
        jTFIDEmpresa = new javax.swing.JTextField();
        jTFNombre = new javax.swing.JTextField();
        jTFRFC = new javax.swing.JTextField();
        jTFGiro = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Módulo Empresa");
        setPreferredSize(new java.awt.Dimension(550, 400));
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

        jLIDEmpresa.setText("ID Empresa:");
        getContentPane().add(jLIDEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLNombre.setText("Nombre:");
        getContentPane().add(jLNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLRFC.setText("RFC:");
        getContentPane().add(jLRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLGiro.setText("Giro:");
        getContentPane().add(jLGiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jTFIDEmpresa.setEnabled(false);
        jTFIDEmpresa.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jTFIDEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 100, -1, -1));

        jTFNombre.setEnabled(false);
        jTFNombre.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 150, -1, -1));

        jTFRFC.setEnabled(false);
        jTFRFC.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jTFRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 200, -1, -1));

        jTFGiro.setEnabled(false);
        jTFGiro.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jTFGiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 250, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarNuevoActionPerformed
        // GUARDAR Y NUEVO:

        insertar();
        jTFIDEmpresa.setText("");
        jTFNombre.setText("");
        jTFRFC.setText("");
        jTFGiro.setText("");

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

        jTFNombre.setEnabled(true);
        jTFRFC.setEnabled(true);
        jTFGiro.setEnabled(true);
        jBGuardarNuevo.setEnabled(true);
        jBGuardarCerrar.setEnabled(true);
        jBAgregar.setEnabled(false);
        jBEliminar.setEnabled(false);
        jBRetroceder.setEnabled(false);
        jBAvanzar.setEnabled(false);
        jBEditar.setEnabled(false);
        jTFIDEmpresa.setText("");
        jTFNombre.setText("");
        jTFRFC.setText("");
        jTFGiro.setText("");

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

        jTFNombre.setEnabled(true);
        jTFRFC.setEnabled(true);
        jTFGiro.setEnabled(true);
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
    private javax.swing.JLabel jLGiro;
    private javax.swing.JLabel jLIDEmpresa;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLRFC;
    private javax.swing.JTextField jTFGiro;
    private javax.swing.JTextField jTFIDEmpresa;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFRFC;
    // End of variables declaration//GEN-END:variables

}
