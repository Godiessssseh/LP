package com.company.TipoCarta;

import com.company.OtrasClases.Mazo;
import com.company.OtrasClases.Tablero;
import com.company.TipoCarta.Enum.Efecto;

import java.util.concurrent.ThreadLocalRandom;

public class Evento extends Carta {

    private Efecto efecto;

    public Evento(){
    }
    //Constructor

    /**
     * Evento
     * Constructor de Evento
     * @param nombre
     * @param lore
     * @param efecto
     */
    public Evento(String nombre, String lore, Efecto efecto) {
        super(nombre, lore);
        this.efecto = efecto;
    }

    //Get and set

    /**
     * getEfecto
     * Obtiene el efecto
     * @return efecto
     * Retorna el efecto a aplicar
     */
    public Efecto getEfecto() {
        return efecto;
    }

    /**
     * setEfecto
     * setea el efecto
     * @param efecto}
     * no retorna nada
     */
    public void setEfecto(Efecto efecto) {
        this.efecto = efecto;
    }


    public void aplicarEvento(Tablero tablero, Mazo mazoCarrera){
        if(Efecto.RAV==efecto){

            //selecciona un ramo (HUMANISTA,MATEMATICA,INFORMATICA) y lo mezcla en el mazoCarrera
        };
        if (Efecto.BUFF==efecto){

        };
        if (Efecto.CAMBIO_DE_COORDINACION==efecto){
            int numeroRandom = ThreadLocalRandom.current().nextInt(1, 3);
            if(numeroRandom==1){
                //creditos ramo a eleccio aumenten 3
            }else{
                //cred ramo a eleccion -3, puede quedar negativo.
            }
        }
    }

    /**
     * mostrarCarta
     * Muestra la carta
     * No hay parametros
     * No hay return
     */
    @Override
    void mostrarCarta() {
        super.mostrarCarta();
    }
}
