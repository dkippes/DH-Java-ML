package practica.clase3.tm;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IPrecedable persona3 = new Persona("Diego", 3828544);
        IPrecedable persona2 = new Persona("Diego", 6856645);
        IPrecedable persona1 = new Persona("Pablo", 4654645);

        IPrecedable[] arrPersonas = { persona1, persona2, persona3 };

        SortUtil.ordenar(arrPersonas);

        // Imprimir normal
        /*for (IPrecedable p: arrPersonas){
            System.out.println(p);
        }*/

        // Imprimir array
        System.out.println(Arrays.toString(arrPersonas));

        IPrecedable celular3 = new Celular(123543534, "Diego");
        IPrecedable celular2 = new Celular(867867345, "Andres");
        IPrecedable celular1 = new Celular(543543533, "Lara");

        IPrecedable[] arrCelulares = { celular1, celular2, celular3 };

        SortUtil.ordenar(arrCelulares);

        // Imprimir con stream
        Arrays.stream(arrCelulares).forEach(System.out::println);
    }
}
