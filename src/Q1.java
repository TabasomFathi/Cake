import java.util.Scanner;

public class Q1 {
    static int n;
    static long[] h;
    static int ans = 0;

    static void bubbleDown(int v) {
        int left = 2*v;
        int right = 2*v + 1;
        if (left <= n && h[left] > h[v] && (right > n || h[right] <= h[left])) {
            ans++;
            long tmp = h[left];
            h[left] = h[v];
            h[v] = tmp;
            bubbleDown(left);
        } else if (right <= n && h[right] > h[v] && (left > n || h[left] <= h[right])) {
            ans++;
            long tmp = h[right];
            h[right] = h[v];
            h[v] = tmp;
            bubbleDown(right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        h = new long[n+1];
        for (int i = 1; i <= n; i++)
            h[i] = scanner.nextLong();

        ans = 0;
        for (int i = n; i > 0; i--) {
            bubbleDown(i);
        }

        System.out.println(ans);
    }
}
