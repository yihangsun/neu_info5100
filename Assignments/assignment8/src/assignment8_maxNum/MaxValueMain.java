package assignment8_maxNum;

import java.util.Random;

public class MaxValueMain {
	public static void main(String[] args) {
		Random rd = new Random();
		int[] array = new int[400];
		for (int i = 0; i < array.length; i++) {
			array[i] = rd.nextInt();
		}
		MaxValue mv = new MaxValue(array);
		System.out.println(mv.findMax());
	}
}
