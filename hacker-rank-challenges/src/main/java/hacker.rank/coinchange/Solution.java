package hacker.rank.coinchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static long solution(short N, short[] C) {
        long [][] W = new long [N+1][C.length+1];
        for (int j = 0; j <= C.length; j++) {
           W[0][j] = 1;
        }
        for (int i = 1; i <= N; i++) {
           W[i][0] = 0;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C.length; j++) {
                W[i][j] = W[i][j-1];
                int i2 = i - C[j-1];
                if( i2 >= 0 ) {
                    W[i][j] += W[i2][j];
                }
            }
        }
        return W[N][C.length];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split("\\s+");
        short N = Short.parseShort(line[0]);
        short M = Short.parseShort(line[1]);
        line = br.readLine().split("\\s+");
        short[] C = new short[M];
        for (int i = 0; i < M; i++) {
            C[i] = Short.parseShort(line[i]);
        }
        long sol = solution(N,C);
        System.out.println(sol);
    }
}
