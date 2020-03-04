package Pollitos;

/**
 *
 * @author luisGonzalez
 */
public class ArchivoConfiguracion {
    
    private String tipo;
    private int numero;
    private String nombreAtributo;
    private Object atributo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombreAtributo() {
        return nombreAtributo;
    }

    public void setNombreAtributo(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    public Object getAtributo() {
        return atributo;
    }

    public void setAtributo(Object atributo) {
        this.atributo = atributo;
    }
    
}
