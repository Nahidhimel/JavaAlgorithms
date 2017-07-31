/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lcs;


import java.util.Scanner;


/**
 *
 * @author User
 */
public class LCS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner h = new Scanner(System.in);
        String s1 = h.nextLine();
        String s2 = h.nextLine();
        String Lcs = lcs(s1,s2);
    }

    public static String lcs(String str1, String str2) {

        int i, j;
        String x = str1;  

        String y = str2;   

        int n = x.length();
        int m = y.length();
        int[][] length = new int[n + 1][m + 1];
        int[][] d = new int[n + 1][m + 1];

        for (i = 0; i <= n; i++) {
            length[i][0] = 0;
        }

        for (j = 0; j <= m; j++) {
            length[0][j] = 0;
        }

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    length[i][j] = length[i - 1][j - 1] + 1;
                    d[i][j] = 1;
                } else if (length[i - 1][j] >= length[i][j - 1]) {
                    length[i][j] = length[i - 1][j];
                    d[i][j] = 2;
                } else {
                    length[i][j] = length[i][j - 1];
                    d[i][j] = 3;
                }
            }
        }
        /* Print */
        String lcs = new String();
        i = n;
        j = m;
        while (i != 0 && j != 0) {
            if (d[i][j] == 1) {   /* diagonal */

                lcs = x.charAt(i - 1) + lcs;
                i = i - 1;
                j = j - 1;
            } else if (d[i][j] == 2) {  /* up */

                i = i - 1;
            } else if (d[i][j] == 3) {  /* backword */

                j = j - 1; 
            }
        }

        System.out.println("String X is " + x);
        System.out.println("String Y is " + y);
        System.out.println("The length of LCS is " + length[n][m]);
        System.out.println("The LCS is " + lcs);

        return lcs;
    }

}
