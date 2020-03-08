package Pollitos;

import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class Jugadores {
    
    private String nombre;
    private ArrayList<String> planetas;
    private ArrayList<Planetas> misPlanetas;
    private String tipo;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Planetas> getMisPlanetas() {
        return misPlanetas;
    }

    public void setMisPlanetas(ArrayList<Planetas> misPlanetas) {
        this.misPlanetas = misPlanetas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(ArrayList<String> planetas) {
        this.planetas = planetas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
