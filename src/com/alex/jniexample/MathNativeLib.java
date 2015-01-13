package com.alex.jniexample;

import android.util.Log;

public class MathNativeLib {

	
	private static final String TAG = "NATIVE_MATHS_lib";
	
	static{
		
		System.loadLibrary("com_alex_jniexample_MathNativeLib");
		Log.i(TAG,"native lib loaded!");
	}
	
	
	
	/*
	 * Computes the n-term of the Fibonacci series using
	 * a recursive approach. Implemented natively.
	 */
	public static native long fibRNative(long n);
	
	/*
	 * Computes the n-term of the Fibonacci Series using
	 * an iterative approach. Implemented natively.
	 */
	public static native long fibINative(long n);
	
	
	/*
	 * Computes the factorial of n using a recursive 
	 * approach. Implemented natively.
	 */
	public static native long factRN(long n);
	
	
	/*
	 * computes the factorial of n using a iterative 
	 * approach. Implemented natively.
	 */
	public static native long factIN(long n);
	
	
	
	/*
	 * Computes the n-term of the Fibonacci series using
	 *  a recursive approach. Implemented in classic Java.
	 */
	public static long fibR(long n){
		
		if(n<=0||n==1||n==2)
			return 1;
		
		return fibR(n-1)+fibR(n-2);

	}
	
	/*
	 * Computes the n-term of the Fibonacci series using
	 *  an iterative approach. Implemented in classic Java.
	 */
	public static long fibI(long n){
		long v0 = 0;
		
		long result=1;
		
	
		for(long i=1;i<n;i++){
			long aux = result+v0;
			v0 = result;
			result = aux;
		}
		return result;
	}

	/*
	 * Computes the factorial of n using a recursive
	 * approach. Implemented in classic Java.
	 */
	public static long factR(long n){
		if(n==0||n==1)
			return 1;
		return n*factR(n-1);
	}
	
	/*
	 * Computes the factorial of n using an iterative
	 * approach. Implemented in classic Java.
	 */
	public static long factI(long n){
		long result = 1;
		long sum =1;
		if(n==0){
			return result;
		}
		
		for(long i=1;i<=n;i++){
			sum = i*sum;
			result = sum;
		}
		return result;
	}
	
	
	
	
	
}
