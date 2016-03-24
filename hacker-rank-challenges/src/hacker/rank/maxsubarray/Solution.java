package hacker.rank.maxsubarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static long [] maxsubarray(int [] input) {
        long current_contig_sum = input[0];
        long best_contig_sum = input[0];
        long best_non_contig_sum = input[0] > 0 ? input[0] : 0l;
        for (int i = 1; i < input.length; i++) {
            current_contig_sum = Math.max( current_contig_sum + input[i], input[i] );

            if(current_contig_sum > best_contig_sum) {
                best_contig_sum = current_contig_sum;
            }

            if(input[i]>0) {
                best_non_contig_sum += input[i];
            }

        }
        long [] resp = {best_contig_sum, best_non_contig_sum};
        return resp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = new Integer(br.readLine().trim());
        for (int i = 0; i < cases; i++) {
            int lenght = new Integer(br.readLine().trim());
            //System.out.println("length = "+lenght);
            String[] parts = br.readLine().trim().split("\\s+");
            assert(lenght == parts.length);
            int[] input = new int[lenght];
            for (int j = 0; j < lenght; j++) {
                input[j] = new Integer(parts[j]);
            }
            long[] result = maxsubarray(input);
            System.out.println(result[0]+" "+result[1]);
        }
        br.close();
    }

}
