import java.util.*;

class Solution {
    PriorityQueue<File> pq = new PriorityQueue<>();
    
    public static class File implements Comparable<File>{
        public String HEAD;
        public String NUMBER;
        public String TAIL;
        public int idx;
        
        public File(String name, int idx){
            this.idx = idx;
            int cnt = 0;
            boolean type = false;
            String str = "";
            for(int i = 0; i < name.length(); i++){
                System.out.printf("%c\t", name.charAt(i));
                if(cnt < 2){
                    if(!type){
                        if(!Character.isDigit(name.charAt(i))) str += name.charAt(i);
                        else {
                            HEAD = str;
                            str = "";
                            type = !type;
                            i--;
                            cnt++;
                        }
                    }else{
                        if(Character.isDigit(name.charAt(i))) str += name.charAt(i);
                        else {
                            NUMBER = str;
                            str = "";
                            type = !type;
                            i--;
                            cnt++;
                        }
                    }
                }
                else str += name.charAt(i);
                if(type && i == name.length()-1) {
                    NUMBER = str;
                    str = "";
                }
            }
            
            TAIL = str;
            System.out.println("\nHEAD : " + this.HEAD + "\tNUMBER : " + this.NUMBER + "\tTAIL : " + this.TAIL);
        }
        
        public int compareTo(File f){
            String s1 = this.HEAD.toUpperCase();
            String s2 = f.HEAD.toUpperCase();
            if(s1.compareTo(s2) > 0) return 1;
            else if(s1.compareTo(s2) < 0) return -1;
            else {
                int n1 = Integer.parseInt(this.NUMBER);
                int n2 = Integer.parseInt(f.NUMBER);
                if(n1-n2 > 0) return 1;
                else if(n1-n2 < 0) return -1;
                else return this.idx - f.idx;
            }
        }
    }
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        for(int i = 0; i < files.length; i++){
            pq.add(new File(files[i], i));
        }
        
        int idx = 0;
        while(!pq.isEmpty()){
            File f = pq.poll();
            answer[idx++] = f.HEAD + f.NUMBER + f.TAIL;
        }
        
        return answer;
    }
}
