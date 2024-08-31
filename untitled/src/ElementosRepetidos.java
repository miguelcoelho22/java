import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ElementosRepetidos {


    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(2);
        System.out.println(elementosRepetidos(a));
    }

    private static ArrayList<Integer> elementosRepetidos(ArrayList<Integer> a) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if(!arrayList.contains(a.get(i))){
                arrayList.add(a.get(i));
            }
        }

        return arrayList;
    }

}