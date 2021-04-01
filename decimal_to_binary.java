import java.util.*;
import java.io.*;

public class decimal_to_binary {
    public static String main(String[] args) {
        
        String num_in = args[0];
        int num=Integer.parseInt(num_in);  

        String binary = toBinary(num); 

        return binary;
    }

    // function to count the number of bits of a decimal
    public static int countBits(int num_in) {
        return (int) (Math.log(num_in) / Math.log(2) + 1);
    }

    // function to convert decimal to binary
    public static String toBinary(int num_in) {
        String binaryResult = "";

        String binString = Integer.toBinaryString((int) num_in);

        return binString;
    }

}
