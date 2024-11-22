/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

/**
 *
 * @author dugla
 */
public class Hash_Table {
    
    Nodo_hash tabla[];
    int tamaño_tabla;
    
    public Hash_Table(int tamaño){
        this.tamaño_tabla = tamaño;
        this.tabla = new Nodo_hash[tamaño_tabla];
        for (int i = 0; i < tamaño_tabla; i++) {
            this.tabla[i] = null;
            
        }
    }
    
    public int hashing(String llave){
        int valor = 0;
        int posicion = 1;
        for (int i = 0; i < llave.length(); i++) {
            if(llave.codePointAt(i) == 32){
                valor += 0;
            } else if (llave.codePointAt(i) >= 48 && llave.codePointAt(i) <= 57){
                valor += ((llave.codePointAt(i) - 47) * posicion);
            } else if (llave.codePointAt(i) >= 65 && llave.codePointAt(i) <= 90){
                valor += ((llave.codePointAt(i) - 54) * posicion);
            } else if (llave.codePointAt(i) >= 97 && llave.codePointAt(i) <= 122){
                valor += ((llave.codePointAt(i) - 60) * posicion);
            }
            posicion ++;
            
        }
        return (valor % tamaño_tabla);
    }
    
    public void insertar(String key, MiembroFamilia value) {
    int posicion = hashing(key);
    Nodo_hash temp = this.tabla[posicion];
    boolean existe = false;

    while (temp != null) {
        if (temp.getName().equals(key)) {
            existe = true;
            temp.setMiembro(value); 
            break;
        }
        temp = temp.getNext();
    }

    if (!existe) {
        Nodo_hash nuevoNodo = new Nodo_hash(key, value);
        nuevoNodo.setNext(this.tabla[posicion]);
        this.tabla[posicion] = nuevoNodo;
    }
}
    
    public MiembroFamilia buscar(String key) {
    int posicion = hashing(key);
    Nodo_hash temp = this.tabla[posicion];

    while (temp != null) {
        if (temp.getName().equals(key)) {
            System.out.println("encontrado");
            return temp.getMiembro();
            
        }
        temp = temp.getNext();
    }
    return null; 
}
    
    public void vaciado(){
        for (int i = 0; i < tamaño_tabla; i++) {
            this.tabla[i] = null;
            
        }
    }
    
    public void imprimir() {
    for (int i = 0; i < tamaño_tabla; i++) {
        Nodo_hash temp = this.tabla[i];
        while (temp != null) {
            System.out.println("Key: " + temp.getMiembro().getNombre() + " " + temp.getMiembro().getSobrenombre() + ", Value: " + temp.getMiembro());
            temp = temp.getNext();
        }
    }
}
    
}
