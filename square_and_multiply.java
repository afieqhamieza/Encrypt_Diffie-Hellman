import java.util.*;

public class square_and_multiply {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long p = 2399;
        long alpha = 11;
        // long key_private = 200;

        // --------- private key ---------
        System.out.print("Enter your private key: ");
        long key_private = scan.nextLong();
        // ------ end of privatee key ------

        // ---------- generating public key ----------
        long key_private_binary = getBinary(key_private);
        long key_public = squareMult(p, alpha, key_private_binary);
        System.out.println("The generated public key is " + key_public);
        // ---------- generating public key ----------

        // --------- exchanging key ---------
        System.out.print("Enter the exhanged key: ");
        long key_exhanged = scan.nextLong();
        // ------ end of exchanging key ------

        // ---------- generating secret key -----------
        // long key_exchanged_binary = getBinary(key_exhanged);
        long key_secret = squareMult(p, key_exhanged, key_private_binary);
        // ------- end of generating secret key --------

        System.out.println("Shared secret key: " + key_secret);
    }

    public static long getBinary(long key_in){
         //--------- binary representation of alpha -----------
         String[] param = new String[]{Long.toString(key_in)};
         String key_b_string = decimal_to_binary.main(param);
         //------ end of binary representation of alpha --------

         long key_binary = Long.parseLong(key_b_string);

         return key_binary;
    }
  
    static long squareMult(long p_in, long alpha_in, long private_key_in)
    {
        if (private_key_in == 0)
            return 1;
  
        if (private_key_in == 1)
            return (alpha_in % p_in);
  
        long temp = squareMult(p_in, alpha_in, private_key_in / 2);
        temp = (temp * temp) % p_in;
  
        if (private_key_in % 2 == 0)
            return temp;
  
        else
            return ((alpha_in % p_in) * temp) % p_in;
    }
}
