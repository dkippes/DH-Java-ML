package practica.clase1.tt;

import java.util.*;

public class RadixSort {

    public static void radixSort(int [] arr){
        // Convertir el array string
        String sArr[] = StringUtil.toStringArray(arr);

        // Todos los elementos string tienen que tener la misma longitud, agregando un 0 adelante
        StringUtil.lNormalize(sArr,'0');

        HashMap<Integer,ArrayList<String>> ed = new HashMap<>();


        int cantDig = sArr[0].length();
        for(int i=0; i<cantDig; i++) {
            // agrega 10 entradas, de 0 a 9, con arraylists vacios
            inicializarED(ed);

            int digPos = cantDig - 1 - i;
            for(int j=0; j<sArr.length; j++) {
                int d = sArr[j].charAt(digPos)-'0';
                ed.get(d).add(sArr[j]);
            }

            rearmarArray(sArr,ed);
        }

        // Paso el Array a Int nuevamente
        int iArr[] = StringUtil.toIntArray(sArr);
        for(int x=0; x<iArr.length;x++) {
            arr[x] = iArr[x];
        }

    }

    private static void rearmarArray(String[] sArr, HashMap<Integer,ArrayList<String>> ed)
    {
        int k = 0;
        for(int i=0; i<10; i++) {
            ArrayList<String> x = ed.get(i);
            for(int j=0; j<x.size(); j++) {
                sArr[k++] = x.get(j);
            }
        }
    }

    private static void inicializarED(HashMap<Integer,ArrayList<String>> ed)
    {
        ed.clear();
        for(int i=0; i<10; i++) {
            ed.put(i, new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6338, 2511, 8};
        radixSort(arr);

        for(int i:arr){
            System.out.println(i);
        }

    }
}
