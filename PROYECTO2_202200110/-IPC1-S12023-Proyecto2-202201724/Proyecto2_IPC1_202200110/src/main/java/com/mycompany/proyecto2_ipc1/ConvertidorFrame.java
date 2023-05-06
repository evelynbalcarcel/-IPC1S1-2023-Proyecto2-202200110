
package com.mycompany.proyecto2_ipc1;

import HANDLERS1.BMPtoJPEGImage;
import HANDLERS1.JPEGHandler;
import HANDLERS1.JPEGImageCopy;
import HANDLERS1.JPEGImageHandlerBN;
import HANDLERS1.JPEGImageHandlerColors;
import HANDLERS1.JPEGImageHandlerRotator;
import HANDLERS1.JPEGtoBMPImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import org.apache.commons.io.FilenameUtils;


public class ConvertidorFrame extends javax.swing.JFrame implements Runnable {

    int indice = 0;
    
    public ConvertidorFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Convertidor de Imagenes");   
        
        //Aqui inicia el modelo para el comboBox
        DefaultComboBoxModel <String> modelo = new DefaultComboBoxModel<>();
        
        for(int i = 0; i < AppState.listaSimple.getSize(); i++){
            String nombre = ((Usuario) AppState.listaSimple.get(i)).nombre;
            modelo.addElement(nombre);
        }
        usuariosComboBox.setModel(modelo);
        
    }
    
    public void actualizarBarraDeProgreso(int valor) {
        jProgressBar1.setValue(valor);
    }
    
    class Barra implements Runnable {

        private JProgressBar progressBar;
        private int progreso;

        public Barra(JProgressBar progressBar) {
            this.progressBar = progressBar;
            this.progreso = 0;
        }

    @Override
      public void run() {
          int progreso = 0;

          // Mientras la barra no haya alcanzado el 100%
          while (progreso < 100) {
              // Incrementa el valor de la barra en un valor aleatorio
              progreso += (int) (Math.random() * 10);

              // Si el progreso es mayor a 100, lo establece en 100
              if (progreso > 100) {
                  progreso = 100;
              }

              // Actualiza la barra de carga
              jProgressBar1.setValue(progreso);

              // Espera un tiempo antes de actualizar de nuevo
              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
    }
    
    class Convertidor implements Runnable{
        private volatile boolean running = true; // variable que indica si el hilo debe seguir ejecutándose
        private int indice = 0;
        public Convertidor(JTextArea textArea) {
            consolaTextArea = textArea;
            
        }
        
        public void stop() {
            running = false; // método para detener el hilo
        }

        @Override
        public void run() {
            while (running) {            
                try {
                    AppState.listaDoble.printListNext(indice, consolaTextArea);
                    indice++;
                } catch (IOException ex) {
                     Logger.getLogger(Convertidor.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 try {
                     Thread.sleep(1000);
                 } catch (Exception e) {
                     e.printStackTrace();
                }
            }
        }
    }
    
        public class ManipulacionImagenes implements Runnable {

        private int indiceImagen;
        private Categorias categoria;
        private String rutaArchivo;

        public ManipulacionImagenes(int indiceImagen, Categorias categoria, String rutaArchivo) {
            this.indiceImagen = indiceImagen;
            this.categoria = categoria;
            this.rutaArchivo = rutaArchivo;
        }

        public void run() {
            String nombreCorto = "";
            Categorias elemento = categoria;
            String elementoConvertido = elemento.toString();

            File f = new File(rutaArchivo);
            nombreCorto = FilenameUtils.removeExtension(f.getName());

            if(nombreCorto.equals(elementoConvertido)){

                if(viceversaRadioButton.isSelected() == true){
                    JPEGtoBMPImage handlerJPG = new JPEGtoBMPImage(rutaArchivo);
                    BMPtoJPEGImage handlerBMP = new BMPtoJPEGImage(rutaArchivo);

                    try{
                        JPEGHandler.runHandler(handlerJPG);
                        JPEGHandler.runHandler(handlerBMP);
                    } catch(Exception ex){
                        ex.printStackTrace(); 
                    }
                }

                if(copiaRadioButton.isSelected() == true){
                    JPEGImageCopy handlerCopy = new JPEGImageCopy(rutaArchivo);

                    try{
                        JPEGHandler.runHandler(handlerCopy);
                    } catch(Exception ex){
                        ex.printStackTrace(); 
                    } 
                } 

                if(coloresRadioButton.isSelected() == true){
                    JPEGImageHandlerColors handlerColors = new JPEGImageHandlerColors(rutaArchivo);

                    try{
                        JPEGHandler.runHandler(handlerColors);
                    } catch(Exception ex){
                        ex.printStackTrace(); 
                    }
                }

                if(modificarRadioButton.isSelected() == true){
                    JPEGImageHandlerRotator handlerModificar = new JPEGImageHandlerRotator(rutaArchivo);

                    try{
                        JPEGHandler.runHandler(handlerModificar);
                    } catch(Exception ex){
                        ex.printStackTrace(); 
                    }
                }

                if(bnRaddioButton.isSelected() == true){
                    JPEGImageHandlerBN handlerBN = new JPEGImageHandlerBN(rutaArchivo);

                    try{
                        JPEGHandler.runHandler(handlerBN);
                    } catch(Exception ex){
                        ex.printStackTrace(); 
                    }
                } 
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        usuariosComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        categoriaComboBox = new javax.swing.JComboBox<>();
        AgregarImagenesButton = new javax.swing.JButton();
        viceversaRadioButton = new javax.swing.JRadioButton();
        copiaRadioButton = new javax.swing.JRadioButton();
        coloresRadioButton = new javax.swing.JRadioButton();
        modificarRadioButton = new javax.swing.JRadioButton();
        bnRaddioButton = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        paraleloButton = new javax.swing.JButton();
        RegresarButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        consolaTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        CategoriasList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Usuario");

        usuariosComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "USUARIOS" }));
        usuariosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Categoria");

        categoriaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CATEGORIAS" }));

        AgregarImagenesButton.setBackground(new java.awt.Color(204, 255, 204));
        AgregarImagenesButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AgregarImagenesButton.setForeground(new java.awt.Color(0, 0, 0));
        AgregarImagenesButton.setText("Agregar");
        AgregarImagenesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarImagenesButtonActionPerformed(evt);
            }
        });

        viceversaRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        viceversaRadioButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        viceversaRadioButton.setForeground(new java.awt.Color(0, 0, 0));
        viceversaRadioButton.setText("JPEG a BMP o viceversa");

        copiaRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        copiaRadioButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        copiaRadioButton.setForeground(new java.awt.Color(0, 0, 0));
        copiaRadioButton.setText("copia JPEG");

        coloresRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        coloresRadioButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        coloresRadioButton.setForeground(new java.awt.Color(0, 0, 0));
        coloresRadioButton.setText("Rojo Verde Azul Sepia");

        modificarRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        modificarRadioButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        modificarRadioButton.setForeground(new java.awt.Color(0, 0, 0));
        modificarRadioButton.setText("Modificar Imagen");

        bnRaddioButton.setBackground(new java.awt.Color(255, 255, 255));
        bnRaddioButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        bnRaddioButton.setForeground(new java.awt.Color(0, 0, 0));
        bnRaddioButton.setText("Blanco y Negro");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setAlignmentY(1.0F);

        paraleloButton.setBackground(new java.awt.Color(153, 255, 255));
        paraleloButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        paraleloButton.setForeground(new java.awt.Color(0, 0, 0));
        paraleloButton.setText("Ejecutar en Paralelo");
        paraleloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paraleloButtonActionPerformed(evt);
            }
        });

        RegresarButton.setBackground(new java.awt.Color(255, 255, 204));
        RegresarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RegresarButton.setForeground(new java.awt.Color(0, 0, 0));
        RegresarButton.setText("Salir");
        RegresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarButtonActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Cola de procesamiento");

        jProgressBar1.setBackground(null);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cantidad Procesada");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Cantidad Procesada");

        consolaTextArea.setBackground(null);
        consolaTextArea.setColumns(20);
        consolaTextArea.setForeground(new java.awt.Color(0, 0, 0));
        consolaTextArea.setRows(5);
        jScrollPane1.setViewportView(consolaTextArea);

        CategoriasList.setBackground(null);
        CategoriasList.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        CategoriasList.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(CategoriasList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuariosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(51, 51, 51)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(categoriaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(52, 52, 52)
                                    .addComponent(AgregarImagenesButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(RegresarButton))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(viceversaRadioButton)
                                        .addComponent(copiaRadioButton, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(coloresRadioButton, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(modificarRadioButton, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bnRaddioButton, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(18, 18, 18)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(paraleloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(121, 121, 121)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(109, 109, 109))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(108, 108, 108)))))
                                .addGap(10, 10, 10)))))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuariosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(categoriaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(AgregarImagenesButton)
                    .addComponent(RegresarButton))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(viceversaRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(copiaRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(coloresRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(modificarRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bnRaddioButton))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(paraleloButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarButtonActionPerformed
        // TODO add your handling code here:
        VentanaPrincipalFrame login = new VentanaPrincipalFrame();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegresarButtonActionPerformed

    private void usuariosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosComboBoxActionPerformed
        // TODO add your handling code here:
        
        String nombreSeleccionado = (String) usuariosComboBox.getSelectedItem();
        DefaultComboBoxModel <String> modelo = new DefaultComboBoxModel<>();
        
        for(int i = 0; i < AppState.categoria.size(); i++){
            
            String usuario = AppState.categoria.get(i).nombre;
            
            if(nombreSeleccionado.equals(usuario)){
                String categoriaAlmacenada = AppState.categoria.get(i).categoria;
                modelo.addElement(categoriaAlmacenada);
            }
        }
        categoriaComboBox.setModel(modelo);
        
    }//GEN-LAST:event_usuariosComboBoxActionPerformed

    private void paraleloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paraleloButtonActionPerformed
        // TODO add your handling code here:
        
        DefaultListModel<Categorias> modeloLista = (DefaultListModel<Categorias>) CategoriasList.getModel();
        int cantidadElementos = modeloLista.getSize();

        for(int i=0; i<cantidadElementos; i++){
            Categorias categoria = modeloLista.getElementAt(i);
            String rutaArchivo = ((Imagen)AppState.listaDoble.get(i)).getArchivo(); 

            ManipulacionImagenes manipulacion = new ManipulacionImagenes(i, categoria, rutaArchivo);
            Thread hilo = new Thread(manipulacion);
            hilo.start();
        }
        
        Convertidor hilo = new Convertidor(consolaTextArea);
        Thread thread = new Thread(hilo);
        thread.start();
        
        Barra barra = new Barra(jProgressBar1);
        Thread thread1 = new Thread(barra);
        thread1.start();        
    }//GEN-LAST:event_paraleloButtonActionPerformed

    private void AgregarImagenesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarImagenesButtonActionPerformed
        // TODO add your handling code here:
        
        DefaultListModel<Categorias> modeloLista = new DefaultListModel<>();
        
        for(int z = 0 ; z < CategoriasList.getModel().getSize() ; z++){
            modeloLista.addElement((Categorias) CategoriasList.getModel().getElementAt(z));
        }
        
        String nombreCorto;
        String nombreSeleccionado = (String) usuariosComboBox.getSelectedItem();
        String categoriaSeleccionada = (String) categoriaComboBox.getSelectedItem();
        
        for(int i = 0; i < AppState.listaDoble.getSize(); i++){
            String nombreAlmacenado = ((Imagen) AppState.listaDoble.get(i)).getNombre();
            String categoriaAlmacenada = ((Imagen) AppState.listaDoble.get(i)).getCategoria();
            
            if(nombreAlmacenado.equalsIgnoreCase(nombreSeleccionado) && categoriaSeleccionada.equals(categoriaAlmacenada)){
                
                String ruta = ((Imagen)AppState.listaDoble.get(i)).getArchivo(); 
                
                File f = new File(ruta);
                nombreCorto = FilenameUtils.removeExtension(f.getName());
                
                System.out.println( i + ") Este es el nombre de las imagenes que existen: " + nombreCorto);
                
                Categorias nuevaCategoria = new Categorias(nombreCorto);
                modeloLista.addElement(nuevaCategoria);
                
            }
        }
        CategoriasList.setModel(modeloLista);
    }//GEN-LAST:event_AgregarImagenesButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ConvertidorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConvertidorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConvertidorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConvertidorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConvertidorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarImagenesButton;
    private javax.swing.JList CategoriasList;
    private javax.swing.JButton RegresarButton;
    private javax.swing.JRadioButton bnRaddioButton;
    private javax.swing.JComboBox<String> categoriaComboBox;
    private javax.swing.JRadioButton coloresRadioButton;
    private javax.swing.JTextArea consolaTextArea;
    private javax.swing.JRadioButton copiaRadioButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton modificarRadioButton;
    private javax.swing.JButton paraleloButton;
    private javax.swing.JComboBox usuariosComboBox;
    private javax.swing.JRadioButton viceversaRadioButton;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void run() {
        
    }
}
