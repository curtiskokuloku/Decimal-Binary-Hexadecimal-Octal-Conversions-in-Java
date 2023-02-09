/**
 * @brief  Implementations of conversion methods for binary numbers, decimals, octal and hexadecimal
 * @author Curtis Kokuloku
 * @note Used for one of my classes (CSCI 2021 - Machine Architecture)
 */

import java.util.Scanner;

public class ConvertBinary {

    public static final String HEX_DIGITS = "0123456789ABCDEF";

    /**
     * @brief Convert decimal numbers to binary numbers
     * @param  num: representing a decimal number
     * @return a string value as binary number
     */
    public static String convertDecToBinary(int num) {
        String binary = "";
        while (num > 0) {
            binary = (num % 2) + binary;
            num /= 2;
        }
        return binary;
    }

    /**
     * @brief Convert binary numbers to decimal numbers
     * @param  n: representing a binary number
     * @return an integer value as decimal number
     */
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

    /**
     * @brief Convert decimal numbers to octal numbers
     * @param  num: representing a decimal number
     * @return an integer value as octal number
     */
    public static int convertDecToOctal(int num) {
        int octal = 0, i = 1;
        while (num > 0) {
            octal += (num % 8) * i;
            num /= 8;
            i *= 10;
        }
        return octal;
    }

    /**
     * @brief Convert octal numbers to decimal numbers
     * @param  num: representing an octal number
     * @return an integer value as decimal number
     */
    public static int convertOctalToDec(int num) {
        int result = 0;
        int copy = num;
        for (int i = 0; copy > 0; i++) {
            int temp = copy % 10;
            double p = Math.pow(8, i);
            result += (temp * p);
            copy /= 10;
        }
        return result;
    }

    /**
     * @brief Convert decimal numbers to hexadecimal numbers
     * @param  num: representing a decimal number
     * @return a string value as hexadecimal number
     */
    public static String convertDecToHexa(int num) {
        String hex = "";
        while (num > 0) {
            int digit = num % 16;
            hex = HEX_DIGITS.charAt(digit) + hex;
            num /= 16;
        }
        return hex;
    }

    /**
     * @brief Convert hexadecimal numbers to decimal numbers
     * @param  val: representing a hexadecimal number
     * @return an integer value as decimal number
     */
    public static int convertHexaToDec(String val) {
        int len = val.length();
        int base = 1;
        int decimal = 0;
        for (int i = len-1; i >= 0; i--) {
            if (val.charAt(i) >= '0' && val.charAt(i) <= '9') {
                decimal += (val.charAt(i) - 48) * base;
                base *= 16;
            } else if (val.charAt(i) >= 'A' && val.charAt(i) <= 'F') {
                decimal += (val.charAt(i) - 55) * base;
                base *= 16;
            }
        }
        return decimal;
    }

    /**
     * @brief Convert binary numbers to hexadecimal numbers
     * @param  n: representing a binary number
     * @return a string value as hexadecimal number
     */
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

        System.out.print("Enter a decimal number to convert to Octal: ");
        int num2 = s.nextInt();
        System.out.println("Octal of " + num2 + " is " + convertDecToOctal(num2));

        System.out.print("Enter octal number to convert to decimal: ");
        int num3 = s.nextInt();
        System.out.println("Decimal of Octal is " + convertOctalToDec(num3));

        s.nextLine();

        System.out.print("Enter hexadecimal number to convert to decimal: ");
        String num4 = s.nextLine();
        System.out.println("Decimal of Octal is " + convertHexaToDec(num4));
    }
}
