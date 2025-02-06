import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
    int num;
    int like;
    public Student(int num, int like)
    {
        this.num = num;
        this.like = like;
    }
    @Override
    public int compareTo(Student other)
    {
        return this.num - other.num;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Student> waiting = new LinkedList<>();
        PriorityQueue<Student> wanted = new PriorityQueue<>();
        PriorityQueue<Student> unwanted = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
        {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("1"))
            {
                waiting.add(new Student(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
            }
            else if (input[0].equals("2"))
            {
                Student temp = waiting.poll();
                if (Integer.parseInt(input[1]) == temp.like)
                {
                    wanted.add(temp);
                }
                else
                {
                    unwanted.add(temp);
                }
            }
        }
        if (wanted.isEmpty())
        {
            System.out.print("None");
        }
        else
        {
            while (!wanted.isEmpty())
                System.out.print(wanted.poll().num + " ");
        }
        System.out.println();

        if (unwanted.isEmpty())
        {
            System.out.print("None");
        }
        else
        {
            while (!unwanted.isEmpty())
                System.out.print(unwanted.poll().num + " ");
        }
        System.out.println();

        if (waiting.isEmpty())
        {
            System.out.print("None");
        }
        else
        {
            List<Student> list = new ArrayList<>(waiting);
            Collections.sort(list);
            waiting = new LinkedList<>(list);
            while (!waiting.isEmpty())
                System.out.print(waiting.poll().num + " ");
        }
    }
}