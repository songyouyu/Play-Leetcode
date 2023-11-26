/**
 * @author youyu.song
 * @date 2020/5/16 10:26
 */
public class Solution {

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * 你可以假设数组中不存在重复的元素。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     *
     * @param nums
     * @param target
     * @return
     */
    int res = -1;
    public int search(int[] nums, int target) {
        // 如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的，
        // 我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边
        //int len = nums.length;
        //int left = 0, right = len-1;
        //while(left <= right){
        //    int mid = (left + right) / 2;
        //    if(nums[mid] == target)
        //        return mid;
        //    else if(nums[mid] < nums[right]){
        //        // 右半段有序
        //        if(nums[mid] < target && target <= nums[right])
        //            left = mid+1;
        //        else
        //            right = mid-1;
        //    }
        //    else{
        //        // 左半段有序
        //        if(nums[left] <= target && target < nums[mid])
        //            right = mid-1;
        //        else
        //            left = mid+1;
        //    }
        //}
        //return -1;

        if (nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        search(nums, l, r, target);
        if (res == -1) {
            return binSearch(nums, 0, len - 1, target);
        } else if (target == nums[res]) {
            return res;
        } else if (nums[0] > target) {
            // nums[res + 1]...nums[r]
            return binSearch(nums, res + 1, len - 1, target);
        } else if (nums[len - 1] < target) {
            // nums[0]...nums[res - 1]
            return binSearch(nums, 0, res - 1, target);
        } else {
            return -1;
        }
    }

    private int binSearch(int[] a, int l, int r, int value) {
        int low = l;
        int high = r;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private void search(int[] nums, int l, int r, int target) {
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            res = mid;
            return;
        }

        if ((mid - 1 >= 0) && (mid + 1 < nums.length)) {
            if ((nums[mid - 1] < nums[mid]) && (nums[mid] > nums[mid + 1])) {
                res = mid + 1;
                return;
            }
            if ((nums[mid - 1] > nums[mid]) && (nums[mid] < nums[mid + 1])) {
                res = mid;
                return;
            }
        }
        if (l == r) {
            return;
        }
        search(nums, l, mid, target);
        search(nums, mid + 1, r, target);
    }

    public int search2(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[l] <= nums[mid]) {
                // 数组左边有序
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 数组右边存在有序连续数据
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 1;
        System.out.println(new Solution().search(nums, target));
    }


}
