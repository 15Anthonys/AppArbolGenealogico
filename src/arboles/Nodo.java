/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

/**
 *
 * @author dugla
 */
public class Nodo {
    
    private Nodo sib;
    private Nodo son;
    private int data;
    
    public Nodo(int data){
        this.data = data;
        this.sib = null;
        this.son = null;
        
    }
    
    
    public void addSon(Nodo newSon){
        if (getSon() != null){
            Nodo temp = getSon();
            Nodo sib = temp;
            while(temp != null){
                sib = temp;
                temp = temp.getSib();
                
            }
            sib.setSib(newSon);
            
        }else{
            setSon(newSon);
        }
    }

    /**
     * @return the sib
     */
    public Nodo getSib() {
        return sib;
    }

    /**
     * @param sib the sib to set
     */
    public void setSib(Nodo sib) {
        this.sib = sib;
    }

    /**
     * @return the son
     */
    public Nodo getSon() {
        return son;
    }

    /**
     * @param son the son to set
     */
    public void setSon(Nodo son) {
        this.son = son;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }
    
    
}
