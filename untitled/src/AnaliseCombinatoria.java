public class AnaliseCombinatoria {

    private static int analiseCombinatoria (int n) {
        int x = 1;

        for(int i = n; i > 0; i--) {
            x *= i;
        }
        return x;
    }


    public static void main(String[] args) {
        int nFatorial = analiseCombinatoria(5);
        int pFatorial = analiseCombinatoria(2);
        int npFatorial = analiseCombinatoria(3);
            System.out.println(nFatorial / (pFatorial * npFatorial));
    }
}
