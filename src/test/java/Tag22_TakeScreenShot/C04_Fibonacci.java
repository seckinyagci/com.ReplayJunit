package Tag22_TakeScreenShot;

public class C04_Fibonacci {
    public static void main(String[] args) {
        long n1 = 0, n2 = 1, sum = 0;


        System.out.println(n1+" "+n2);
        for (int i = 2; i < 100; i++) {
            sum=n1+n2;

            System.out.print(" "+sum);
            n1=n2;
            n2=sum;

        }
    }

}
