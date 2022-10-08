/*
import java.util.*;
import java.io.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/


import java.util.*;
import java.io.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T;
	static int N;
	static int map[][];
	static int MAX;
	static int DE;
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			
			MAX=Integer.MIN_VALUE;
			N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			arr=new int[N];
			
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			
			func(0, 0, new boolean[N]);
			
			System.out.println("#"+tc+" "+MAX);
			
		}

	}
	
	static void func(int toChoose, int now, boolean visited[]) {
		if(toChoose==N) {
			//System.out.println(Arrays.toString(arr));
			int sum=0;
			for(int i=0;i<N;i++) {
				sum+=map[i][arr[i]];
			}
			MAX=Integer.max(MAX,sum);
			DE=12;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			visited[i]=true;
			arr[toChoose]=i;
			func(toChoose+1,i,visited);
			visited[i]=false;
		}
		
	}

}
