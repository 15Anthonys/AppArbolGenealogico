


package arboles;




public class Nodo {
    
    private MiembroFamilia miembro;
    private Nodo hijo; // Referencia al primer hijo
    private Nodo hermano; // Referencia al siguiente hermano

    public Nodo(MiembroFamilia miembro) {
        this.miembro = miembro;
        this.hijo = null;
        this.hermano = null;
    }

    public MiembroFamilia getMiembro() {
        return miembro;
    }

    public Nodo getHijo() {
        return hijo;
    }

    public Nodo getHermano() {
        return hermano;
    }

    public void setHijo(Nodo hijo) {
        this.hijo = hijo;
    }

    public void setHermano(Nodo hermano) {
        this.hermano = hermano;
    }
}