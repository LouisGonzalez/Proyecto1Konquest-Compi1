package Pollitos;

/**
 *
 * @author luisGonzalez
 */
public class Mapa {
   
    
    private String id;
    private int size;
    private String size_filas;
    private String size_columnas;
    private String alAzar;
    private String planetasNeutrales;
    private String mapaCiego;
    private String acumular;
    private String finalizacion;
    private MapaPNeutrales mapaPNeutral;
    private Boolean todoCorrecto;

    public Boolean getTodoCorrecto() {
        return todoCorrecto;
    }

    public void setTodoCorrecto(Boolean todoCorrecto) {
        this.todoCorrecto = todoCorrecto;
    }

    public MapaPNeutrales getMapaPNeutral() {
        return mapaPNeutral;
    }

    public void setMapaPNeutral(MapaPNeutrales mapaPNeutral) {
        this.mapaPNeutral = mapaPNeutral;
    }

    public String getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(String finalizacion) {
        this.finalizacion = finalizacion;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSize_filas() {
        return size_filas;
    }

    public void setSize_filas(String size_filas) {
        this.size_filas = size_filas;
    }

    public String getSize_columnas() {
        return size_columnas;
    }

    public void setSize_columnas(String size_columnas) {
        this.size_columnas = size_columnas;
    }

    public String getAlAzar() {
        return alAzar;
    }

    public void setAlAzar(String alAzar) {
        this.alAzar = alAzar;
    }

    public String getPlanetasNeutrales() {
        return planetasNeutrales;
    }

    public void setPlanetasNeutrales(String planetasNeutrales) {
        this.planetasNeutrales = planetasNeutrales;
    }

    public String getMapaCiego() {
        return mapaCiego;
    }

    public void setMapaCiego(String mapaCiego) {
        this.mapaCiego = mapaCiego;
    }

    public String getAcumular() {
        return acumular;
    }

    public void setAcumular(String acumular) {
        this.acumular = acumular;
    }
    
    
    
}
