class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map= new HashMap<>();
        List<Integer> li= new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for(int num:nums2){
            if(map.containsKey(num)){
                li.add(num);
                map.put(num,map.getOrDefault(num,0)-1);
                if(map.get(num)==0){
                    map.remove(num);
                }
            }
        }
        int result[]= new int[li.size()];
        for(int i=0;i<li.size();i++){
            result[i]=li.get(i);
        }
        return result;
    }
}