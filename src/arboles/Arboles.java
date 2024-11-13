/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboles;

/**
 *
 * @author dugla
 */
public class Arboles {
    
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Crear el árbol
        Tree arbol = new Tree();

        // Crear la raíz
        arbol.create(10);

        // Agregar nodos hijo
        arbol.insert(5, arbol.getRoot());
        arbol.insert(15, arbol.getRoot());
        arbol.insert(0, arbol.getRoot());
        
        arbol.insert(9, arbol.getRoot().getSon());
        arbol.insert(4, arbol.getRoot().getSon().getSib());        
        
        String guardar = arbol.inorder(arbol.getRoot());
        
        System.out.println(guardar);
        
        
        
        
        
        
    }
    
}
