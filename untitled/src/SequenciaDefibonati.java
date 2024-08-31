import java.util.Arrays;

public class SequenciaDefibonati {


    private static void sequencia () {
        int a = 0;
        int b = 1;
        int aux = 0;
        for (int i = 1; i < 30; i++) {
            System.out.println(a);
            aux = a;
            a += b;
            b = aux;
        }
    }

    public static void main(String[] args) {
        sequencia();
    }
}
