package com.programacion;

public class Dragon extends Criatura {

    private String escamas;

    public Dragon() {
        super();
    }

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

        public String getEscamas() {
        return escamas;
    }

    public void setEscamas(String escamas) {
        this.escamas = escamas;
    }

        // El dragon ataca con el doble de su fuerza.
    @Override
    public void atacar(Criatura objetivo) {
        int dano = getFuerza() * 2;

        System.out.println(getNombre() + " lanza fuego contra "
                + objetivo.getNombre() + " con " + dano + " de dano.");

        objetivo.defender(dano);
    }

        // Las escamas reducen el dano a la mitad.
    @Override
    public void defender(int dano) {
        if (dano < 0) {
            throw new IllegalArgumentException("El dano no puede ser negativo");
        }

        int danoRecibido = dano / 2;

        if (dano > 0 && danoRecibido == 0) {
            danoRecibido = 1;
        }

        recibirDano(danoRecibido);

        System.out.println(getNombre() + " se protege con sus escamas y recibe "
                + danoRecibido + " de dano.");
    }
}