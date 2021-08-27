package practica.clase2.tm.ejercicio2;

public class Contador {

    private int contador = 0;

    public Contador(){
        this(0);
    }

    public Contador(Contador c){
        this(c.contador);
    }

    public Contador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return this.contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void incrementar() {
        this.contador++;
    }

    public void decrementar() {
        this.contador--;
    }
}
