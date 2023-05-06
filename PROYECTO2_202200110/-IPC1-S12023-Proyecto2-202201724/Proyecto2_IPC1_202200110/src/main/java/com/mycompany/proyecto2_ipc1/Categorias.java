
package com.mycompany.proyecto2_ipc1;


public class Categorias {
    public String nombre;
    public String categoria;
    
    public Categorias(String categoria){
        this.categoria = categoria;
    }
    
    public Categorias(String nombre, String categoria){
        this.nombre = nombre; 
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString() {
    return this.categoria;
    }
    
    public void eliminarCategoria(String categoria) {
    for (int i = 0; i < AppState.categoria.size(); i++) {
        if (AppState.categoria.get(i).getCategoria().equals(categoria)) {
            AppState.categoria.remove(i);
            break;
        }
    }
}
}
