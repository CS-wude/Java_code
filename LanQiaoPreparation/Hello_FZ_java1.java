package one_month;

public class Hello_FZ_java1 {
	public int dfs(int[] nums, int target, int i , int j) {
		if(i > j) {
			return -1;
		}
		int m = (i + j)/2;
		if(nums[m] < target) {
			return dfs(nums, target, m+1, j);
		} else if(nums[m] > target) {
			return dfs(nums, target, i, m-1);
		}else {
			return m;
		}
	}
	public int binarySearch(int[] nums, int target) {
		int n = nums.length;
		return dfs(nums, target, 0, n-1);
	}
}
