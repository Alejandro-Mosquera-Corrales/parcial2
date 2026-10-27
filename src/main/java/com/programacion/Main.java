package com.programacion;

public class Main {

    public static void main(String[] args) {

        // Referencias de tipo Criatura con objetos de diferentes subclases.
        Criatura dragon = new Dragon("Fuego", 100, 15, "Rojas");
        Criatura mago = new Mago("Merlin", 100, 20, "Rayo");

        simularBatalla(dragon, mago);

        // Objetos nuevos para comenzar otra batalla con salud completa.
        Criatura guerrero = new Guerrero("Arthur", 100, 18, "Espada");
        Criatura otroMago = new Mago("Gandalf", 100, 20, "Bola de fuego");

        simularBatalla(guerrero, otroMago);
    }

    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {

        if (criatura1 == null || criatura2 == null) {
            throw new IllegalArgumentException("Se necesitan dos criaturas");
        }

        if (criatura1 == criatura2) {
            throw new IllegalArgumentException(
                    "Una criatura no puede luchar contra si misma");
        }

        if (!criatura1.estaViva() || !criatura2.estaViva()) {
            throw new IllegalArgumentException(
                    "Ambas criaturas deben estar vivas al iniciar");
        }

        if (criatura1.getFuerza() <= 0 || criatura2.getFuerza() <= 0) {
            throw new IllegalArgumentException(
                    "Ambas criaturas deben tener fuerza positiva");
        }

        System.out.println("\n========== BATALLA ==========");
        System.out.println(criatura1.getNombre() + " contra "
                + criatura2.getNombre());

        int ronda = 1;

        while (criatura1.estaViva() && criatura2.estaViva()) {

            System.out.println("\nRonda " + ronda);

            criatura1.atacar(criatura2);

            System.out.println(criatura1);
            System.out.println(criatura2);

            // La segunda criatura solo responde si sobrevivio.
            if (criatura2.estaViva()) {
                criatura2.atacar(criatura1);

                System.out.println(criatura1);
                System.out.println(criatura2);
            }

            ronda++;
        }

        System.out.println("\n========== RESULTADO ==========");

        if (criatura1.estaViva()) {
            System.out.println("Ganador: " + criatura1.getNombre());
        } else {
            System.out.println("Ganador: " + criatura2.getNombre());
        }

        System.out.println(criatura1);
        System.out.println(criatura2);
    }
}