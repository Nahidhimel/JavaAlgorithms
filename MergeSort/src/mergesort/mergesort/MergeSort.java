/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02.mergesort;

/**
 *
 * @author User
 */
public class MergeSort {
   // private int[] arr;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] a = {45,4,6,3,34,67,9};
        MergeSort ms = new MergeSort();
        int[] mergesort = new int[a.length];
        mergesort=ms.mergeSort(a,a.length);
        for(int x=0;x<a.length;x++){
            System.out.print(mergesort[x]+" ");
        }
        System.out.println();
        
        // TODO code application logic here
    }
        public static int[] mergeSort(int[] S, int c){
            if(c==1){
                return S;
            }
            else{
                int size1 = (int)Math.ceil(c/2);
                int size2 = c-size1;
                int S1[] = new int[size1];
                for(int i=0;i<size1;i++){
                    S1[i]=S[i];
                }
                int[] a = new int[size1];
                a = mergeSort(S1,S1.length);
                int S2[] = new int[size2];
                int j=0;
                for(int i=size1;i<=S.length-1;i++){
                    S2[j]=S[i];
                    j++;
                }
                int [] b = new int[size2];
                b = mergeSort(S2,S2.length);
                return(merge(a,b));
                
            }
    }
        
        public static int[] merge(int[] S1, int[] S2){
            int n1 = S1.length;
            int n2 = S2.length;
            int n = n1 + n2;
            int[] C = new int[n];
            int i = 0, j = 0;
            int k = 0;
            while (i < S1.length && j < S2.length) {
                if (S1[i] <= S2[j]) {
                C[k] = S1[i];
                i++;
            } else {
                C[k] = S2[j];
                j++;
            }
            k++;
        }
        if (i < S1.length || j < S2.length) {
            if (i >= S1.length) {
                for (; j <= S2.length-1; j++) {
                    C[k] = S2[j];
                    k++;
                }
            } else if (j >= S2.length) {
                for (; i <= S1.length-1; i++) {
                    C[k] = S1[i];
                    k++;
                }
            }
        }
        return C;
    }
}
