class Solution {
    public int candy(int[] ratings) {
        int i=1;
        int sum=1;
        while(i<ratings.length){
            if(ratings[i]==ratings[i-1]){
                sum++;
                i++;
                continue;
            }
            int peak=1;
            while(i<ratings.length && ratings[i]>ratings[i-1]){
                peak++;
                sum+=peak;
                i++;
            }
            int down=1;
            while(i<ratings.length && ratings[i]<ratings[i-1]){
                sum+=down;
                i++;
                down++;
            }
            if(down>peak){
                sum+=down-peak;
            }


        }
        return sum;
    }
}