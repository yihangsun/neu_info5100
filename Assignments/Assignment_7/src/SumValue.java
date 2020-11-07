import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

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
  AtomicLong sumValue = new AtomicLong();
  int aveLength = arr.length / 4;
  Thread td1 = new Thread(() -> {
   for (int i = 0; i < aveLength; i++) {
    sumValue.addAndGet(arr[i]);
   }
  });
  Thread td2 = new Thread(() -> {
   for (int i = aveLength; i < aveLength * 2; i++) {
    sumValue.addAndGet(arr[i]);
   }
  });
  Thread td3 = new Thread(() -> {
   for (int i = aveLength * 2; i < aveLength * 3; i++) {
    sumValue.addAndGet(arr[i]);
   }
  });
  Thread td4 = new Thread(() -> {
   for (int i = aveLength * 3; i < arr.length; i++) {
    sumValue.addAndGet(arr[i]);
   }
  });
  td1.start();
  td2.start();
  td3.start();
  td4.start()
  return sumValue.get();
 }

 public static void main(String[] args){
  int[] arr = new int[4000000];
  generateRandomArray(arr);
  long sum = sum(arr);
  System.out.println("Sum: " + sum);
 }
}
