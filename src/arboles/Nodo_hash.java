/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

/**
 *
 * @author dugla
 */
public class Nodo_hash {
    
    private Nodo_hash next;
    private String name;
    private MiembroFamilia miembro;
    
    public Nodo_hash(String nombre, MiembroFamilia miembro){
        this.next = null;
        this.name = nombre;
        this.miembro = miembro;
    }
    
    

    /**
     * @return the next
     */
    public Nodo_hash getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Nodo_hash next) {
        this.next = next;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the miembro
     */
    public MiembroFamilia getMiembro() {
        return miembro;
    }

    /**
     * @param miembro the miembro to set
     */
    public void setMiembro(MiembroFamilia miembro) {
        this.miembro = miembro;
    }

    
    
    
    
}
