package practica.repasopractico.ejercicio2dakar.domain;

import java.util.List;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        if(this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        if(this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        for(Integer i = 0; i < this.listaDeVehiculos.size(); i++) {
            if(unaPatente == this.listaDeVehiculos.get(i).getPatente()) {
                this.listaDeVehiculos.remove(this.listaDeVehiculos.get(i));
                break;
            }
        }
    }

    public void mostrarGanador() {
        if(listaDeVehiculos.size() > 0 ) {
            double maxPower = 0;
            Vehiculo ganador = null;

            for(Integer i = 0; i < listaDeVehiculos.size(); i++) {
                if(maxPower < formulaGanadora(listaDeVehiculos.get(i))) {
                    maxPower = formulaGanadora(listaDeVehiculos.get(i));
                    ganador = listaDeVehiculos.get(i);
                }
            }
            System.out.println(maxPower);
            System.out.println(ganador);
        } else {
            System.out.println("No hay nadie en la carrera");
        }
    }

    public static double formulaGanadora(Vehiculo vehiculo) {
        return vehiculo.getVelocidad() * (0.5 * vehiculo.getAceleracion() / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100)));
    }

    public void socorrerAuto(String patente) {
        SocorristaAuto socorristaAuto = new SocorristaAuto();

        Vehiculo v = getVehiculoByPatente(patente);
        if (v instanceof Moto) {
            socorristaAuto.socorrer( (Auto) v);
        }
    }

    public void socorrerMoto(String patente) {
        SocorristaMoto socorristaMoto = new SocorristaMoto();

        /*for(Integer i = 0; i < this.listaDeVehiculos.size(); i++) {
            if(patente == this.listaDeVehiculos.get(i).getPatente()) {
                if (listaDeVehiculos.get(i) instanceof Moto) {
                    socorristaMoto.socorrer( (Moto) this.listaDeVehiculos.get(i));
                    break;
                }
            }
        }*/

        Vehiculo v = getVehiculoByPatente(patente);
        if (v instanceof Moto) {
            socorristaMoto.socorrer( (Moto) v);
        }
    }

    private Vehiculo getVehiculoByPatente(String patente) {
        return listaDeVehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", listaDeVehiculos=" + listaDeVehiculos +
                '}';
    }
}
