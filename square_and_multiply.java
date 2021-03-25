import java.util.*;

public class square_and_multiply {
    public static void main(String[] args) {
        // A = alpha^secret key(g) mod p
        long r = squareMult(2399, 11);

        System.out.println("\n" + r);
    }

    public static int[] bytearrToIntarr(byte[] array_in, int size_in) {
        int[] int_array = new int[size_in];

        for (int i = 0; i < size_in; i++) {
            int_array[i] = (int) array_in[i];
        }

        return int_array;
    }

    public static long squareMult(int p_in, int alpha_in){
        int z = alpha_in;
        long exp_in = 63;
        // --------- get binary representation of p_in -----------
        String[] param = new String[]{Long.toString(exp_in)};
        String b_string = decimal_to_binary.main(param);
        // ------ end of get binary representation of p_in --------

        
        int b_length = b_string.length();

        for (int i = b_length-1; i >= 0; i--) {
            z = (z*z) % p_in;

            if (b_string.charAt(i) == '1') {
                z = (z*alpha_in) % p_in;
            }
        }
    
        return z;
    }
}
