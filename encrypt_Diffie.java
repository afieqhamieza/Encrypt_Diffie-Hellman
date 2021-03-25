import java.util.*;

public class encrypt_Diffie {
    static String Z32 = "abcdefghijklmnopqrstuvwxyz .,?()";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println(toBinaryString("hello, this is a test message."));
        System.out.println(binaryToString("001110010001011010110111011100110101001100111010001001011010010001001011010000001101010011001001001010011110100110000100100101001000000001100010011011"));
    }

    public static String toBinaryString(String text_in){
        String bit = "00000";
        String binaryResult = "";
        List<Integer> index_in = new ArrayList<Integer>();

        Scanner scan = new Scanner(System.in);

        String text = text_in;
        text = text.toLowerCase();

        // --------- finding index of each char ---------
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            index_in.add(Z32.indexOf(c));
        }
        // ------ end of finding index of each char ------

        // ---------- convert to binary ----------
        for (int i = 0; i < index_in.size(); i++) {
            int n = index_in.get(i);

            String binString = Integer.toBinaryString((int) n);
            binaryResult += (bit + binString).substring(binString.length());
        }
        // ------- end of convert to binary -------

        return binaryResult;
    }

    public static String binaryToString(String text_in){
        String[] blocks_binary = text_in.split("(?<=\\G.{5})");
        String ciphertext = "";

        for (String block : blocks_binary) {
            int index = Integer.parseInt(block, 2);
            ciphertext += Z32.charAt(index);
        }

        return ciphertext;
    }
}
