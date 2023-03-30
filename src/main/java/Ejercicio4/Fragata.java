package Ejercicio4;
import java.awt.Point;

public class Fragata extends Barco {

    private static final int TAMANOFRAGATA = 3; // Tamaño de la fragata (3 casillas) en el tablero

    public Fragata(Point inicio, Point fin) {
        super(TAMANOFRAGATA, inicio, fin);
    }

}