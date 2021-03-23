import java.util.*;

public class square_and_multiply {
    public static void main(String[] args) {
        // A = alpha^secret key(g) mod p

        String[] param = new String[]{"2398"};
        byte[] result = decimal_to_binary.main(param);

        // to display the binary number
        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }
    }

    public static void squareMult(int b_in, int p_in){
        int z = 1;

    }

    // public static long squareMult(int b_in, int p_in){
    //     if (exp == 0)
    //         return 1;
  
    //     if (exp == 1)
    //         return base % N;
  
    //     long t = exponentiation(base, exp / 2);
    //     t = (t * t) % N;
  
    //     // if exponent is even value
    //     if (exp % 2 == 0)
    //         return t;
  
    //     // if exponent is odd value
    //     else
    //         return ((base % N) * t) % N;
    // }
}
