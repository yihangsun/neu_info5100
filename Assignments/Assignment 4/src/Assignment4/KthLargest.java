package Assignment4;
//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//Example 1:
//
//Input: [3, 2, 1, 5, 6, 4] and k = 2 Output: 5
//
//Example 2:
//
//Input: [3,2,3,1,2,4,5,5,6] and k = 4 Output: 4
//
//Note:
//
//You may assume k is always valid, 1 ≤ k ≤ array's length.
//Implement the test cases in class Test's main method. Please don't forget to consider about the corner cases.
import java.util.*;

public class KthLargest {
	
	public static int findKthLargest(int[] nums, int k) {
		// if nums is empty, print smallest value
		int result = Integer.MIN_VALUE;
		if (nums.length == 0) return result;
		// create a max heap to sort int[] nums in descending order 
		PriorityQueue<Integer> pq= new PriorityQueue<>((a, b) -> b - a);
		for (int num : nums) {
			pq.add(num);
		}
		for (int i = 0; i < k; i++) {
			result = pq.poll();
		}
		return result;
	}
}

