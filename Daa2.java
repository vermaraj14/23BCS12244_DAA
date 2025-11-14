import java.util.HashMap;

public class Daa2 {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k); 
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String args[]){
        int[] arr={1,2,3};
        int k=3;
        System.out.println(subarraySum(arr, k));
    }
}
