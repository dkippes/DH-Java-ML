import java.util.Scanner;

public class EjerciciosCurso {

    public static void main(String[] args) {

        // ejercicio1();
        // ejercicio2();
        // ejercicio3();
        // ejercicio4();
        ejercicio5();
    }

    public static void ejercicio1(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese numero entero: ");
        int n = scanner.nextInt();

        if(n % 2 == 0){
            System.out.println("Es el " + n + " par");
        } else {
            System.out.println("Es el " + n + " impar");
        }
    }

    public static void ejercicio2(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese numero multiplo n: ");
        int n = scanner.nextInt();

        System.out.println("Ingrese numero entero m: ");
        int m = scanner.nextInt();

        for (int i=1; i < n; i++){
            if(i % m == 0){
                System.out.println(i + " es multiplo de " + m);
            }
        }
    }

    public static void ejercicio3(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese numero entero n: ");
        int n = scanner.nextInt();

        if(n == 1 || n == 1 || n == 4){
            System.out.println("El " + n + " no es primo");
            return;
        }

        for (int i = 2; i < n / 2; i++){
            if(n % i == 0) {
                System.out.println("El " + n + " no es primo");
                return;
            }
        }

        System.out.println("El " + n + " es primo");
    }

    public static void ejercicio4(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese numero entero n: ");
        int n = scanner.nextInt();

        for(int index = 2; index <= n ; index++){
            if(esPrimo(index)){
                System.out.println(index);
            }
        }
    }

    public static boolean esPrimo(int num) {
        if(num <= 1){
            return false;
        }

        for(int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void ejercicio5(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese numero entero n: ");
        int n = scanner.nextInt();

        System.out.println("Ingrese numero m: ");
        int m = scanner.nextInt();

        System.out.println("Ingrese numero de digitos: ");
        int d = scanner.nextInt();

        int cantidadContados = 0;
        int numeroActual = 0;

        while(cantidadContados < n){
            if(numero_tieneN_DigitosDe_(numeroActual, m, d)) {
                System.out.println(numeroActual);
                cantidadContados++;
            }
            numeroActual++;
        }
    }

    public static boolean numero_tieneN_DigitosDe_(int numero, int cantDeDigitos, int digito){
        String numCadena= Integer.toString(numero);
        char digitoCadena = (char)(digito + '0');

        // if(cantDeDigitos < numCadena.length() || cantDeDigitos > numCadena.length()) return false;

        int cantidadRepetida = 0;
        for (int i=0; i < numCadena.length(); i++){

            if(numCadena.charAt(i) == digitoCadena){
                cantidadRepetida++;
            }
        }

        if(cantidadRepetida >= cantDeDigitos){
            return true;
        }
        return false;
    }
}
