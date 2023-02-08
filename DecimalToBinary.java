public class DecimalToBinary {
    public static String convertDecToBinary(int num) {
        String s = "";
        int i = 0;
        while (num > 0) {
            s += num % 2;
            num /= 2;
        }
        String binaryString = "";
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            binaryString = c + binaryString;
        }
        return binaryString;
    }

    public static void main(String[] args) {
        int num = 184;
        String binary = convertDecToBinary(num);
        System.out.println(binary);
    }
}
