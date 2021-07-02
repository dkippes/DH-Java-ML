package practica.repasopractico.ejercicio1savetheropa.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {
    private Map<Integer, List<Prenda>> diccionario;
    private Integer contador;

    public GuardarRopa() {
        this.diccionario = new HashMap<>();
        this.contador = 0;
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.contador++;
        this.diccionario.put(contador, listaDePrenda);
        return this.contador;
    }

    public void mostrarPrendas() {
        System.out.println(this.diccionario);
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return this.diccionario.get(numero);
    }

    @Override
    public String toString() {
        return "GuardarRopa{" +
                "diccionario=" + diccionario +
                '}';
    }
}
