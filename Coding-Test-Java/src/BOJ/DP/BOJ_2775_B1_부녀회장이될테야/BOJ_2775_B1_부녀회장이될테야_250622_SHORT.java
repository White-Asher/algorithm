package BOJ.DP.BOJ_2775_B1_부녀회장이될테야;

import java.util.*;
public class BOJ_2775_B1_부녀회장이될테야_250622_SHORT{public static void main(String[] args) throws Exception {int[][]a=new int[15][15];
for(int i=0;i<15;i++)a[0][i]=i;
for(int i=1;i<15;i++)for(int j=1;j<15;j++)a[i][j]=a[i-1][j]+a[i][j-1];
Scanner s=new Scanner(System.in);
for(int t=s.nextInt();t>0;t--)System.out.println(a[s.nextInt()][s.nextInt()]);}}