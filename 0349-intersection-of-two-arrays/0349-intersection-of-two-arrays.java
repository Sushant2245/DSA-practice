class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> list= new HashSet<>();
        Set<Integer> set= new HashSet<>();
        for(int n:nums1){
            set.add(n);
        }
        for(int i:nums2){
            if(set.contains(i)) list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}