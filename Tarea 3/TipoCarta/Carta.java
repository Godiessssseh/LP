package com.company.TipoCarta;

public abstract class Carta{

    protected String nombre;

    protected String lore;

    public Carta(){
    }
    //Constructor

    /**
     *Constructor de Carta
     * @param nombre
     * @param lore
     */
    public Carta(String nombre, String lore) {
        this.nombre = nombre;
        this.lore = lore;
    }

    /**
     *getNombre
     * Obtiene el nombre
     * @return nombre
     * retorna el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *setNombre
     * setea el nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *getLore
     * Obtiene el lore
     * @return lore
     * devuelve el lore
     */
    public String getLore() {
        return lore;
    }

    /**
     *setLore
     * setea el Lore
     * @param lore
     */
    public void setLore(String lore) {
        this.lore = lore;
    }
    /**
     * mostrarCarta
     * Muestra la carta
     * No hay parametros
     * No hay return
     */
    void mostrarCarta() {
    }
}
