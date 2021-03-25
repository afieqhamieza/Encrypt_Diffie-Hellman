import java.util.*;
// import com.google.common.base.Splitter;

public class encrypt_Diffie {
    static String Z32 = "abcdefghijklmnopqrstuvwxyz .,?()";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long key_secret = 2092;
        String key_secret_binary = longToBinary(key_secret);
        // ---------- prompt for messagee -----------
        System.out.print("Enter the message: ");
        String msg = scan.nextLine();
        // ------- end of prompt for messagee --------

        // ----------- get binary version of message ----------
        String msg_binary = stringToBinary(msg);
        // ------------ debugging -----------


        encryptDiffie(msg_binary, key_secret_binary);
        // System.out.println(msg_binary);
        // System.out.println(toBinaryString("hello, this is a test message."));
        // System.out.println(binaryToString("001110010001011010110111011100110101001100111010001001011010010001001011010000001101010011001001001010011110100110000100100101001000000001100010011011"));
    }

    // function that takes a decimal and return a binary version of it
    public static String longToBinary(long key_in) {
        // --------- binary representation of alpha -----------
        String[] param = new String[] { Long.toString(key_in) };
        String key_b_string = decimal_to_binary.main(param);
        // ------ end of binary representation of alpha --------

        long key_binary = Long.parseLong(key_b_string);

        return key_b_string;
    }

    // function that takes a string and return a binary version of it
    public static String stringToBinary(String text_in) {
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

    // function that takes a binary and return a string version of it
    public static String binaryToString(String text_in) {
        String[] blocks_binary = text_in.split("(?<=\\G.{5})");
        String ciphertext = "";

        for (String block : blocks_binary) {
            int index = Integer.parseInt(block, 2);
            ciphertext += Z32.charAt(index);
        }

        return ciphertext;
    }

    public static String padBinary(String str_in, int length_in){
        String pad_str = "";

        while (str_in.length() % length_in != 0) {
            str_in = "0" + str_in;
        }

        pad_str += str_in;

        // System.out.println(pad_str);
        return str_in;
    }
    // take a string and return the splitted blocks
    public static String[] splitToBlocks(String str_in, int length_in) {
        str_in = padBinary(str_in, length_in);

        String[] result = new String[(int) Math.ceil((double) str_in.length() / (double) length_in)];

        for (int i = 0; i < result.length; i++)
            result[i] = str_in.substring(i * length_in, Math.min(str_in.length(), (i + 1) * length_in));
        return result;
    }

    public static void encryptDiffie(String msg_binary_in, String key_secret_binary_in) {
        int key_secret_binary_length = key_secret_binary_in.length();

        // split into blocks
        String[] blocks = splitToBlocks(msg_binary_in, key_secret_binary_length);

        // debugging
        for (String string : blocks) {
            System.out.println(string);
        }

    }
}
