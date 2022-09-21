/*
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/
// 해밀턴 회로
/*
import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int MIN;
	static int N;
	static int[][] ADJ;
	
	static void dfs(int node, boolean visited[], int cnt, int sum) {
		
		if(node==0&&cnt==N) {
			MIN=Integer.min(sum,MIN);
			//System.out.println(MIN);
			return;
		}
		
		
		for(int i=0;i<N;i++) {
			if(ADJ[node][i]==0) continue;
			if(visited[i]) continue;
			if(sum+ADJ[node][i]>MIN) continue;
			//가지치기 - 만약 다음하는 노드가 가망성이 없다면 continue
			//			만약 지금 노드에서 다음노드 가는데 MIN보다 초고환다면 가지치기
			
			visited[i]=true;
			dfs(i,visited,cnt+1,sum+ADJ[node][i]);
			visited[i]=false;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MIN=Integer.MAX_VALUE;

		N=Integer.parseInt(br.readLine());
		ADJ=new int[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				ADJ[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, new boolean[N],0,0);
		System.out.println(MIN);
	}

}
*/

// 럭셔리 여행
/*
import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, start, end;
	static int arr[][];
	static int DE;
	static int MAX;
	static int MIN;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		MAX=Integer.MIN_VALUE;
		MIN=Integer.MAX_VALUE;
		st=new StringTokenizer(br.readLine());
		start=Integer.parseInt(st.nextToken());
		end=Integer.parseInt(st.nextToken());
		

		dfs(start, new boolean [N], 0);
		
		System.out.println(MIN);
		System.out.println(MAX);

	}
	
	static void dfs(int current, boolean visited[], int sum) {

		if(current==start) {
			visited[current]=true;
		}

		if(current == end) {
			MIN=Integer.min(sum,MIN);
			MAX=Integer.max(sum,MAX);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(arr[current][i]==0) continue;
			if(visited[i]) continue;
			
			visited[i]=true;
			dfs(i,visited,sum+arr[current][i]);
			visited[i]=false;
			
		}
	}

}
*/
// 그래픽 순회

/*
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int Node, Edge;
	static int start;
	static ArrayList<Integer> al[];
	static boolean visited[];
	static int DE;
	static int MAX;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st=new StringTokenizer(br.readLine());
		Node = Integer.parseInt(st.nextToken())+1;
		Edge = Integer.parseInt(st.nextToken());
		start=Integer.parseInt(br.readLine());

		MAX=Integer.MIN_VALUE;
		al=new ArrayList[Node];
		visited=new boolean[Node];
		for(int i=0;i<Node;i++) {
			al[i]=new ArrayList<>();
		}
			
		
		for(int i=0;i<Edge;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			al[from].add(to);
		}
		
		for(int i=0;i<Node;i++) {
			Collections.sort(al[i]);
		}
		
		visited[start]=true;
		System.out.print(start+" ");
		dfs(start);
		
		Arrays.fill(visited,false);

		System.out.println();
		visited[start]=true;
		dfs2(start);
		System.out.print(start+" ");
		
	}
	
	static void dfs2(int current) {
		if(al[current].isEmpty()) {
			return;
		}
			
		
		for(int index=al[current].size()-1;index>=0;index--) {
			int next=al[current].get(index);
			//if(al[next].isEmpty()) continue;
			if(visited[next]) continue;
			
			visited[next]=true;
			DE=12;
			
			dfs(next);
			DE=12;
			System.out.print(next+" ");
			//visited[next]=false;
		}
		
	}

	static void dfs(int current) {
		if(al[current].isEmpty())
			return;
		
		for(int index=al[current].size()-1;index>=0;index--) {
			int next=al[current].get(index);
			//if(al[next].isEmpty()) continue;
			if(visited[next]) continue;
			
			visited[next]=true;
			System.out.print(next+" ");
			dfs(next);
			//visited[next]=false;
		}
		
	}
}


*/


/*
// quiz

4 5
0 1
0 2
1 2
1 3
2 3

import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Integer>[] al;
	static int Node, Edge;
	static int DE;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st=new StringTokenizer(br.readLine());
		Node = Integer.parseInt(st.nextToken());
		Edge = Integer.parseInt(st.nextToken());
		al=new ArrayList[Node];
		
		for(int i=0;i<Node;i++) {
			al[i]=new ArrayList<>();
		}
		
		for(int i=0;i<Edge;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			al[from].add(to);
			al[to].add(from);
		}
		
		DE=12;
		dfs(0, new boolean [Node]);
		System.out.println();
	}
	
	static void dfs(int current, boolean visited[]) {
		if(current==0) {
			visited[current]=true;
			System.out.print(0+" ");
		}
			
		DE=12;
		
		for(int index=0;index<al[current].size();index++) {
			int next=al[current].get(index);
			if(visited[next]) continue;
			if(al[next].size()==0) continue;
			
			visited[next]=true;
			System.out.print(next+ " ");
			dfs(next, visited);
			//visited[next]=false;
			
		}
		
		

	}

}

*/


//스파이
/*
import java.util.*;
import java.io.*;
public class Main {
	
	static int N;
	static int DE;
	static int member_order;
	static boolean find;
						 // 0     1    2   3    4     5   6    7    8    9    10 
	static int members[]= {1004,1680,9941,3367,3261,2976,4889,1234,6461,7329,5518};
	static ArrayList<Integer> org[];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		org=new ArrayList[11];
		for(int i=0;i<11;i++) {
			org[i]=new ArrayList<>();			
		}
		
		org[0].add(1);
		org[0].add(2);
		org[1].add(3);
		org[1].add(4);
		org[2].add(5);
		org[2].add(6);
		org[4].add(7);
		org[4].add(8);
		org[5].add(9);
		org[5].add(10);
		
		
		N=Integer.parseInt(br.readLine());
		boolean is_no_person=false;
		
		for(int i=0;i<members.length;i++) {
			if(members[i]==N) {
				is_no_person=false;
				break;
			}else {
				is_no_person=true;
			}
			
		}
		
		if(!is_no_person) {
			if(N==members[0]) {
				System.out.println("no boss");
				System.out.println("no company");
				for(int i=0;i<org[0].size();i++) {
					System.out.print(members[org[0].get(i)] +" ");
				}
			}else {
				for(int i=0;i<members.length;i++) {
					if(members[i]==N) {
						member_order=i;
					}
				}
					
				func(0);
			}
		}else {
			System.out.println("no person");
		}

	}
	
	static void func(int level) {
		if(find) return;
		if(level==members.length) return;
		
		for(int i=0;i<2;i++) {
			if(!org[level].isEmpty()) {
				if(org[level].get(i)==member_order) {
					find=true;
					//내 보스 출력
					System.out.println(members[level]);
					if(org[level].size()>1) {
						// 내 동료 출력
						if(i==0) {
							System.out.println(members[org[level].get(1)]);
//							break;
						}else {
							System.out.println(members[org[level].get(0)]);
//							break;
						}
					}else {
						System.out.println("no company");
					}
					
					//내 자식이 있을 경우 자식 출력
					if(org[member_order].size()==0) {
						System.out.println("no junior");
					}else {
						for(int j=0;j<org[member_order].size();j++) {
							System.out.print(members[org[member_order].get(j)]+ " ");
						}
					}
				}
			}
			func(level+1);
		}

	}

}
*/
// 사랑의 스튜디오
/*
import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int ADJ[][];
	static int cnt[];
	static int MAX;
	static int MIN;
	static int DE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		ADJ=new int[N][N];
		cnt=new int[N];
		MAX=Integer.MIN_VALUE;
		MIN=Integer.MAX_VALUE;
		int ret_max=0;
		int ret_min=0;
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				ADJ[i][j]=Integer.parseInt(st.nextToken());
				if(ADJ[i][j]==1) {
					cnt[j]++;
				}
			}
		}
		DE=12;
		for(int i=0;i<N;i++) {
			MAX=Integer.max(MAX, cnt[i]);
			MIN=Integer.min(MIN, cnt[i]);
			if(MAX==cnt[i]) ret_max=i;
			if(MIN==cnt[i]) ret_min=i;
		}
		System.out.println(ret_max+" "+ret_min);
	}

}
*/
//Day3_추가2
/*
import java.util.*;
import java.io.*;
public class Main {

	static int N, T;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> al[];
	static int ADJ[][];
	static int DE;
	
	static void f_al_input() throws IOException {
		al=new ArrayList[N+1];
		
		for(int i=0;i<N;i++)
			al[i]=new ArrayList<>();
		
		
		for(int i=0;i<T;i++) {
			st=new StringTokenizer(br.readLine());
			DE=12;
			int from = Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			al[from].add(to);
		}
		DE=12;
		for(int i=0;i<N;i++) {
			
			if(al[i].size()!=0) {
				System.out.print(i+" : ");
				for(int j=0;j<al[i].size();j++) {
					System.out.print(al[i].get(j)+" ");
				}
				System.out.println();
			}
			
		}
	}
	
	static void f_arr_input() throws IOException {
		
		
		for(int i=0;i<T;i++) {
			DE=12;	
			st=new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			
			ADJ[from-1][to-1]=1;
			
		
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(ADJ[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		ADJ=new int[N][N];
		f_al_input();
		//f_arr_input();
		
		DE=12;

	}

}
*/

// 

/*
//Day3_추가1
import java.util.*;
import java.io.*;
public class Main {

	static int N, T;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> al[];
	static int ADJ[][];
	static int DE;
	
	static void f_al_input() throws IOException {
		al=new ArrayList[N];
		
		for(int i=0;i<N;i++)
			al[i]=new ArrayList<>();
		
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			DE=12;
			int from = Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			al[from].add(to);
		}
	}
	
	static void f_arr_input() throws IOException {
		
		
		for(int i=0;i<T;i++) {
			DE=12;	
			st=new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			
			ADJ[from-1][to-1]=1;
			
		
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(ADJ[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		ADJ=new int[N][N];
		//f_al_input();
		f_arr_input();
		
		DE=12;

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