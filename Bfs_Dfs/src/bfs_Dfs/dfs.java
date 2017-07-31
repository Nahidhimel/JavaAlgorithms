/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs_Dfs;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Nahid H Himel
 */
public class dfs {
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
        DFS(aList);
    }
    static String []color;
    static String []prev;
    static int time;
    public static void DFS(Object[] G) {
        color=new String[G.length];
        time=0;
        prev=new String[G.length];
        
        for (int u = 0; u < G.length; u++) {
            color[u] = "w";
            prev[u] = "nil";
        }
        time = 0;
        for (int u = 0; u < G.length; u++) {
            if (color[u].equals("w")) {
                DFS_Visit(u);
            }
        }
        int c=0;
        for (int i = 0; i < prev.length; i++) {
            if(prev[i].equals("nil")){
                c++;
            }
        }
        System.out.println(c);
    }
    public static void DFS_Visit(int u) {
        color[u] = "G";
        time+=1;
        int v;
        for (int i = 0; i < ((ArrayList<Integer>) aList[u]).size(); i++) {
                v = ((ArrayList<Integer>) aList[u]).get(i);
                if (color[v].equals("w")) {
                    prev[v]=""+u;
                    DFS_Visit(v);
                }
            }
        color[u]="B";
        time+=1;
        
    }
}

    

