package Ejercicio4;

import java.awt.*;

public class Barco {
    // Atributos
    protected int tamano;
    protected int golpes;
    protected Point inicio;
    protected Point fin;

    // Constructor
    public Barco(int tamano, Point inicio, Point fin) {

        this.tamano = tamano;
        this.golpes = 0;
        this.inicio = inicio;
        this.fin = fin;
    }

    // Getters y Setters
    public int dameTamano() {
        return tamano;
    }

    public int dameGolpes() {
        return golpes;
    }

    public Point dameInicio() {
        return inicio;
    }

    public Point dameFin() {
        return fin;
    }

    public void setGolpes(int golpes) {
        this.golpes = golpes;
    }

    // Metodo is_sunk que devuelve true si el barco está hundido
    public boolean esta_hundido() {
        return golpes == tamano; // si el numero de hits es igual al tamaño del barco, el barco está hundido
    }

    // Metodo get_shot que recibe un punto y comprueba si está entre los puntos de inicio y fin
    public void recibe_disparo(Point shot_point) {
        if (esta_entre(inicio, fin, shot_point)) {
            golpes++;
        }
    }

    //  Metodo is_between que recibe dos puntos y un punto y comprueba si el punto está entre los dos puntos
    public boolean esta_entre(Point start, Point end, Point p) {
        return (p.getX() >= start.getX() && p.getX() <= end.getX() || p.getX() >= end.getX() && p.getX() <= start.getX())
                && (p.getY() >= start.getY()

                && p.getY() <= end.getY() || p.getY() >= end.getY() && p.getY() <= start.getY());
    }


}