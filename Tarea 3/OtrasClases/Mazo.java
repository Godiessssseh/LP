package com.company.OtrasClases;
import com.company.TipoCarta.Carta;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private List<Carta>  cartas;

    public Mazo(){
    }
    //Constructor para las cartas del Mazo, recibe una lista de cartas

    /**
     * Mazo
     * Recibe la lista de cartas y las setea
     * @param cartas
     * return nada, debido a que solo setea las cartas
     */

    public Mazo(List<Carta> cartas) {
        this.cartas = cartas;
    }

    //Get and Set

    /**
     * getCartas
     * Recibe la lista de cartas y retorna las cartas
     * No hay parametros
     * @return cartas, las cartas de la lista
     */
    public List<Carta> getCartas() {
        return cartas;
    }

    /**
     * setCartas
     * Setea las cartas de la lista
     * @param cartas
     * no retorna nada, porque es de tipo void
     */
    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    //Implementaciones de las funciones pedidas

    public void putBack(Carta carta){
        cartas.add(carta);
    }

    public Carta draw(){
        Carta carta = cartas.get(0);
        cartas.remove(0);
        return carta;
    }
    public void shuffle(){
        Collections.shuffle(cartas);
    }
}
