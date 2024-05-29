import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico();
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 3) {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Añadir animal");
            System.out.println("2. Mostrar animales");
            System.out.println("3. Salir");

            opcion = obtenerOpcion(scanner);
            switch (opcion) {
                case 1:
                    añadirAnimal(zoologico, scanner);
                    break;
                case 2:
                    zoologico.mostrarAnimales();
                    break;
                case 3:
                    System.out.println("Hasta Luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }

        scanner.close();
    }

    private static int obtenerOpcion(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void añadirAnimal(Zoologico zoologico, Scanner scanner) {
        System.out.println("Selecciona el tipo de animal (1: León, 2: Elefante, 3: Pájaro): ");
        int tipoAnimal = obtenerTipoAnimal(scanner);
        Animal animal;
        switch (tipoAnimal) {
            case 1:
                animal = crearLeon(scanner);
                break;
            case 2:
                animal = crearElefante(scanner);
                break;
            case 3:
                animal = crearPajaro(scanner);
                break;
            default:
                System.out.println("Tipo de animal no válido.");
                return;
        }
        zoologico.añadirAnimal(animal);
    }

    private static int obtenerTipoAnimal(Scanner scanner) {
        while (true) {
            int tipoAnimal = obtenerOpcion(scanner);
            if (tipoAnimal >= 1 && tipoAnimal <= 3) {
                return tipoAnimal;
            } else {
                System.out.println("Por favor, introduce un número entre 1 y 3.");
            }
        }
    }

    private static Animal crearLeon(Scanner scanner) {
        System.out.println("Introduce el nombre del león:");
        String nombre = scanner.next();
        System.out.println("Introduce la edad del león:");
        int edad = obtenerEdad(scanner);
        return new Leon(nombre, edad);
    }

    private static Animal crearElefante(Scanner scanner) {
        System.out.println("Introduce el nombre del elefante:");
        String nombre = scanner.next();
        System.out.println("Introduce la edad del elefante:");
        int edad = obtenerEdad(scanner);
        return new Elefante(nombre, edad);
    }

    private static Animal crearPajaro(Scanner scanner) {
        System.out.println("Introduce el nombre del pájaro:");
        String nombre = scanner.next();
        System.out.println("Introduce la edad del pájaro:");
        int edad = obtenerEdad(scanner);
        return new Pajaro(nombre, edad);
    }

    private static int obtenerEdad(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int edad = scanner.nextInt();
                if (edad >= 0) {
                    return edad;
                } else {
                    System.out.println("La edad debe ser un número positivo.");
                }
            } else {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next();
            }
        }
    }
}
