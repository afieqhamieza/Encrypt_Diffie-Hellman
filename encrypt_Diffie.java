import java.util.*;
// import com.google.common.base.Splitter;

public class encrypt_Diffie {
    static String Z32 = "abcdefghijklmnopqrstuvwxyz .,?()";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long key_secret = square_and_multiply.main(args);

        // ---------- prompt for a message to decrypt -----------
        System.out.print("Enter a message to decrypt: ");
        String msg_decrypt = scan.nextLine();
        // ------- end of prompt for a message to decrypt --------

        System.out.println("The decrypted message is: " + decryptDiffie(msg_decrypt, key_secret));

        // ---------- prompt for a message to encrypt -----------
        System.out.print("Enter a message to encrypt: ");
        String msg_encrypt = scan.nextLine();
        // ------- end of prompt for a message to encrypt --------

        System.out.println("The encrypted message is: " + encryptDiffie(msg_encrypt, key_secret));

        
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

    // functions to pad the binary string
    public static String padBinary(String str_in, int length_in) {
        while (str_in.length() % length_in != 0) {
            str_in = "0" + str_in;
        }

        return str_in;
    }

    // take a string and return the splitted blocks
    public static String[] splitToBlocks(String str_in, int length_in) {
        // str_in = padBinary(str_in, length_in);

        String[] result = new String[(int) Math.ceil((double) str_in.length() / (double) length_in)];

        for (int i = 0; i < result.length; i++)
            result[i] = str_in.substring(i * length_in, Math.min(str_in.length(), (i + 1) * length_in));
        return result;
    }

    // take an int[] and return byte representation of it
    public static byte[] intarrToBytearr(int[] array_in, int size_in) {
        byte[] byte_array = new byte[size_in];

        for (int i = 0; i < size_in; i++) {
            byte_array[i] = (byte) array_in[i];
        }

        return byte_array;
    }

    // take byte and return string representation of it
    public static String bytearrToStrarr(byte[] array_in, int size_in) {
        String str_array = "";

        for (int j = 0; j < array_in.length; j++) {
            str_array = str_array + array_in[j];
        }

        return str_array;
    }

    // xor two binary strings
    public static String xor(String x_in, String key_secret_in, int size_in) {
        int[] b_in = strToIntArr(x_in);
        int[] k_in = strToIntArr(key_secret_in);

        byte[] b_byte_array = intarrToBytearr(b_in, size_in);
        byte[] k_byte_array = intarrToBytearr(k_in, size_in);

        byte[] xor_byte_array = new byte[size_in];

        int i = 0;
        for (byte x : b_byte_array) {
            xor_byte_array[i] = (byte) (x ^ k_byte_array[i]);
            i++;
        }

        String xor_str_array = bytearrToStrarr(xor_byte_array, size_in);

        return xor_str_array;
    }

    // take string and return int representation of it
    public static int[] strToIntArr(String str_in) {
        int[] conversion = new int[str_in.length()];

        for (int i = 0; i < str_in.length(); i++) {
            int c = Character.getNumericValue(str_in.charAt(i));
            conversion[i] = c;
        }

        return conversion;
    }

    // perrform the diffie hellman algo
    public static String encryptDiffie(String msg_in, long key_secret_in) {
        String encrypted = "";
        String msg_binary = stringToBinary(msg_in);
        
        String key_secret_binary = longToBinary(key_secret_in);
        int key_secret_binary_length = key_secret_binary.length();
        String encrypted_binary = "";

        // split msg_binary_in into blocks
        String[] blocks = splitToBlocks(msg_binary, key_secret_binary_length);

        // --------- xor operation by blocks ----------
        String[] xored_block = new String[blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            xored_block[i] = xor(blocks[i], key_secret_binary, blocks[i].length());
            encrypted += xored_block[i];
        }
        // ------ end of xor operation by blocks -------

        // get the english version of the encrypted text
        encrypted_binary = binaryToString(encrypted);

        return encrypted_binary;

    }

    public static String decryptDiffie(String msg_in, long key_secret_in) {
        String decrypted = "";
        String msg_binary = stringToBinary(msg_in);
        
        String key_secret_binary = longToBinary(key_secret_in);
        int key_secret_binary_length = key_secret_binary.length();
        String decrypted_binary = "";

        // split msg_binary_in into blocks
        String[] blocks = splitToBlocks(msg_binary, key_secret_binary_length);

        // --------- xor operation by blocks ----------
        String[] xored_block = new String[blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            xored_block[i] = xor(blocks[i], key_secret_binary, blocks[i].length());
            decrypted_binary += xored_block[i];
        }
        // ------ end of xor operation by blocks -------

        // get the english version of the encrypted text
        decrypted = binaryToString(decrypted_binary);

        return decrypted;
    }
}
