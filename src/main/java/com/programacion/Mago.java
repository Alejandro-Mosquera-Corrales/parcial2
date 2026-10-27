package com.programacion;

public class Mago extends Criatura {

    private String hechizos;

    public Mago() {
        super();
    }

    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    public String getHechizos() {
        return hechizos;
    }

    public void setHechizos(String hechizos) {
        this.hechizos = hechizos;
    }

    // El mago ataca con su fuerza normal.
    @Override
    public void atacar(Criatura objetivo) {
        int dano = getFuerza();

        System.out.println(getNombre() + " utiliza " + hechizos
                + " contra " + objetivo.getNombre()
                + " con " + dano + " de dano.");

        objetivo.defender(dano);
    }

    // El escudo magico reduce el dano en una cuarta parte.
    @Override
    public void defender(int dano) {
        if (dano < 0) {
            throw new IllegalArgumentException("El dano no puede ser negativo");
        }

        int danoRecibido = dano - dano / 4;

        recibirDano(danoRecibido);

        System.out.println(getNombre() + " usa su escudo magico y recibe "
                + danoRecibido + " de dano.");
    }
}