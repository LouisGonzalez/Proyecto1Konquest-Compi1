package mapa;

import Pollitos.Juego;
import interfaz.VentanaPrincipal;

/**
 *
 * @author luisGonzalez
 */
public class MedicionDistancias {
    
    public Integer[] verificarExistenciaPlaneta(Juego misDatos, int x, int y){
    
        boolean encontrado = false; 
        boolean encontrado2 = false;
        Integer[] nodosJalar = new Integer[2];
        for (int i = 0; i < misDatos.getJugadores().size(); i++) {
            for (int j = 0; j < misDatos.getJugadores().get(i).getMisPlanetas().size(); j++) {
                int posX = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getPosicionX());
                int posY = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getPosicionY());
                if(posX == x && posY == y){
                    encontrado = true;
                    nodosJalar[0] = i;
                    nodosJalar[1] = j;
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
                    nodosJalar[0] = null;
                    nodosJalar[1] = i;
                    break;
                }
            }
        }
        return nodosJalar;
    }
    
    public void verificarExistenciaPlaneta2(Juego misDatos, int x, int y, Integer[] nodosJalar){
        boolean encontrado = false;
        boolean encontrado2 = false;
        Integer noJugador = null;
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
            
        } else if(encontrado2){
            
        } else {
            
        }
        
    }
}
