package go.jacob.day0323.toutiao;


import java.util.*;

public class Demo3 {

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);

        int count=in.nextInt();

        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count=in.nextInt();
        int []result=new int[]{Integer.MAX_VALUE};

        helper(1,1,0,result,count);

        System.out.println(result[0]);


    }

    public static void helper(int m,int s,int step,int []result,int count){
        if(s>count){
            return;
        }
        if(s==count){
            result[0]=Math.min(step,result[0]);
        }

        helper(s,s*2,step+1,result,count);
        helper(m,s+m,step+1,result,count);

    }


}
