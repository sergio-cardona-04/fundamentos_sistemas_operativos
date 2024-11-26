public class Nodo {
    
    private int id;
    private int prioridad;
    private int siguiente;

    public Nodo(int id, int prioridad, int siguiente) {
        this.id = id;
        this.prioridad = prioridad;
        this.siguiente = siguiente;
    }
    
    public Nodo(int id, int prioridad) {
        this.id = id;
        this.prioridad = prioridad;
        this.siguiente = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(int siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
