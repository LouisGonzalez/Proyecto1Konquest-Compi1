package AccionesComputadora;

import Pollitos.Juego;
import Pollitos.NavesCamino;
import Pollitos.Planetas;
import interfaz.VentanaPrincipal;
import java.util.ArrayList;
import mapa.Jugabilidad;

/**
 *
 * @author luisGonzalez
 */
public class InteligenciaArtificial {

    private Jugabilidad jugabilidad = new Jugabilidad();
    

    public void accionesModoFacil(Juego misDatos, ArrayList<NavesCamino> listNaves) {
        int noJugador = VentanaPrincipal.contador;
        if (misDatos.getJugadores().get(noJugador).getEnJuego().equals("true")) {
            int totalPlanetas = misDatos.getJugadores().get(noJugador).getMisPlanetas().size();
            int totalPlanetas2 = totalPlanetas - 1;
            int planetaElegido = (int) (Math.random() * totalPlanetas2);
            int totalNaves = Integer.parseInt(misDatos.getJugadores().get(noJugador).getMisPlanetas().get(planetaElegido).getNaves());
            int random = (int) (totalNaves * 0.8);
            System.out.println(totalNaves + " el total de las naveds");
            int navesLanzadas = (int) (Math.random() * random);
            System.out.println(navesLanzadas + " las naves  que termino lanzando");
            int noJugadorAtacado = 0;
            int noPlanetaAtacado = 0;
            noJugadorAtacado = calculoJugadorAleatorio(noJugadorAtacado, misDatos);
            noPlanetaAtacado = calculoPlanetaAleatorio(noPlanetaAtacado, noJugadorAtacado, misDatos);
            envioNaves(navesLanzadas, misDatos, planetaElegido, noJugadorAtacado, noPlanetaAtacado, listNaves);
        }

    }

    //VERIFICAR LOS RANDOM D:
    public int calculoJugadorAleatorio(int noJugadorAtacado, Juego misDatos) {
        int noJugadorAtacado2 = misDatos.getJugadores().size();
        noJugadorAtacado = (int) (Math.random() * noJugadorAtacado2);
        System.out.println(noJugadorAtacado + "   ME REPITO?");
        int valor;
        if (noJugadorAtacado == VentanaPrincipal.contador || !misDatos.getJugadores().get(noJugadorAtacado).getEnJuego().equals("true")) {
            valor = calculoJugadorAleatorio(noJugadorAtacado, misDatos);
        } else {
            valor = noJugadorAtacado;
        }
        return valor;
    }

    public int calculoPlanetaAleatorio(int noPlanetaAtacado, int noJugadorAtacado, Juego misDatos) {
        int rango = misDatos.getJugadores().get(noJugadorAtacado).getMisPlanetas().size();
        int rango2 = rango - 1;
        noPlanetaAtacado = (int) (Math.random() * rango2);
        return noPlanetaAtacado;
    }

    public void accionesModoDificil(Juego misDatos, ArrayList<NavesCamino> listNaves) {
        int noJugador = VentanaPrincipal.contador;
        int noPlaneta = 0;
        if (misDatos.getJugadores().get(noJugador).getEnJuego().equals("true")) {
            int planetaMasFuerte = Integer.parseInt(misDatos.getJugadores().get(noJugador).getMisPlanetas().get(0).getNaves());
            for (int i = 0; i < misDatos.getJugadores().get(noJugador).getMisPlanetas().size(); i++) {
                if (i > 0) {
                    int navesAux = Integer.parseInt(misDatos.getJugadores().get(noJugador).getMisPlanetas().get(i).getNaves());
                    if (navesAux >= planetaMasFuerte) {
                        planetaMasFuerte = navesAux;
                        noPlaneta = i;
                    }
                }
            }
            double rango = planetaMasFuerte * 0.8;
            int rangoConvertido = (int) rango;
            int totalNaves = (int) (Math.random() * (planetaMasFuerte - rangoConvertido + 1) + rangoConvertido);
            int planetaContrincante = 0;
            int noJugadorAtacado = 0;
            int noPlanetaAtacado = 0;
            if (VentanaPrincipal.contador != 0 && misDatos.getJugadores().get(0).getEnJuego().equals("true")) {
                planetaContrincante = Integer.parseInt(misDatos.getJugadores().get(0).getMisPlanetas().get(0).getNaves());
            } else {
                planetaContrincante = Integer.parseInt(misDatos.getJugadores().get(1).getMisPlanetas().get(0).getNaves());
                for (int i = 1; i < misDatos.getJugadores().size(); i++) {
                    for (int j = 0; j < misDatos.getJugadores().get(i).getMisPlanetas().size(); j++) {
                        if (i != noJugador && misDatos.getJugadores().get(i).getEnJuego().equals("true")) {
                            noJugadorAtacado = i;
                            noPlanetaAtacado = j;
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < misDatos.getJugadores().size(); i++) {
                if (misDatos.getJugadores().get(i).getEnJuego().equals("true")) {
                    for (int j = 0; j < misDatos.getJugadores().get(i).getMisPlanetas().size(); j++) {
                        if (i != VentanaPrincipal.contador) {
                            int navesAux = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getNaves());
                            if (navesAux <= planetaContrincante) {
                                planetaContrincante = navesAux;
                                noJugadorAtacado = i;
                                noPlanetaAtacado = j;
                            }
                        }
                    }
                }
            }
            envioNaves(totalNaves, misDatos, noPlaneta, noJugadorAtacado, noPlanetaAtacado, listNaves);

        }

    }

    public void envioNaves(int navesEnvio, Juego misDatos, int noPlanetaAtacante, int noJugadorAtacado, int noPlanetaAtacado, ArrayList<NavesCamino> listNaves) {
        Planetas atacante = misDatos.getJugadores().get(VentanaPrincipal.contador).getMisPlanetas().get(noPlanetaAtacante);
        Planetas atacado = misDatos.getJugadores().get(noJugadorAtacado).getMisPlanetas().get(noPlanetaAtacado);
        int navesAtacado = Integer.parseInt(atacado.getNaves());
        int navesAtacante = Integer.parseInt(atacante.getNaves());
        int pitagoras = 0;
        int nuevasNaves = navesAtacante - navesEnvio;
        misDatos.getJugadores().get(VentanaPrincipal.contador).getMisPlanetas().get(noPlanetaAtacante).setNaves(Integer.toString(nuevasNaves));
        pitagoras = jugabilidad.distanciaPlanetaPlaneta(noPlanetaAtacante, noJugadorAtacado, noPlanetaAtacado, misDatos, pitagoras);
        int turno = VentanaPrincipal.contadorTurnos + pitagoras;
        NavesCamino camino = new NavesCamino();
        String planeta1 = misDatos.getJugadores().get(VentanaPrincipal.contador).getMisPlanetas().get(noPlanetaAtacante).getNombre();
        String planeta2 = misDatos.getJugadores().get(noJugadorAtacado).getMisPlanetas().get(noPlanetaAtacado).getNombre();
        float porcentajeMuertes = Float.parseFloat(misDatos.getJugadores().get(VentanaPrincipal.contador).getMisPlanetas().get(noPlanetaAtacante).getPorcentajeMuertes());
        camino = jugabilidad.seteoNavesCamino(noPlanetaAtacante, misDatos, camino, listNaves, navesEnvio, noJugadorAtacado, planeta1, planeta2, porcentajeMuertes, turno);
        listNaves.add(camino);
        jugabilidad.agregarLanzamientosReplay(misDatos, camino);
    }

    
    public boolean verificadorTipoInteligencia(Juego misDatos, ArrayList<NavesCamino> listNaves) {
        boolean esInteligencia = false;
        int contador = VentanaPrincipal.contador;
        if (misDatos.getJugadores().get(contador).getTipo().equals("DIFICIL")) {
            accionesModoDificil(misDatos, listNaves);
            VentanaPrincipal.contador++;
            esInteligencia = true;
        } else if (misDatos.getJugadores().get(contador).getTipo().equals("FACIL")) {
            accionesModoFacil(misDatos, listNaves);
            VentanaPrincipal.contador++;
            esInteligencia = true;
        }
        return esInteligencia;
    }

}
