public class BinaryToDecimal {
    public static int convertBinaryToDec(int n) {
        int decimal = 0;
        int i = 1;

        while (n > 0) {
            int remainder = n % 10;
            n /= 10;
            decimal += remainder * i;
            i = i * 2;
        }
        return decimal;
    }

    public static void main(String[] args) {
        int num = 100;
        int decimal = convertBinaryToDec(num);
        System.out.println("Binary to decimal: " + num + " = " + decimal);
    }

}
