/*
import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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