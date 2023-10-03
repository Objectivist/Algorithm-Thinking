import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Softeer_강의실배정 {
    static class Lecture implements Comparable<Lecture>{
        int start;
        int end;
        Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            return this.end - o.end;
        }
    }
    static int n, answer;
    static PriorityQueue<Lecture> pq;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        answer = 1;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Lecture(start, end));
        }

        Lecture prev = pq.poll();
        while(!pq.isEmpty()){
            Lecture next = pq.poll();
            if(prev.end <= next.start){
                answer++;
                prev = next;
            }
        }

        System.out.println(answer);

    }
}