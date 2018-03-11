package go.jacob.day0303.array;

public class P11_ContainerWithMostWater {

    public int maxArea(int[] height) {
        if(height==null||height.length<2)
            return 0;

        int l=0,r=height.length-1;

        int sum=0;

        while(l<r){
            sum=Math.max(sum,(r-l)*Math.min(height[l],height[r]));
            if(height[l]<height[r])
                l++;
            else
                r--;
        }


        return sum;
    }
}
