/*
import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/
// 안나와 엘사M

import java.util.*;
import java.io.*;


public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static char MAP[][];
	static int AY, AX;
	static int LY, LX;
	static boolean visited[][];
	static boolean visited2[][];
	static int dr[]= {-1,1,0,0};
	static int dc[]= {0,0,-1,1};
	static String AN[]=new String[4];
	static String LN[]=new String[4];
	static int ret;
	static int DE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		MAP=new char[N][N];
		visited=new boolean[N][N];
		visited2=new boolean[N][N];
		for(int i=0;i<N;i++) {
			//st=new StringTokenizer(br.readLine());
			String tmp=br.readLine();
			for(int j=0;j<N;j++) {
				MAP[i][j]=tmp.charAt(j);
			}
		}
		
		st=new StringTokenizer(br.readLine());
		AY=Integer.parseInt(st.nextToken());
		AX=Integer.parseInt(st.nextToken());
		LY=Integer.parseInt(st.nextToken());
		LX=Integer.parseInt(st.nextToken());
		
		visited[AY][AX]=true;
		visited2[LY][LX]=true;
		ret=0;
		bfs();
		System.out.println(ret);

	}
	
	static void bfs() {
		Queue<Node> AQ = new LinkedList<>();
		Queue<Node> LQ = new LinkedList<>();
		
		AQ.add(new Node(AY,AX,0));
		LQ.add(new Node(LY,LX,0));
		

		boolean find=false;
		while(!AQ.isEmpty()&&!find) {
			Node A_curr = AQ.poll();
			Node L_curr = LQ.poll();
			
			DE=12;
			
			//if(A_curr.r==L_curr.r&&A_curr.c==L_curr.c) {
				//ret=A_curr.d;
				//break;
			//}
			Arrays.fill(AN, "");
			Arrays.fill(LN, "");
			
			for(int i=0;i<4;i++) {
				int A_nr=A_curr.r+dr[i];
				int A_nc=A_curr.c+dc[i];

				
				if(A_nr<0||A_nr>=N||A_nc<0||A_nc>=N) continue;
				if(visited[A_nr][A_nc]) continue;
				if(MAP[A_nr][A_nc]=='#')continue;
				AN[i]=A_nr+""+A_nc;
				visited[A_nr][A_nc]=true;
				AQ.add(new Node(A_nr,A_nc,A_curr.d+1));
				
			}
			for(int i=0;i<4;i++) {
				int L_nr=L_curr.r+dr[i];
				int L_nc=L_curr.c+dc[i];
				
				if(L_nr<0||L_nr>=N||L_nc<0||L_nc>=N) continue;
				if(visited2[L_nr][L_nc]) continue;
				if(MAP[L_nr][L_nc]=='#')continue;
				LN[i]=L_nr+""+L_nc;
				visited2[L_nr][L_nc]=true;
				LQ.add(new Node(L_nr,L_nc,L_curr.d+1));
			}
			DE=12;
			for(int k=0;k<4;k++) {
				for(int j=0;j<4;j++) {
					if(AN[k]!=""&&LN[j]!="") {
						if(AN[k].equals(LN[j])) {
							ret=A_curr.d+1;
							find=true;
							break;
						}
					}
				}
			}
			
		}
		
	}

}

class Node{
	int r, c, d;
	Node(int r, int c, int d){
		this.r=r;
		this.c=c;
		this.d=d;
	}
}

// 나이트 라이더
/*
import java.util.*;
import java.io.*;


public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int DE;
	static int H,W;
	static int Y1, X1;
	static int Y2, X2;
	static int MAP[][];
	static boolean visited[][];
	static int D[][]= {{-2,1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}}; //8개
	
	static int ret;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		st=new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		MAP=new int[H][W];
		visited=new boolean[H][W];
		
		st=new StringTokenizer(br.readLine());
		Y1=Integer.parseInt(st.nextToken());
		X1=Integer.parseInt(st.nextToken());
		Y2=Integer.parseInt(st.nextToken());
		X2=Integer.parseInt(st.nextToken());
		
		MAP[Y2][X2]=1;
		visited[Y1][X1]=true;
		ret=0;
		
		bfs();
		
		System.out.println(ret);
	}
	static void bfs() {
		Queue<Node> myQ = new LinkedList<>();
		myQ.add(new Node(Y1, X1, 0));
		while(!myQ.isEmpty()) {
			Node curr = myQ.poll();
			if(MAP[curr.r][curr.c]==1) {
				ret=curr.d;
				break;
			}
			
			for(int i=0;i<8;i++) {
				int nr=curr.r+D[i][0];
				int nc=curr.c+D[i][1];
				
				if(nr<0||nr>=H||nc<0||nc>=W) continue; 
				if(visited[nr][nc]) continue;
				visited[nr][nc]=true;
				myQ.add(new Node(nr,nc,curr.d+1));
			}
		}
	}

}

class Node{
	int r, c, d;
	Node(int r, int c, int d){
		this.r=r;
		this.c=c;
		this.d=d;
	}
}
*/
// 플러드필
/*
import java.util.*;
import java.io.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int Y, X;
	static int MAP[][]=new int[5][5];
	static boolean visited[][]=new boolean[5][5];
	
	static int dr[]= {-1,1,0,0};
	static int dc[]= {0,0,-1,1};
	
	static int DE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st=new StringTokenizer(br.readLine());
		Y=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		
		visited[Y][X]=true;
		bfs();
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(MAP[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	static void bfs() {
		Queue<Node> myQ = new LinkedList<>();
		myQ.add(new Node(Y,X,1));
		
		while(!myQ.isEmpty()) {
			Node curr = myQ.poll();
			MAP[curr.r][curr.c]=curr.d;
			DE=12;
			
			for(int i=0;i<4;i++) {
				int nr = curr.r+dr[i];
				int nc = curr.c+dc[i];
				
				if(nr<0||nr>=5||nc<0||nc>=5) continue;
				if(visited[nr][nc]) continue;
				
				visited[nr][nc]=true;
				myQ.add(new Node(nr,nc,curr.d+1));
			}
		}
	}

}

class Node{
	int r, c, d;
	Node(int r, int c, int d){
		this.r=r;
		this.c=c;
		this.d=d;
	}
}

*/
//좀비 바이러스
/*
import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int W, H;
	static int X, Y;
	static int MAP[][];
	static boolean visited[][];
	static int dr[]= {-1,1,0,0};
	static int dc[]= {0,0,-1,1};
	static int ret;
	static int cnt;
	
	
	static int DE;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		st=new StringTokenizer(br.readLine());
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		MAP=new int[H][W];
		visited=new boolean[H][W];
		cnt=0;
		for(int i=0;i<H;i++) {
			String tmp=br.readLine();
			for(int j=0;j<W;j++) {
				MAP[i][j]=Integer.parseInt(tmp.charAt(j)+"");
				if(MAP[i][j]==1)
					cnt++;
			}
			
		}
		
		DE=12;
		st=new StringTokenizer(br.readLine());
		X=Integer.parseInt(st.nextToken())-1;
		Y=Integer.parseInt(st.nextToken())-1;

		visited[Y][X]=true;
		
		ret=Integer.MIN_VALUE;
		
		
		bfs();
		
		System.out.println(ret+3);
		System.out.println(cnt);
	}
	
	static void bfs() {
		Queue<Node> myQ = new LinkedList<>();
		myQ.add(new Node(Y,X,0));
		
		while(!myQ.isEmpty()) {
			Node curr = myQ.poll();
			ret=Integer.max(ret,curr.d);
			cnt--;
			
			for(int i=0;i<4;i++) {
				int nr=curr.r+dr[i];
				int nc=curr.c+dc[i];
				
				if(nr<0||nr>=H||nc<0||nc>=W) continue;
				if(MAP[nr][nc]==0) continue;
				if(visited[nr][nc]) continue;
				
				visited[nr][nc]=true;
				myQ.add(new Node(nr,nc,curr.d+1));
				
			}	
		}
		
	}

}

class Node{
	int r, c, d;
	Node(int r, int c, int d){
		this.r=r;
		this.c=c;
		this.d=d;
	}
}
*/

// 폭탄투
/*
import java.io.*;
import java.util.*; 

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;	
	
	static char[][] MAP = new char[4][5];
	static int[] ydir = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] xdir = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) throws IOException{
		// MAP 초기화
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++)
				MAP[i][j] = '_';
		}
		
		// 폭탄 두개 입력
		for(int i = 0; i < 2; i++) {
			int y, x;
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			// (y,x)기준으로 상하좌우+대각선 방향을 터트립니다
			// 8방향으로 펑펑 
			for(int j = 0; j < 8; j++) {
				// 다음 y
				int ny = y + ydir[j];
				// 다음 x
				int nx = x + xdir[j];
				// 항상 가장 먼저 체크 - 범위 
				if(ny < 0 || nx < 0 || ny >= 4 || nx >= 5)
					continue;
				MAP[ny][nx] = '#'; 
			}
		}
		
		// 출력
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++)
				System.out.print(MAP[i][j] + " ");
			System.out.println();
		}
	}
}
*/
// Bloom
/*
import java.util.*;
import java.io.*;


public class Main {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int H, W;
	static int y1,x1;
	static int y2,x2;
	static int MAP[][];
	static int dy[]= {-1,1,0,0};
	static int dx[]= {0,0,-1,1};
	
	static boolean visited[][];
	static int DE;
	
	static int ret;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st=new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		MAP=new int[H][W];
		visited=new boolean[H][W];
		
		st=new StringTokenizer(br.readLine());
		y1=Integer.parseInt(st.nextToken());
		x1=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		y2=Integer.parseInt(st.nextToken());
		x2=Integer.parseInt(st.nextToken());
		
		ret=Integer.MIN_VALUE;
		bfs();
		System.out.println(ret+1);
		
	}
	
	static void bfs() {
		
		visited[y1][x1]=true;
		visited[y2][x2]=true;
		
		Queue<Node> myQ = new LinkedList<>();
		myQ.add(new Node(y1,x1,0));
		myQ.add(new Node(y2,x2,0));
		
		while(!myQ.isEmpty()) {
			Node curr = myQ.poll();
			ret=Integer.max(ret,curr.d);
			DE=12;
			int ny=0;
			int nx=0;
			
			for(int i=0;i<4;i++) {
				ny=curr.y+dy[i];
				nx=curr.x+dx[i];
				if(is_invalid(ny,nx)) continue;
				if(visited[ny][nx]) continue;
				visited[ny][nx]=true;
				myQ.add(new Node(ny,nx,curr.d+1));
			}
			
		}
		
	}
	
	static boolean is_invalid(int y, int x) {
		if(y>=H||y<0||x>=W||x<0)
			return true;
		else {
			return false;
		}
		
	}

}

class Node{
	int y,x,d;
	Node(int y, int x, int d){
		this.y=y;
		this.x=x;
		this.d=d;
	}
}
*/

//트리 BFS
/*
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int Node_Value[];
	static int ADJ[][];
	static int DE;
	static boolean visited[];
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		N=Integer.parseInt(br.readLine());
		Node_Value=new int[N];
		ADJ=new int[N][N];
		visited=new boolean[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			Node_Value[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				ADJ[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0]=true;
		bfs(0);

	}

	static void bfs(int node) {
		Queue<Integer> myQ = new LinkedList<>();
		myQ.add(node);
		
		while(!myQ.isEmpty()) {
			int curr = myQ.poll();
			System.out.print(Node_Value[curr]+" ");
			
			for(int next=0;next<N;next++) {
				if(ADJ[curr][next]==0) continue;
				if(visited[next]) continue;
				
				visited[next]=true;
				myQ.add(next);
			}
			
		}
	}
}
*/

/*
4 5
0 1
0 2
1 2
1 3
2 3
 */
// BFS 예제
/*
import java.util.*;
import java.io.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	
	static int N, M;
	static boolean visited[];
	static ArrayList<Integer> al[];
	static int DE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		visited=new boolean[N];
		al=new ArrayList[N];
		
		for(int i=0;i<N;i++) {
			al[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			al[from].add(to);
		}
		
		DE=12;
		bfs(0);

	}
	
	static void bfs(int node) {
		// 1. Queue 생성
		Queue<Integer> myQ = new LinkedList<>();
		// Queue 시작노드 추가
		myQ.add(node);
		// visited 넷팅
		visited[node]=true;
		
		//3 BFS 구성 : Queue가 비어있지 않은 동안 > 대기열에 갈 수 있는 노드가 있을동안 계속 반복
		while(!myQ.isEmpty()) {
			int now= myQ.poll();
			DE=12;
			System.out.print(now+" ");
			
			for(int next=0;next<al[now].size();next++) {
				if(visited[al[now].get(next)]) continue;
				if(al[next].isEmpty()) continue;
				visited[al[now].get(next)]=true;
				myQ.add(al[now].get(next));
			}
			
			
		}
		
	}

}
*/