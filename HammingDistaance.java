import java.util.Scanner;

public class HammingDistaance {
    
    public static String HammingDistance(String s, int A, int B){

        // Check if the string only contains 'o' and '1'
        if(!s.matches("[01]+")) {
            return "INVALID";
        }

        int count0 = 0;
        int count1 = 0;

        // count the no. of '0' and '1'
        for (char c : s.toCharArray()) {
            if (c == '0') {
                count0++;
            } else {
                count1++;
            }
        }

        // Rearrange the string with all '0' followed by '1'
        String rearranged01 = "0".repeat(count0) + "1".repeat(count1);

        // Calculate the hamming distance
        int HammingDist =0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != rearranged01.charAt(i)) {
                HammingDist++;
            }
        }

        return String.valueOf(HammingDist);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the no. of test cases
        int T = Integer.parseInt(sc.nextLine().trim());

        // Loop through each test case 
        for  (int t = 0; t < T; t++) {
            // Read binary string
            String s = sc.nextLine().trim();

            // Read values of A and B
            String[] inputs = sc.nextLine().trim().split(" ");
            int A = Integer.parseInt(inputs[0]);
            int B = Integer.parseInt(inputs[1]);

            // Get the result for this test case
            String result = HammingDistance(s, A, B);

            // Print result without extra newlines
            System.out.print(result); // Using print insted of println to avoid extra newlines

            if (t < T - 1) {
                System.out.print("\n"); // Only print newline if it's not the last test case
            }
        }

        sc.close();
    }
}