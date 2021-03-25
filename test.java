import java.util.*;


public class test {
    public static void main(String[] args)
    {
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






    // public static void main(String[] args) {
    //     // long r = squareMult(8, 5);

    //     System.out.println("\n" + r);
    // }

    // // function to generate key alpha^a mod p
    // public static void generateKey(long alpha_in, long p_in, long private_a){

    // }

    // public static void squareMult(long alpha_in, long p_in){
    //     long private_a = 4;

    // }









    //     // --------- get binary representation of p_in -----------
    //     String[] param = new String[]{Long.toString(p_in)};
    //     String exp_string = decimal_to_binary.main(param);
    //     // ------ end of get binary representation of p_in --------
    //     System.out.println(exp_string);
    //     long value = alpha_in;

    //     for (int i = 3; i < exp_string.length(); i++) {
    //         value = (value * value) % p_in;
    //         if (exp_string.charAt(i) == '1') {
    //             // System.out.println("here");
    //             value = (value * alpha_in) % p_in;
    //         }
    //         System.out.println(value);
    //     }
    
    //     return value;
    // }

    // def exp_func(x, y):
    // exp = bin(y)
    // print ("Binary value of b is:",exp)
    // print ("Bit\tResult")
    // value = x
 
    // for i in range(3, len(exp)):
    //   value = value * value
    //   print (i-1,":\t",value,"(square)")
    //   if(exp[i:i+1]=='1'):
    //     value = value*x
    //   print (i-1,":\t",value,"(multiply)")
    // return value
}
