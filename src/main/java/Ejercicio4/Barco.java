package Ejercicio4;

import java.awt.*;

public class Barco {
    // atributos
    protected int tamano;
    protected int hits;
    protected Point inicio;
    protected Point fin;

    // constructor
    public Barco(int size, Point inicio, Point fin) {
        this.tamano = size;
        this.hits = 0;
        this.inicio = inicio;
        this.fin = fin;
    }

    // Getters y Setters
    public int getSize() {
        return tamano;
    }

    public int getHits() {
        return hits;
    }

    public Point getStart() {
        return inicio;
    }

    public Point getEnd() {
        return fin;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    // Metodo is_sunk que devuelve true si el barco está hundido
    public boolean is_sunk() {
        return hits == tamano; // si el numero de hits es igual al tamaño del barco, el barco está hundido
    }

    // Metodo get_shot que recibe un punto y comprueba si está entre los puntos de inicio y fin
    public void get_shot(Point shot_point) {
        if (is_between(inicio, fin, shot_point)) {
            hits++;
        }
    }

    //  Metodo is_between que recibe dos puntos y un punto y comprueba si el punto está entre los dos puntos
    public boolean is_between(Point start, Point end, Point p) {
        return (p.getX() >= start.getX() && p.getX() <= end.getX() || p.getX() >= end.getX() && p.getX() <= start.getX())
                && (p.getY() >= start.getY()

                && p.getY() <= end.getY() || p.getY() >= end.getY() && p.getY() <= start.getY());
    }


}