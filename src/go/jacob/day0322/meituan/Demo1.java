package go.jacob.day0322.meituan;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        String t=sc.next();
        if(s==null||t==null||s.length()<t.length())
            return;
        if(s.length()==0)
            System.out.println(0);
        int n=s.length()-t.length()+1;
        int sum=0;

        for(int i=0;i<n;i++){
            String tmp=s.substring(i,i+t.length());
            for(int j=0;j<tmp.length();j++){
                if(tmp.charAt(j)!=t.charAt(j))
                    sum++;
            }
        }
        System.out.println(sum);

    }

}
