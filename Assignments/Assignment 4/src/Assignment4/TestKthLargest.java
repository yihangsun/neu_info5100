package Assignment4;
public class TestKthLargest extends KthLargest{
	public static void main(String[] args) {
		int[] nums = new int[] {-1, 3, 2, 100, 5, -10, 8 , 77};
		
		System.out.println(findKthLargest(nums, 3));
		System.out.println(findKthLargest(nums, 2));
		System.out.println(findKthLargest(nums, nums.length));
		System.out.println("------");
		
		int[] nums2 = new int[] {};
		System.out.println(findKthLargest(nums2, 0));
	}
}
