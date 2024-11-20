/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

/**
 *Clase que representa los Nodos de una lista simple
 * @author Anthony Caldera
 */
public class NodoListaSimple {
    
    private NodoListaSimple pNext; 
    private String nombrehijo;
    
    /**
     * Constructor de la clase Nodo de lista simple correspondiente
     * @author Anthony Caldera
     * @param estacion para el constructor de la clase
     */

    public NodoListaSimple(String nombrehijo) {
        this.nombrehijo = nombrehijo;
        this.pNext = null;
    }
    
   

    /**
     * @return the pNext
     */
    public NodoListaSimple getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(NodoListaSimple pNext) {
        this.pNext = pNext;
    }

    /**
     * @return the nombrehijo
     */
    public String getNombrehijo() {
        return nombrehijo;
    }

    /**
     * @param nombrehijo the nombrehijo to set
     */
    public void setNombrehijo(String nombrehijo) {
        this.nombrehijo = nombrehijo;
    }

    /**
     * @return the nodito
     */

    
    
}
