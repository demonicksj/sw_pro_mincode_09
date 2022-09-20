/*
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// 주사위 던지기
/*
import java.util.*;
import java.io.*;

public class Main {
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int cnt;
	static int dice[];
	static int check_dice[];
	static int db_dice[][];
	static int db_dice2[];
	static int DE;
	static int DAT[]=new int[7];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		//int tmp=6*6*6;
		dice=new int[N];
		check_dice=new int[N];
		db_dice=new int[300][N];
		db_dice2=new int[66667];
		cnt=0;
		if(M==1) {
			func1(0);
		}else if(M==2) {
			func2(0);
		}else if(M==3) {
			func3(0);
		}
		

	}
	
	static void print() {
		for(int i=0;i<N;i++) {
			System.out.print(dice[i]+" ");
		}
		System.out.println();
	}
	
	// 마지막에 찾아주는 방식
	static void func2_2(int n) {
		if(n>=N) {
			check_dice=Arrays.copyOf(dice, dice.length);
			Arrays.sort(check_dice);
			int tmp=0;
			for(int i=0;i<N;i++) {
				tmp+=check_dice[i]*(Math.pow(10,N-i-1));
			}
			DE=12;
			db_dice2[tmp]++;
			if(db_dice2[tmp]==1) {
				print();	
			}
				return;
			
		}
		
		for(int i=1;i<=6;i++) {
			dice[n]=i;
			DE=12;
			func2_2(n+1);
		}
		
		
	}
	
	
	// 가지치기 방식
	static void func2(int n) {
		if(n>=N) {
			print();	
			return;
			
		}
		
		for(int i=1;i<=6;i++) {
			if(n>0&&i<dice[n-1]) {
				continue;
			}
			dice[n]=i;
			
			DE=12;
			func2(n+1);
			dice[n]=0;
		}
		
		
	}
	static void func1(int n) {
		if(n>=N) {
			
//			Arrays.sort(null);
			
			for(int i=0;i<N;i++) {
				System.out.print(dice[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=6;i++) {
			dice[n]=i;
			DE=12;
			func1(n+1);
		}
		
	}
	static void func3(int n) {
		if(n>=N) {
			
			for(int i=0;i<N;i++) {
				
				System.out.print(dice[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=6;i++) {
			
			if(DAT[i]+1>1) {
				continue;
			}
			
			dice[n]=i;
			DAT[i]++;
			func3(n+1);
			DAT[i]--;
		}
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