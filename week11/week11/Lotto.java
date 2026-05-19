package week11;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
    public static void main(String[] args) {
        Random random = new Random();
        int n[] = new int[6];
        
        for(int i = 0; i < 6; i++) {
            n[i] = random.nextInt(45) + 1;
        }
        
        // Prints out cleanly as: 이번주 로또 번호는 [14, 22, 5, 41, 33, 9]
        System.out.println("이번주 로또 번호는 " + Arrays.toString(n));
    }
}