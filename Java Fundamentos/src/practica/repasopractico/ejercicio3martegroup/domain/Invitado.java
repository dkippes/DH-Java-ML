package practica.repasopractico.ejercicio3martegroup.domain;

public abstract class Invitado extends Persona{
    private String tipo;

    public Invitado(String nombre, int edad) {
        super(nombre, edad);
    }

    public Invitado(String nombre, int edad, String tipo) {
        super(nombre, edad);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Invitado{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
