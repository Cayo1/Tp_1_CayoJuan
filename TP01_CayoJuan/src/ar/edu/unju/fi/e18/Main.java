package ar.edu.unju.fi.e18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.e18Model.DestinoTuristico;
import ar.edu.unju.fi.e18Model.Pais;

public class Main {
    private static ArrayList<Pais> paises = new ArrayList<>();
    private static ArrayList<DestinoTuristico> destinos = new ArrayList<>();

    public static void main(String[] args) {
        precargarPaises();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    altaDestinoTuristico(scanner);
                    break;
                case 2:
                    mostrarDestinosTuristicos();
                    break;
                case 3:
                    modificarPaisDestino(scanner);
                    break;
                case 4:
                    limpiarDestinosTuristicos();
                    break;
                case 5:
                    eliminarDestinoTuristico(scanner);
                    break;
                case 6:
                    mostrarDestinosOrdenados();
                    break;
                case 7:
                    mostrarPaises();
                    break;
                case 8:
                    mostrarDestinosPorPais(scanner);
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 9);
    }

    private static void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1 - Alta de destino turístico");
        System.out.println("2 - Mostrar todos los destinos turísticos");
        System.out.println("3 - Modificar el país de un destino turístico");
        System.out.println("4 - Limpiar el ArrayList de destino turísticos");
        System.out.println("5 - Eliminar un destino turístico");
        System.out.println("6 - Mostrar los destinos turísticos ordenados por nombre");
        System.out.println("7 - Mostrar todos los países");
        System.out.println("8 - Mostrar los destinos turísticos que pertenecen a un país");
        System.out.println("9 - Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void precargarPaises() {
        paises.add(new Pais("ARG", "Argentina"));
        paises.add(new Pais("BRA", "Brasil"));
        paises.add(new Pais("CHL", "Chile"));
        paises.add(new Pais("USA", "Estados Unidos"));
        paises.add(new Pais("ESP", "España"));
    }

    private static void altaDestinoTuristico(Scanner scanner) {
        try {
            System.out.print("Ingrese el código del destino: ");
            String codigo = scanner.nextLine();
            System.out.print("Ingrese el nombre del destino: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el precio del destino: ");
            double precio = scanner.nextDouble();
            System.out.print("Ingrese la cantidad de días: ");
            int cantidadDias = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Ingrese el código del país: ");
            String codigoPais = scanner.nextLine();
            Pais pais = buscarPaisPorCodigo(codigoPais);

            if (pais != null) {
                DestinoTuristico destino = new DestinoTuristico(codigo, nombre, precio, pais, cantidadDias);
                destinos.add(destino);
                System.out.println("Destino turístico agregado exitosamente.");
            } else {
                System.out.println("País no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al agregar destino turístico: " + e.getMessage());
        }
    }

    private static void mostrarDestinosTuristicos() {
        if (destinos.isEmpty()) {
            System.out.println("No hay destinos turísticos registrados.");
        } else {
            for (DestinoTuristico destino : destinos) {
                System.out.println(destino);
            }
        }
    }

    private static void modificarPaisDestino(Scanner scanner) {
        try {
            System.out.print("Ingrese el código del destino a modificar: ");
            String codigoDestino = scanner.nextLine();
            DestinoTuristico destino = buscarDestinoPorCodigo(codigoDestino);

            if (destino != null) {
                System.out.print("Ingrese el nuevo código del país: ");
                String nuevoCodigoPais = scanner.nextLine();
                Pais nuevoPais = buscarPaisPorCodigo(nuevoCodigoPais);

                if (nuevoPais != null) {
                    destino.setPais(nuevoPais);
                    System.out.println("País del destino turístico modificado exitosamente.");
                } else {
                    System.out.println("País no encontrado.");
                }
            } else {
                System.out.println("Destino turístico no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el país del destino turístico: " + e.getMessage());
        }
    }

    private static void limpiarDestinosTuristicos() {
        destinos.clear();
        System.out.println("Todos los destinos turísticos han sido eliminados.");
    }

    private static void eliminarDestinoTuristico(Scanner scanner) {
        try {
            System.out.print("Ingrese el código del destino a eliminar: ");
            String codigoDestino = scanner.nextLine();
            Iterator<DestinoTuristico> iterator = destinos.iterator();

            boolean encontrado = false;
            while (iterator.hasNext()) {
                DestinoTuristico destino = iterator.next();
                if (destino.getCodigo().equals(codigoDestino)) {
                    iterator.remove();
                    encontrado = true;
                    System.out.println("Destino turístico eliminado exitosamente.");
                }
            }

            if (!encontrado) {
                System.out.println("Destino turístico no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar destino turístico: " + e.getMessage());
        }
    }

    private static void mostrarDestinosOrdenados() {
        if (destinos.isEmpty()) {
            System.out.println("No hay destinos turísticos registrados.");
        } else {
            Collections.sort(destinos, Comparator.comparing(DestinoTuristico::getNombre));
            for (DestinoTuristico destino : destinos) {
                System.out.println(destino);
            }
        }
    }

    private static void mostrarPaises() {
        if (paises.isEmpty()) {
            System.out.println("No hay países registrados.");
        } else {
            for (Pais pais : paises) {
                System.out.println(pais);
            }
        }
    }

    private static void mostrarDestinosPorPais(Scanner scanner) {
        try {
            System.out.print("Ingrese el código del país: ");
            String codigoPais = scanner.nextLine();
            Pais pais = buscarPaisPorCodigo(codigoPais);

            if (pais != null) {
                boolean encontrado = false;
                for (DestinoTuristico destino : destinos) {
                    if (destino.getPais().equals(pais)) {
                        System.out.println(destino);
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    System.out.println("No hay destinos turísticos registrados para este país.");
                }
            } else {
                System.out.println("País no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar destinos turísticos por país: " + e.getMessage());
        }
    }

    private static Pais buscarPaisPorCodigo(String codigo) {
        for (Pais pais : paises) {
            if (pais.getCodigo().equalsIgnoreCase(codigo)) {
                return pais;
            }
        }
        return null;
    }

    private static DestinoTuristico buscarDestinoPorCodigo(String codigo) {
        for (DestinoTuristico destino : destinos) {
            if (destino.getCodigo().equalsIgnoreCase(codigo)) {
                return destino;
            }
        }
        return null;
    }
}
