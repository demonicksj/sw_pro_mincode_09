/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/
//예식장 서빙

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T;
	static int N, R;
	static String ret;
	static int arr[];
	static int DE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			boolean is_true = false;
			
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			R=Integer.parseInt(st.nextToken());
			arr=new int[N];
			
			//1. 공통구역 설정
			int start=0;
			
			int end;
			
			if(R%2!=0) {
				end=(R*2+1)%N;
			}else {
				end=(R*2)%N;
				
			}
			
			HashMap<Integer,Integer> h_map = new HashMap<>();
			
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			DE=12;
			for(int i=0;i<end;i++) {
				int input=arr[i];
				if(h_map.get(input)==null) {
					is_true=true;
					h_map.put(input,1);
				}else {
					if(h_map.get(input)>=2) {
						is_true=false;
						DE=12;
						break;
					}
					is_true=true;
					h_map.put(input,h_map.get(input)+1);
					
				}
			}
			
			if(is_true) {
				int cnt=0;
				while(cnt<N) {
					// 완전화 + 수행
					int input=arr[end];
					if(h_map.get(input)==null) {
						h_map.put(input,1);
					}else {
						if(h_map.get(input)>=2) {
							is_true=false;
							DE=12;
							break;
						}
						is_true=true;
						h_map.put(input,h_map.get(input)+1);
						
					}
					
					// 다음값 셋팅
					h_map.put(arr[start],h_map.get(arr[start])-1);
					
					//이동
					start=(start+1)%N;
					end=(end+1)%N;
					cnt++;
					
				}
				
			}
			 
	
			ret = is_true?"YES":"NO";
			System.out.println("#"+tc+" "+ret);
		}
		

	}

}

// 미확인 신호
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T;
	static int M;
	static String message;
	static String pattern;
	static int DE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			M=Integer.parseInt(br.readLine());
			message = br.readLine();
			pattern="";
			HashMap<Character,Integer> h_map = new HashMap<>();
			
			// 공통구간 세팅
			int start=0;
			int end=M-1;
			boolean is_true = false;
			String ret="";
			
			DE=12;
			for(int i=start;i<end;i++) {
				pattern+=message.charAt(i);
				if(h_map.get(pattern.charAt(i))==null) {
					h_map.put(pattern.charAt(i),1);

				}else {
					is_true = false;
					break;
				}
				is_true=true;
			}
			
			if(is_true) {
				// 슬라이등 윈도우 구현
				while(end<message.length()) {
					pattern+=message.charAt(end);
					// 수행
					if(h_map.get(pattern.charAt(end))==null) {
						h_map.put(pattern.charAt(end),1);

					}else {
						is_true = false;
						break;
					}
					is_true=true;
					//다음 공통영역설정
					h_map.remove(pattern.charAt(start));
					
					// 이동
					start++;
					end++;
				}
			}
			
			
			if(is_true) {
				ret="PASS";
			}else {
				ret="FAIL";
			}
			
			System.out.println("#"+tc+" "+ret);
			
		}

	}

}
*/

//슬라이등 윈도우

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int TC;
	static int N, W;
	static int arr[];
	static int MAX;
	static int DE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			st = new StringTokenizer(br.readLine());
			
			N=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			
			arr=new int[N];

			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			// 슬라이딩 윈도우
			
			// 공통구간 세팅
			int start=0;
			int end=W-1;
			int sum=0;
			int start_i=0;
			int end_i=0;
			MAX=Integer.MIN_VALUE;
			
			for(int i=start;i<end;i++)
				sum+=arr[i];
			
			// 슬라이딩 윈도우 구현
			while(end<N) {
				//2-1 구간완성
				sum+=arr[end];
				DE=12;
				//2-2 수행
				MAX=Integer.max(MAX,sum);
				if(MAX==sum) {
					start_i=start;
					end_i=end;
				}
				//2-3 다음 공통구간 설정
				sum-=arr[start];
				//2-4 이동
				start++;
				end++;
			}
			
			System.out.println("#"+t+" "+start_i+" "+end_i+" "+MAX);
			
		}

	}

}
*/

// 버스 주차요금 저렴한 곳 찾기(슬라이딩 윈도우)
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int arr[]= {1,2,3,3,5,1,0,1,3};
	static int N;
	static int start;
	static int end;
	static int MIN;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MIN=Integer.MAX_VALUE;
		N=Integer.parseInt(br.readLine());
		//1.공통구간 세팅(start ~ end-1 까지)
		//start, end 포인터를 설정
		int start=0;
		int end=N-1;
		int sum=0;
		// 공통구간의 합 저장
		for(int i=start;i<end;i++) {
			sum+=arr[i];
		}
		
		//2. 슬라이등 윈도우 구현
		while(end<arr.length) {
			// 2-1구간완성
			sum+=arr[end];
			
			//2-2. 수행
			MIN=Integer.min(MIN,sum);
			//2-3. 다음 공통구간 설정
			sum-=arr[start];
			//2-4. 구간이동
			start++;
			end++;
		}
		System.out.println(MIN);
	}

}
*/


//카드 발급기
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int TC;
	static int N;
	static int arr[];
	static int order_arr[];
	static int DE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br=new BufferedReader(new InputStreamReader(System.in));
		TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			N=Integer.parseInt(br.readLine());
			arr=new int[N];
			order_arr=new int[N];
			st=new StringTokenizer(br.readLine());
			//PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			boolean is_ture=false;
			 
			for(int i=0;i<N;i++) {
				int num=Integer.parseInt(st.nextToken());
				//pq.add(num);
				order_arr[i]=num;
				arr[i]=num;
			}
			Arrays.sort(order_arr);
			
			
			
			HashMap<Integer,Integer> h_map = new HashMap<>();
			for(int i=N-1;i>=0;i--) {
				//int tmp = pq.poll();
				h_map.put(N-i,order_arr[i]);
				DE=12;	
			}
			
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int order_num=Integer.parseInt(st.nextToken());
				if(h_map.get(order_num) != arr[i]) {
					is_ture=false;
					break;
				}else {
					is_ture=true;
				}
				
			}
			String ret = is_ture ? "YES" : "NO";
			System.out.println(ret);
		}

	}

}
*/


// 블랙리스트
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer token;
	static int h, w;
	static int bh,bw;
	static int map[][];
	static int b_map[][];
	static int DE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> hash_map = new HashMap<Integer,Integer>();
		br=new BufferedReader(new InputStreamReader(System.in));
		token=new StringTokenizer(br.readLine());
		h=Integer.parseInt(token.nextToken());
		w=Integer.parseInt(token.nextToken());
		map=new int[h][w];
		
		for(int i=0;i<h;i++) {
			token=new StringTokenizer(br.readLine());	
			for(int j=0;j<w;j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
				if(hash_map.get(map[i][j])!=null) {
					int temp = hash_map.get(map[i][j])+1;
					hash_map.put(map[i][j],temp);
				}else {
					hash_map.put(map[i][j],1);
				}
				
			}
		}
		
		token=new StringTokenizer(br.readLine());
		bh=Integer.parseInt(token.nextToken());
		bw=Integer.parseInt(token.nextToken());
		b_map=new int[bh][bw];
		HashMap<Integer,Boolean> v_check = new HashMap<>();
		int b_sum=0;
		
		for(int i=0;i<bh;i++) {
			token=new StringTokenizer(br.readLine());
			for(int j=0;j<bw;j++) {
				b_map[i][j]=Integer.parseInt(token.nextToken());
				if(hash_map.get(b_map[i][j])!=null) {
					if(v_check.get(b_map[i][j])==null){
						v_check.put(b_map[i][j], true);
						b_sum+=hash_map.get(b_map[i][j]);
					}
					
				}
				
			}
		}
		
		System.out.println(b_sum);
		System.out.println(h*w-b_sum);
		
	}

}
*/

// 뭐리 입력 받아 갯수 구하는 로직
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	//static int arr[]={1,2,1,3,5,8,1,2,5,9};
	// 10
	// 1 2 1 3 5 8 1 2 5 9
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br=new BufferedReader(new InputStreamReader(System.in));
		int Q=Integer.parseInt(br.readLine());
		HashMap<Integer,Integer> h_map = new HashMap<>();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<Q;i++) {
			int tmp=Integer.parseInt(st.nextToken());
			if(h_map.get(tmp)!=null) {
				h_map.put(tmp,h_map.get(tmp)+1);
			}else {
				h_map.put(tmp,1);
			}
			
		}
		
		int A=Integer.parseInt(br.readLine());
		System.out.println(h_map.get(A));
		

	}

}
*/


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
