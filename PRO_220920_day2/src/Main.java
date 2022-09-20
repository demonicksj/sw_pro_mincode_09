/*
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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