public class Challenge2 {
    public static int duplicatenumber(int arr[]){
        for(int i=0;i<=arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    System.out.println("Duplicate number:"+arr[i]);
                }
            }
            
        }  return -1;
    }
    public static void main(String[] args) {
        Challenge2 c=new Challenge2();
        //Test case 1
        int[] arr1={1,3,4,2,2};
        c.duplicatenumber(arr1);

        //Test case 2
        int[] arr2={3,1,3,4,2};
        c.duplicatenumber(arr2);

        //Test case 3
        int[] arr3={1,1};
        c.duplicatenumber(arr3);

        //Test case 4
        int[] arr4={1,4,4,2,3};
        c.duplicatenumber(arr4);  

        //Test case 5
        int n = 99999;
        int[] arr5 = new int[n + 1];
        for(int i = 0; i < n; i++){
            arr5[i] = i + 1;
        }
        arr5[n] = 50000; 
        c.duplicatenumber(arr5);
    }
}
