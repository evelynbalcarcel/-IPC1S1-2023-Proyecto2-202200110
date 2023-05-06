
package ESTRUCTURA2;

import com.mycompany.proyecto2_ipc1.Imagen;
import java.io.IOException;
import javax.swing.JTextArea;


public class ListaDoble extends EstructuraDeDatos {
    
    NodoImagen primerNodo;
    NodoImagen ultimoNodo;
    
    public void printListNext(int indice, JTextArea area) throws IOException {
        NodoImagen nodoAuxiliar = primerNodo;
        int index = 0;
        
        while(index <= indice){
            System.out.println("Indice " + index);
            if(index == indice){
                System.out.println("La imagen que se esta trabajando es: " + nodoAuxiliar.getRuta().archivo);
                area.append("La imagen que se esta trabajando es: " + nodoAuxiliar.getRuta().archivo + "\n");
                break;
            }
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
            index++;
            
            if(nodoAuxiliar == null){
                return;
            }
        }
        System.out.println();
    }
    
    public void imprimirLista(){
        
        if(primerNodo == null){
           System.out.println("null <--->");
            return;
        } 
        
        NodoImagen nodoAuxiliar = primerNodo;
        
        while(nodoAuxiliar != null){
            System.out.println(nodoAuxiliar.getImagen().getNombre() + "<--->" + nodoAuxiliar.getImagen().getCategoria() + 
                    "<--->" + nodoAuxiliar.getImagen().getArchivo());
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        System.out.println("null");
    }
    
    @Override
    public void add(Object e) {
        
        Imagen nombre = (Imagen)e;
        Imagen categoria = (Imagen)e;
        Imagen imagen = (Imagen)e;
        Imagen ruta = (Imagen)e;
        
        
        if(primerNodo == null){
            primerNodo = ultimoNodo = new NodoImagen(nombre, categoria, ruta, imagen);
        } else {
            NodoImagen nuevoNodo = new NodoImagen(nombre, categoria, ruta, imagen, null, ultimoNodo);
            ultimoNodo.setSiguiente(nuevoNodo);
            ultimoNodo = nuevoNodo;
        }
        index++;
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Object e) {
        
        if(primerNodo == null){
            return null;
        }
        
        String nombreImagen = e.toString();
        NodoImagen nodoAuxiliar = primerNodo;
        
        for ( int i = 0 ; i < index ; i++){
            if(nodoAuxiliar.getImagen().getNombre().equals(nombreImagen)){
                return nodoAuxiliar.getImagen();
            }
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        return null;
        
    }

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getSize() {
        int size = 0;
        NodoImagen nodoAuxiliar = primerNodo;
        while (nodoAuxiliar != null) {
            size++;
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        return size;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i > index) {
            return new IndexOutOfBoundsException();
        }

        NodoImagen nodoAuxiliar = primerNodo;
        for (int contador = 0; contador < i; contador++) {
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        if (nodoAuxiliar == null) {
            return null;
        }
        return nodoAuxiliar.getImagen();
    }

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object e) {
        String nombreRuta = e.toString();
        NodoImagen nodoAuxiliar = primerNodo;
        while (nodoAuxiliar != null && !nodoAuxiliar.getImagen().archivo.equals(nombreRuta) ) {
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        
        if (nodoAuxiliar == null) {
            return;
        } else if (nodoAuxiliar == primerNodo) {
            primerNodo = primerNodo.getSiguiente();
            primerNodo.setAnterior(null);
        } else if (nodoAuxiliar == ultimoNodo) {
            ultimoNodo = ultimoNodo.getAnterior();
            ultimoNodo.setSiguiente(null);
        } else {
            nodoAuxiliar.getAnterior().setSiguiente(nodoAuxiliar.getSiguiente());
            nodoAuxiliar.getSiguiente().setAnterior(nodoAuxiliar.getAnterior());
        }
        index--;
    }
}
