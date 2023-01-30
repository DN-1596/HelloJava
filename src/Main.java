import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            int[] cnt = new int[26];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                Arrays.fill(cnt, 0);
                int cur = 0;
                cnt[s.charAt(i) - 'a']++;
                for (int j = i + 1; j < n; j++) {
                    if (++cnt[s.charAt(j) - 'a'] == 1) {
                        cur++;
                    }
                    if (cur == 3) {
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}