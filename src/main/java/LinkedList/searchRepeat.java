package LinkedList;

import java.util.Arrays;

public class searchRepeat {
    public static void main(String[] args) {

    }
    public static int findDuplicate(int[] nums) {
        //快慢指针
        int slow = 0, fast = 0;
        do {
            //slow走一步，fast走两步
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        //已经找到环中的节点，需要找到入环的第一个节点
        //fast从头开始
        fast = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[fast];
    }
}
