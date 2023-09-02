import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_서강그라운드 {
    public static class Loc implements Comparable<Loc>{
        int index;
        int cost;
        Loc(int index, int cost){
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Loc o) {
            return this.cost - o.cost;
        }
    }

    static PriorityQueue<Loc> pq = new PriorityQueue<>();
    static int n, m, r, answer;
    static int[] itemsArr;
    static int[] distance;
    static ArrayList<ArrayList<Loc>> graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        itemsArr = new int[n+1];
        distance = new int[n+1];
        answer = Integer.MIN_VALUE;

        for(int i=1;i<=n;i++){
            itemsArr[i] = Integer.parseInt(st.nextToken());
        }
        graph = new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }


        for(int i=0;i<r;i++){

            st = new StringTokenizer(br.readLine());
            //두 정점의 번호
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Loc(b, l));
            graph.get(b).add(new Loc(a, l));
        }

        for(int i=1;i<=n;i++){
            dijkstra(i);
        }

        System.out.println(answer);


    }
    public static void dijkstra(int start){
        pq = new PriorityQueue<>();
        Arrays.fill(distance, 987654321);
        int sum = 0;
        distance[start] = 0;
        pq.offer(new Loc(start, 0));

        while(!pq.isEmpty()){
            Loc cur = pq.poll();
            if(distance[cur.index] < cur.cost)
                continue;

            ArrayList<Loc> list = graph.get(cur.index);
            for(int i=0;i<list.size();i++){
                Loc next = list.get(i);

                if(distance[next.index] > cur.cost + next.cost){
                    distance[next.index] = Math.min(cur.cost + next.cost, distance[next.index]);
                    pq.offer(new Loc(next.index, distance[next.index]));
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(distance[i] <= m)
                sum += itemsArr[i];
        }
        answer = Math.max(answer, sum);
    }
}
