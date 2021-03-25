public class test {
    static long N = 2399L; // prime modulo value
    public static void main(String[] args)
    {
        long p = 2399;
        long base = 1831;
        // long exp = 00000000000000000000000000111111;
        //--------- binary representation of alpha -----------
        String[] param = new String[]{Long.toString(200)};
        String b_string = decimal_to_binary.main(param);
        //------ end of binary representation of alpha --------

        long exp = Long.parseLong(b_string);
  
        long modulo = exponentiation(base, exp);
        System.out.println(modulo);
    }
  
    static long exponentiation(long base, long exp)
    {
        if (exp == 0)
            return 1;
  
        if (exp == 1)
            return base % N;
  
        long t = exponentiation(base, exp / 2);
        t = (t * t) % N;
  
        // if exponent is even value
        if (exp % 2 == 0)
            return t;
  
        // if exponent is odd value
        else
            return ((base % N) * t) % N;
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
