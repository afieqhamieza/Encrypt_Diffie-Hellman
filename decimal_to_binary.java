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
        String bit = "00000000000000000000000000000000";

        String binString = Integer.toBinaryString((int) num_in);
        binaryResult += (bit + binString).substring(binString.length());

        return binaryResult;
    }


    // public static byte[] toBinary(int num_in) {
    //     byte[] binary = new byte[32];
    //     int i = 0;

    //     while (num_in > 0) {
    //         binary[i++] = (byte) (num_in % 2);
    //         num_in = num_in / 2;
    //     }

    //     return binary;
    // }

}
