package Pollitos;

/**
 *
 * @author luisGonzalez
 */
public class ResumenTurno {

    private Boolean estadoJugador;
    private String nombreJugador;
    private Boolean todoCorrecto;

    public Boolean getTodoCorrecto() {
        return todoCorrecto;
    }

    public void setTodoCorrecto(Boolean todoCorrecto) {
        this.todoCorrecto = todoCorrecto;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Boolean getEstadoJugador() {
        return estadoJugador;
    }

    public void setEstadoJugador(Boolean estadoJugador) {
        this.estadoJugador = estadoJugador;
    }
    
}
