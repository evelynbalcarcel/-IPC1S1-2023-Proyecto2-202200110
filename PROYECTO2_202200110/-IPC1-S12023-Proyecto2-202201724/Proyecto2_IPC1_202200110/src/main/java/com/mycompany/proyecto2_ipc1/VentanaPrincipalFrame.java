
package com.mycompany.proyecto2_ipc1;

import javax.swing.JOptionPane;


public class VentanaPrincipalFrame extends javax.swing.JFrame {

    public VentanaPrincipalFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Ventana Principal");        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        usuarioText = new javax.swing.JTextField();
        bibliotecaButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        editorButton = new javax.swing.JButton();
        convertidorButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Usuario");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bibliotecaButton.setText("Ingresar a Biblioteca");
        bibliotecaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bibliotecaButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("MENU");

        editorButton.setText("Ingresar editor");
        editorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editorButtonActionPerformed(evt);
            }
        });

        convertidorButton.setText("Ingresar a convertidor");
        convertidorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertidorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(usuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(bibliotecaButton)))
                .addGap(52, 52, 52)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editorButton)
                        .addGap(40, 40, 40)
                        .addComponent(convertidorButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(bibliotecaButton))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editorButton)
                    .addComponent(convertidorButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bibliotecaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bibliotecaButtonActionPerformed
        // TODO add your handling code here:
        
        String usuario = usuarioText.getText();

        
        if(usuario.isEmpty()){
            JOptionPane.showMessageDialog(null, "Tiene que ingresar datos validos", "Error de credenciales", JOptionPane.WARNING_MESSAGE);
        } else {
            Usuario usuarios = new Usuario(usuario);
            AppState.listaSimple.add(usuarios);
            AppState.listaSimple.listarNombres();
            AppState.nombreUsuarios = usuario;
            
            BibliotecaFrame login = new BibliotecaFrame();
            login.setVisible(true);
            dispose();        
        }
    }//GEN-LAST:event_bibliotecaButtonActionPerformed

    private void editorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editorButtonActionPerformed
        // TODO add your handling code here:
        EditorsFrame editor = new EditorsFrame();
        editor.setVisible(true);
        dispose();
    }//GEN-LAST:event_editorButtonActionPerformed

    private void convertidorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertidorButtonActionPerformed
        // TODO add your handling code here:
        ConvertidorFrame login = new ConvertidorFrame();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_convertidorButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VentanaPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipalFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bibliotecaButton;
    private javax.swing.JButton convertidorButton;
    private javax.swing.JButton editorButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField usuarioText;
    // End of variables declaration//GEN-END:variables
}
