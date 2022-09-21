/*
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/



/*
import java.io.*;
import java.util.*; 

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[][] MAP = new int[5][5];  
	static int[] path = new int[5];
	
	static long MAX;
	static long mul;
	static int DE;
	
	// 검증함수
	// 내가 지금 level층의 회전값을 "확정"하고 path에 기록 
	// --> 지금 level층까지 이미 위에 회전값이 확정된 층들과 비교하며 같은 값이 있는가? --> false
	static boolean isGood(int level) {
		// 세로방향 확인 -> 열 기준
		for(int i = 0; i < M; i++) {
			// 지금 레벨 위에 확정된 층들을 비교 (체크)
			for(int j = 0; j < level; j++) {
				// (같은 열에서) 만약 지금 (층 + 회전값 적용) == (위층들 + 회전값 적용) false
				// MAP[level][i] = level층의 모든 열의 값
				// MAP[j][i] = level 위에 있는 모든 층들의 열의 값 
				// level 층의 회전값 = path[level] -> j층의 회전값 = path[j]
				if(MAP[level][(i + path[level]) % M] == MAP[j][(i + path[j]) % M])
					return false; 
			}
		}
		return true; 
	}
	
	
	
	static void func(int level) {
		// 기저조건 -> 만약 N-1층의 회전값을 설정하고, N층까지 내려왔다면 
		// N-1번층의 회전값은 isGood()을 거쳐왔으므로, "이 회전값은 유효하다" 라는게 확정
		if(level == N) {
			//열값들의 합의 곱을 계산 
			//최대값을 갱신
			DE=12;
			mul=1;
			for(int i=0;i<M;i++) {
				int sum=0;
				for(int j=0;j<N;j++) {
					sum+=MAP[j][(i + path[j]) % M];
				}
				mul*=sum;
			}
			
			MAX=Long.max(MAX, mul);
			DE=12;
			return; 
		}
		
		// 재귀 구성 --> 모든 층에서 내려가는 branch -> 0~M-1번의 회전값 
		for(int i = 0; i < M; i++) {
			// path에다 해당 층을 회전시킨 회전 수/값 저장
			path[level] = i; // level층을 i번만큼 회전시킬것이다! 
			// 만약 지금 내가 level층을 i번 회전했을때 
			// 이 전 층들과 동일한 값이 있으면 -> 가망성이 없으니 바로 다음 회전 값 적용 
			// 아니라면 이제 다음 층으로 넘어가 다음 층에 대한 회전값을 설정하고 내려갈것. 
			if(isGood(level))
				func(level+1);
			path[level] = 0; 
		}
	}
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		MAX = Long.MIN_VALUE;
		mul=1;
		
		// MAP 정보 타워 정보 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(0); 
		
		System.out.println(MAX);
	}
}
*/