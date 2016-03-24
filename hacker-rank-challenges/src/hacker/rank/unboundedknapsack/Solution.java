package hacker.rank.unboundedknapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mglvl on 23/03/16.
 */
public class Solution {

    static long solution(short K, short[] A) {
        int n = A.length;
        long [][] S = new long[K+1][n+1];
        for (int i = 0; i <= K; i++) {
            S[i][0] = 0;
        }
        for (int i = 0; i <= K; i++) {
            for (int j = 1; j <= n; j++) {
                int i2 = i-A[j-1];
                long sumWhenExcludingJ = S[i][j-1];
                if(i2>=0 && S[i2][j] + A[j-1] > sumWhenExcludingJ) {
                    S[i][j] = S[i2][j] + A[j-1];
                } else {
                    S[i][j] = sumWhenExcludingJ;
                }
            }
        }
        return S[K][n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        short T = Short.parseShort(line);
        for (int i = 0; i < T; i++) {
            String [] segs = br.readLine().split("\\s+");
            short n = Short.parseShort(segs[0]);
            short K = Short.parseShort(segs[1]);
            segs = br.readLine().split("\\s+");
            short[] A = new short[n];
            for (int j = 0; j < n; j++) {
                A[j] = Short.parseShort(segs[j]);
            }
            System.out.println(solution(K,A));
        }
        br.close();
    }
}
