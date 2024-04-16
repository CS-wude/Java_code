/*
 * package one_month;
 * 
 * import java.util.ArrayList; import java.util.Arrays; import java.util.List;
 * import java.util.PriorityQueue;
 * 
 * public class day13j12_GPS { static class Edge implements Comparable<Edge>{
 * int to,weight; public Edge(int to,int weight) { this.to = to;this.weight =
 * weight; } public int comparaTo(Edge other) { return
 * Integer.compare(this.weight, other.weight); } } static final int maxn =
 * 10003, inf = 1 << 29; static int N,M; static List<Edge>[] va = new
 * ArrayList[maxn],vb = new ArrayList[maxn],v = new ArrayList[maxn]; static
 * int[][] dist = new int[3][maxn]; static int dij(List<Edge>[] v, int a, int
 * src) { Arrays.fill(dist[a], inf); dist[a][src] = 0; PriorityQueue<Edge> pq =
 * new PriorityQueue<>(); pq.add(new Edge(src, 0));
 * 
 * } public static void main(String[] args) {
 * 
 * } }
 */