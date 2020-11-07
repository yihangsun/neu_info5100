package assignment7;

import java.util.Random;

public class SumValue {
	 static void generateRandomArray(int[] arr){
	  Random rd = new Random();
	  for (int i = 0 ; i < arr.length; i++) {
	   arr[i] = rd.nextInt();
	  }
	 }

	 /*get sum of an array using 4 threads*/
	 static long sum(int[] arr){
	  if (arr.length == 0 || arr == null) return 0;
	  int aveLength = arr.length / 4;
	  myThread td1 = new myThread(0, aveLength, arr);
	  myThread td2 = new myThread(aveLength, aveLength * 2, arr);
	  myThread td3 = new myThread(aveLength * 2, aveLength * 3, arr);
	  myThread td4 = new myThread(aveLength * 3, arr.length, arr);
	  td1.start();
	  td2.start();
	  td3.start();
	  td4.start();
	  return td1.getSum() + td2.getSum() + td3.getSum() + td4.getSum();
	 }

	 public static void main(String[] args){
	  int[] arr = new int[4000000];
	  generateRandomArray(arr);
	  long sum = sum(arr);
	  System.out.println("Sum: " + sum);
	 }
}
