package Ejercicio4;
import java.awt.*;

public class Canoa extends Barco {

    private static final int TAMANOCANOA = 1; // Tamaño de la canoa (1 casilla) en el tablero

    public Canoa(Point inicio, Point fin) {
        super(TAMANOCANOA, inicio, fin);
    }

}