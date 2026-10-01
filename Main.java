import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("1085000001", "Ana Pérez", "ana@correo.com",
                "E001", "Ingeniería de Software");
        Ejemplar ejemplar = new Ejemplar("EJ-001");
        Prestamo prestamo = new Prestamo(estudiante, ejemplar, LocalDate.of(2026, 10, 1));

        // Prueba 1: renovación válida
        System.out.println("== Prueba 1: renovación válida ==");
        prestamo.renovar(LocalDate.of(2026, 10, 15));
        estudiante.notificar("Su préstamo fue renovado.");
        System.out.println("Nueva fecha: " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Cantidad de renovaciones: " + prestamo.getCantidadRenovaciones());

        // Prueba 2: renovación inválida (fecha igual a la vigente)
        System.out.println("== Prueba 2: renovación inválida ==");
        try {
            prestamo.renovar(LocalDate.of(2026, 10, 15));
        } catch (IllegalArgumentException e) {
            System.out.println("Renovación rechazada: " + e.getMessage());
        }
        System.out.println("Fecha vigente: " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Cantidad de renovaciones: " + prestamo.getCantidadRenovaciones());
    }
}
