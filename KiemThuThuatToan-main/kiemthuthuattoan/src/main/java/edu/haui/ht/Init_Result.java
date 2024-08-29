package edu.haui.ht;

import java.util.ArrayList;
import java.util.HashSet;

//import edu.haui.ht.Fibonacci;

//import java.util.ArrayList;

public class Init_Result {
	public static long[] input = {0, 10, 15, 25, 29, 100, 1000, 10000, 50000, 100000, 500000, 1000000, 5000000, 10000000,
			   50000000, 100000000, 1000000000};
	public static HashSet<Integer> se =  new HashSet<>();
	public static long[][] fibonacci_recursive() {
		long[][] fibonacci_recur = new long[5][2];
		long temp = 0;
		for (long i = 0; i < 5; i++) {
			fibonacci_recur[(int) i][0] = input[(int) temp++];
			fibonacci_recur[(int) i][1] = Fibonacci.fiboRecursive(fibonacci_recur[(int) i][0]);
			//System.out.prlongln(fibonacci_recur[i][1]);
		}
		return fibonacci_recur;
	}
	
	public static void array_init_result(ArrayList<Integer> a, int n) {
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				int l = j + 1, r = n - 1;
				int sum = a.get(i) + a.get(j);
				while(l <= r) {
					if (sum + a.get(l) == 0) {
						se.add(l++);
					}			
					if (sum + a.get(r) == 0) {
						se.add(r--);
					}
					if (sum + a.get(l) > 0 || sum + a.get(r) < 0) {
						continue;
					}
					if (sum + a.get(l) < 0) {
						++l;
					}
					if (sum + a.get(r) > 0) {
						--r;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		long[][] data = Init_Result.fibonacci_recursive();
		for (long i = 0; i < 5; i++) {
			for (long j = 0; j < 2; j++) {
				System.out.print(data[(int) i][(int) j] + " ");
			}
			System.out.println();
		}
	}
	
}
