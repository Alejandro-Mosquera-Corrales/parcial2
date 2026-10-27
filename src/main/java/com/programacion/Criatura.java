package com.programacion;

/**
 * Clase abstracta que representa a cualquier criatura del juego.
 * Define los atributos comunes (nombre, salud, fuerza) y obliga a cada
 * subclase a implementar su propia forma de atacar y defenderse.
 */
public abstract class Criatura {

    // ---------- Atributos ----------
    private String nombre;
    private int salud;
    private int fuerza;

    // ---------- Constructores ----------

    /** Constructor vacio. */
    public Criatura() {
    }

    /**
     * Crea una criatura con sus datos.
     *
     * @param nombre nombre de la criatura
     * @param salud  puntos de salud iniciales (mayor a 0)
     * @param fuerza fuerza de la criatura (mayor a 0)
     */
    public Criatura(String nombre, int salud, int fuerza) {
        if (salud <= 0 || fuerza <= 0) {
            throw new IllegalArgumentException("La salud y la fuerza deben ser mayores a 0");
        }
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    // ---------- Getters y setters ----------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    // ---------- Metodos abstractos ----------

    // Cada tipo de criatura define su ataque y su defensa.
    public abstract void atacar(Criatura objetivo);

    public abstract void defender(int dano);

    // ---------- Metodos concretos ----------

    // Una criatura permanece viva mientras su salud sea mayor que cero.
    public boolean estaViva() {
        return salud > 0;
    }

    /**
     * Resta salud a la criatura. La salud nunca baja de 0.
     * Lo usan las subclases dentro de defender().
     */
    protected void recibirDano(int cantidad) {
        salud = Math.max(0, salud - cantidad);
    }

    @Override
    public String toString() {
        return nombre + " (salud: " + salud + ", fuerza: " + fuerza + ")";
    }
}