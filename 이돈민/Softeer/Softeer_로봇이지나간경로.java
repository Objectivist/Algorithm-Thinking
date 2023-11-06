import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Softeer_로봇이지나간경로 {
    static int h, w;
    static char[][] map;
    static boolean[][] visited;
    //북 서 남 동
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<Robot> q;
    static List<Robot> arr;
    static class Robot implements Comparable<Robot>{
        int x;
        int y;
        String command;
        String dir;
        Robot(int x, int y, String command, String dir){
            this.x = x;
            this.y = y;
            this.command = command;
            this.dir = dir;
        }

        @Override
        public int compareTo(Robot o) {
            return this.command.length() - o.command.length();
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        arr = new ArrayList<>();
        List<Robot> startPointList = new ArrayList<>();

        for(int i=0;i<h;i++){
            String str = br.readLine();
            for(int j=0;j<w;j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(map[i][j] == '#'){
                    Robot startPointRobot = getStartPoint(i, j);
                    if(startPointRobot.x == -1 && startPointRobot.y == -1)
                        continue;
                    else
                        startPointList.add(new Robot(startPointRobot.x, startPointRobot.y, "", startPointRobot.dir));
                }
            }
        }

        for(int i=0;i<startPointList.size();i++){
            visited = new boolean[h][w];
            Robot cur = startPointList.get(i);
            int cx = cur.x;
            int cy = cur.y;
            String cd = cur.dir;
            //System.out.println("x : " + (cx+1) + " , y : " + (cy+1) + " , dir : " + cd);
            String command = bfs(cx, cy, cd);

            //System.out.println(command);
            arr.add(new Robot(cx, cy, command, cd));
        }

        Collections.sort(arr);

        System.out.println((arr.get(0).x+1)+ " " + (arr.get(0).y+1));
        System.out.println(arr.get(0).dir);
        System.out.println(arr.get(0).command);

        //print();




    }

    public static void print(){
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static Robot getStartPoint(int x, int y){
        int count = 1;
        String dir = "";
        int check = 0;
        //북 서 남 동
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx < 0 || ny < 0 || nx >= h || ny >= w)
                continue;
            if(map[nx][ny] == '#'){
                count++;
                check = i;
            }
        }
        if(check == 0){
            dir = "^";
        }else if(check == 1){
            dir = "<";
        }else if(check == 2){
            dir = "v";
        }else if(check == 3){
            dir = ">";
        }

        if(count == 2) {
            return new Robot(x, y, "", dir);
        }else
            return new Robot(-1, -1, "", "");
    }

    public static String bfs(int x, int y, String dir){
        String command = "";
        q = new LinkedList<>();
        q.offer(new Robot(x, y, command, dir));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Robot cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int cd = convDir(cur.dir);
            //System.out.println("-------------------------------");
            //System.out.println("현재 위치 x : " + cx + " , y : " + cy + " 보는 방향 : " + cur.dir + "("+convDir(cur.dir)+")");
            String cc = cur.command;
            command = cc;
            //현재 바라보고 있는 방향과 i가 일치하면 A 아니면 L 또는 R
            for(int i=0;i<4;i++){
                int nx = cx+2*dx[i];
                int ny = cy+2*dy[i];
                int nd = cd-i;

                //북 : 0, 서 : 1, 남 : 2, 동 : 3
                if(nx < 0 || ny < 0 || nx >= h || ny >= w)
                    continue;
                if(!visited[nx][ny] && map[nx][ny] == '#'){
                    if(nd == 0){
                        cc += "A";
                    }else if(nd == -1 || nd == 3){
                        cc += "LA";
                    }else if(nd == 2 || nd == -2){
                        cc += "LLA";
                    }else if(nd == -3 || nd == 1){
                        cc += "RA";
                    }
                    visited[nx][ny] = true;
                    //System.out.println("다음 이동할 방향 : " + convDir2(i)+"("+i+")");
                    //System.out.println("추가될 커맨드 : " + cc);
                    q.offer(new Robot(nx, ny, cc, convDir2(i)));
                }
            }
        }

        return command;
    }

    public static int convDir(String dir){
        int d = 0;
        switch(dir){
            case "^":
                d = 0;
                break;
            case "<":
                d = 1;
                break;
            case "v":
                d = 2;
                break;
            case ">":
                d = 3;
                break;
        }
        return d;
    }

    public static String convDir2(int dir){
        String d = "";
        switch(dir){
            case 0:
                d = "^";
                break;
            case 1:
                d = "<";
                break;
            case 2:
                d = "v";
                break;
            case 3:
                d = ">";
                break;
        }

        return d;
    }
}
