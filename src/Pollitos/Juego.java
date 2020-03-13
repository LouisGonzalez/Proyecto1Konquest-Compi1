package Pollitos;

import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class Juego {
    
    private Mapa mapa;
    private ArrayList<Jugadores> jugadores;
    private ArrayList<PlanetasNeutrales> pNeutrales;
    private ArrayList<Planetas> planetas;

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public ArrayList<Jugadores> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugadores> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<PlanetasNeutrales> getpNeutrales() {
        return pNeutrales;
    }

    public void setpNeutrales(ArrayList<PlanetasNeutrales> pNeutrales) {
        this.pNeutrales = pNeutrales;
    }

    public ArrayList<Planetas> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(ArrayList<Planetas> planetas) {
        this.planetas = planetas;
    }
    
}
