import java.util.Scanner;

public class EjerciciosWord {

    public static void main(String[] args) {

        // ejercicio1();
        // ejercicio2();
        ejercicio3();
        // ejercicio4();
    }

    public static void ejercicio1(){
        int numero1 = 3;
        int numero2 = 6;

        System.out.println("suma: " + (numero1 + numero2));
        System.out.println("resta: " + (numero1 - numero2));
        System.out.println("division: " + (numero1 / numero2));
        System.out.println("modulo: " + (numero1 % numero2));
    }

    public static void ejercicio2(){
        String nombre = "Diego";

        System.out.println("Bienvenido " + nombre);
    }

    public static void ejercicio3(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese radio: ");
        double radio = scanner.nextInt();

        System.out.println("El area es: " + (Math.PI * Math.pow(radio, 2)));
    }

    public static void ejercicio4(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese numero: ");
        int n = scanner.nextInt();

        if(n % 2 == 0){
            System.out.println("El numero " + n + " es divisible por 2");
        } else {
            System.out.println("El numero " + n + " NO es divisible por 2");
        }
    }
}
