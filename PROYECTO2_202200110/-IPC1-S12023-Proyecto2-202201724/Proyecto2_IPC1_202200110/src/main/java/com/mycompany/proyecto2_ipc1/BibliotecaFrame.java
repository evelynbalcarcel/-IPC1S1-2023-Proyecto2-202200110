
package com.mycompany.proyecto2_ipc1;

import java.awt.Image;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class BibliotecaFrame extends javax.swing.JFrame {

    /**
     * Creates new form BibliotecaFrame
     */
    private int indiceActual = 0;
    public BibliotecaFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Biblioteca"); 
        
        NombreUsuario.setText(AppState.nombreUsuarios);
        String nombreUsuario = AppState.nombreUsuarios;
        
        DefaultListModel<Categorias> modeloLista = new DefaultListModel<>();
        for(int i = 0; i < AppState.categoria.size(); i++){
            if(AppState.categoria.get(i).getNombre().equalsIgnoreCase(nombreUsuario)){
                Categorias nuevaCategoria = new Categorias(AppState.categoria.get(i).getCategoria());
                modeloLista.addElement(nuevaCategoria);
            }
            
            String categoriaAlmacenada = AppState.categoria.get(i).categoria;
            for(int j = 0 ; j < AppState.listaDoble.getSize() ; j++){
                String nombreUsuario1 = ((Imagen)AppState.listaDoble.get(j)).getNombre();
                String CategoriaAlamcenada1 = ((Imagen)AppState.listaDoble.get(j)).getCategoria();
                //Imagen imagen = (Imagen) AppState.listaDoble.get(j);
                if(categoriaAlmacenada.equals(CategoriaAlamcenada1) && nombreUsuario.equals(nombreUsuario1)){
                    ImageIcon imagenActual = ((Imagen)AppState.listaDoble.get(j)).getImageIcon();
                    Image imagenOriginal = imagenActual.getImage();
                    Image imagenRedimensionada = imagenOriginal.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon imagenRedimensionadaIcon = new ImageIcon(imagenRedimensionada);
                    imagenLabel.setIcon(imagenRedimensionadaIcon);
                }
            }
        }
        
        if (modeloLista.isEmpty()) {
            Categorias categorias1 = new Categorias(nombreUsuario, "General");
            AppState.categoria.add(categorias1);
            modeloLista.addElement(categorias1);
        }
        
        CategoriasList.setModel(modeloLista);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        CategoriasList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        categoriaText = new javax.swing.JTextField();
        añadirCategoriaButton = new javax.swing.JButton();
        eliminarCategoriaButton = new javax.swing.JButton();
        agregarImagenButton = new javax.swing.JButton();
        eliminarImagenButton = new javax.swing.JButton();
        imagenLabel = new javax.swing.JLabel();
        SalirButton = new javax.swing.JButton();
        SiguienteButton = new javax.swing.JButton();
        AnteriorButton = new javax.swing.JButton();
        NombreUsuario = new javax.swing.JLabel();
        ContadorFotosLabel = new javax.swing.JLabel();
        RutaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CategoriasList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "General" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        CategoriasList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                CategoriasListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(CategoriasList);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("CATEGORIAS");

        añadirCategoriaButton.setText("Añadir Categoria");
        añadirCategoriaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirCategoriaButtonActionPerformed(evt);
            }
        });

        eliminarCategoriaButton.setText("Eliminar Categoria");
        eliminarCategoriaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCategoriaButtonActionPerformed(evt);
            }
        });

        agregarImagenButton.setText("Agregar Imagen");
        agregarImagenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarImagenButtonActionPerformed(evt);
            }
        });

        eliminarImagenButton.setText("Eliminar Imagen");
        eliminarImagenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarImagenButtonActionPerformed(evt);
            }
        });

        SalirButton.setText("Regresar");
        SalirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirButtonActionPerformed(evt);
            }
        });

        SiguienteButton.setText(">");
        SiguienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteButtonActionPerformed(evt);
            }
        });

        AnteriorButton.setText("<");
        AnteriorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnteriorButtonActionPerformed(evt);
            }
        });

        NombreUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NombreUsuario.setText("Usuario");

        ContadorFotosLabel.setText("-----------");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(75, 75, 75)
                        .addComponent(agregarImagenButton)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarImagenButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NombreUsuario)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(añadirCategoriaButton)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarCategoriaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SalirButton)
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RutaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(categoriaText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(75, 75, 75)
                                            .addComponent(AnteriorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(imagenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(SiguienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ContadorFotosLabel)
                                            .addGap(321, 321, 321))))))
                        .addContainerGap(46, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregarImagenButton)
                            .addComponent(eliminarImagenButton))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 22, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(categoriaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(AnteriorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadirCategoriaButton)
                    .addComponent(eliminarCategoriaButton)
                    .addComponent(SalirButton))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(NombreUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ContadorFotosLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SiguienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagenLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(RutaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirButtonActionPerformed
        // TODO add your handling code here:
        VentanaPrincipalFrame login = new VentanaPrincipalFrame();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_SalirButtonActionPerformed

    private void añadirCategoriaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirCategoriaButtonActionPerformed
        // TODO add your handling code here:
        
        String nombre = NombreUsuario.getText();
        String categoria = categoriaText.getText();
        String nombreUsuario = AppState.nombreUsuarios;
        
        if(categoria.isEmpty()){
            JOptionPane.showMessageDialog(null, "Tiene que ingresar datos validos", "Error de credenciales", JOptionPane.WARNING_MESSAGE);
        } else {
            Categorias categorias1 = new Categorias(nombre, categoria);
            
            AppState.categoria.add(categorias1);
            
        for (Categorias cat : AppState.categoria){
            System.out.println("Nombre: " + cat.getNombre() + ", Categoria " + cat.getCategoria());
        }
            
        categoriaText.setText(null);
        
        // Obtener la referencia al modelo de la lista
        DefaultListModel<Categorias> modeloLista = (DefaultListModel<Categorias>) CategoriasList.getModel();
        modeloLista.clear(); // Borrar todas las categorías actuales

        for (Categorias cat : AppState.categoria){
            if (cat.getNombre().equalsIgnoreCase(nombreUsuario)) { // Agregar solo las categorías del usuario actual
                Categorias nuevaCategoria = new Categorias(cat.getCategoria());
                modeloLista.addElement(nuevaCategoria);
            }
        }
        JOptionPane.showMessageDialog(null, "Categoria Agregada", "Categoria Agregada", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_añadirCategoriaButtonActionPerformed

    private void eliminarCategoriaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCategoriaButtonActionPerformed
        // TODO add your handling code here:
        
        // Obtener la referencia al modelo de la lista
        DefaultListModel<Categorias> modeloLista = (DefaultListModel<Categorias>) CategoriasList.getModel();
        int indiceSeleccionado = CategoriasList.getSelectedIndex();
    
        if (indiceSeleccionado != -1) {
            Categorias categoriaSeleccionada = modeloLista.getElementAt(indiceSeleccionado);
        
        for (Categorias cat : AppState.categoria) {
            if (cat.getCategoria().equals(categoriaSeleccionada.getCategoria())) {
                AppState.categoria.remove(cat);
                modeloLista.removeElement(categoriaSeleccionada);
                JOptionPane.showMessageDialog(null, "Categoria Eliminada", "Eliminar Categoria", JOptionPane.INFORMATION_MESSAGE);
                break;
                }
            }
        }
    }//GEN-LAST:event_eliminarCategoriaButtonActionPerformed

    private void agregarImagenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarImagenButtonActionPerformed
        // TODO add your handling code here:

        String nombreUsuario = AppState.nombreUsuarios;
        DefaultListModel<Categorias> modeloLista = (DefaultListModel<Categorias>) CategoriasList.getModel();
        int indiceSeleccionado = CategoriasList.getSelectedIndex();
        
        if (indiceSeleccionado != -1) {
            Categorias categoriaSeleccionada = modeloLista.getElementAt(indiceSeleccionado);
            String categoriaTransformada = categoriaSeleccionada.toString();
            
            JFileChooser selector = new JFileChooser();
            int resultado = selector.showOpenDialog(this);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = selector.getSelectedFile();
                ImageIcon imagen = new ImageIcon(archivo.getAbsolutePath());
                Image imagenRedimensionada = imagen.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imagenRedimensionadaIcon = new ImageIcon(imagenRedimensionada);
                imagenLabel.setIcon(imagenRedimensionadaIcon);    

                Imagen imagenes = new Imagen(nombreUsuario, categoriaTransformada, archivo, imagen);

                AppState.listaDoble.add(imagenes);
                AppState.listaDoble.imprimirLista();


                // Obtener la ruta de la imagen actual
                String rutaImagenActual = ((Imagen) AppState.listaDoble.get(indiceActual)).getArchivo();

                // Actualizar el label con la ruta de la imagen actual
                RutaLabel.setText("Ruta de la imagen: " + rutaImagenActual);

                // actualiza el texto del JLabel con la posición actual
                int totalFotos = AppState.listaDoble.getSize();
                String textoLabel = categoriaTransformada + " " + (indiceActual + 1) + "/" + totalFotos;
                ContadorFotosLabel.setText(textoLabel);
                System.out.println(textoLabel);
                JOptionPane.showMessageDialog(null, "Imagen agregada", "Agregada con exito", JOptionPane.INFORMATION_MESSAGE);
            } 
        }
    }//GEN-LAST:event_agregarImagenButtonActionPerformed

    private void eliminarImagenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarImagenButtonActionPerformed
        // TODO add your handling code here:
        
        // Obtener el nombre del archivo de la imagen que se muestra en el JLabel
        String nombreArchivo = RutaLabel.getText().replace("Ruta de la imagen: ", "");

        // Iterar a través de la lista doble enlazada para encontrar la imagen que coincida con los valores obtenidos
        for(int i = 0; i < AppState.listaDoble.getSize(); i++){
            String ruta = ((Imagen)AppState.listaDoble.get(i)).getArchivo();
            if(nombreArchivo.equals(ruta)){
                // Eliminar la imagen de la lista
                AppState.listaDoble.delete(ruta);
                System.out.println("Imagen eliminada.");

                // Actualizar el índice actual
                if (indiceActual >= AppState.listaDoble.getSize()) {
                    indiceActual = AppState.listaDoble.getSize() - 1;
                }

                // Actualizar la imagen actual
                if (AppState.listaDoble.getSize() > 0) {
                    String rutaImagen = ((Imagen) AppState.listaDoble.get(indiceActual)).getArchivo();
                    RutaLabel.setText("Ruta de la imagen: " + rutaImagen);
                    // Obtener la imagen a partir de la ruta
                    ImageIcon imagenOriginal = new ImageIcon(rutaImagen);
                    Image imagen = imagenOriginal.getImage();

                    // Obtener el tamaño actual del JLabel
                    int anchoLabel = imagenLabel.getWidth();
                    int altoLabel = imagenLabel.getHeight();

                    // Redimensionar la imagen
                    Image imagenRedimensionada = imagen.getScaledInstance(anchoLabel, altoLabel, Image.SCALE_SMOOTH);

                    // Crear un nuevo ImageIcon con la imagen redimensionada
                    ImageIcon imagenRedimensionadaIcon = new ImageIcon(imagenRedimensionada);

                    // Actualizar la imagen del JLabel
                    imagenLabel.setIcon(imagenRedimensionadaIcon);
                } else {
                    // No hay más imágenes en la lista
                    RutaLabel.setText("Ruta de la imagen: ");
                    imagenLabel.setIcon(null);
                }

                break;
            }
        }
        AppState.listaDoble.imprimirLista();  
        JOptionPane.showMessageDialog(null, "Imagen Eliminada", "Eliminada Con exito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_eliminarImagenButtonActionPerformed

    
    private void SiguienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteButtonActionPerformed
        // TODO add your handling code here:
        
        String nombreUsuario = AppState.nombreUsuarios;
                
        DefaultListModel<Categorias> modeloLista = (DefaultListModel<Categorias>) CategoriasList.getModel();
        int indiceSeleccionado = CategoriasList.getSelectedIndex();
        
        if (indiceSeleccionado != -1) {
            Categorias categoriaSeleccionada = modeloLista.getElementAt(indiceSeleccionado);
            String categoriaTransformada = categoriaSeleccionada.toString();
            
            
            
            int siguienteIndice = indiceActual + 1;
            while (siguienteIndice != indiceActual) {
                if (siguienteIndice >= AppState.listaDoble.getSize()) {
                    siguienteIndice = 0;
                }

                Imagen imagen = (Imagen) AppState.listaDoble.get(siguienteIndice);
                if (imagen.getNombre().equals(nombreUsuario) && imagen.getCategoria().equals(categoriaTransformada)) {
                    indiceActual = siguienteIndice;

                    // establece la imagen actual
                    ImageIcon imagenActual = imagen.getImageIcon();
                    Image imagenOriginal = imagenActual.getImage();
                    Image imagenRedimensionada = imagenOriginal.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon imagenRedimensionadaIcon = new ImageIcon(imagenRedimensionada);
                    imagenLabel.setIcon(imagenRedimensionadaIcon);

                    // Obtener la ruta de la imagen actual
                    String rutaImagen = imagen.getArchivo();

                    // Actualizar el label con la ruta de la imagen
                    RutaLabel.setText("Ruta de la imagen: " + rutaImagen);

                    // actualiza el texto del JLabel con la posición actual
                    int totalFotos = AppState.listaDoble.getSize();
                    String textoLabel = categoriaTransformada + " " + (indiceActual + 1) + "/" + totalFotos;
                    ContadorFotosLabel.setText(textoLabel);

                    break;
                }

                siguienteIndice++;
                if (siguienteIndice >= AppState.listaDoble.getSize()) {
                    siguienteIndice = 0;
                }
            }
        }
    }//GEN-LAST:event_SiguienteButtonActionPerformed

    private void AnteriorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnteriorButtonActionPerformed
        // TODO add your handling code here:
        
        String nombreUsuario = AppState.nombreUsuarios;

        DefaultListModel<Categorias> modeloLista = (DefaultListModel<Categorias>) CategoriasList.getModel();
        int indiceSeleccionado = CategoriasList.getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Categorias categoriaSeleccionada = modeloLista.getElementAt(indiceSeleccionado);
            String categoriaTransformada = categoriaSeleccionada.toString();

            int totalFotos = AppState.listaDoble.getSize();

            // retroceder el índice actual
            indiceActual--;
            if (indiceActual < 0) {
                indiceActual = totalFotos - 1;
            }

            // buscar la imagen adecuada a partir del índice actual
            int i = indiceActual;
            do {
                Imagen imagenActual = (Imagen) AppState.listaDoble.get(i);

                // si la imagen no pertenece al usuario actual, pasar a la siguiente imagen
                if (!imagenActual.getNombre().equals(nombreUsuario)) {
                    i++;
                    if (i >= totalFotos) {
                        i = 0;
                    }
                    continue;
                }

                // si la imagen pertenece a la categoría seleccionada, mostrarla
                if (imagenActual.getCategoria().equals(categoriaTransformada)) {

                    // establece la imagen actual
                    ImageIcon imagenActualIcon = imagenActual.getImageIcon();
                    Image imagenOriginal = imagenActualIcon.getImage();
                    Image imagenRedimensionada = imagenOriginal.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon imagenRedimensionadaIcon = new ImageIcon(imagenRedimensionada);
                    imagenLabel.setIcon(imagenRedimensionadaIcon);

                    // Obtener la ruta de la imagen actual
                    String rutaImagen = imagenActual.getArchivo();

                    // Actualizar el label con la ruta de la imagen
                    RutaLabel.setText("Ruta de la imagen: " + rutaImagen);

                    // actualiza el texto del JLabel con la posición actual
                    String textoLabel = categoriaTransformada + " " + (i + 1) + "/" + totalFotos;
                    ContadorFotosLabel.setText(textoLabel);

                    // actualizar el índice actual
                    indiceActual = i;

                    break;
                }

                i++;
                if (i >= totalFotos) {
                    i = 0;
                }

            } while (i != indiceActual);
        }
    }//GEN-LAST:event_AnteriorButtonActionPerformed

    private void CategoriasListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_CategoriasListValueChanged
        // TODO add your handling code here:
        
        String nombreUsuario = AppState.nombreUsuarios;
        for(int i = 0; i < AppState.categoria.size(); i++){
            String categoriaAlmacenada = AppState.categoria.get(i).categoria;
            for(int j = 0 ; j < AppState.listaDoble.getSize() ; j++){
                String nombreUsuario1 = ((Imagen)AppState.listaDoble.get(j)).getNombre();
                String CategoriaAlamcenada1 = ((Imagen)AppState.listaDoble.get(j)).getCategoria();
                //Imagen imagen = (Imagen) AppState.listaDoble.get(j);
                if(categoriaAlmacenada.equals(CategoriaAlamcenada1) && nombreUsuario.equals(nombreUsuario1)){
                    ImageIcon imagenActual = ((Imagen)AppState.listaDoble.get(j)).getImageIcon();
                    Image imagenOriginal = imagenActual.getImage();
                    Image imagenRedimensionada = imagenOriginal.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon imagenRedimensionadaIcon = new ImageIcon(imagenRedimensionada);
                    imagenLabel.setIcon(imagenRedimensionadaIcon);
                }
                break;
            }
        }
    }//GEN-LAST:event_CategoriasListValueChanged

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
            java.util.logging.Logger.getLogger(BibliotecaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BibliotecaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BibliotecaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BibliotecaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BibliotecaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnteriorButton;
    private javax.swing.JList CategoriasList;
    private javax.swing.JLabel ContadorFotosLabel;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JLabel RutaLabel;
    private javax.swing.JButton SalirButton;
    private javax.swing.JButton SiguienteButton;
    private javax.swing.JButton agregarImagenButton;
    private javax.swing.JButton añadirCategoriaButton;
    private javax.swing.JTextField categoriaText;
    private javax.swing.JButton eliminarCategoriaButton;
    private javax.swing.JButton eliminarImagenButton;
    private javax.swing.JLabel imagenLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
