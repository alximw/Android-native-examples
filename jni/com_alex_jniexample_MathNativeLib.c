/*
 * com_alex_jniexample_MathNativeLib.c
 *
 *  Created on: Jan 12, 2015
 *      Author: Alex
 */

#include "com_alex_jniexample_MathNativeLib.h"
/* this file has been generated with javah -classpath /classes/path -d jni name.space.path.to.myClass */

static jlong recursionHelper(jlong n, int caller)
{

	if(caller==1){
		/* fibonacci series*/
		if(n<=0||n==1||n==2){
			return 1;
		}

		return recursionHelper(n-1,1)+recursionHelper(n-2,1);

	}else if(caller==2){
		/* factorial */

		if(n==0||n==1){
			return 1;
		}
		return n*recursionHelper(n-1,2);

	}else{

		return -1;
	}

}




/*
 * Class:     com_alex_jniexample_MathNativeLib
 * Method:    fibRNative
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_alex_jniexample_MathNativeLib_fibRNative(JNIEnv *env, jclass thiz, jlong n)
{

	/* to avoid duplicating the stack variables (the parameters)
	 * on each call, lets use a function to compute only the maths
	 */

	/*
	 * n is the number to compute the factorial with
	 * 1 is the caller id indicating factorial
	 */
	return recursionHelper(n,1);

}

/*
 * Class:     com_alex_jniexample_MathNativeLib
 * Method:    fibINative
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_alex_jniexample_MathNativeLib_fibINative(JNIEnv *env, jclass thiz, jlong n)
{
	jlong v0 = 0;
	jlong result=1;
	jlong i;
	for(i=1;i<n;i++){
		jlong aux = result+v0;
		v0 = result;
		result = aux;
	}
	return result;
}

/*
 * Class:     com_alex_jniexample_MathNativeLib
 * Method:    factRN
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_alex_jniexample_MathNativeLib_factRN(JNIEnv *env, jclass thiz, jlong n)
{

	/* to avoid duplicating the stack variables (the parameters)
	 * on each call, lets use a function to compute only the maths
	 */

	/*
	 * n is the number to compute the factorial with
	 * 2 is the caller id indicating factorial
	 */
	return recursionHelper(n,2);


}

/*
 * Class:     com_alex_jniexample_MathNativeLib
 * Method:    factIN
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_alex_jniexample_MathNativeLib_factIN(JNIEnv *env, jclass thiz, jlong n){

	jlong result = 1;
	jlong sum =1;

	if(n==0){
		return result;
	}

	jlong i;
	for(i=1;i<=n;i++){
		sum = i*sum;
		result = sum;
	}
	return result;


}




