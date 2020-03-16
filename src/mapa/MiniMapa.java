package mapa;

import Pollitos.Planetas;
import Pollitos.PlanetasNeutrales;
import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class MiniMapa {
    
    
    public void seteoFalsoInterruptores(ArrayList<Planetas> listPlanetas, ArrayList<PlanetasNeutrales> listNeutrales){
        for (int i = 0; i < listPlanetas.size(); i++) {
            listPlanetas.get(i).setInterruptor(false);
        }
        for (int i = 0; i < listNeutrales.size(); i++) {
            listNeutrales.get(i).setInterruptor(false);
        }
    }
}
