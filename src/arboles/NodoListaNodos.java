/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

/**
 *
 * @author ffust
 */
public class NodoListaNodos {
    
    private Nodo nodo;
    private NodoListaNodos pNext;

    public NodoListaNodos(Nodo nodo) {
        this.nodo = nodo;
        this.pNext = null;
    }

    /**
     * @return the nodo
     */
    public Nodo getNodo() {
        return nodo;
    }

    /**
     * @param nodo the nodo to set
     */
    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    /**
     * @return the pNext
     */
    public NodoListaNodos getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(NodoListaNodos pNext) {
        this.pNext = pNext;
    }
    
    
}
