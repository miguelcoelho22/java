import java.util.Scanner;

public class InverterString {

    private static String inverter(String palavra) {
        String nova = "";
        for(int i = palavra.length() - 1; i >= 0; i--) {
            nova = nova + palavra.charAt(i);
        }

        return nova;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("digite a palavra");
        String palavra = scanner.nextLine();
        System.out.println(inverter(palavra));
    }
}
