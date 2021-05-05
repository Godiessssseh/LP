package com.company.TipoCarta;
import java.util.concurrent.ThreadLocalRandom;

public class Estudio extends Carta {
    private Integer horas;

    private Integer bonusMin;

    private Integer bonusMax;

    private Enum area;

    public Estudio() {
    }

    /**
     * Constructor de estudio
     * @param nombre
     * @param lore
     * @param horas
     * @param bonusMin
     * @param bonusMax
     * @param area
     */
    public Estudio(String nombre, String lore, Integer horas, Integer bonusMin, Integer bonusMax, Enum area) {
        super(nombre, lore);
        this.horas = horas;
        this.bonusMin = bonusMin;
        this.bonusMax = bonusMax;
        this.area = area;
    }

    //Get and set

    /**
     * getHoras
     * Obtiene las horas
     * @return horas
     * retorna la cant de horas
     */
    public Integer getHoras() {
        return horas;
    }

    /**
     * setHoras
     * Setea las horas
     * @param horas
     * no hay return
     */
    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    /**
     *getBonusMin
     * Obtiene el bonus minimo
     * @return BonusMin
     * retorna el bonus minimo
     */
    public Integer getBonusMin() {
        return bonusMin;
    }

    /**
     *setBonusMin
     * setea el valor de bonus minimo
     * @param bonusMin
     * void, no retorna nada
     */
    public void setBonusMin(Integer bonusMin) {
        this.bonusMin = bonusMin;
    }

    /**
     *getBonusMax
     * Obtiene el bonus maximo
     * @return BonusMax
     * retorna el bonus maximo
     */
    public Integer getBonusMax() {
        return bonusMax;
    }

    /**
     *setBonusMax
     * setea el valor de Bonus maximo
     * @param bonusMax
     */
    public void setBonusMax(Integer bonusMax) {
        this.bonusMax = bonusMax;
    }

    /**
     *getArea
     * Obtiene el area
     * @return area
     * retorna el area
     */
    public Enum getArea() {
        return area;
    }

    /**
     *setArea
     * setea el area
     * @param area
     */
    public void setArea(Enum area) {
        this.area = area;
    }

    //Se debe definir +1 en bonusMax, debido a que si es un rango entre 20 y 48, nunca considerará el 48,
    //pero si se le agrega el +1, si lo va a considerar.

    public int calcularBonus() {
        int numeroRandom = ThreadLocalRandom.current().nextInt(bonusMin, bonusMax + 1);
        return numeroRandom;
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