package Ejercicio4;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Programa {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);

        // Usuario 1
        System.out.println("--------------------------------------");
        System.out.println("BIENVENIDO USUARIO 1 -> CONFIGURACION:");
        System.out.println("--------------------------------------");
        ArrayList<Barco> barcosDeUsuario1 = getUserShips(scanner);

        // Usuario 2
        System.out.println("--------------------------------------");
        System.out.println("BIENVENIDO USUARIO 2 -> CONFIGURACION:");
        System.out.println("--------------------------------------");
        ArrayList<Barco> barcosDeUsuario2 = getUserShips(scanner);

        // Crear usuarios del juego
        Usuario usuario1 = new Usuario(barcosDeUsuario1);
        Usuario usuario2 = new Usuario(barcosDeUsuario2);

        // Comenzar el juego
        Random random = new Random();
        while (usuario1.esta_vivo() && usuario2.esta_vivo() ) {
            // Ataque del Usuario 1 al Usuario 2
            Point shotPoint1 = devolverPuntoDisparo(random);
            usuario1.atacar(shotPoint1, usuario2);

            // Ataque del Usuario 2 al Usuario 1
            Point shotPoint2 = devolverPuntoDisparo(random);
            usuario2.atacar(shotPoint2, usuario1);
        }

            // Mostrar ganador o empate en caso de que haya uno de los dos usuarios muerto
        if (usuario1.esta_vivo() && !usuario2.esta_vivo()) {
            System.out.println("GANA EL USUARIO 1");
        } else if (!usuario1.esta_vivo() && usuario2.esta_vivo()) {
            System.out.println("GANA EL USUARIO 2");
        } else {
            System.out.println("HAY UN EMPATE");
        }
    }

    private static ArrayList<Barco> getUserShips(Scanner teclado2) {

        ArrayList<Barco> ships = new ArrayList<>();

        System.out.println("Dispones de 3 barcos en total, uno de cada tipo de los siguientes:");
        System.out.println("Un BUQUE ocupa 5 casillas, una FRAGATA ocupa 3 casillas, y una canoa 1 casilla.");
        System.out.println("------------------------------------------------------------------------------------------------");

        for (String tipoBarco : new String[]{"Buque", "Fragata", "Canoa"}) {
            System.out.println("Coordenada inicial y final de " + tipoBarco + " en formato x1 y1 x2 y2, o 'no' si no deseas este tipo de barco:");
            System.out.println("------------------------------------------------------------------------------------------------");

            String input = teclado2.next();
            if (!input.equalsIgnoreCase("no")) {
                System.out.println("Introduzca las coordenadas del barco:");
                int x1 = teclado2.nextInt();
                int y1 = teclado2.nextInt();
                int x2 = teclado2.nextInt();
                int y2 = teclado2.nextInt();
                Point puntoInicial =
                        new Point(x1, y1);
                Point puntoFinal = new Point(x2, y2);
                Barco barcoalmacenado;
                switch (tipoBarco) {
                    case "Buque":
                        barcoalmacenado = new Buque(puntoInicial, puntoFinal);
                        break;
                    case "Fragata":
                        barcoalmacenado = new Fragata(puntoInicial, puntoFinal);
                        break;
                    case "Canoa":
                        barcoalmacenado = new Canoa(puntoInicial, puntoFinal);
                        break;
                    default:
                        System.out.println(" ¡Error! Tipo de barco desconocido. Intente de nuevo.");
                        continue;
                }
                ships.add(barcoalmacenado);
            }
        }
        return ships;
    }

    // Devuelve un punto aleatorio para disparar en el tablero de 10x10 (0,0) a (9,9)
    private static Point devolverPuntoDisparo(Random azar) {
        int x = azar.nextInt(10);
        int y = azar.nextInt(10);
        return new Point(x, y);
    }
}