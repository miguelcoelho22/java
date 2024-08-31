import java.util.Scanner;

public class IMC {

    public static double imc () {
        Scanner scanner = new Scanner(System.in);


        System.out.println("digite o peso em kg");
        double peso = scanner.nextDouble();
        System.out.println("digite a altura em metros");
        double altura = scanner.nextDouble();


        return  peso / (altura * altura);

    }


    public static void main(String[] args) {
        System.out.println(imc());
    }
}
