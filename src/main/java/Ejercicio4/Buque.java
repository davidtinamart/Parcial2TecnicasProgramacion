package Ejercicio4;

import java.awt.*;

public class Buque extends Barco {

    // Atributos
    private final int huecosAislados;
    private int golpesAislados;

    // Metodo constructor
    public Buque(Point start, Point end) {
        super(5, start, end); // tamaño de 5
        this.huecosAislados = 2; //huecos aislados que puede haber en el barco
        this.golpesAislados = 0;
    }

    // Metodo get_shot que recibe un punto y comprueba si está entre los puntos de inicio y fin
    public void recibe_disparo(Point shot_point) {
        if (esta_entre(inicio, fin, shot_point)) {
            golpes++;
            if (esta_aislado(shot_point)) {
                golpesAislados++;
            }
        }
    }

    // método auxiliar para comprobar si un punto es una posición aislada del Battleship
    private boolean esta_aislado(Point p) {
        int x = (int) p.getX();
        int y = (int) p.getY();
        int startX = (int) inicio.getX();
        int startY = (int) inicio.getY();
        int endX = (int) fin.getX();
        int endY = (int) fin.getY();
        if (x == startX && (y == startY - 1 || y == endY + 1)) {
            return true;
        } else if (x == endX && (y == startY - 1 || y == endY + 1)) {
            return true;
        } else if (y == startY && (x == startX - 1 || x == endX + 1)) {
            return true;
        } else if (y == endY && (x == startX - 1 || x == endX + 1)) {
            return true;
        } else {
            return false;
        }
    }

    // Metodo esta_hundido (is_sunk) que devuelve true si el barco está hundido
    // (incluyendo los contenedores aislados)
    @Override
    public boolean esta_hundido() {
        return golpes == tamano && golpesAislados == huecosAislados;
    }


}
