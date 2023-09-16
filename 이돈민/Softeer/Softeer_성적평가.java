import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Softeer_성적평가 {
    public static class Player implements Comparable<Player>{
        int index;
        int score;
        Player(int index, int score){
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(Player o) {
            return o.score - this.score;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        int[] result = new int[n];

        PriorityQueue<Player> pq;

        pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr1[i] = Integer.parseInt(st.nextToken());
            pq.offer(new Player(i, arr1[i]));
        }
        int[] rank = solve(pq, n);
        for(int i=0;i<n;i++){
            System.out.print(rank[i] + " ");
        }
        System.out.println();


        pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
            pq.offer(new Player(i, arr2[i]));
        }
        int[] rank2 = solve(pq, n);
        for(int i=0;i<n;i++){
            System.out.print(rank2[i] + " ");
        }
        System.out.println();

        pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr3[i] = Integer.parseInt(st.nextToken());
            pq.offer(new Player(i, arr3[i]));
        }

        int[] rank3 = solve(pq, n);
        for(int i=0;i<n;i++){
            System.out.print(rank3[i] + " ");
        }
        System.out.println();

        pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            result[i] = arr1[i]+arr2[i]+arr3[i];
            pq.offer(new Player(i, result[i]));
        }

        int[] rank4 = solve(pq, n);
        for(int i=0;i<n;i++){
            System.out.print(rank4[i]+" ");
        }
        System.out.println();





    }

    public static int[] solve(PriorityQueue<Player> pq, int n){

        int prevScore = pq.peek().score;
        int prevIndex = pq.peek().index;
        pq.poll();
        int[] rank = new int[n];
        Arrays.fill(rank, 1);
        int cnt = 1;
        int rankk = 1;
        while(!pq.isEmpty()){
            Player cur = pq.poll();
            int curScore = cur.score;
            int curIndex = cur.index;
            //만약 이전 플레이어의 점수보다 현재 플레이어의 점수가 크다면
            //이전 플레이어의 등수를 증가시켜줘야함
            if(curScore > prevScore){
                rank[prevIndex] += cnt;
                cnt++;
            }
            //만약 점수가 같다면 같은 등수로 복사
            else if(curScore == prevScore){
                rank[curIndex] = rank[prevIndex];
                cnt++;
            }
            else if(curScore < prevScore){
                rank[curIndex] += cnt;
                cnt++;
            }
            prevScore = curScore;
            prevIndex = curIndex;
        }

        return rank;
    }
}

/*
현주는 N명의 인원이 참여하는 프로그래밍 스터디 그룹을 이끌고 있다.


현주는 스터디를 위해 대회를 세 개 개최하였고, 모든 구성원이 각 대회에 참여하였다.

참가자는 각 대회에서 0 이상 1,000 이하의 정수인 점수를 얻는다.

한 대회에서 둘 이상의 참가자가 동점이 나오는 경우도 있을 수 있다.

현주는 각 대회별 등수 및 최종 등수를 매기고 싶다.

등수는 가장 점수가 높은 사람부터 1등, 2등, ···, N등의 순서대로 붙는다.

만일 동점이 있을 경우 가능한 높은 (등수의 수가 작은) 등수를 부여한다. 즉, 점수가 내림차순으로 10,7,6,6,4의 순서일 경우, 6점을 받은 두 사람은 공동 3등이 되고,

그 다음 순서인 4점을 받은 사람은 5등이 된다. 이 규칙을 다르게 표현하면 다음과 같다: 각 사람마다 “나보다 점수가 큰 사람”의 수를 세어 1을 더한 것이 자신의 등수가 된다.

대회별 등수는 각 대회에서 얻은 점수를 기준으로 하며 최종 등수는 세 대회의 점수의 합을 기준으로 한다.

각 참가자의 대회별 등수 및 최종 등수를 출력하는 프로그램을 작성하시오.
 */