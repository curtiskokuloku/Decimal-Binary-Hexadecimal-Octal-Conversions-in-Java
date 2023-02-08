import java.util.Scanner;

public class ConvertBinary {

    public static final String HEX_DIGITS = "0123456789ABCDEF";

    public static String convertDecToBinary(int num) {
        String binary = "";
        while (num > 0) {
            binary = (num % 2) + binary;
            num /= 2;
        }
        return binary;
    }

    public static int convertBinaryToDec(String n) {
        int decimal = 0;
        int power = 0;

        for (int i = n.length() - 1; i >= 0; i--) {
            int digit = n.charAt(i) - '0';
            decimal += digit * (int)Math.pow(2, power);
            power++;
        }
        return decimal;
    }

    public static String convertDecToHexa(int num) {
        String hex = "";
        while (num > 0) {
            int digit = num % 16;
            hex = HEX_DIGITS.charAt(digit) + hex;
            num /= 16;
        }
        return hex;
    }

    public static String convertBinaryToHexadecimal(String n) {
        int decimal = convertBinaryToDec(n);
        System.out.println("Binary to Decimal: " + decimal);
        return convertDecToHexa(decimal);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter a binary number to convert to hexadecimal: ");
        String binary = s.nextLine();
        System.out.println("Hexadecimal: " + convertBinaryToHexadecimal(binary));

        System.out.print("Enter a decimal number to convert to binary: ");
        int num = s.nextInt();
        System.out.println("Binary of " + num + " is " + convertDecToBinary(num));

    }
}
