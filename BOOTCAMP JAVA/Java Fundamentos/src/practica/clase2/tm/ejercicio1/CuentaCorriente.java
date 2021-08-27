package practica.clase2.tm.ejercicio1;

public class CuentaCorriente {

    private double saldo = 0;
    private String numero = "";

    public CuentaCorriente(){}

    public CuentaCorriente(double saldo, String numero) {
        this.saldo = saldo;
        this.numero = numero;
    }

    public CuentaCorriente(CuentaCorriente cc)
    {
        this(cc.saldo, cc.numero);
    }

    public String getNumero() {
        return this.numero;
    }

    public void setBanco(String numerp) {
        this.numero = numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingreso(double ingresarSaldo) {
        this.saldo += ingresarSaldo;
    }

    public void egreso(double egresoSaldo) {
        this.saldo -= egresoSaldo;
    }

    public void reintegro(double reintegro) {
        this.saldo += reintegro;
    }

    public void transferencia(double transferencia, CuentaCorriente ccDest) {
        this.saldo -= transferencia;
        ccDest.saldo += transferencia;
    }
}
