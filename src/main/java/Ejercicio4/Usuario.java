package Ejercicio4;

import java.awt.*;
import java.util.ArrayList;

public class Usuario {
    // Atributos

    private ArrayList<Barco> ships;
    private boolean esta_vivo;

    // Metodo Constructor que recibe un array de barcos y comprueba que no sea nulo o vacío

    public Usuario(ArrayList<Barco> ships) throws IllegalArgumentException {
        if (ships == null || ships.isEmpty()) {
            throw new IllegalArgumentException("Debe haber al menos un barco para el usuario.");
        }
        this.ships = ships;
        this.esta_vivo = true;
    }

    // Getters y Setters
    public ArrayList<Barco> getShips() {
        return ships;
    }
    // Metodo is_alive que devuelve true si el usuario está vivo

    public boolean esta_vivo() {
        return esta_vivo;
    }

    // Metodo muere que cambia el estado del usuario a muerto

    public void muere() {
        this.esta_vivo = false;
    }

    // Metodo atacar que recibe un punto y un usuario y comprueba si el punto está
    // entre los puntos de inicio y fin de alguno de los barcos del usuario y si
    // está hundido lo elimina

    public boolean atacar(Point shot_point, Usuario usuario) throws Exception {
        if (shot_point == null || usuario == null) {
            throw new IllegalArgumentException("No pueden ser nulos.");
        }
        for (Barco barco : usuario.getShips()) {
            barco.recibe_disparo(shot_point);
            if (barco.esta_hundido()) {
                usuario.getShips().remove(barco);
            }
            return true;
        }
        return false;
    }

    // Metodo get_shot que recibe un punto y comprueba si está entre los puntos de inicio
    // y fin de alguno de los barcos del usuario y si está hundido lo elimina.

    public void get_shot(Point shot_point) {
        for (Barco barco : ships) {
            barco.recibe_disparo(shot_point);
            if (barco.esta_hundido()) {
                ships.remove(barco);
            }
            return;
        }
    }


}