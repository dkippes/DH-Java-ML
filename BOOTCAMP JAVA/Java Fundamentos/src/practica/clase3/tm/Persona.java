package practica.clase3.tm;

public class Persona implements IPrecedable<Persona>{
    private String nombre;
    public int dni;

    // Getter and Setter
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    // Constructors
    public Persona() {
    }

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni=" + dni +
                '}';
    }

    @Override
    public int precedeA(Persona t) {
        // Si los nombres son iguales
        if(this.nombre.compareToIgnoreCase(t.nombre) == 0){
            // return this.dni == t.dni? 1: 0;
            return Integer.compare(this.dni, t.getDni());
        }
        // Este ya devuelve 1, 0, -1
        return this.nombre.compareToIgnoreCase(t.getNombre());
    }
}
