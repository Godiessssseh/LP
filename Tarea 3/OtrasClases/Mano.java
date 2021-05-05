package com.company.OtrasClases;
import com.company.TipoCarta.Carta;

import java.util.List;

public class Mano {

    private List<Carta> cartas;

    public Mano(){
    }

    //Constructor para Mano, solo recibe la lista de cartas que hay en la mano

    /**
     * Mano
     *Setea las cartas que hay en mano
     * @param cartas
     * Return nada debido a que solo setea el valor
     */

    public Mano(List<Carta> cartas) {
        this.cartas = cartas;
    }

    /**
     * getCartas
     * Obtiene todas las cartas de la Lista
     * No recibe parametros
     * @return cartas
     */
    //Get and set
    public List<Carta> getCartas() {
        return cartas;
    }

    /**
     *setCartas
     * Setea todas las cartas que estan en la lista
     * @param cartas
     * No hay return porque solo setea el valor
     */
    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    //Implementaciones de las funciones definidas

    public void mostrarMano(){
        for(int i=0;i<cartas.size();i++){
            System.out.println(cartas.get(i)+"\n");
        }
    }
    //Si tiene 6 cartas, no puede seguir sacando. Si tiene menos a 6, puede sacar.
    public void anadirCarta(Carta carta){
        if(cartas.size()<6){
            cartas.add(carta);
        }else{
            System.out.println("La mano está llena, solo puedes tener 6 cartas en tu mano");
        }

    }
    public Carta seleccionarCarta(Integer pos){
        Carta carta =cartas.get(pos);
        return carta;
    }
}
