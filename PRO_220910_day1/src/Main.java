/*
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/* 입력과 출력
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int type;
	static int N;
	static int MAX;
	static int MIN;
	static String words[];
	static int Y, X;
	static int arr[][];
	static int DE;
	
	static void sol1() throws IOException {
		
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		int sum=0;
		long mul=1;
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int tmp=Integer.parseInt(st.nextToken());
			sum+=tmp;
			mul*=tmp;
		}
		System.out.println(sum + " " + mul);
	}
	
	static void sol2() throws IOException {
		MAX=Integer.MIN_VALUE;
		MIN=Integer.MAX_VALUE;
		String ret1="";
		String ret2="";
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		words=new String[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			words[i]=st.nextToken();
			MAX=Integer.max(words[i].length(),MAX);
			MIN=Integer.min(words[i].length(),MIN);
			if(MAX!=Integer.MIN_VALUE && words[i].length()==MAX) {
				ret1=words[i];
			}
			
			if(MIN!=Integer.MAX_VALUE && words[i].length()==MIN) {
				ret2=words[i];
			}
			
		}
		
		DE=12;
		System.out.println(ret1);
		System.out.println(ret2);
		
	}
	
	static void sol3() throws IOException {
		st=new StringTokenizer(br.readLine());
		Y=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		MIN=Integer.MAX_VALUE;
		HashMap<Integer,Integer> h_map = new HashMap<>();
		
		arr=new int[Y][X];
		
		for(int i=0;i<Y;i++) {
			st=new StringTokenizer(br.readLine());
			DE=12;
			for(int j=0;j<X;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				MIN=Integer.min(MIN, arr[i][j]);
				if(MIN==arr[i][j]) {
					if(h_map.get(arr[i][j])==null) {
						h_map.clear();
						h_map.put(arr[i][j], 1);
					}
					else {
						int tmp=h_map.get(arr[i][j])+1;
						h_map.put(arr[i][j], tmp);
						DE=12;
					}
				}
			}
			
		}
		System.out.println(MIN);
		System.out.println(h_map.get(MIN)+"개");
		
		
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		type=Integer.parseInt(st.nextToken());
		if(type==1) {
			sol1();
		}else if(type==2) {
			sol2();
		}else if(type==3) {
			sol3();
		}
		
	
	}

}


 */


// 2차원 배열 입력 연습
/*
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int map[][];
	static BufferedReader br;
	static StringTokenizer token;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		token=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		map=new int[N][M];
		
		for(int i=0;i<N;i++) {
			token=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[j][i] + " ");
			}
			System.out.println();
		}
		
	}

}
*/

/* 1차원 배열 입력 연습
import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int arr[];
	static BufferedReader br;
	static StringTokenizer token;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		token=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(token.nextToken());
		
		arr=new int[N];
		token=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(token.nextToken());
		}
		
		int DE=12;
		
		for(int i=N-1;i>-1;i--) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
*/
