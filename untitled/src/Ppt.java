import java.util.Random;
import java.util.Scanner;

public class Ppt {


    static void pedraPapelTesoura (Scanner leitor) {
        int pontosComputador = 0;
        int pontosUsuario = 0;
        int rodadas = 0;
        Random computador = new Random();
        while (rodadas < 5) {
            rodadas += 1;

            //1 papel, 2 tesoura, 3 pedra;
            // 1 2 = -1 vence computador
            // 1 3 = - 2 vence usuario
            // 2 1 = 1 vence usuario
            // 2 3 =  -1vence computador
            // 3 1 = 2 vence computador
            // 3 2 = 1 vence usuario


            int numeroUsuario = leitor.nextInt();
            int numeroComputador = computador.nextInt(3) + 1;

            switch (numeroComputador) {
                case 1:
                    System.out.println("computador escolheu papel");
                    break;
                case 2:
                    System.out.println("computador escolher tesoura");
                    break;
                case 3:
                    System.out.println("computador escolheu pedra");
                    break;
            }

            if (numeroUsuario == numeroComputador) {
                System.out.println("empate");
            } else if (numeroUsuario - numeroComputador == 1 || numeroUsuario - numeroComputador == -2) {
                System.out.println("usuario vence");
                pontosUsuario++;
            } else {
                System.out.println("computador vence");
                pontosComputador++;
            }
        }
        if(pontosUsuario > pontosComputador){
            System.out.println("usuario vence");

        }else {
            System.out.println("computador vence");

        }
    }

    public static void main(String[] args) {
        System.out.println("digite um numero 1- papel, 2- tesoura, 3 - pedra");
        Scanner leitor = new Scanner(System.in);

        pedraPapelTesoura(leitor);
    }

}
