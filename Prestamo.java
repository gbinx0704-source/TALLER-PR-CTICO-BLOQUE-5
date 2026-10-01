import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    private Estudiante estudiante;
    private Ejemplar ejemplar;
    private LocalDate fechaPrevistaDevolucion;
    private List<Renovacion> renovaciones = new ArrayList<>();

    public Prestamo(Estudiante estudiante, Ejemplar ejemplar, LocalDate fechaPrevistaDevolucion) {
        this.estudiante = estudiante;
        this.ejemplar = ejemplar;
        this.fechaPrevistaDevolucion = fechaPrevistaDevolucion;
    }

    public void renovar(LocalDate nuevaFecha) {
        // 1. validar que nuevaFecha sea posterior a la fecha actual prevista
        if (!nuevaFecha.isAfter(fechaPrevistaDevolucion)) {
            throw new IllegalArgumentException(
                "La nueva fecha (" + nuevaFecha + ") debe ser posterior a la fecha prevista vigente ("
                + fechaPrevistaDevolucion + ").");
        }
        // 2. crear la Renovacion
        Renovacion renovacion = new Renovacion(LocalDate.now(), fechaPrevistaDevolucion, nuevaFecha);
        // 3. almacenarla
        renovaciones.add(renovacion);
        // 4. actualizar fechaPrevistaDevolucion
        fechaPrevistaDevolucion = nuevaFecha;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public Ejemplar getEjemplar() { return ejemplar; }
    public LocalDate getFechaPrevistaDevolucion() { return fechaPrevistaDevolucion; }
    public int getCantidadRenovaciones() { return renovaciones.size(); }
}
