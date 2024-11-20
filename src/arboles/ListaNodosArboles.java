/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

/**
 *
 * @author ffust
 */
public class ListaNodosArboles {
    
    private NodoListaNodos pFirst;
    private int size;

    public ListaNodosArboles() {
        this.pFirst = null;
        this.size = 0;
    }

    /**
     * @return the pFirst
     */
    public NodoListaNodos getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(NodoListaNodos pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    public void agregar(Nodo nodo) {
           
           NodoListaNodos nuevo = new NodoListaNodos(nodo);
           nuevo.setpNext(pFirst);
           pFirst  = nuevo;
           size ++;
    
}

}
