import java.util.*;
import java.io.*;

public class decimal_to_binary {
    public static void main(String[] args) {





        
        // --------- debugging ----------
        System.out.println(countBits(2398));
        System.out.println(toBinary(2398));

        byte[] binary = toBinary(2398);

        // to display the binary number
        for (int i = binary.length - 1; i >= 0; i--) {
            System.out.print(binary[i]);
        }
        // --------- end of debugging ----------

    }

    // function to count the number of bits of a decimal
    public static int countBits(int num_in) {
        return (int) (Math.log(num_in) / Math.log(2) + 1);
    }

    // function to convert decimal to binary
    public static byte[] toBinary(int num_in) {
        byte[] binary = new byte[32];
        int i = 0;

        while (num_in > 0) {
            binary[i++] = (byte) (num_in % 2);
            num_in = num_in / 2;
        }

        return binary;
    }

}
