package Pollitos;

/**
 *
 * @author luisGonzalez
 */
public class NavesCamino {
    
    private int noFlota;
    private String planetaOrigen;
    private String planetaDestino;
    private int noNaves;
    private int noJugadorEnvio;
    private Integer noJugadorAtaque;
    private float porcentajeMuertes;
    private int turnoLlegada;
    private boolean verificador;

    public boolean isVerificador() {
        return verificador;
    }

    public void setVerificador(boolean verificador) {
        this.verificador = verificador;
    }

    public int getNoJugadorEnvio() {
        return noJugadorEnvio;
    }

    public void setNoJugadorEnvio(int noJugadorEnvio) {
        this.noJugadorEnvio = noJugadorEnvio;
    }

    public Integer getNoJugadorAtaque() {
        return noJugadorAtaque;
    }

    public void setNoJugadorAtaque(Integer noJugadorAtaque) {
        this.noJugadorAtaque = noJugadorAtaque;
    }

    public int getNoFlota() {
        return noFlota;
    }

    public void setNoFlota(int noFlota) {
        this.noFlota = noFlota;
    }

    public String getPlanetaOrigen() {
        return planetaOrigen;
    }

    public void setPlanetaOrigen(String planetaOrigen) {
        this.planetaOrigen = planetaOrigen;
    }

    public String getPlanetaDestino() {
        return planetaDestino;
    }

    public void setPlanetaDestino(String planetaDestino) {
        this.planetaDestino = planetaDestino;
    }

    public int getNoNaves() {
        return noNaves;
    }

    public void setNoNaves(int noNaves) {
        this.noNaves = noNaves;
    }

    public float getPorcentajeMuertes() {
        return porcentajeMuertes;
    }

    public void setPorcentajeMuertes(float porcentajeMuertes) {
        this.porcentajeMuertes = porcentajeMuertes;
    }

    public int getTurnoLlegada() {
        return turnoLlegada;
    }

    public void setTurnoLlegada(int turnoLlegada) {
        this.turnoLlegada = turnoLlegada;
    }
    
    
}
