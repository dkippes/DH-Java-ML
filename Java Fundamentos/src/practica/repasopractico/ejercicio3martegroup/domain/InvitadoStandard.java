package practica.repasopractico.ejercicio3martegroup.domain;

public class InvitadoStandard extends Invitado{

    public InvitadoStandard(String nombre, int edad) {
        super(nombre, edad);
    }

    public InvitadoStandard(String nombre, int edad, String tipo) {
        super(nombre, edad, tipo);
    }
}
