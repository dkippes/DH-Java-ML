package practica.clase1.tt;

public class StringUtil {

    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String stringAdd="";
        for(int i=0; i<n; i++) {
            stringAdd += c;
        }
        return stringAdd;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        return replicate(c,n-s.length()) + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String stringArray[] = new String[arr.length];

        for(int i=0; i<arr.length; i++) {
            stringArray[i] = Integer.toString(arr[i]);
        }
        return stringArray;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int inrArray[] = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            inrArray[i] = Integer.parseInt(arr[i]);
        }
        return inrArray;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int i = 0;
        int max = arr[i].length();
        for(String s:arr) {
            if(s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c)
    {
        int max = maxLength(arr);
        for(int i=0; i<arr.length;i++) {
            arr[i] = lpad(arr[i], max, c);
        }
    }

}
