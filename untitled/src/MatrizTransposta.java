import java.util.Random;

public class MatrizTransposta {


    static int[][] criarMatriz (int n, int m) {
        int[][] matriz = new int[n][m];
        Random gerador = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = gerador.nextInt(100);
            }
        }
        return matriz;
    }

    static void  retornarMatriz(int [][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println(matriz[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    static int [][] matrizTransposta (int [][] matriz) {
        int [][] matrizTransposta = new int[matriz[0].length][matriz.length];
        for (int i = 0; i < matrizTransposta.length; i++) {
            for (int j = 0; j < matrizTransposta[0].length; j++) {
                matrizTransposta[i][j] = matriz[j][i];
            }
        }
        return matrizTransposta;
    }


    public static void main(String[] args) {
        int [][] matriz = criarMatriz(2, 2);
        retornarMatriz(matriz);
        int[][] transposta = matrizTransposta(matriz);
        retornarMatriz(transposta);
    }

}
