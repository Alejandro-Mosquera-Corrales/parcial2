package com.programacion;

import org.junit.Test;
import static org.junit.Assert.*;

public class BatallaTest {
    @Test
    public void criaturaDerrotadaNoContraataca() {
        Criatura dragon = new Dragon("Fuego", 100, 20, "Rojas");
        Criatura mago = new Mago("Merlin", 10, 5, "Rayo");
        Main.simularBatalla(dragon, mago);
        assertEquals(0, mago.getSalud());
        assertEquals(100, dragon.getSalud());
    }

    @Test(timeout = 2000)
    public void batallaTerminaConUnaCriaturaViva() {
        Criatura mago = new Mago("Merlin", 30, 10, "Rayo");
        Criatura guerrero = new Guerrero("Arthur", 30, 10, "Espada");
        Main.simularBatalla(mago, guerrero);
        assertTrue(mago.estaViva() || guerrero.estaViva());
        assertFalse(mago.estaViva() && guerrero.estaViva());
    }

    @Test(expected = IllegalArgumentException.class)
    public void noPermiteBatallaContraSiMismo() {
        Criatura dragon = new Dragon("Fuego", 100, 20, "Rojas");
        Main.simularBatalla(dragon, dragon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void noPermiteIniciarConCriaturaMuerta() {
        Criatura mago = new Mago("Merlin", 10, 10, "Rayo");
        Criatura guerrero = new Guerrero("Arthur", 100, 10, "Espada");
        mago.setSalud(0);
        Main.simularBatalla(mago, guerrero);
    }
}
