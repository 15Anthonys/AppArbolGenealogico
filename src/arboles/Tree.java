/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

/**
 *
 * @author dugla
 */
public class Tree {
    
    private Nodo root;
    
    
    public Tree(){
        this.root = null;
    }
    
    
    public void create(int data){
        Nodo nuevoNodo = new Nodo(data);
        setRoot(nuevoNodo);
    }
    
    
    public void insert(int data, Nodo parent){
        Nodo nuevoNodo = new Nodo(data);
        if (!isEmpty()){
            parent.addSon(nuevoNodo);
        }
    }
    
    
    public String preorder(Nodo root){
        String toPrint = "";
        if(root != null){
            toPrint += root.getData()+ "\n";
            toPrint += preorder(root.getSon());
            toPrint += preorder(root.getSib());
        }
        
        return toPrint;
    }
    
    public String inorder(Nodo root){
        String toPrint = "";
        if (root != null){
            Nodo temp =  root.getSon();
            toPrint += inorder(temp);
            toPrint += root.getData() + "\n";
            while (temp != null){
                temp = temp.getSib();
                toPrint += inorder(temp);
                
            }
        }
        return toPrint;
    }
    
    public boolean isEmpty(){
        return getRoot() == null;
    }

    /**
     * @return the root
     */
    public Nodo getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Nodo root) {
        this.root = root;
    }
    
    
    
}
