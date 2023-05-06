
package com.mycompany.proyecto2_ipc1;

import java.io.File;
import javax.swing.ImageIcon;


public class Imagen {
    
    //Colocar atributos necesarios para el proyecto
    public String nombre;
    public String categoria;
    public String archivo;
    public ImageIcon imageIcon;
    
    public Imagen(String nombre){
        this.nombre = nombre;
    }
    
    public Imagen(String nombre, String categoria, File archivo, ImageIcon imageIcon){
        this.nombre = nombre;
        this.categoria = categoria;
        this.archivo = archivo.getAbsolutePath();
        this.imageIcon = imageIcon;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    
    
    
    
}
