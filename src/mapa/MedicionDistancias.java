package mapa;

import Pollitos.Juego;
import interfaz.VentanaPrincipal;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class MedicionDistancias {
    
    public Integer[] verificarExistenciaPlaneta(Juego misDatos, int x, int y){
    
        boolean encontrado = false; 
        boolean encontrado2 = false;
        Integer[] nodoJalar = new Integer[3];
        for (int i = 0; i < misDatos.getJugadores().size(); i++) {
            for (int j = 0; j < misDatos.getJugadores().get(i).getMisPlanetas().size(); j++) {
                int posX = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getPosicionX());
                int posY = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getPosicionY());
                if(posX == x && posY == y){
                    encontrado = true;
                    nodoJalar[0] = i;
                    nodoJalar[1] = j;
                    break;
                }
            }
        }
        if(encontrado == false){
            for (int i = 0; i < misDatos.getpNeutrales().size(); i++) {
                int posX = Integer.parseInt(misDatos.getpNeutrales().get(i).getPosicionX());
                int posY = Integer.parseInt(misDatos.getpNeutrales().get(i).getPosicionY());
                if(posX == x && posY == y){
                    encontrado2 = true;
                    nodoJalar[1] = i;
                    break;
                }
            }
        }
        if(encontrado || encontrado2){
            VentanaPrincipal.clicksDistancia++;
        }
        return nodoJalar;
    }
    
    public void verificarExistenciaPlaneta2(Juego misDatos, int x, int y, Integer[] nodoJalar, JButton btnDistancia, JButton btnFlotas){
        boolean encontrado = false;
        boolean encontrado2 = false;
        Integer noJugador = 0;
        Integer noPlaneta = 0;
        for (int i = 0; i < misDatos.getJugadores().size(); i++) {
            for (int j = 0; j < misDatos.getJugadores().get(i).getMisPlanetas().size(); j++) {
                int posX = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getPosicionX());
                int posY = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getPosicionY());
                if(posX == x && posY == y){
                    encontrado = true;
                    noJugador = i;
                    noPlaneta = j;
                    break;
                }
            }
        }
        if(encontrado == false){
            for (int i = 0; i < misDatos.getpNeutrales().size(); i++) {
                int posX = Integer.parseInt(misDatos.getpNeutrales().get(i).getPosicionX());
                int posY = Integer.parseInt(misDatos.getpNeutrales().get(i).getPosicionY());
                if(posX == x && posY == y){
                    encontrado2 = true;
                    noPlaneta = i;
                }
            }
        }
        //DENTRO DE ESTOS METODOS VA EL CACULO DE DISTANCIA 
        if(encontrado){
            if(nodoJalar[0] == null){
                distanciaPlanetaNeutral(noJugador, noPlaneta, nodoJalar[1], misDatos);
            } else {
                distanciaPlanetaPlaneta(nodoJalar, noJugador, noPlaneta, misDatos);
            }
            VentanaPrincipal.clicksDistancia = 0;
            btnDistancia.setEnabled(true);
            btnFlotas.setEnabled(true);
        } else if(encontrado2){
            if(nodoJalar[0] == null){
                distanciaNeutralNeutral(nodoJalar[1], noPlaneta, misDatos);
            } else {
                distanciaPlanetaNeutral(nodoJalar[0], nodoJalar[1], noPlaneta, misDatos);
            }
            VentanaPrincipal.clicksDistancia = 0;
            btnDistancia.setEnabled(true);
            btnFlotas.setEnabled(true);
        }
        
    }
    
    public void distanciaPlanetaPlaneta(Integer[] nodoJalar, int noJugador, int noPlaneta, Juego misDatos){
       int posX = Integer.parseInt(misDatos.getJugadores().get(noJugador).getMisPlanetas().get(noPlaneta).getPosicionX());
       int posY = Integer.parseInt(misDatos.getJugadores().get(noJugador).getMisPlanetas().get(noPlaneta).getPosicionY());
       int posX2 = Integer.parseInt(misDatos.getJugadores().get(nodoJalar[0]).getMisPlanetas().get(nodoJalar[1]).getPosicionX());
       int posY2 = Integer.parseInt(misDatos.getJugadores().get(nodoJalar[0]).getMisPlanetas().get(nodoJalar[1]).getPosicionY());
       int posXFinal = 0;
       int posYFinal = 0;
       int pitagoras = 0;
       pitagoras = resultadoDistancia(posX, posY, posX2, posY2, pitagoras, posXFinal, posYFinal);
       JOptionPane.showMessageDialog(null, "La distancia entre el planeta "+misDatos.getJugadores().get(noJugador).getMisPlanetas().get(noPlaneta).getNombre()+" y el planeta "+misDatos.getJugadores().get(nodoJalar[0]).getMisPlanetas().get(nodoJalar[1]).getNombre()+" es de: "+pitagoras + " años luz.");
       
    }
    
    public void distanciaPlanetaNeutral(int noJugador, int noPlaneta, int noPlaneta2, Juego misDatos){
        int posX = Integer.parseInt(misDatos.getJugadores().get(noJugador).getMisPlanetas().get(noPlaneta).getPosicionX());
        int posY = Integer.parseInt(misDatos.getJugadores().get(noJugador).getMisPlanetas().get(noPlaneta).getPosicionY());
        int posX2 = Integer.parseInt(misDatos.getpNeutrales().get(noPlaneta2).getPosicionX());
        int posY2 = Integer.parseInt(misDatos.getpNeutrales().get(noPlaneta2).getPosicionY());
        int posXFinal = 0;
        int posYFinal = 0;
        int pitagoras = 0;
        pitagoras = resultadoDistancia(posX, posY, posX2, posY2, pitagoras, posXFinal, posYFinal);
        JOptionPane.showMessageDialog(null, "La distancia entre el planeta "+misDatos.getJugadores().get(noJugador).getMisPlanetas().get(noPlaneta).getNombre()+" y el planeta "+misDatos.getpNeutrales().get(noPlaneta2).getNombre()+" es de: "+pitagoras+" años luz.");
    }
    
    public void distanciaNeutralNeutral(int noPlaneta, int noPlaneta2, Juego misDatos){
        int posX = Integer.parseInt(misDatos.getpNeutrales().get(noPlaneta).getPosicionX());
        int posY = Integer.parseInt(misDatos.getpNeutrales().get(noPlaneta).getPosicionY());
        int posX2 = Integer.parseInt(misDatos.getpNeutrales().get(noPlaneta2).getPosicionX());
        int posY2 = Integer.parseInt(misDatos.getpNeutrales().get(noPlaneta2).getPosicionY());
        int posXFinal = 0;
        int posYFinal = 0;
        int pitagoras = 0;
        pitagoras = resultadoDistancia(posX, posY, posX2, posY2, pitagoras, posXFinal, posYFinal);
        JOptionPane.showMessageDialog(null, "La distancia entre los planetas es de: "+pitagoras);
    }
    
    public int resultadoDistancia(int posX, int posY, int posX2, int posY2, int pitagoras, int posXFinal, int posYFinal){
            if(posX >= posX2){
           posXFinal = posX - posX2;
       } else {
           posXFinal = posX2 - posX;
       }
       if(posY >= posY2){
           posYFinal = posY - posY2;
       } else {
           posYFinal = posY2 - posY;
       }
       int sumasCuadrado = (int) Math.pow(posXFinal, 2) + (int) Math.pow(posYFinal, 2);
       pitagoras = (int) Math.sqrt(sumasCuadrado);
       return pitagoras;
    }
}
