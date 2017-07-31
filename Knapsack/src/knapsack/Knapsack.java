/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

/**
 *
 * @author User
 */
public class Knapsack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int wt =9;
        int[] w = {2,3,5};
        int[] p = {4,5,7};
        int n = w.length;
        String s = knapSack(wt,w,p,n);
        System.out.println(s);
    }

    private static String knapSack(int wt, int[] w, int[] p, int n) {
        int [][]k = new int[n+1][wt+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=wt;j++){
                if(i==0 || j==0){
                    k[i][j]=0;
                }
                else if(w[i-1]<= j){
                    k[i][w] = Math.max(p[i-1]+k[i-1][j-wt[i-1]],k[i-1]w);
                }
            }
        }
    }
    
}
