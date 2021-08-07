package hashmap;

public class MyHashSetUtils {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        MyHashSet myHashSet = new MyHashSet();

        for(int num: nums) {
            if (myHashSet.contains(num)) {
                return true;
            }
            myHashSet.add(num);
        }
        return false;
    }
}
