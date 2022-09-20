/*
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/
// 입력받은 Level까지 재귀함수 동작
/*
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		func(0);
		//function

	}
	
	static void func(int n) {
		if(n>N) {
			return;
		}
		
		System.out.print(n);
		for(int i=0;i<2;i++) {
			func(n+1);
		}
	}

}
*/
// 재귀는 몇번
/*
import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int branch, level;
	static int cnt;
	static int DE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st=new StringTokenizer(br.readLine());
		branch=Integer.parseInt(st.nextToken());
		level=Integer.parseInt(st.nextToken());
		cnt=0;
		func(0);
		System.out.println(cnt);
	}
	
	static void func(int n) {
		
		if(n>level) {
			return;
		}
		cnt++;
		
		for(int i=0;i<branch;i++) {
			func(n+1);
		}
		
		
	}

}
*/
// 마이클 잭슨
/*
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int arr[];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int start,end;
	static int DE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
			
		st=new StringTokenizer(br.readLine());
		start=Integer.parseInt(st.nextToken());
		end=Integer.parseInt(st.nextToken());
		
		func(start);

	}
	
	static void func(int n) {
		if(n>end) {
			return;
		}
		
		System.out.print(arr[n]+" ");
		DE=12;
		func(n+1);
		if(n==end) {
			return;
		}
		System.out.print(arr[n] + " ");
	}

}
*/
/*
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/

//Quiz N을 입력받으면 1~N까지 입력하는 프로그램
/*
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int DE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		N=Integer.parseInt(br.readLine());
		
		f_quiz1(1);
		System.out.println("===========");
		f_quiz2(1);
		System.out.println("===========");
		f_quiz3(1);

	}
	
	static void f_quiz1(int n) {
		if(n>N) {
			return;
		}
		DE=12;
		
		System.out.println(n);
		f_quiz1(n+1);
		
	}
	
	static void f_quiz2(int n) {
		if(n>N) {
			return;
		}
		
		f_quiz2(n+1);
		System.out.println(n);
		
	}
	
	static void f_quiz3(int n) {
		if(n>N) {
			return;
		}
		System.out.println(n);
		f_quiz3(n+1);
		if(n==N) {
			return;
		}
		System.out.println(n);
		
	}

}
*/