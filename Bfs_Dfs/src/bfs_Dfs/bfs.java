/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs_Dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Nahid H Himel
 */
public class bfs {
     static Object[] aList;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner h = new Scanner(System.in);
        int vert = h.nextInt();
        int edge = h.nextInt();
        aList = new Object[vert];
        for (int i=0;i<vert;i++){
            aList[i]= new ArrayList();
        }
        int x,y;
        for(int j=edge;j>0;j--){
            x=h.nextInt();
            y=h.nextInt();
            ((ArrayList<Integer>) aList[x]).add(y);
            ((ArrayList<Integer>) aList[y]).add(x);
        }
        BFS(aList,0);
    }
    static String []color;
    static String []prev;
    static int[] d;
    static int time;
    public static void BFS(Object[]G, int s){
        color = new String[G.length];
        prev = new String[G.length];
        d = new int[G.length];
        
        for(int u=0;u<G.length;u++){
            color[u]="w";
            prev[u]="nil";
            d[u]=0;
        }
        color[s]="G";
        prev[s]="nil";
        d[s]=0;
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(s);
        while(!Q.isEmpty()){
            int u = Q.poll();
            int v = 0;
            for(int i =0; i<((ArrayList<Integer>) G[u]).size(); i++){
                v = ((ArrayList<Integer>) G[u]).get(i);
                if(color[v].equals("w")){
                    color[v]= "G";
                    prev[v]=""+u;
                    d[v]=d[u]+1;
                    Q.add(v);
                }
            }
            color[u]="B";
        }
        for(int j =0;j<d.length;j++){
            System.out.print(d[j]+"");
        }
        System.out.println();
    }
}

   
