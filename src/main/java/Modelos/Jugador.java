package Modelos;

public class Jugador {
    private int id;
    private String nombre;
    private int votos;

    public Jugador(int id, String nombre, int votos) {
        this.id = id;
        this.nombre = nombre;
        this.votos = votos;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
    
    public int getVotos() {
        return votos;
    }
}