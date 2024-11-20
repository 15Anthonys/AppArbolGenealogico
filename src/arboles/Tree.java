/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Edge;
import org.graphstream.graph.EdgeRejectedException;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerPipe;
import org.graphstream.ui.swing_viewer.SwingViewer;

/**
 *
 * @author dugla
 */
public class Tree {
    
    private Nodo raiz;

    public Tree(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRoot() {
        return raiz;
    }

    public void agregarHijo(Nodo padre, Nodo hijo) {
    if (padre.getHijo() == null) {
        padre.setHijo(hijo); // Si no tiene hijos, agrega el primero
    } else {
        Nodo hermanoActual = padre.getHijo();
        while (hermanoActual.getHermano() != null) {
            hermanoActual = hermanoActual.getHermano(); // Encuentra el último hermano
        }
        hermanoActual.setHermano(hijo); // Agrega el nuevo hijo como hermano del último
    }
}
    
    
 public void mostrarArbol() {
    Graph graph = new SingleGraph("Árbol Familiar");

    // Agregar nodos y aristas
    agregarNodosYEnlaces(graph, raiz);

    // Crear un JFrame para mostrar el gráfico
    JFrame frame = new JFrame("Árbol Familiar");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    
    // Usar SwingViewer para mostrar el gráfico
    SwingViewer viewer = new SwingViewer(graph, SwingViewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
    viewer.enableAutoLayout();

    // Agregar el panel del visualizador al JFrame
    JPanel panel = (JPanel) viewer.addDefaultView(false);
    frame.add(panel, BorderLayout.CENTER);
    
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);  // Centrar la ventana
}
    
    private void agregarNodosYEnlaces(Graph graph, Nodo nodo) {
        String nodeId = nodo.getMiembro().getNombre() + " " + nodo.getMiembro().getSobrenombre();
        if (graph.getNode(nodeId) == null) {
            graph.addNode(nodeId);
            graph.getNode(nodeId).setAttribute("ui.label", nodeId);
            graph.getNode(nodeId).setAttribute("ui.size", 500);
            graph.getNode(nodeId).setAttribute("ui.style", "fill-color: #f0f0f0; stroke-mode: plain; stroke-color: #333; text-size: 14;");
        }

        Nodo hijo = nodo.getHijo();
        while (hijo != null) {
            agregarNodosYEnlaces(graph, hijo);
            String childId = hijo.getMiembro().getNombre() + " " + hijo.getMiembro().getSobrenombre();
            if (graph.getNode(childId) == null) {
                graph.addNode(childId);
                graph.getNode(childId).setAttribute("ui.label", childId);
                graph.getNode(childId).setAttribute("ui.size", 500);
                graph.getNode(childId).setAttribute("ui.style", "fill-color: #f0f0f0; stroke-mode: plain; stroke-color: #333; text-size: 14;");
            }
            graph.addEdge(nodeId + "-" + childId, nodeId, childId);
            graph.getEdge(nodeId + "-" + childId).setAttribute("ui.style", "fill-color: #333; stroke-mode: plain; stroke-width: 2;");
            hijo = hijo.getHermano();
        }
    }



    
    public String preorder(Nodo root){
        String toPrint = "";
        if (root != null){
            toPrint += root.getMiembro().getNombre() + "\n";
            toPrint += preorder(root.getHijo());
            toPrint += preorder(root.getHermano());
            
    }
        return toPrint;
    }


    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    /**
     * @return the raiz
     */
    public Nodo getRaiz() {
        return raiz;
    }
    
    


    
}

    
