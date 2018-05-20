package go.jacob.day0322.meituan;

import org.junit.Test;

import java.util.Scanner;

public class Counter {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String s = scanner.next();
                int[] arr = new int[10];
                for (int i = 0; i < s.length(); i++) {
                    arr[s.charAt(i) - '0']++;
                }
                arr[0]++;
                int n = 1;
                int idx = 0;
                while (arr[idx] != 0) {
                    arr[idx]--;
                    idx++;
                    if (idx > 9) {
                        idx = 0;
                        n++;
                    }
                }
                String res = "";
                if (idx == 0) {
                    res = res + "1";
                    n--;
                }
                for (int i = 0; i < n; i++)
                    res += idx;
                System.out.println(res);


            }
        }



    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.next();
        int[] arr=new int[10];

        for(char c:str.toCharArray()){
            arr[c-'0']++;
        }

        if(arr[0]==0){
            System.out.println(0);
            return;
        }


        int minCount=Integer.MAX_VALUE;
        int index=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]<minCount) {
                minCount = arr[i];
                index=i;
            }
        }
        StringBuilder res=new StringBuilder();
        if(index==0){
            int newMinCount=Integer.MAX_VALUE;
            int newIndex=1;
            for(int i=1;i<arr.length;i++){

                if(arr[i]<newMinCount) {
                    newMinCount = arr[i];
                    newIndex=i;
                }
            }

            if(newMinCount>=minCount+2){
                res.append("1");
                for(int i=0;i<minCount+1;i++){
                    res.append("0");
                }
                System.out.println(res.toString());
                return;
            }else{

                for(int i=0;i<newMinCount;i++){
                    res.append(newIndex);
                }
                System.out.println(res.toString());
                return;
            }


        }


    }
    @Test
    public void testm(){
        test("1122334455667788990");
    }


    public void test(String str){
        int[] arr=new int[10];

        for(char c:str.toCharArray()){
            arr[c-'0']++;
        }

        if(arr[0]==0){
            System.out.println(0);
            return;
        }


        int minCount=Integer.MAX_VALUE;
        int index=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]<minCount) {
                minCount = arr[i];
                index=i;
            }
        }
        StringBuilder res=new StringBuilder();
        if(index==0){
            int newMinCount=Integer.MAX_VALUE;
            int newIndex=1;
            for(int i=1;i<arr.length;i++){

                if(arr[i]<newMinCount) {
                    newMinCount = arr[i];
                    newIndex=i;
                }
            }

            if(newMinCount>=minCount+2){
                res.append("1");
                for(int i=0;i<minCount+1;i++){
                    res.append("0");
                }
                System.out.println(res.toString());
                return;
            }else{

                for(int i=0;i<newMinCount;i++){
                    res.append(newIndex);
                }
                System.out.println(res.toString());
                return;
            }


        }


    }
}
