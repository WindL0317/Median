import java.util.Arrays;
import java.util.Scanner;


public class Median {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int []x=new int[n];
        int []y=new int [n];
        for(int i=0;i<n;i++){
            x[i]=s.nextInt();
        }
        for(int i=0;i<n;i++){
            y[i]=s.nextInt();
        }
        System.out.print(Median(x,y,n));
    }

    public static float middle(int a[]){
        float mid;
        int l=a.length;
        if(l%2==0){
            mid=(float)(a[l/2-1]+a[l/2])/2;
        }else{
            mid=a[l/2];
        }
        return mid;
    }

    public static float Median(int x[],int y[],int n){
        float mx=middle(x);
        float my=middle(y);
        float med=0;
        if(n==1){
            return (mx+my)/2;
        }
        else{
            if(mx==my){
                return mx;
            }else if(mx>my){
                int []x2=Arrays.copyOfRange(x, 0, (int) Math.ceil((float)n/2));  //当n为奇数时，需要用Math.ceil函数，保证两个数组的个数和新n保持一致
                int []y2=Arrays.copyOfRange(y, n/2, n);
                n=(int) Math.ceil((float)n/2);
                med=Median(x2,y2,n); //函数返回为float类型，所以每次将返回的中值赋值给zhw
            }else if(mx<my){
                int []x2=Arrays.copyOfRange(x, n/2, n);
                int []y2=Arrays.copyOfRange(y, 0, (int) Math.ceil((float)n/2));
                n=(int) Math.ceil((float)n/2);
                med=Median(x2,y2,n);
            }
        }
        return med;
        //因为用到了递归，所以返回中值给上一层
    }
}
