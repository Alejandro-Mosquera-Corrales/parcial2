package com.programacion;

public class Guerrero extends Criatura {

    private String arma;

    public Guerrero() {
        super();
    }

    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    // El guerrero ataca con su fuerza normal.
    @Override
    public void atacar(Criatura objetivo) {
        int dano = getFuerza();

        System.out.println(getNombre() + " ataca con " + arma
                + " a " + objetivo.getNombre()
                + " con " + dano + " de dano.");

        objetivo.defender(dano);
    }

    // El bloqueo del guerrero reduce el dano en tres puntos.
    @Override
    public void defender(int dano) {
        if (dano < 0) {
            throw new IllegalArgumentException("El dano no puede ser negativo");
        }

        int danoRecibido = 0;

        if (dano > 0) {
            danoRecibido = dano - 3;

            if (danoRecibido < 1) {
                danoRecibido = 1;
            }
        }

        recibirDano(danoRecibido);

        System.out.println(getNombre() + " bloquea el ataque y recibe "
                + danoRecibido + " de dano.");
    }
}