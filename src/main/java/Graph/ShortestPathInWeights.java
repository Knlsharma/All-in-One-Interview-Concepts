package Graph;

/**
 * @author kunal sharma
 */

import java.io.*;
import java.util.*;

public class ShortestPathInWeights {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int vtx;
        String psf;
        int wsf;

        Pair(int vtx, String psf, int wsf){
            this.vtx = vtx;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair o){
            return this.wsf - o.wsf;
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
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());

        // write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, src + "", 0));
        boolean[] visited = new boolean[vtces];

        while(pq.size() > 0){
            Pair rem = pq.remove(); // remove

            if(visited[rem.vtx]){   // if already visited continue
                continue;
            }
            visited[rem.vtx] = true;  // visite vertex

            System.out.println(rem.vtx + " via " + rem.psf + " @ " + rem.wsf);  // print
            for(Edge e: graph[rem.vtx]){      // visite its neighbour if not visited
                if(!visited[e.nbr]){
                    pq.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt));
                }
            }
        }
    }

    // TC : Vlog(E)
    // Algo Djkstra => DP
    // Not work on -ive edges
}