public class MediaPonderada {



    public static void main(String[] args) {
        System.out.println(calcularMedia(10, 2, 4));
    }

    private static double calcularMedia(int i, int i1, int i2) {

        return (double) (i * 2 + i1 * 3 + i2 * 5) / 10;
    }
}
