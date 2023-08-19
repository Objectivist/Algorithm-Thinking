import java.util.*;

public class Programmers_파일명정렬 {
        static class File implements Comparable<File>{
            String fullname;
            int index;
            String head;
            String number;
            String tail;
            File(String fullname, int index, String head, String number, String tail){
                this.fullname = fullname;
                this.index = index;
                this.head = head;
                this.number = number;
                this.tail = tail;
            }

            @Override
            public int compareTo(File o){
                /* HEAD부분이 같은 경우 NUMBER순으로 정렬 */
                if(this.head.equalsIgnoreCase(o.head)){
                    if(Integer.parseInt(this.number) == Integer.parseInt(o.number)){
                        return this.index - o.index;
                    }
                    return Integer.parseInt(this.number) - Integer.parseInt(o.number);
                }else
                    return this.head.toLowerCase().compareTo(o.head.toLowerCase());
            }
        }
        public static List<String> solution(String[] files) throws Exception{
            List<String> answer = new ArrayList<>();
            PriorityQueue<File> pq = new PriorityQueue<>();
            for(int i=0;i<files.length;i++){
                String str = files[i];
                String head = "";
                String number = "";
                String tail;
                int hIndex = 0;
                int nIndex = 0;
                int tIndex = 0;
                String tmp = "";
                for(int j=0;j<str.length();j++){
                    char c = str.charAt(j);
                    if(Character.isDigit(c)){
                        hIndex = j;
                        break;
                    }
                }
                for(int j=hIndex;j<str.length();j++){
                    char c = str.charAt(j);
                    if(!Character.isDigit(c)){
                        nIndex = j;
                        break;
                    }else{
                        if(j == str.length()-1){
                            nIndex = j+1;
                        }
                    }

                }
                head = str.substring(0, hIndex);
                number = str.substring(hIndex, nIndex);
                if(nIndex < str.length())
                    tail = str.substring(nIndex, str.length());
                else
                    tail = "";
                pq.offer(new File(str, i, head, number, tail));
            }

            while(!pq.isEmpty()){
                File cur = pq.poll();
                answer.add(cur.fullname);
            }
            return answer;
        }

    public static void main(String[] args) throws Exception {
        solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
    }
}
