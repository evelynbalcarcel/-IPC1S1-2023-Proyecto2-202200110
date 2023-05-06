
package ESTRUCTURA2;

import com.mycompany.proyecto2_ipc1.Usuario;


public class ListaSimple extends EstructuraDeDatos{
    
    private NodoUsuario cabeza = null;
    
    public void listarNombres(){
        NodoUsuario nodoAuxiliar = cabeza;
        while(nodoAuxiliar != null){
            System.out.print(nodoAuxiliar.getUsuario().nombre + " -> ");
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        System.out.println("null \n");
    }

    @Override
    public void add(Object e) {
        Usuario usuario = (Usuario)e;
        
        if(find(usuario.nombre) != null){
            return;
        }
        
        NodoUsuario nodoUsuario = new NodoUsuario(usuario);
        if( cabeza == null){
            cabeza = nodoUsuario;
        } else {
            NodoUsuario nodoAuxiliar = cabeza;
            while(nodoAuxiliar.getSiguiente() != null){
                nodoAuxiliar = nodoAuxiliar.getSiguiente();
            }
            
            nodoAuxiliar.setSiguiente(nodoUsuario);
        }
        index++;
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Object e) {
        
        String nombreUsuario = e.toString();
        
        NodoUsuario nodoAuxiliar = cabeza;
        for(int i = 0; i < index; i++){
            if(nodoAuxiliar.getUsuario().nombre.equals(nombreUsuario)){
                return nodoAuxiliar.getUsuario();
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
        NodoUsuario nodoAuxiliar = cabeza;
        while (nodoAuxiliar != null) {
            size++;
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        return size;
    }

    @Override
    public Object get(int i) {
        
        if (i < 0 || i > index ){
            return new IndexOutOfBoundsException();
        }
        
        NodoUsuario nodoAuxiliar = cabeza;
        for(int contador = 0 ; contador < i ; contador++){
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        return nodoAuxiliar.getUsuario();
    }
        
    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object e) {
        
        String nombreUsuario = e.toString();
        
        NodoUsuario nodoActual = cabeza;
        NodoUsuario nodoAnterior = null;
        
        while(nodoActual != null && !nodoActual.getUsuario().nombre.equals(nombreUsuario)){
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getSiguiente();
        }
        
        if(nodoActual == null){
            return;
        }
        
        if(nodoAnterior == null){
            cabeza = cabeza.getSiguiente();
        } else {
            nodoAnterior.setSiguiente(nodoActual.getSiguiente());
        }
        
        index--;
    }
}
