package sistemapos;

public class JFFPantallaPrincipal extends javax.swing.JFrame {

    public JFFPantallaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMBBarraDeNavegacion = new javax.swing.JMenuBar();
        jMConfiguraciones = new javax.swing.JMenu();
        jMIUsuarios = new javax.swing.JMenuItem();
        jMIRoles = new javax.swing.JMenuItem();
        jMIEmpresas = new javax.swing.JMenuItem();
        jMIPrivilegios = new javax.swing.JMenuItem();
        jMIPaises = new javax.swing.JMenuItem();
        jMModulos = new javax.swing.JMenu();
        jMAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));

        escritorio.setPreferredSize(new java.awt.Dimension(1100, 600));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        jMConfiguraciones.setText("Configuraciones");

        jMIUsuarios.setText("Usuarios");
        jMIUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIUsuariosActionPerformed(evt);
            }
        });
        jMConfiguraciones.add(jMIUsuarios);

        jMIRoles.setText("Roles");
        jMIRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRolesActionPerformed(evt);
            }
        });
        jMConfiguraciones.add(jMIRoles);

        jMIEmpresas.setText("Empresas");
        jMIEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIEmpresasActionPerformed(evt);
            }
        });
        jMConfiguraciones.add(jMIEmpresas);

        jMIPrivilegios.setText("Privilegios");
        jMIPrivilegios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrivilegiosActionPerformed(evt);
            }
        });
        jMConfiguraciones.add(jMIPrivilegios);

        jMIPaises.setText("Países");
        jMIPaises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPaisesActionPerformed(evt);
            }
        });
        jMConfiguraciones.add(jMIPaises);

        jMBBarraDeNavegacion.add(jMConfiguraciones);

        jMModulos.setText("Módulos");
        jMBBarraDeNavegacion.add(jMModulos);

        jMAyuda.setText("Ayuda");
        jMBBarraDeNavegacion.add(jMAyuda);

        setJMenuBar(jMBBarraDeNavegacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRolesActionPerformed
        // ROLES
        JIFFRol moduloRol = new JIFFRol();
        escritorio.add(moduloRol);
        moduloRol.show();
        
        
    }//GEN-LAST:event_jMIRolesActionPerformed

    private void jMIUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIUsuariosActionPerformed
        // USUARIOS
        JIFFUsuario moduloUsuario = new JIFFUsuario();
        escritorio.add(moduloUsuario);
        moduloUsuario.show();
        
    }//GEN-LAST:event_jMIUsuariosActionPerformed

    private void jMIEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEmpresasActionPerformed
        // EMPRESAS
        JIFFEmpresa moduloEmpresa = new JIFFEmpresa();
        escritorio.add(moduloEmpresa);
        moduloEmpresa.show();
        
    }//GEN-LAST:event_jMIEmpresasActionPerformed

    private void jMIPrivilegiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrivilegiosActionPerformed
        // PRIVILEGIOS
        JIFFPrivilegio moduloPrivilegio = new JIFFPrivilegio();
        escritorio.add(moduloPrivilegio);
        moduloPrivilegio.show();
        
    }//GEN-LAST:event_jMIPrivilegiosActionPerformed

    private void jMIPaisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPaisesActionPerformed
        // PAISES
        JIFFPais moduloPais = new JIFFPais();
        escritorio.add(moduloPais);
        moduloPais.show();
        
    }//GEN-LAST:event_jMIPaisesActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFFPantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFFPantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFFPantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFFPantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFFPantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMAyuda;
    private javax.swing.JMenuBar jMBBarraDeNavegacion;
    private javax.swing.JMenu jMConfiguraciones;
    private javax.swing.JMenuItem jMIEmpresas;
    private javax.swing.JMenuItem jMIPaises;
    private javax.swing.JMenuItem jMIPrivilegios;
    private javax.swing.JMenuItem jMIRoles;
    private javax.swing.JMenuItem jMIUsuarios;
    private javax.swing.JMenu jMModulos;
    // End of variables declaration//GEN-END:variables
}
