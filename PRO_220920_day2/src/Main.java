/*
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
*/
// �ٺ�ġ Ÿ��(��ǰ)
/*
//�Է� 1
 
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int tower[][];
	static int new_tower[][];
	static int a_sum[];
	static int minus_cnt;
	static long MAX;
	static int mul;
	static int DE;
	static int Path[];
	
	// �� : 9000
	----1tc----
3 3 
-100 90 20 
10 -100 100 
90 90 -90 
9000
	----2tc----
	3 5 
	1 1 3 1 5 
	6 4 2 3 8 
	4 5 1 6 -4
	�� : 59400
	----3tc---- 
	3 4 
	-10 -10 -10 1 
	1 2 3 4 
	5 6 7 8 
	�� : 175
	----4tc----
	5 5
	100 100 100 100 100
	99 99 99 99 99 
	98 98 98 98 98 
	97 97 97 97 97
	96 96 96 96 96
	�� : 28247524900000
	 
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		tower=new int[N][M];
		new_tower=new int[N][M];
		a_sum=new int[M];
		Path=new int[M];
		MAX=Long.MIN_VALUE;
		minus_cnt=0;
		mul=1;
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				tower[i][j]=Integer.parseInt(st.nextToken());
				a_sum[j]+=tower[i][j];
				if(a_sum[j]<0) {
					minus_cnt++;
				}
			}
		}
		DE=12;
		
		for(int i=0;i<M;i++) {
			mul*=a_sum[i];
		}
		MAX=Long.max(MAX, mul);
		DE=12;
		
		func(0);

		//System.out.println(MAX);
	}
	static void func(int n) {
		
		if(n==M) {

			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					new_tower[i][(Path[j]+j)%M]=tower[i][j];
				}
			}
			DE=12;
			
			return;
		}
	
		for(int i=0;i<M;i++) {
			if(n==0&&i!=0)
				continue;
			Path[n]=i;
			func(n+1);
			//Path[i]=0;
		}
		
		
	}
}
*/
//���� ����
/*
import java.io.*;
import java.util.*; 

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[] path = new int[80]; 
	static int flag = 0; // flag -> ���� ������ ã�Ҵ°�? 0 : ���� ��ã�Ҵ� / 1 : ã�Ҵ�!
	
	// �����Լ� (isGood)
	static boolean isGood(int level) {
		// 1233212
		// ���� 1 -> 1 2 / 2 3 / 3 3 / 3 2 / 2 1
		// ���� 2 -> 12 33 / 23 32 / 33 21 
		// ���� 3 -> 123 321 
		// ���� üũ�غ����� �ִ� ����? --> ���ݱ��� ��ϵ� path�� ���� / 2
		int len = (level + 1) / 2; 
		
		// 1������ ~ len���� ���̱����� ������ ���ڿ��� �� ��� ��
		// i = ����
		for(int i = 1; i <= len ; i++) {
			int cnt = 0; 
			for(int j = 0; j < i; j++) {
				// ���� ���� level�� ��ġ�� �ִ� ���ڸ� �������� i���̸�ŭ�� ���ڿ����� ��
				if(path[level - j] == path[level - i - j])
					// ������ ��ġ�� ���ڰ� ��̴�!
					cnt++; 
			}
			// ���� üũ�ϴ� i��ŭ ũ���� �������� ������ ���ڰ� i���� �����Ѹ�ŭ �����Ǿ��ִٸ� 
			if(cnt == i)
				// �ߺ��̵ȴ� ! -> ���� ������ �ƴϴ�! 
				return false; 
		}
		// ���������̴�!
		return true; 
	}
	
	
	static void func(int level) {
		// ����ġ�� 
		if(flag==1) 
			return; 
		
		// ���� ���� -> N������ ���� ������ �ϼ�
		if(level == N) {
			for(int i=0;i<N;i++) {
				System.out.print(path[i]);
			}
			flag=1; 
			return; 
		}
		
		// ��� ���� -> �������� �ִ� branch = 1~3
		for(int i = 1; i <= 3; i++) {
			// ���� 1~3 ��, i�� �׳� �ϴ� �����־
			path[level] = i; 
			// �� ������ -> ���� ������ level(����)������ ������ ���� �����ΰ�? (����)
			// ���� ���� i��°��� ���ٿ��� �������� ���������� �����ȴٸ� -> ���� �����ΰ��� 1,2,3 �߰�
			if(isGood(level))
				func(level+1);
			path[level] = 0; 
		}
	}
	
	public static void main(String[] args) throws IOException{
		// input
		N = Integer.parseInt(br.readLine());
		func(0);
	}
}
*/
//N��
/*
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int cnt;
	static int DE;
	static int Location[];
	static int lurd[];
	static int ldru[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		Location=new int[N];
		lurd = new int [N*2];
		ldru = new int [N*2];
		cnt=0;
		func(0);
		System.out.println(cnt);
	}
	
	static void func(int n) {
		if(n==N) {
			cnt++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			DE=12;
			int tmp=0;
			if(n>i) tmp=N;
			if(Location[i]==1) 
				continue;
			if(ldru[n+i]==1) 
				continue;
			if(lurd[Math.abs(i-n)+tmp]==1)
				continue;
			
			ldru[n+i]=1;
			lurd[Math.abs(i-n)+tmp]=1;
			Location[i]=1;
			
			func(n+1);
			
			Location[i]=0;
			ldru[n+i]=0;
			lurd[Math.abs(i-n)+tmp]=0;
		}
				
		
	} 

}
*/

// n�ɽ�
/*
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int cnt;
	static int DE;
	static int Location[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		Location=new int[N];
		cnt=0;
		func(0);
		System.out.println(cnt);
	}
	
	static void func(int n) {
		if(n==N) {
			cnt++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(Location[i]==1) 
				continue;
			Location[i]=1;
			func(n+1);
			Location[i]=0;
		}
				
		
	} 

}
*/

// �ֻ��� ������
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
	
	// �������� ã���ִ� ���
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
	
	
	// ����ġ�� ���
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

// �Է¹��� Level���� ����Լ� ����
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
// ��ʹ� ���
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
// ����Ŭ �轼
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

//Quiz N�� �Է¹����� 1~N���� �Է��ϴ� ���α׷�
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