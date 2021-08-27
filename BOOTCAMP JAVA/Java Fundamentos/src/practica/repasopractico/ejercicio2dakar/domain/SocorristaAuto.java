package practica.repasopractico.ejercicio2dakar.domain;

public class SocorristaAuto implements Socorrer <Auto>{

    public SocorristaAuto() {
    }

    @Override
    public void socorrer(Auto unAuto) {
        System.out.println("Socorriendo vehiculo: " + unAuto.getPatente());
    }
}
