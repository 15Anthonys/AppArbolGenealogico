/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author dugla
 */
public class FamilyTreeBuilder {
    
    private Map<String, MiembroFamilia> memberMap = new HashMap<>();
    
   public Tree buildTree(String jsonString) {
    JSONObject json = new JSONObject(jsonString);
    String houseName = json.keys().next();
    JSONArray houseMembers = json.getJSONArray(houseName);
    MiembroFamilia raiz = null;

    // Crear la raíz
    for (int i = 0; i < houseMembers.length(); i++) {
        JSONObject member = houseMembers.getJSONObject(i);
        for (String memberName : member.keySet()) {
            JSONArray attributes = member.getJSONArray(memberName);
            MiembroFamilia newMember = createMember(memberName, attributes);
            if (raiz == null) {
                raiz = newMember;
            }
        }
    }

    Nodo raizNodo = new Nodo(raiz);
    Tree familyTree = new Tree(raizNodo);

    // Procesar nuevamente para establecer relaciones
    for (int i = 0; i < houseMembers.length(); i++) {
        JSONObject member = houseMembers.getJSONObject(i);
        for (String memberName : member.keySet()) {
            JSONArray attributes = member.getJSONArray(memberName);
            MiembroFamilia newMember = createMember(memberName, attributes);
            Nodo hijoNodo = new Nodo(newMember);
            // Llamar a ElModificador para establecer las relaciones
            ElModificador(familyTree.getRoot(), hijoNodo, familyTree);
        }
    }

    return familyTree; // Retornar el árbol de la casa
}

    public void ElModificador(Nodo padre, Nodo hijo, Tree familyTree) {
        
    String elPapa = hijo.getMiembro().getPadre();
    
    // Crear el nombre completo del padre para la comparación
    String nombreCompletoPadre = padre.getMiembro().getNombre() + ", " + padre.getMiembro().getSobrenombre() + " of his name";

    // Verificar si el padre del hijo coincide con el nombre, mote o sobrenombre del padre
    if (padre.getMiembro().getNombre().equals(elPapa) || padre.getMiembro().getMote().equals(elPapa) || nombreCompletoPadre.equals(elPapa)) {
        
        
        familyTree.agregarHijo(padre, hijo);
    } else {
        // Si no coincide, buscar en todos los hijos de este nodo
        Nodo hijoActual = padre.getHijo();
        while (hijoActual != null) {
            ElModificador(hijoActual, hijo, familyTree); // Llamar recursivamente
            hijoActual = hijoActual.getHermano(); // Mover al siguiente hermano
        }
    }
}


    private MiembroFamilia createMember(String memberName, JSONArray attributes) {
    String sobrenombre = "";
    String motes = "";
    String bornToFather = null;
    String bornToMother = "";
    String title = "";
    String wedTo = "";
    String eyesColor = "";
    String hairColor = "";
    ListaSimple children = new ListaSimple();
    String notes = "";
    String fate = "";

    for (int j = 0; j < attributes.length(); j++) {
        JSONObject attribute = attributes.getJSONObject(j);
        
        if (attribute.has("Of his name")) {
            sobrenombre = attribute.getString("Of his name");
        }
        
        
        
        if (attribute.has("Born to")) {
            String parents = attribute.getString("Born to");
            if (bornToFather == null) {
                bornToFather = parents; // Guardar padre
            } else {
                bornToMother = parents; // Guardar madre
            }
        }
        
        if (attribute.has("Known throughout as")){
            motes = attribute.getString("Known throughout as");
        }
        
        if (attribute.has("Held title")) {
            title = attribute.getString("Held title");
        }
        if (attribute.has("Wed to")) {
            wedTo = attribute.getString("Wed to");
        }
        if (attribute.has("Of eyes")) {
            eyesColor = attribute.getString("Of eyes");
        }
        if (attribute.has("Of hair")) {
            hairColor = attribute.getString("Of hair");
        }
        if (attribute.has("Father to")) {
            JSONArray fatherToArray = attribute.getJSONArray("Father to");
            for (int k = 0; k < fatherToArray.length(); k++) {
                children.agregar(fatherToArray.getString(k)); // Agregar hijos
            }
        }
        if (attribute.has("Notes")) {
            notes = attribute.getString("Notes");
        }
        if (attribute.has("Fate")) {
            fate = attribute.getString("Fate");
        }
    }

    // Crear y retornar el objeto MiembroFamilia
    return new MiembroFamilia(memberName,sobrenombre, bornToFather, bornToMother, motes,  title, wedTo, eyesColor, hairColor, children, notes, fate);
}

}


