import java.util.*;
import java.io.*;

public class Main
{
    public static class Point implements Comparable<Point> {
        public int s, e;
        public Point(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int compareTo(Point p){
            if(this.e == p.e) return this.s - p.s;
            else return this.e - p.e;
        }
    }

    public static int N;
    public static PriorityQueue<Point> pq = new PriorityQueue<Point>();

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Point(s, e));
        }

        int res = 0;
        int t = 0;

        while(!pq.isEmpty()){
            Point p = pq.poll();
            if(t <= p.s) {
                t = p.e;
                res++;
            }
        }

        System.out.println(res);
    }
}
