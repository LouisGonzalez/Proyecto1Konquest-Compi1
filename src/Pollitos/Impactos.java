package Pollitos;

/**
 *
 * @author luisGonzalez
 */
public class Impactos {

    private String nombreJugador;
    private String nombrePlaneta;
    private Integer navesRestantes;
    private String estado;
    private String mensaje;
    private Integer noFlota;
    private Integer noTurno;

    public Integer getNoTurno() {
        return noTurno;
    }

    public void setNoTurno(Integer noTurno) {
        this.noTurno = noTurno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNombrePlaneta() {
        return nombrePlaneta;
    }

    public void setNombrePlaneta(String nombrePlaneta) {
        this.nombrePlaneta = nombrePlaneta;
    }

    public Integer getNavesRestantes() {
        return navesRestantes;
    }

    public void setNavesRestantes(Integer navesRestantes) {
        this.navesRestantes = navesRestantes;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getNoFlota() {
        return noFlota;
    }

    public void setNoFlota(Integer noFlota) {
        this.noFlota = noFlota;
    }

    
}
