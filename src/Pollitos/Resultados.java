package Pollitos;

/**
 *
 * @author luisGonzalez
 */
public class Resultados {
    
    private String jugador;
    private int navesConstruidas;
    private int planetasConquistados;
    private int flotasLanzadas;
    private int produccionActual;
    private int totalPlanetas;

    public int getTotalPlanetas() {
        return totalPlanetas;
    }

    public void setTotalPlanetas(int totalPlanetas) {
        this.totalPlanetas = totalPlanetas;
    }
    
    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public int getNavesConstruidas() {
        return navesConstruidas;
    }

    public void setNavesConstruidas(int navesConstruidas) {
        this.navesConstruidas = navesConstruidas;
    }

    public int getPlanetasConquistados() {
        return planetasConquistados;
    }

    public void setPlanetasConquistados(int planetasConquistados) {
        this.planetasConquistados = planetasConquistados;
    }

    public int getFlotasLanzadas() {
        return flotasLanzadas;
    }

    public void setFlotasLanzadas(int flotasLanzadas) {
        this.flotasLanzadas = flotasLanzadas;
    }

    public int getProduccionActual() {
        return produccionActual;
    }

    public void setProduccionActual(int produccionActual) {
        this.produccionActual = produccionActual;
    }
    
    
}
