/*
import java.util.*;
import java.io.*;
public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int DE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/

// Priority Queue

import java.util.*;
import java.io.*;
public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int DE;
	//static int arr[] =new int [256];
	static int n=15;
	static int m=4;
	static int num[]= {0,1,0,1,1,0,0,0,1,1,1,1,0,1,1,};
	static boolean visited[][]=new boolean[4][5];
	
	static char arr[]= {'B','G','T','K'};
	static char path[]=new char[4];
	
	static int cnt;
	
	
	static char MAP[][]= {{'#',' ','#',' ',' '},
			{' ',' ',' ','D',' '},
			{' ','A','#',' ','#'},
			{' ','B',' ','C',' '}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cnt=0;
		func2(0);
		System.out.println(cnt);
	}
	
	static void func2(int now) {
		DE=12;
		if(now>=4) return;
		
		for(int i=0;i<4;i++) {
			if(now!=0) {
				if(path[now-1]== 'B' && arr[i]=='T') {
					cnt++;
					DE=12;
					continue;
				}
				if(path[now-1]== 'T'&& arr[i]=='B') {
					cnt++;
					DE=12;
					continue;
				}
			}	
				path[now]=arr[i];
				func2(now+1);
				path[now]=0;
				
			
			
		}
	}
	
}

/*
import java.util.*;
import java.io.*;
public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int DE;
	
	static int N;
	static String type;
	static int num;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		


		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			type=st.nextToken();
			num=Integer.parseInt(st.nextToken());
			
			if(type.equals("push")){
				pq.add(num);
			}else if(type.equals("pop")){
				for(int j=0;j<num;j++) {
					System.out.print(pq.poll()+" ");
				}
				System.out.println();
				
			}else if(type.equals("add")){
				int tmp=pq.poll();
				pq.add(tmp+num);
				
			}
			
		}

	}

}
*/

/*
//회의실 배정 - 그리디
import java.util.*;
import java.io.*;
public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int DE;

	static int N;
	static Room arr[];
	static int MIN;
	static int MAX;
	static boolean timeline[];
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		N=Integer.parseInt(br.readLine());
		arr=new Room[N];
		
		MIN=Integer.MAX_VALUE;
		MAX=Integer.MIN_VALUE;
		cnt=1;
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());	
			int e=Integer.parseInt(st.nextToken());
			arr[i]= new Room(s, e);
			
			MIN=Integer.min(MIN, s);
			MAX=Integer.max(MIN, e);
		}
		
		timeline=new boolean[MAX+1];
		
		Arrays.sort(arr);
		
		int time=arr[0].end;
		

		DE=12;
		//timeline[now]=true;
		for(int now=1;now<N;now++) {

			if(time>arr[now].start) continue;
			cnt++;
			time=arr[now].end;

		}
		
		DE=12;
		System.out.println(cnt);
		
	}
	
	static class Room implements Comparable<Room>{
		int start, end;
		Room(int start, int end){
			this.start=start;
			this.end=end;
			
		}
		@Override
		public int compareTo(Room next) {
			// TODO Auto-generated method stub
			
			if(end<next.end)
				return -1;
			if(end>next.end)
				return 1;
			
			if(start<next.start)
				return -1;
			if(start>next.start)
				return 1;
				
			
			return 0;
		}
	}

}
*/
/*
import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st ;
	
	static class Node implements Comparable <Node>{
		int num;
		char ch; 
		Node(int num, char ch){
			this.num = num;
			this.ch = ch; 
		}
		
		@Override
		public int compareTo(Node next) {
			// 1. 짝수
			if(num % 2 == 0 && next.num % 2 != 0)
				return -1;
			if(num % 2 == 1 && next.num % 2 == 0)
				return 1; 
			
			// 2. 숫자 오름차순 
			if(num < next.num)
				return -1;
			if(num > next.num)
				return 1; 
			
			// 3. 문자 오름차순
			if(ch < next.ch)
				return -1;
			if(ch > next.ch)
				return 1;
			
			return 0; 
		}
	}

	static int N; 
	static Integer[] arr; // 숫자만 담을 배열 
	static Node[] nodearr; 
	
	public static void main(String[] args) throws IOException {
		// input 
		N = Integer.parseInt(br.readLine());
		arr = new Integer[N];
		nodearr = new Node[N]; 
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) 
			nodearr[i] = new Node(arr[i], st.nextToken().charAt(0));
		
		// type 1
		Arrays.sort(arr); 
		for(int i = 0; i < N; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		
		// type 2
		Arrays.sort(arr, Collections.reverseOrder()); 
		for(int i = 0; i < N; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		
		// type 3
		Arrays.sort(nodearr);
		for(int i = 0; i < N; i++)
			System.out.print(nodearr[i].num + " ");
		System.out.println();
		for(int i = 0; i < N; i++)
			System.out.print(nodearr[i].ch + " ");
		System.out.println();
		
	}
}
*/
/*
import java.util.*;
import java.io.*;
public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int DE;
	
	static int N;
	static Integer num_arr[];
	static char chr_arr[];
	static Ret ret_arr[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		N=Integer.parseInt(br.readLine());
		num_arr=new Integer[N];
		chr_arr=new char[N];
		ret_arr=new Ret[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num_arr[i]=Integer.parseInt(st.nextToken());
		}
		
		//st=new StringTokenizer(br.readLine());
		String tmp=br.readLine();
		tmp.split(" ");
		int cnt=0;
		for(int i=0;i<tmp.length();i++) {
			if(tmp.charAt(i)==' ')
				continue;
			chr_arr[cnt]=tmp.charAt(i);
			cnt++;
		}
		
		for(int i=0;i<N;i++) {
			ret_arr[i]=new Ret(num_arr[i], chr_arr[i]);	
		}
		//

		Arrays.sort(num_arr);
		
		for(int i=0;i<N;i++) {
			System.out.print(num_arr[i]+ " ");
		}
		System.out.println();
		
		//Collections.reverseOrder()
		
		Arrays.sort(num_arr,Collections.reverseOrder());
		
		for(int i=0;i<N;i++) {
			System.out.print(num_arr[i]+ " ");
		}
		System.out.println();
		
		//
		
		Arrays.sort(ret_arr);
		for(int i=0;i<N;i++) {
			System.out.print(ret_arr[i].i+" ");
		}
		System.out.println();
		for(int i=0;i<N;i++) {
			System.out.print(ret_arr[i].c+" ");
		}
		
		
	}
	
	static class Ret implements Comparable <Ret>{
		int i;
		char c;
		Ret(int i, char c) {
			this.i=i;
			this.c=c;
		}
		@Override
		public int compareTo(Ret right) {
			
			// TODO Auto-generated method stub
			if(i%2==0 && right.i%2==1)
				return -1;
			if(i%2==1 && right.i%2==0)
				return 1;
			
			//오름차순
			if(i<right.i)
				return -1;
			if(i>right.i)
				return 1;
			
			//문자 오름차순
			if(c<right.c)
				return -1;
			if(c>right.c)
				return 1;
			
			return 0;
		}
		
	}

}

*/

// 정렬 예제코드
/*
import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st ;
	
	// unstable -> 안정적이지 않음
	// 버블 정렬 / 선택정렬 / 삽입정렬 //<-- 효율 나쁜 정렬 O(N~N^2) --> N^2
	// 병합 정렬 / 퀵 정렬 // <-- 효율 좋은 정렬 알고리즘 --> NlogN --> N^2
	
	// STL에서 제공하는 정렬 알고리즘 쓰는것보다 효율이 떨어짐 
	// Java, C++에서 제공하는 정렬 알고리즘 sort() --> 항상 아주 stable하게 NlogN 
	
	// Java : Dual pivot Quick sort
	// C++ : Introsort (Quick sort, heap sort, ???) --> NlogN
	
	static Integer[] arr = {2, 3, 1, 4, 5}; 
	// 1. 오름차순 정렬
	// 2. 내림차순 정렬 
	// **3. custom 정렬
	
	// 비교가 가능한 class로 만들어주셔야 합니다.(comparable)  
	static class Student implements Comparable <Student>{
		int age;
		int height; 
		Student(int age, int height) {
			this.age = age;
			this.height = height; 
		}
		
		// 우리가 새로운 클래스에 대해서 정렬할수 있는 기준을 직접 구현
		@Override
		public int compareTo(Student right) {
			// 1. 나이가 많은순으로 우선순위 --> 올바른(원하는) 상황이다! 
			if(age > right.age) 
				return -1; // 올바른 상황에서는 -1 return
			if(age < right.age) // 잘못된 상황이다!
				return 1; // 잘못된 상황에서는 1 return 
			
			// 2. 키가 작은순으로 우선순위
			if(height < right.height)
				return -1;
			if(height > right.height)
				return 1; 
			
			// 아직 처리하지 않은 상황 -- 모두가 동일할떄
			return 0; // 중립기어
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		// 1. 오름차순 
		Arrays.sort(arr);
		
		for(int i = 0; i < 5; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		
		// 2. 내림차순 -> int가 아닌, 정렬 기준을 바꿀수 있게 허용하는 Integer type (Wrapper)
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i = 0; i < 5; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		
		// 3. custom 정렬
		Student[] students = new Student[5]; 
		students[0] = new Student(13, 170);
		students[1] = new Student(15, 155);
		students[2] = new Student(15, 165);
		students[3] = new Student(13, 165);
		students[4] = new Student(18, 165);
		
		Arrays.sort(students);
		
		for(int i = 0; i < 5; i++)
			System.out.println(students[i].age + " " + students[i].height);
		
	}
}

*/