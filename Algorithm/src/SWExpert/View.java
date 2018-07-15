package SWExpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class View {
 
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
 
    static int T;
 
 
    public static void main(String args[]) throws Exception {
 
        for (int i = 1; i <= 1; ++i) {
 
            int N = Integer.parseInt(br.readLine()), ans = 0;
 
            int[] apt = new int[N];
 
            st = new StringTokenizer(br.readLine());
 
            for (int j = 0; j < N; ++j)
                apt[j] = Integer.parseInt(st.nextToken());
 
            for (int j = 2; j < N - 2; ++j) {
                int tmp = 0;
                // ¿ÞÂÊ ¿À¸¥ÂÊ ÇÑÄ­ ¶³¾îÁü
                if (apt[j - 1] < apt[j] && apt[j + 1] < apt[j]) {
                    tmp = Math.min(apt[j] - apt[j - 1], apt[j] - apt[j + 1]);
 
                    // ¿ÞÂÊ ¿À¸¥ÂÊ µÎÄ­ ¶³¾îÁü
                    if (apt[j - 2] < apt[j] && apt[j + 2] < apt[j]) {
                        tmp = Math.min(tmp, Math.min(apt[j] - apt[j - 2], apt[j] - apt[j + 2]));
                        ans += tmp;
                    }
                }
            }
            bw.write("#" + i + " " + ans + "\n");
        }
        bw.flush();
    }
}