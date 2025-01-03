package Graph;

/**
 * @author Kunal Sharma at 08/05/22 3:49 PM
 */


import java.io.*;
import java.util.*;



public class GraphBFS {

    static class Edge {

        int src;

        int nbr;



        Edge(int src, int nbr) {

            this.src = src;

            this.nbr = nbr;

        }

    }



    static class Pair {

        int vtx;

        String psf;



        Pair(int vtx, String psf){

            this.vtx = vtx;

            this.psf = psf;

        }

    }





    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int vtces = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[vtces];

        for (int i = 0; i < vtces; i++) {

            graph[i] = new ArrayList<>();

        }



        int edges = Integer.parseInt(br.readLine());

        for (int i = 0; i < edges; i++) {

            String[] parts = br.readLine().split(" ");

            int v1 = Integer.parseInt(parts[0]);

            int v2 = Integer.parseInt(parts[1]);

            graph[v1].add(new Edge(v1, v2));

            graph[v2].add(new Edge(v2, v1));

        }



        int src = Integer.parseInt(br.readLine());



        // write your code here

        ArrayDeque<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(src, src + ""));

        boolean[] visited = new boolean[vtces];



        while(queue.size() > 0) {

            // remove, mark*, work as print , add*

            Pair rem = queue.remove();

            if(visited[rem.vtx]){
                continue;
            }

            visited[rem.vtx] = true;

            System.out.println(rem.vtx + "@" + rem.psf);

            for(int i = 0; i < graph[rem.vtx].size(); i++){

                Edge e = graph[rem.vtx].get(i);

                if(!visited[e.nbr]) {
                    queue.add(new Pair(e.nbr, rem.psf + e.nbr));
                }

            }

        }

    }

}