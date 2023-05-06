
package ESTRUCTURA2;

import com.mycompany.proyecto2_ipc1.Usuario;


public class NodoUsuario {
    private Usuario usuario;
    private NodoUsuario siguiente;

    public NodoUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public NodoUsuario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoUsuario siguiente) {
        this.siguiente = siguiente;
    }
}
