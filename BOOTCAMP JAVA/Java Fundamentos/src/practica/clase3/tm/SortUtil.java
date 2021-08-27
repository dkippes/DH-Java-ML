package practica.clase3.tm;

public class SortUtil {

    // Hay que aclarar que usa un tipo generico
    public static <T> void ordenar(IPrecedable arr[]){
        for ( int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex-- ){
            for ( int i = 0; i < lastUnsortedIndex; i++ ) {
                // Se compara con precedeA
                if ( arr[i].precedeA( arr[i + 1] ) > 0 ) { // Asc
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static <T> void swap(IPrecedable<T>[] array, int i, int j){
        if( i == j ) return;

        // Se pone el tipo de la interfase
        IPrecedable<T> temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
