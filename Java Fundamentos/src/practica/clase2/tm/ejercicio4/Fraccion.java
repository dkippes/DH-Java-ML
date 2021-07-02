package practica.clase2.tm.ejercicio4;

public class Fraccion {
    private int denominador;
    private int numerador;

    public Fraccion(int f2, int i) {
    }

    public int getDenominador() {
        return this.denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int getNumerador() {
        return this.numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public static double sumar(double n1, double n2){
        return n1 + n2;
    }

    public static double restar(double n1, double n2){
        return n1 - n2;
    }

    public static double multiplicar(double n1, double n2){
        return n1 * n2;
    }

    public static Fraccion add(Fraccion f1, Fraccion f2){
        int numerador = f1.getNumerador() * f2.getDenominador() + f2.getNumerador() * f1.getDenominador();
        int denominador = f1.getDenominador() * f2.getDenominador();
        return new Fraccion(numerador, denominador);
    }

    public static Fraccion add(int f1, Fraccion f2){
        return add(new Fraccion(f1, 1), f2);
    }

    public static Fraccion add(Fraccion f1, int f2){
        return add(f1, new Fraccion(f2, 1));
    }

    public static Fraccion add(int f1, int f2){
        return add(new Fraccion(f1, 1), new Fraccion(f2, 1));
    }
}
