package ar.edu.unju.fi.e18;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import ar.edu.unju.fi.e18Model.Destino;
import ar.edu.unju.fi.e18Model.Pais;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        ArrayList<Pais> paises = new ArrayList<>();
        ArrayList<Destino> destinos = new ArrayList<>();

        paises.add(new Pais("AR-0000", "Argentina"));
        paises.add(new Pais("BR-0001", "Brasil"));
        paises.add(new Pais("UY-0002", "Uruguay"));

        int opcion = 0 ;
        opcion = scanner.nextInt();
        try {
            do {
                MostrarMenu();
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        altaDestinoTuristico(scanner, destinos, paises);
                        break;
                    case 2:
                        mostrarDestinosTuristicos(destinos);
                        break;
                    case 3:
                        modificarPaisDestinoTuristico(scanner, destinos, paises);
                        break;
                    case 4:
                        destinos.clear();
                        System.out.println("Se han eliminado todos los destinos turisticos.");
                        break;
                    case 5:
                        eliminarDestinoTuristico(scanner, destinos);
                        break;
                    case 6:
                        mostrarDestinosOrdenadosPorNombre(destinos);
                        break;
                    case 7:
                        mostrarTodosLosPaises(paises);
                        break;
                    case 8:
                        mostrarDestinosPorPais(scanner, destinos);
                        break;
                    case 9:
                        System.out.println("Saliendo del programa");
                        break;
                    default:
                        System.out.println("Opcion invalida. Intente de nuevo.");
                        break;
                }
            } while (opcion != 9);
        } catch (InputMismatchException e) {
            System.out.println("Ingrese un número valido.");
            scanner.nextLine();
        }

        scanner.close();
    }
	private static void MostrarMenu() {
		System.out.println("Menu");
        System.out.println("1 - Alta de destino turistico");
        System.out.println("2 - Mostrar todos los destinos turisticos");
        System.out.println("3 - Modificar el país de un destino turistico");
        System.out.println("4 - Limpiar la lista de destinos turisticos");
        System.out.println("5 - Eliminar un destino turistico");
        System.out.println("6 - Mostrar destinos turísticos ordenados por nombre");
        System.out.println("7 - Mostrar todos los paises");
        System.out.println("8 - Mostrar destinos turísticos por país");
        System.out.println("9 - Salir");
        System.out.println("Ingrese su opción: ");
	}
	
	public static void altaDestinoTuristico(Scanner scanner, ArrayList<Destino> destinos, ArrayList<Pais> paises) {
        try {
		System.out.println("Ingrese el codigo del destino:");
        String codigo = scanner.next();
        scanner.nextLine();
        System.out.println("Ingrese el nombre del destino:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el precio del destino:");
        double precio = scanner.nextDouble();
        System.out.println("Ingrese el codigo del país asociado al destino:");
        String codigoPais = scanner.next();

        Pais paisAsociado = null;
        for (Pais pais : paises) {
            if (pais.getCodigo().equalsIgnoreCase(codigoPais)) {
                paisAsociado = pais;
                break;
            }
        }

        if (paisAsociado != null) {
            System.out.println("Ingrese la cantidad de dias del destino:");
            int cantidadDias = scanner.nextInt();
            Destino nuevoDestino = new Destino(codigo, nombre, precio, paisAsociado, cantidadDias);
            destinos.add(nuevoDestino);
            System.out.println("Destino agregado con exito.");
        } else {
            System.out.println("El codigo de pais ingresado no corresponde a ningun pais existente.");
        }}catch (InputMismatchException e) {
            System.err.println("Error: Se esperaba un valor numérico para el precio o la cantidad de días.");
        } catch (Exception e) {
            System.err.println("Se produjo un error al agregar el destino turístico: " + e.getMessage());
        } finally {
           
        }
    }

    public static void mostrarDestinosTuristicos(ArrayList<Destino> destinos) {
    	try {
        if (destinos.isEmpty()) {
            System.out.println("No hay destinos para mostrar.");
        } else {
            System.out.println("Destinos Turísticos");
            for (Destino destino : destinos) {
                System.out.println(destino);
            }
        }}catch (Exception e) {
            System.err.println("Se produjo un error al mostrar los destinos turísticos: " + e.getMessage());
        } finally {
            
        }
    }

    public static void modificarPaisDestinoTuristico(Scanner scanner, ArrayList<Destino> destinos, ArrayList<Pais> paises) {
       try {
    	System.out.println("Ingrese el codigo del destino a modificar:");
        String codigoDestino = scanner.next();

        Destino destinoEncontrado = null;
        for (Destino destino : destinos) {
            if (destino.getCodigo().equalsIgnoreCase(codigoDestino)) {
                destinoEncontrado = destino;
                break;
            }
        }

        if (destinoEncontrado != null) {
            System.out.println("Ingrese el nuevo codigo del país asociado al destino:");
            String nuevoCodigoPais = scanner.next();

            Pais nuevoPaisAsociado = null;
            for (Pais pais : paises) {
                if (pais.getCodigo().equalsIgnoreCase(nuevoCodigoPais)) {
                    nuevoPaisAsociado = pais;
                    break;
                }
            }

            if (nuevoPaisAsociado != null) {
                destinoEncontrado.setPais(nuevoPaisAsociado);
                System.out.println("El país asociado al destino se ha modificado con exito.");
            } else {
                System.out.println("El codigo de pais ingresado no corresponde a ningún pais existente.");
            }
        } else {
            System.out.println("No se encontro ningún destino con el codigo ingresado.");
        }}catch (Exception e) {
            System.err.println("Se produjo un error al modificar el país del destino turístico: " + e.getMessage());
        } finally {
            
        }
    }

    public static void eliminarDestinoTuristico(Scanner scanner, ArrayList<Destino> destinos) {
    	try {
        System.out.println("Ingrese el código del destino turístico a eliminar:");
        String codigoDestino = scanner.next();

        Iterator<Destino> iterator = destinos.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Destino destino = iterator.next();
            if (destino.getCodigo().equalsIgnoreCase(codigoDestino)) {
                iterator.remove();
                encontrado = true;
                System.out.println("Destino turístico eliminado con éxito.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro ningún destino con el codigo ingresado.");
        }}catch (Exception e) {
            System.err.println("Se produjo un error al eliminar el destino turístico: " + e.getMessage());
        } finally {
            
        }
    }

    public static void mostrarDestinosOrdenadosPorNombre(ArrayList<Destino> destinos) {
    	try {
        if (destinos.isEmpty()) {
            System.out.println("No hay destinos turísticos para mostrar.");
        } else {
            Collections.sort(destinos, Comparator.comparing(Destino::getNombre));
            System.out.println("Destinos Turisticos Ordenados por Nombre");
            for (Destino destino : destinos) {
                System.out.println(destino);
            }
        }}catch (Exception e) {
            System.err.println("Se produjo un error al mostrar los destinos turísticos ordenados por nombre: " + e.getMessage());
        } finally {
        	
        }
    	
    }

    public static void mostrarTodosLosPaises(ArrayList<Pais> paises) {
    	try {
        if (paises.isEmpty()) {
            System.out.println("No hay paises para mostrar.");
        } else {
            System.out.println("Países");
            for (Pais pais : paises) {
                System.out.println(pais);
            }}}
         catch (Exception e) {
            System.err.println("Se produjo un error al mostrar los países: " + e.getMessage());
        } finally {         
        }
    }

    public static void mostrarDestinosPorPais(Scanner scanner, ArrayList<Destino> destinos) {
    	try {
        System.out.println("Ingrese el codigo del pais:");
        String codigoPais = scanner.next();

        System.out.println(" Destinos para el Pais con Codigo " + codigoPais + " ***");
        boolean encontrado = false;
        for (Destino destino : destinos) {
            if (destino.getPais().getCodigo().equalsIgnoreCase(codigoPais)) {
                System.out.println(destino);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron destinos para el pais con codigo " + codigoPais);
        }
    }catch (InputMismatchException e) {
        System.err.println("Se esperaba un formato de entrada incorrecto.");
    } finally {
   
        scanner.nextLine(); 
    }
    }
 }

