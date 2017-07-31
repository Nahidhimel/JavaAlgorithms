/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bellman.ford;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nahid H Himel
 */
public class BellmanFord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws  Exception {
        // TODO code application logic here
        Scanner h = new Scanner(new File("book.txt"));
        int vert = h.nextInt();
        int edge = h.nextInt();
        ArrayList arr[] = new ArrayList[vert];
        for(int i=0;i<vert;i++){
            arr[i]= new ArrayList();
        }
        
        int x,y,z;
        int [][]w = new int [vert][vert];
        for(int j=edge;j>0;j--){
            x=h.nextInt();
            y=h.nextInt();
            z=h.nextInt();
            (arr[x]).add(y);
            w[x][y]=z;
        }
        System.out.println(bellmanFord(arr,w,0));
    }
    
    public static boolean bellmanFord(ArrayList[] G, int[][]w, int s) throws Exception{
        int[] d = new int[G.length];
        int[] prev = new int[G.length];
        for (int i = 0; i < G.length; i++) {
            d[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }
        d[s] = 0;
        for (int i = 0; i < G.length-1; i++) {
            for (int u = 0; u < G.length; u++) {
                for (int j = 0; j < G[u].size(); j++) {
                    int v = (int) G[u].get(j);
                    Relax(u, v, w, d, prev);
                }
            }
        }
        for (int u = 0; u < G.length; u++) {
            for (int j = 0; j < G[u].size(); j++) {
                int v = (int) G[u].get(j);
                if (d[v] > d[u] + w[u][v]){
                    throw new Exception("Negative cycle");
                }
            }
        }
        int[][]st = new int[G.length][G.length];
        for(int a =1;a<st.length;a++){
            st[prev[a]][a] = d[a];
            
        }
        for(int b=0; b<st.length;b++){
            for(int c=0; c< st.length;c++){
                System.out.print(st[b][c]+" ");
            }
            System.out.println(" ");
        }
        return true;
    }
    public static void Relax(int u, int v, int[][]w, int[]d, int[] prev){
        if (d[v] > d[u] + w[u][v]) {
            d[v] = d[u] + w[u][v];
            prev[v] = u;
        }
    }
}
