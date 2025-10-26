import java.util.Scanner;
import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] h = new int[n+2];

        for (int i = 1; i <= n; i++)
            h[i] = scanner.nextInt();

        int[] mx = new int[n+2];
        int[] mxr = new int[n+2];

        for (int i = 1; i <= n; i++) {
            mx[i] = Math.max(mx[i-1], h[i]);
            mxr[n - i + 1] = Math.max(mxr[n - i + 2], h[n - i + 1]);
        }

        int[] fl = new int[n+2];
        int[] fr = new int[n+2];

        h[0] = 1000000001;
        h[n+1] = 1000000001;
        Stack<Integer> v = new Stack<>();
        v.push(0);
        for (int i = 1; i <= n; i++) {
            while (h[i] >= h[v.peek()]) {
                v.pop();
            }

            fl[i] = v.peek();
            v.push(i);
        }

        v.clear();
        v.push(n+1);

        for (int i = n; i > 0; i--) {
            while (h[i] >= h[v.peek()]) {
                v.pop();
            }

            fr[i] = v.peek();
            v.push(i);
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            if (mx[i-1] <= h[i] || mxr[i+1] <= h[i])
                continue;

            ans = Math.max(ans, (long) (Math.min(mx[i-1], mxr[i+1]) - h[i]) * (fr[i] - fl[i] - 1));
        }

        System.out.println(ans);
    }
}
