package go.jacob.day0323.toutiao;

public class Demo5 {
    public static void main(String[] args) {
        System.out.println(3.6666>3);
        System.out.println(1.222==1.222);
    }

    public static void main1(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] arr1=new int[n];
//        int[] arr2=new int[m];
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//
//        for(int i=0;i<n;i++){
//            arr1[i]=sc.nextInt();
//        }
//        for(int i=0;i<m;i++){
//            arr2[i]=sc.nextInt();
//        }

        int[] arr1={1,2,5};
        int[] arr2={2,3,4,5,6};

        double avg1=avg(arr1);
        double avg2=avg(arr2);

        int res=0;
        if(avg1<avg2){
            for(int i=0;i<arr2.length;i++){
                if(arr2[i]>avg2)
                    break;
                if(arr2[i]>=avg1)
                    res++;
            }
        }else if(avg1>avg2){
            for(int i=0;i<arr1.length;i++){
                if(arr1[i]>avg1)
                    break;
                if(arr1[i]>=avg2)
                    res++;
            }
        }else
            res=1;
        System.out.println(res);

    }

    private static double avg(int[] arr) {
        int res=0;
        for(int i=0;i<arr.length;i++){
            res+=arr[i];
        }

        return (double)res/arr.length;
    }
}
