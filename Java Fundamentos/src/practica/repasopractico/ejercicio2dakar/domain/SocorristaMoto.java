package practica.repasopractico.ejercicio2dakar.domain;

public class SocorristaMoto implements Socorrer <Moto> {

    public SocorristaMoto() {
    }

    @Override
    public void socorrer(Moto unaMoto) {
        System.out.println("Socorriendo moto: " + unaMoto.getPatente());
    }
}
