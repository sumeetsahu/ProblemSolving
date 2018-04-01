import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static HashMap<Integer,Node> lookUpNode = new
HashMap<Integer,Node>();

    static class Node{
        private int id;
        LinkedList<Node> adjecent = new LinkedList<Node>();
        public Node(int id){
            this.id = id;
        }
    }
    static Node getNode(int id){
       return lookUpNode.get(id);
    }
    static void addEdge(int source,int destination){
        Node s = getNode(source-1);
        Node d = getNode(destination-1);
        s.adjecent.add(d);
    }
    static int[] shortestPath(Node source,int n){
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(source);
        int k = lookUpNode.size();
        int[] distance = new int[n];
        int[] result = new int[n-1];
        Arrays.fill(distance,-1);
        distance[source.id] = 0;
        int lvl=0;
        // System.out.println("D:"+distance.length+" N:"+n);
        while(!queue.isEmpty()){
            Node node = queue.pop();
            lvl++;
            for(Node child:node.adjecent){
                // System.out.println(child.id +" ="+distance.length);
                if(distance[child.id] == -1){
                    distance[child.id] = distance[node.id] + 6;
                    // distance[child.id-1] = 0 + 6;
                    // System.out.println(child.id +" = "+ distance[child.id]);
                    //queue.add(child);
                }
                else {
                    if(distance[child.id] > (distance[node.id] + 6)){
                        distance[child.id] = distance[node.id] + 6;
                    }
                        
                }
                
                queue.add(child);
            }
        }
        int count = 0;
        for(int dis: distance){
            if(dis == 0){
                continue;
            }
            result[count] = dis;
            count++;

        }

        Arrays.fill(distance,-1);

        return result;

    }

    static int[] bfs(int n, int m, int[][] edges, int s) {
        // Complete this function

        int[] result = new int[2*m];
        int count = 0;
        for(int i=0; i<n;i++){
            Node node = new Node(i);
            lookUpNode.put(i,node);
        }

        for(int edges_i = 0; edges_i < m; edges_i++){
            addEdge(edges[edges_i][0],edges[edges_i][1]);

            }


        return shortestPath(getNode(s-1),n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] edges = new int[m][2];
            for(int edges_i = 0; edges_i < m; edges_i++){
                for(int edges_j = 0; edges_j < 2; edges_j++){
                    edges[edges_i][edges_j] = in.nextInt();
                }
            }
            int s = in.nextInt();
            int[] result = bfs(n, m, edges, s);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " "
: ""));
            }
            System.out.println("");


        }
        in.close();
    }
}