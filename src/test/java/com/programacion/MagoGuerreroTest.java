package com.programacion;

import org.junit.Test;
import static org.junit.Assert.*;

public class MagoGuerreroTest {
    @Test
    public void magoReduceDanoEnUnaCuartaParte() {
        Mago mago = new Mago("Merlin", 100, 20, "Rayo");
        mago.defender(20);
        assertEquals(85, mago.getSalud());
    }

    @Test
    public void magoAtacaConFuerzaNormal() {
        Mago mago = new Mago("Merlin", 100, 20, "Rayo");
        Guerrero objetivo = new Guerrero("Arthur", 100, 10, "Espada");
        mago.atacar(objetivo);
        // Ataque de 20 menos los 3 puntos del bloqueo.
        assertEquals(83, objetivo.getSalud());
    }

    @Test
    public void guerreroReduceDanoEnTresPuntos() {
        Guerrero guerrero = new Guerrero("Arthur", 100, 20, "Espada");
        guerrero.defender(10);
        assertEquals(93, guerrero.getSalud());
    }

    @Test
    public void guerreroAtacaConFuerzaNormal() {
        Guerrero guerrero = new Guerrero("Arthur", 100, 20, "Espada");
        Mago objetivo = new Mago("Merlin", 100, 10, "Rayo");
        guerrero.atacar(objetivo);
        assertEquals(85, objetivo.getSalud());
    }

    @Test
    public void bloqueoPermiteAlMenosUnPuntoDeDano() {
        Guerrero guerrero = new Guerrero("Arthur", 100, 20, "Espada");
        guerrero.defender(2);
        assertEquals(99, guerrero.getSalud());
    }

    @Test
    public void danoCeroNoModificaLaSalud() {
        Mago mago = new Mago("Merlin", 100, 20, "Rayo");
        Guerrero guerrero = new Guerrero("Arthur", 100, 20, "Espada");
        mago.defender(0);
        guerrero.defender(0);
        assertEquals(100, mago.getSalud());
        assertEquals(100, guerrero.getSalud());
    }

    @Test(expected = IllegalArgumentException.class)
    public void magoRechazaDanoNegativo() {
        Mago mago = new Mago("Merlin", 100, 20, "Rayo");
        mago.defender(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void guerreroRechazaDanoNegativo() {
        Guerrero guerrero = new Guerrero("Arthur", 100, 20, "Espada");
        guerrero.defender(-5);
    }

    @Test
    public void danoExcesivoDejaAmbosEnCero() {
        Mago mago = new Mago("Merlin", 10, 20, "Rayo");
        Guerrero guerrero = new Guerrero("Arthur", 10, 20, "Espada");
        mago.defender(100);
        guerrero.defender(100);
        assertEquals(0, mago.getSalud());
        assertEquals(0, guerrero.getSalud());
        assertFalse(mago.estaViva());
        assertFalse(guerrero.estaViva());
    }
}
