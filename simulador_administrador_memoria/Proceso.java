public class Proceso {
    
    private int id;
    private int tamaño;

    public Proceso(int id, int tamaño) {
        this.id = id;
        this.tamaño = tamaño;
    }

    public Proceso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
}