public class BinarioEmDecimal {


    private static int  transformarDecimal (String binario) {
        int potencia = 0;
        int decimal = 0;
        for (int i =binario.length() - 1; i >= 0; i--) {
            decimal += (int) (Math.pow(2, potencia) * Character.getNumericValue(binario.charAt(i)));
            potencia++;
        }

        return decimal;
    }

    public static void main(String[] args) {
        System.out.println(transformarDecimal("11001"));
    }
}
