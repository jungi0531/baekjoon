import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Cd implements Comparable<Cd>{
    private int x;
    private int y;

    public Cd(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Cd c) {
        if (this.x < c.x) {
            return -1;
        }
        else if (this.x > c.x) {
            return 1;
        }
        else {
            if (this.y < c.y) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }
    @Override
    public String toString() {
        return x + " " + y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        Cd[] cd = new Cd[N];

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            cd[i] = new Cd(x, y);
        }
        Arrays.sort(cd);

        for (int i = 0; i < N; i++) {
            System.out.println(cd[i]);
        }

        scanner.close();
    }
}