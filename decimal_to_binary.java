import java.util.*;
import java.io.*;

public class decimal_to_binary {
    public static void main(String[] args) {
        System.out.println(countBits(2398));
    }

    // function to count the number of bits of a decimal
    static int countBits(int num_in)
    { 
        return (int)(Math.log(num_in) / Math.log(2) + 1);
    }
}
