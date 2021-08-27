package practica.repasopractico.ejercicio1savetheropa;

import practica.repasopractico.ejercicio1savetheropa.domain.GuardarRopa;
import practica.repasopractico.ejercicio1savetheropa.domain.Prenda;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        GuardarRopa guardaropa = new GuardarRopa();
        Prenda prenda1 = new Prenda("Kevingstone", "kv1");
        Prenda prenda2 = new Prenda("Nike", "nk1");
        Prenda prenda3 = new Prenda("Addiddas", "add1");

        List<Prenda> listaDePrendas1 = new ArrayList<>();
        listaDePrendas1.add(prenda1);
        listaDePrendas1.add(prenda2);

        List<Prenda> listaDePrendas2 = new ArrayList<>();
        listaDePrendas2.add(prenda2);
        listaDePrendas2.add(prenda3);

        guardaropa.guardarPrendas(listaDePrendas1);
        guardaropa.guardarPrendas(listaDePrendas2);

        guardaropa.mostrarPrendas();

        System.out.println(guardaropa.devolverPrendas(2));
    }
}
