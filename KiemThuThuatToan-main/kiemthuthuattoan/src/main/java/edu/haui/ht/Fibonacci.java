package edu.haui.ht;

import java.math.BigInteger;

public class Fibonacci {
	public static long fiboRecursive(long input) {
		if (input <= 1) {
			return input;
		}
		if (input >= 30) {
			throw new IllegalArgumentException("n is greater than or equal to 30");
		}
		return fiboRecursive(input - 1) + fiboRecursive(input - 2);
	}
	// n > 10 ^ 7 --> dừng
	public static long fiboLoop(long n) {
		if (n > 10000000) {
			throw new IllegalArgumentException("n is greater than 10000000");
		}
		long [] arr = new long[(int) (n + 1)];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		for (long i = 3; i <= n; i++) {
			arr[(int) i] = arr[(int) (i - 1)] + arr[(int) (i - 2)];
			arr[(int) i] %= 1000000007;
		}
		return (long) arr[(int) n];
	}
	
	public static long fiboLoopOptimize(long n) {
		if (n > 100000000) {
			throw new IllegalArgumentException("n is greater than 100000000");
		}
		long a = 0;
		long b = 1;
		long c = 0;
		if (n == 0) {
			return a;
		}
		if (n == 1) {
			return b;
		}
		for (int i = 2; i <= n; i++) {
			c = (a + b) % 1000000007;
			a = b % 1000000007;
			b = c % 1000000007;
		}
		return c;
	}
	
	public static BigInteger fiboBinetBigInteger(long n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        double fib = (Math.pow(phi, n) - Math.pow(1 - phi, n)) / Math.sqrt(5);
        String str = Double.toString(fib);
        BigInteger bigInt = new BigInteger(str);
        return bigInt;
    }
	
	public static long fiboBinet(long n) {
		double phi = (1 + Math.sqrt(5)) / 2;
        double fib = (Math.pow(phi, n) - Math.pow(1 - phi, n)) / Math.sqrt(5);
        return (long) (Math.round(fib));
	}
	
	public static long fiboMatrix(long n) {
	    if (n < 2) {
	        return n;
	    }
	    long[][] matrix = {{1, 1}, {1, 0}};
	    power(matrix, n - 1);
	    return matrix[0][0];
	}

	private static void power(long[][] matrix, long n) {
	    if (n <= 1) {
	        return;
	    }
	    power(matrix, n / 2);
	    multiply(matrix, matrix);
	    if (n % 2 != 0) {
	        long[][] baseMatrix = {{1, 1}, {1, 0}};
	        multiply(matrix, baseMatrix);
	    }
	}
	

	private static void multiply(long[][] matrix1, long[][] matrix2) {
	    long a = (matrix1[0][0] * matrix2[0][0] + matrix1[0][1] * matrix2[1][0]) % 1000000007;
	    long b = (matrix1[0][0] * matrix2[0][1] + matrix1[0][1] * matrix2[1][1]) % 1000000007;
	    long c = (matrix1[1][0] * matrix2[0][0] + matrix1[1][1] * matrix2[1][0]) % 1000000007;
	    long d = (matrix1[1][0] * matrix2[0][1] + matrix1[1][1] * matrix2[1][1]) % 1000000007;
	    matrix1[0][0] = a;
	    matrix1[0][1] = b;
	    matrix1[1][0] = c;
	    matrix1[1][1] = d;
	}
	public static void main(String[] args) {
		System.out.println(fiboMatrix(23234));
	}
}
