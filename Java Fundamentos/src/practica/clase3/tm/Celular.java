package practica.clase3.tm;

public class Celular implements IPrecedable<Celular>{
    private int numero;
    private String titular;

    // Getter and Setter
    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    // Constructors
    public Celular() {
    }

    public Celular(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }


    @Override
    public int precedeA(Celular t) {
        // Si los nombres son iguales
        if(this.titular.compareToIgnoreCase(t.titular) == 0){
            // return this.dni == t.dni? 1: 0;
            return Integer.compare(this.numero, t.numero);
        } else {
            // Este ya devuelve 1, 0, -1
            return this.titular.compareToIgnoreCase(t.titular);
        }
    }

    @Override
    public String toString() {
        return "Celular{" +
                "numero=" + numero +
                ", titular='" + titular + '\'' +
                '}';
    }
}
