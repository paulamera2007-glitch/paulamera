import java.util.Scanner;
import java.util.ArrayList;

public class GestorNotas {

    static ArrayList<String> nombres = new ArrayList<>();
    static ArrayList<Double> notas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;
                case 2:
                    listarEstudiantes();
                    break;
                case 3:
                    calcularPromedio();
                    break;
                case 4:
                    buscarEstudiante();
                    break;
                case 5:
                    eliminarEstudiante();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("\n===== GESTOR DE NOTAS =====");
        System.out.println("1. Agregar estudiante");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Calcular promedio del curso");
        System.out.println("4. Buscar estudiante");
        System.out.println("5. Eliminar estudiante");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }
  // Permite registrar un nuevo estudiante con su nombre y nota
    static void agregarEstudiante() {
        System.out.print("Nombre del estudiante: ");
        String nombre = sc.nextLine();
        System.out.print("Nota (0.0 - 5.0): ");
        double nota = sc.nextDouble();
        sc.nextLine();

        if (nota < 0.0 || nota > 5.0) {
            System.out.println("Nota invalida. Debe estar entre 0.0 y 5.0.");
            return;
        }

        nombres.add(nombre);
        notas.add(nota);
        System.out.println("Estudiante agregado correctamente.");
    }
    // Muestra todos los estudiantes registrados con sus notas
    static void listarEstudiantes() {
        if (nombres.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        System.out.println("\n--- Lista de estudiantes ---");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println((i + 1) + ". " + nombres.get(i) + " - Nota: " + notas.get(i));
        }
    }
    // Calcula el promedio de notas de todos los estudiantes
    static void calcularPromedio() {
        if (notas.isEmpty()) {
            System.out.println("No hay notas registradas.");
            return;
        }
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        double promedio = suma / notas.size();
        System.out.printf("Promedio del curso: %.2f%n", promedio);
    }
    // Busca un estudiante por nombre y muestra su nota
    static void buscarEstudiante() {
        System.out.print("Nombre a buscar: ");
        String nombre = sc.nextLine();
        int index = nombres.indexOf(nombre);

        if (index == -1) {
            System.out.println("Estudiante no encontrado.");
        } else {
            System.out.println(nombres.get(index) + " tiene nota: " + notas.get(index));
        }
    }
    // Elimina a un estudiante de la lista por nombre
    static void eliminarEstudiante() {
        System.out.print("Nombre a eliminar: ");
        String nombre = sc.nextLine();
        int index = nombres.indexOf(nombre);

        if (index == -1) {
            System.out.println("Estudiante no encontrado.");
        } else {
            nombres.remove(index);
            notas.remove(index);
            System.out.println("Estudiante eliminado.");
        }
    }
}