package test;


public class T3 {
    public int minPath(int n, int[][] edges, int start, int end) {
        if(start == end) return 0;
        int ans = -1;
        int[][] g = new int[n + 1][n + 1];
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                g[i][j] = Integer.MAX_VALUE;
                if (i == j) g[i][j] = 0;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            int d1 = edges[i][0];
            int d2 = edges[i][1];
            g[d1][d2] = edges[i][2];
            g[d2][d1] = edges[i][2];
        }
        int[] s = new int[n+1];
        int[] shortPath = new int[n+1]; // 保存start到其他各点的最短路径
        int[] visited = new int[n+1]; // 标记当前该顶点的最短路径是否已经求出,1表示已求出
        shortPath[start] = 0;
        visited[start] = 1;
        for (int i = 1; i <= n; i++) {
            int minIndex = 0;//剩余节点中最小的那个的下标
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if (visited[j] == 0 && g[start][j] < min) {
                    min = g[start][j];
                    minIndex = j;
                }
            }
            shortPath[minIndex] = min;
            visited[minIndex] = 1;
            // 更新剩余节点
            for (int j = 1; j <= n; j++) {
                if (visited[j] == 0 && (g[start][minIndex] | g[minIndex][j]) < g[start][j]) {
                    g[start][j] = g[start][minIndex] | g[minIndex][j];
                }
            }
        }
        return shortPath[end] == 0 ? -1 : shortPath[end];
    }

    public static void main(String[] args) {
        T3 t3 = new T3();
        int[][] edges =  {{1,2,1},{2,3,3},{1,3,2}};
        int minPath = t3.minPath(3, edges, 1, 3);
        System.out.println(minPath);
    }
}
