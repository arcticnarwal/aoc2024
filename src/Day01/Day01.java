package Day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 {
    public static int getSolution() {
        String filePath = "src/Day01/input.txt";
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int sum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] leftAndRight = line.split("   ");
                left.add(Integer.parseInt(leftAndRight[0]));
                right.add(Integer.parseInt(leftAndRight[1]));
            }   
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        Collections.sort(left);
        Collections.sort(right);

        if (left.size() != right.size()) {
            System.err.println("Mismatching number of left and right values.");
        } else {
            for (int i = 0; i < left.size(); i++) {
                sum += Math.abs(left.get(i) - right.get(i));
            }
        }

        return sum;
    }
}
