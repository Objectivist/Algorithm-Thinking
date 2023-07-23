import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 방의 개수
		long Hatk = Integer.parseInt(st.nextToken()); // 초기 공격력
		long Hmax = 0; // 최대 생명력
		long Hcur = 0; // 현재 생명력
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(t == 1) {
				Hcur += a * (h % Hatk == 0 ? ((h/Hatk) - 1) : (h/Hatk));
				Hmax = Hmax < Hcur ? Hcur : Hmax;
			}else {
				Hatk += a;
				Hcur = Hcur - h > 0 ? Hcur - h : 0; 
			}
		}
		
		Hmax++;
		System.out.println(Hmax);
	}
}
