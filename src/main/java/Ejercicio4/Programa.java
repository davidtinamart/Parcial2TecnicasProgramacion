package Ejercicio4;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Programa {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Usuario 1
        System.out.println("Configuración de barcos para el Usuario 1:");
        ArrayList<Barco> barcosDeUsuario1 = getUserShips(scanner);

        // Usuario 2
        System.out.println("Configuración de barcos para el Usuario 2:");
        ArrayList<Barco> barcosDeUsuario2 = getUserShips(scanner);

        // Crear usuarios del juego
        Usuario usuario1 = new Usuario(barcosDeUsuario1);
        Usuario usuario2 = new Usuario(barcosDeUsuario2);

        // Comenzar el juego
        Random random = new Random();
        while (usuario1.esta_vivo() && usuario2.esta_vivo() ) {
            // Ataque del Usuario 1 al Usuario 2
            Point shotPoint1 = getRandomShotPoint(random);
            usuario1.atacar(shotPoint1, usuario2);

            // Ataque del Usuario 2 al Usuario 1
            Point shotPoint2 = getRandomShotPoint(random);
            usuario2.atacar(shotPoint2, barcosDeUsuario1);
        }

        // Mostrar el ganador
        if (barcosDeUsuario1.esta_vivo() && !usuario2.esta_vivo()) {
            System.out.println("¡El Usuario 1 ha ganado!");
        } else if (!barcosDeUsuario1.esta_vivo() && usuario2.esta_vivo()) {
            System.out.println("¡El Usuario 2 ha ganado!");
        } else {
            System.out.println("¡Empate!");
        }
    }

    private static ArrayList<Barco> getUserShips(Scanner scanner) {
        ArrayList<Barco> ships = new ArrayList<>();

        System.out.println("Tienes un máximo de 3 barcos en total, uno de cada tipo:");
        System.out.println("Battleship: 5 casillas, Frigate: 3 casillas, Canoe: 1 casilla");
        System.out.println("Ingresa las coordenadas de inicio y fin para cada barco o escribe 'no' si no deseas ese tipo de barco.");

        for (String shipType : new String[]{"Battleship", "Frigate", "Canoe"}) {
            System.out.println("Punto inicial y punto final del " + shipType + " en formato x1 y1 x2 y2 ej(3 2 2 6), o 'no' si no deseas este tipo de barco:");

            String input = scanner.next();
            if (!input.equalsIgnoreCase("no")) {
                int x1 = Integer.parseInt(input);
                int y1 = scanner.nextInt();
                int x2 = scanner.nextInt();
                int y2 = scanner.nextInt();
                Point startPoint =
                        new Point(x1, y1);
                Point endPoint = new Point(x2, y2);
                Barco barco;
                switch (shipType) {
                    case "Battleship":
                        barco = new Battleship(startPoint, endPoint);
                        break;
                    case "Frigate":
                        barco = new Frigate(startPoint, endPoint);
                        break;
                    case "Canoe":
                        barco = new Canoe(startPoint, endPoint);
                        break;
                    default:
                        System.out.println("Tipo de barco no válido. Intente de nuevo.");
                        continue;
                }
                ships.add(barco);
            }
        }
        return ships;
    }

    private static Point getRandomShotPoint(Random random) {
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        return new Point(x, y);
    }
}