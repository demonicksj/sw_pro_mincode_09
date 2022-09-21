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
import java.io.*;
import java.util.*; 

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[][] MAP = new int[5][5];  
	static int[] path = new int[5];
	
	static long MAX;
	static long mul;
	static int DE;
	
	// �����Լ�
	// ���� ���� level���� ȸ������ "Ȯ��"�ϰ� path�� ��� 
	// --> ���� level������ �̹� ���� ȸ������ Ȯ���� ����� ���ϸ� ���� ���� �ִ°�? --> false
	static boolean isGood(int level) {
		// ���ι��� Ȯ�� -> �� ����
		for(int i = 0; i < M; i++) {
			// ���� ���� ���� Ȯ���� ������ �� (üũ)
			for(int j = 0; j < level; j++) {
				// (���� ������) ���� ���� (�� + ȸ���� ����) == (������ + ȸ���� ����) false
				// MAP[level][i] = level���� ��� ���� ��
				// MAP[j][i] = level ���� �ִ� ��� ������ ���� �� 
				// level ���� ȸ���� = path[level] -> j���� ȸ���� = path[j]
				if(MAP[level][(i + path[level]) % M] == MAP[j][(i + path[j]) % M])
					return false; 
			}
		}
		return true; 
	}
	
	
	
	static void func(int level) {
		// �������� -> ���� N-1���� ȸ������ �����ϰ�, N������ �����Դٸ� 
		// N-1������ ȸ������ isGood()�� ���Ŀ����Ƿ�, "�� ȸ������ ��ȿ�ϴ�" ��°� Ȯ��
		if(level == N) {
			//�������� ���� ���� ��� 
			//�ִ밪�� ����
			DE=12;
			mul=1;
			for(int i=0;i<M;i++) {
				int sum=0;
				for(int j=0;j<N;j++) {
					sum+=MAP[j][(i + path[j]) % M];
				}
				mul*=sum;
			}
			
			MAX=Long.max(MAX, mul);
			DE=12;
			return; 
		}
		
		// ��� ���� --> ��� ������ �������� branch -> 0~M-1���� ȸ���� 
		for(int i = 0; i < M; i++) {
			// path���� �ش� ���� ȸ����Ų ȸ�� ��/�� ����
			path[level] = i; // level���� i����ŭ ȸ����ų���̴�! 
			// ���� ���� ���� level���� i�� ȸ�������� 
			// �� �� ����� ������ ���� ������ -> �������� ������ �ٷ� ���� ȸ�� �� ���� 
			// �ƴ϶�� ���� ���� ������ �Ѿ ���� ���� ���� ȸ������ �����ϰ� ��������. 
			if(isGood(level))
				func(level+1);
			path[level] = 0; 
		}
	}
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		MAX = Long.MIN_VALUE;
		mul=1;
		
		// MAP ���� Ÿ�� ���� �Է�
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(0); 
		
		System.out.println(MAX);
	}
}
*/