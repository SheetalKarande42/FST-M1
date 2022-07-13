package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] values={10, 77, 10, 54, -11, 10};
        int sum =0;
        for(int i=0;i<values.length;i++){
                if(values[i]==10) {
                    sum = sum + values[i];
                }
        }
        System.out.println("sum - "+sum);
    }
}
