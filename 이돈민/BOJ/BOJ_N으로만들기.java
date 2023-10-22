import java.io.*;
import java.util.*;

public class BOJ_N으로만들기 {
    static int[] arr;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        arr = new int[str.length()];
        set = new HashSet<>();
        for(int i=0; i<str.length(); i++) {
            arr[i] = str.charAt(i)-0;
        }

        for(int i=0;i<arr.length;i++){
            dfs(i, i, arr[i]+"", arr[i]+"");
        }

        System.out.println(set.size());
    }

    public static void dfs(int left, int right, String str, String step){
        if(left == 0 && right == arr.length-1){
            set.add(step);
            return;
        }

        if(left-1 >= 0){
            dfs(left-1, right, arr[left-1]+str, step+" "+arr[left-1]+str);
        }
        if(right+1 < arr.length){
            dfs(left, right+1, str+arr[right+1], step+" "+str+arr[right+1]);
        }
    }

}
