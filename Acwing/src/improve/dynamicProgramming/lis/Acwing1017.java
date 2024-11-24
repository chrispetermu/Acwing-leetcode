package improve.dynamicProgramming.lis;

import java.util.Scanner;

public class Acwing1017{
    public static void main(String[] args) {

        Scanner read =new Scanner(System.in);
        int [] a=new int[102];
        int [] ans=new int[102];
        int [] ansD=new int[102];
        int k= read.nextInt();
        while(k-->0){
            int n= read.nextInt();
            for (int i = 1; i <=n ; i++) {
                a[i]= read.nextInt();
            }
            int resu=0;
            int resd=0;

            ans[0]=0;


            // LIS 结构
            for (int i = 1; i <=n ; i++) {

                for (int j = 0; j < i; j++) {
                    if (a[i] > a[j]) ans[i] = Math.max(ans[i], ans[j] + 1);
                    resu=Math.max(resu,ans[i]);
                }
                resu=Math.max(resu,ans[i]);
            }
            ansD[n+1]=0;
            for (int i = n; i >=1 ; i--) {
                for (int j = n+1; j >i ; j--) {
                    if (a[i]>a[j]) ansD[i]=Math.max(ansD[i],ansD[j]+1);
                    resd=Math.max(resd,ansD[i]);
                }
                resd=Math.max(resd,ansD[i]);
            }

            int res = 0;
            for (int i = 1; i <= n; ++ i)
            {
                res = Math.max(res, ans[i]);
                res = Math.max(res, ansD[i]);
                ans[i]=0;
                ansD[i]=0;
                a[i]=0;
            }


            System.out.println(res);

        }
    }
}
