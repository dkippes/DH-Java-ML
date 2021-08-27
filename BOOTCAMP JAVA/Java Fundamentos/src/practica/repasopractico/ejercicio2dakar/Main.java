package practica.repasopractico.ejercicio2dakar;

import practica.repasopractico.ejercicio2dakar.domain.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static void main(String[] args) {
        Vehiculo auto1 = new Auto(100, 10, 35, "auto1");
        Vehiculo auto2 = new Auto(115, 8, 25, "auto2");
        Vehiculo moto1 = new Moto(125, 5, 15, "moto1");
        Vehiculo moto2 = new Moto(135, 17, 25, "moto2");

        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(auto1);
        listaVehiculos.add(moto2);
        listaVehiculos.add(moto1);
        listaVehiculos.add(auto2);

        Carrera carrera = new Carrera(1500, 500, "Pista BSAS", 5, listaVehiculos);

        // carrera.darDeAltaAuto(200, 20, 50, "auto master");
        // carrera.darDeAltaAuto(200, 20, 50, "moto master");

        // carrera.eliminarVehiculo(auto1);
        // carrera.eliminarVehiculoConPatente("auto1");

        // carrera.mostrarGanador();

        carrera.socorrerMoto("moto1");


    }
}
