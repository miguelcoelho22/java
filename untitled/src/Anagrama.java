import java.util.ArrayList;
import java.util.Objects;

public class Anagrama {

    static String anagramas (String palavra1, String palavra2) {
        if (palavra1.length() != palavra2.length()){
            System.out.println("nao é anagrama");
        }
        String[] palavraDois = palavra2.split("");
        String[] palavraUm = palavra1.split("");

        for (int i = 0; i < palavraUm.length; i++) {
            for (int j = 0; j < palavraUm.length; j++) {
                if(palavraUm[i] == palavraDois[j]){
                    
                }
            }
        }

    }


    public static void main(String[] args) {

    }
}
