package com.company.OtrasClases;

import com.company.TipoCarta.Estudio;
import com.company.TipoCarta.Ramo;

import java.util.List;


public class Tablero {
    private List<Ramo> semestre;
    private Integer horasDisponibles;

    public Tablero(){
    }
    //Constructor

    /**
     * Tablero
     * Constructor para tablero
     * @param semestre
     * @param horasDisponibles
     */
    public Tablero(List<Ramo> semestre, Integer horasDisponibles) {
        this.semestre = semestre;
        this.horasDisponibles = horasDisponibles;
    }
    //Sobrecargar un método para empezar con 12 hrs

    /**
     * Tablero
     * Sobre carga de tablero, para empezar el juego con 12 horas, si necesito cambiarlo, uso el Tablero normal.
     * @param semestre
     */

    public Tablero(List<Ramo> semestre){
        this.semestre = semestre;
        this.horasDisponibles =12;

    }
    //Get and set

    /**
     * getSemestre
     * No recibe parametros
     * @return semestre
     * retorna la lista de ramos
     */
    public List<Ramo> getSemestre() {
        return semestre;
    }

    /**
     * setSemestre
     * Recibe la lista de ramos: semestre
     * @param semestre
     * setea los valores de semestre
     */
    public void setSemestre(List<Ramo> semestre) {
        this.semestre = semestre;
    }

    /**
     * getHorasDisponibles
     * No recibe parametros
     * @return horasDisponibles
     * retorna las horas disponibles
     */
    public Integer getHorasDisponibles() {
        return horasDisponibles;
    }

    /**
     * setHorasDisponibles
     * Setea las horas disponibles
     * @param horasDisponibles
     * No hay return porque es void
     */
    public void setHorasDisponibles(Integer horasDisponibles) {
        this.horasDisponibles = horasDisponibles;
    }

    public void jugarEstudio(Estudio estudio, Integer pos){
        Integer hora = estudio.getHoras();
        Ramo ramo= semestre.get(pos);
        ramo.anadirEstudio(estudio);
        horasDisponibles= horasDisponibles - hora;
        System.out.println("Se aplico la carta de estudio"+estudio.getNombre()+"a la carta de ramo:"+ramo.getNombre());
    }
    public void mostrarTablero(){
        for (Ramo i:semestre
             ) {
            List<Estudio> nombre = i.getEstudios();
            String ramo = i.getNombre();
            System.out.println("Nombre de la carta:"+ramo);
            for (Estudio j: nombre
                 ) {
                String ramo1= j.getNombre();
                System.out.println("Nombre de la carta estudio"+ramo1);
            }
        }
    }
}
