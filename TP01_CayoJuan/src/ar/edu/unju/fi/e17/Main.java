package ar.edu.unju.fi.e17;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import ar.edu.unju.fi.e17Model.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        int cantJugador = 0;
try {
        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    altaJugador(jugadores, scanner);
                    cantJugador++;
                    break;
                case 2:
                    mostrarDatosJugador(jugadores, scanner);
                    break;
                case 3:
                    mostrarJugadoresOrdenados(jugadores);
                    break;
                case 4:
                    modificarDatos(jugadores, scanner);
                    break;
                case 5:
                    eliminarJugador(jugadores, scanner);
                    cantJugador--;
                    break;
                case 6:
                    System.out.println("La cantidad de jugadores es de " + cantJugador);
                    break;
                case 7:
                    mostrarCantidadPorNacionalidad(jugadores, scanner);
                    break;
                case 8:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo");
                    break;
            }
        } while (opcion != 8);
    } catch (InputMismatchException e) {
        System.err.println("Se esperaba un numero entero.");
    } finally {
        scanner.close();
    }
}
    private static void mostrarMenu() {
    	 System.out.println("\n*** Menu ***");
         System.out.println("1-Alta de jugador");
         System.out.println("2-Mostrar Datos del jugador");
         System.out.println("3-Mostrar todos los jugadores ordenados por apellido");
         System.out.println("4-Modificar los datos de un jugador");
         System.out.println("5-Eliminar un jugador");
         System.out.println("6-Mostrar la cantidad total de jugadores que tiene el ArrayList");
         System.out.println("7-Mostrar la cantidad de jugadores que pertenecen a una nacionalidad");
         System.out.println("8-Salir");
         System.out.print("Ingrese una opción: ");
    }
    private static void altaJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
    	try {
    	Jugador jugador = new Jugador();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	System.out.println("Datos del Jugador: ");
    	System.out.println("Nombre: ");
    	String Nombre = scanner.next();
    	jugador.setNombre(Nombre);
    	System.out.println("Apellido: ");
    	String apellido = scanner.next();
    	jugador.setApellido(apellido);
    	System.out.print("Fecha de Nacimiento (yyyy-MM-dd): ");
        String fechaString = scanner.next();
        LocalDate fechaNacimiento = LocalDate.parse(fechaString, formatter);
        jugador.setFechaNac(fechaNacimiento);
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.next();
        jugador.setNacionalidad(nacionalidad);
        System.out.print("Estatura (metros con ,): ");
        float estatura = scanner.nextFloat();
        jugador.setEstatura(estatura);
        System.out.print("Peso (kg con ,): ");
        float peso = scanner.nextFloat();
        jugador.setPeso(peso);
        System.out.print("Posicion (delantero, medio, defensa, arquero): ");
        String posicion = scanner.next();
        jugador.setPosicion(posicion);
        jugadores.add(jugador);
        System.out.println("Jugador agregado");
    	}catch (DateTimeParseException e) {
            System.out.println("Error al ingresar la fecha de nacimiento. Formato esperado: yyyy-MM-dd");
        } catch (InputMismatchException e) {
            System.out.println("Se esperaba un valor numérico para estatura o peso.");
        } finally {
            scanner.nextLine();
        }
    }
    private static void mostrarDatosJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
    	try {
        System.out.println("Mostrar Datos del Jugador");
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();

        boolean encontrado = false;
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                jugador.mostrarDatos();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro ningun jugador con ese nombre y apellido.");
        }}catch (InputMismatchException e) {
            System.out.println("Error: Se esperaba una cadena de texto para el nombre o apellido.");
        } finally {
            scanner.nextLine();
        }
    }
    private static void mostrarJugadoresOrdenados(ArrayList<Jugador> jugadores) {
        System.out.println("Jugadores ordenados por apellido");
        ArrayList<Jugador> jugadoresOrdenados = new ArrayList<>(jugadores);
        Collections.sort(jugadoresOrdenados, Comparator.comparing(Jugador::getApellido));
        for (Jugador jugador : jugadoresOrdenados) {
            System.out.println(jugador.getApellido());
        }
    }
    public static void modificarDatos(ArrayList<Jugador> jugadores, Scanner scanner) {
        boolean encontrado = false;

        System.out.println("**Modificar Datos**");
        System.out.println("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.println("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();

        for (Jugador jugador : jugadores) {
            if (nombre.equalsIgnoreCase(jugador.getNombre()) && apellido.equalsIgnoreCase(jugador.getApellido())) {
                int opcion;
                do {
                    System.out.println("***Menu de Modificar datos***");
                    System.out.println("1-Nombre");
                    System.out.println("2-Apellido");
                    System.out.println("3-Fecha de nacimiento");
                    System.out.println("4-Nacionalidad");
                    System.out.println("5-Estatura");
                    System.out.println("6-Peso");
                    System.out.println("7-Posicion");
                    System.out.println("8-Salir");
                    System.out.println("Ingrese una opción: ");
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:
                        	try {
                            System.out.println("Ingrese el nuevo nombre: ");
                            String nuevoNombre = scanner.next();
                            jugador.setNombre(nuevoNombre);
                    } catch (InputMismatchException e) {
                        System.err.println("Se esperaba un nombre valido.");
                    } finally {
                        scanner.nextLine(); 
                    }
                            break;
                        case 2:
                        	try {
                            System.out.println("Ingrese el nuevo apellido: ");
                            String nuevoApellido = scanner.next();
                            jugador.setApellido(nuevoApellido);
                        	}  catch (InputMismatchException e) {
                                System.err.println("Se esperaba un apellido valido.");
                            } finally {
                                scanner.nextLine();
                            }
                            break;
                        case 3:
                        	try {
                        	System.out.println("Ingrese la nueva fecha de nacimiento (yyyy-MM-dd): ");
                            String nuevaFechaNacimientoStr = scanner.next();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                     
                            LocalDate nuevaFechaNacimiento = LocalDate.parse(nuevaFechaNacimientoStr, formatter);

                            jugador.setFechaNac(nuevaFechaNacimiento);
                        	}catch (DateTimeParseException e) {
                                System.err.println("Formato de fecha inválido. Use el formato yyyy-MM-dd.");
                        	}
                            break;                   
                        case 4:
                            System.out.println("Ingrese la nueva nacionalidad: ");
                            String nuevaNacionalidad = scanner.next();
                            jugador.setNacionalidad(nuevaNacionalidad);
                            
                            break;
                        case 5:
                            System.out.println("Ingrese la nueva estatura: ");
                            float nuevaEstatura = scanner.nextFloat();
                            jugador.setEstatura(nuevaEstatura);
                            break;
                        case 6:
                            System.out.println("Ingrese el nuevo peso: ");
                            float nuevoPeso = scanner.nextFloat();
                            jugador.setPeso(nuevoPeso);
                            break;
                        case 7:
                            System.out.println("Ingrese la nueva posición (delantero, medio, defensa, arquero): ");
                            String nuevaPosicion = scanner.next();
                            jugador.setPosicion(nuevaPosicion);
                            break;
                        case 8:
                            System.out.println("Saliendo del menu de modificacion.");
                            break;
                        default:
                            System.out.println("Opcion invalida. Intentelo de nuevo.");
                    }
                } while (opcion != 8);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Jugador no encontrado.");
        }
    }
    private static void eliminarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
    	try {
        System.out.println("Eliminar Jugador");
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();

        boolean encontrado = false;
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                jugadores.remove(i);
                System.out.println("Jugador eliminado.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro ningun jugador con ese nombre y apellido.");
        }}  catch (InputMismatchException e) {
                System.err.println("Se esperaba un valor de entrada valido.");
            } finally {
                scanner.nextLine();
            }
        }
        
    
    private static void mostrarCantidadPorNacionalidad(ArrayList<Jugador> jugadores, Scanner scanner) {
    	try {
        System.out.println("Cantidad de jugadores por nacionalidad");
        System.out.print("Ingrese la nacionalidad del jugador: ");
        String nacionalidad = scanner.next();

        int contador = 0;
        for (Jugador jugador : jugadores) {
            if (jugador.getNacionalidad().equalsIgnoreCase(nacionalidad)) {
                contador++;
            }
        }
        System.out.println("Hay " + contador + " jugadores con nacionalidad " + nacionalidad);
    	}catch (InputMismatchException e) {
            System.err.println("Se esperaba un valor de entrada válido.");
        } finally {
            scanner.nextLine();
        }
    }
}