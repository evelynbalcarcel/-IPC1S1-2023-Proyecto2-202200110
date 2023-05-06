
package ESTRUCTURA2;

import com.mycompany.proyecto2_ipc1.Imagen;


public class NodoImagen {
    private Imagen imagen;
    private Imagen nombre;
    private Imagen categoria;
    private Imagen ruta;
    private NodoImagen siguiente;
    private NodoImagen anterior;
    
    public NodoImagen(Imagen imagen){
        this.imagen = imagen;
    }
    
    public NodoImagen(Imagen nombre, Imagen categoria, Imagen ruta, Imagen imagen){
        this.nombre = nombre;
        this.categoria = categoria;
        this.ruta = ruta;
        this.imagen = imagen;
    }
    
    public NodoImagen(Imagen nombre, Imagen categoria, Imagen ruta, Imagen imagen, NodoImagen siguiente, NodoImagen anterior){
        this.nombre = nombre;
        this.categoria = categoria;
        this.ruta = ruta;
        this.imagen = imagen;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public NodoImagen(Imagen imagen, NodoImagen siguiente, NodoImagen anterior) {
        this.imagen = imagen;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public Imagen getNombre() {
        return nombre;
    }

    public void setNombre(Imagen nombre) {
        this.nombre = nombre;
    }

    public Imagen getCategoria() {
        return categoria;
    }

    public void setCategoria(Imagen categoria) {
        this.categoria = categoria;
    }

    public Imagen getRuta() {
        return ruta;
    }

    public void setRuta(Imagen ruta) {
        this.ruta = ruta;
    }
    
    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public NodoImagen getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoImagen siguiente) {
        this.siguiente = siguiente;
    }

    public NodoImagen getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoImagen anterior) {
        this.anterior = anterior;
    }
    
    
}
