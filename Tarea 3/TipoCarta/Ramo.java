package com.company.TipoCarta;

import com.company.TipoCarta.Enum.Area;

import java.util.List;

public class Ramo extends Carta {
    private Integer creditos;
    private List<Estudio> estudios;
    private Area area;

    public Ramo() {
    }

    /**
     * Constructor de Ramo con nombre y lore incluidos
     * @param nombre
     * @param lore
     * @param creditos
     * @param estudios
     * @param area
     */

    //Constructor
    public Ramo(String nombre, String lore, Integer creditos, List<Estudio> estudios, Area area) {
        super(nombre, lore);
        this.creditos = creditos;
        this.estudios = estudios;
        this.area = area;
    }

    /**
     * SobreCarga de Ramo, sin lore ni metodo
     * @param creditos
     * @param estudios
     * @param area
     */
    //Sobrecarga de método

    public Ramo(Integer creditos, List<Estudio> estudios, Area area) {
        this.creditos = creditos;
        this.estudios = estudios;
        this.area = area;
    }




    //Get and set

    /**
     * getCreditos
     * Obtiene los creditos
     * @return creditos
     * retorna la cantidad de creditos
     */
    public Integer getCreditos() {
        return creditos;
    }

    /**
     * setCreditos
     * Setea los valores de credito
     * @param creditos
     * Es de tipo void, no hay return
     */

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    /**
     * getEstudios
     * Obtiene los estudios de la lista
     * @return estudios
     * retorna los estudios de la lista
     */
    public List<Estudio> getEstudios() {
        return estudios;
    }

    /**
     * setEstudios
     * setea los estudios
     * @param estudios
     * no hay return
     */
    public void setEstudios(List<Estudio> estudios) {
        this.estudios = estudios;
    }

    /**
     * getArea
     * No hay parametros
     * @return area
     * retorna el area a la que pertenece (Enum)
     */
    public Area getArea() {
        return area;
    }

    /**
     * setArea
     * setea el area
     * @param area
     * no hay return
     */
    public void setArea(Area area) {
        this.area = area;
    }


    public int calcularNota() {
        int NF = 0;
        Float bonus = 1.25f;
        for (Estudio i : estudios
        ) {
            if (i.getArea() == Area.HUMANISTA) {
                if (area == i.getArea()) {
                    NF = (int) (i.calcularBonus() * bonus) - 2 * 2;
                } else {
                    NF = (i.calcularBonus()) - 2 * 2;
                }
            }
            if (i.getArea() == Area.INFORMATICA) {
                if (area == i.getArea()) {
                    NF = (int) (bonus * i.calcularBonus()) - 2 * 5;
                } else {
                    NF = (i.calcularBonus()) - 2 * 5;
                }
            }
            if (i.getArea() == Area.MATEMATICA) {
                if (area == i.getArea()) {
                    NF = (int) (bonus * i.calcularBonus()) - 2 * 7;
                } else {
                    NF = (i.calcularBonus()) - 2 * 7;
                }
            }
            NF += NF;
        }
        return NF;
    }

    public void anadirEstudio(Estudio estudio) {
        estudios.add(estudio);
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


