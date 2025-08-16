public class Challenge1 {

    public static void main(String[] args) {
        
        int [] arr={1,2,4,5};

        int sum1=0;

        for(int i=0;i<arr.length;i++){
            sum1+=arr[i];
        }

        int sum2=0;
        for(int i=0;i<=(arr.length+1);i++){
            sum2+=i;
        }

        System.out.println("Missing value is:"+ (sum2-sum1));
    }
}