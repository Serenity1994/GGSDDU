package test;
public class T1 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        //保证顺序性
        //Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        int len = intervals.length;
        int[][] ans = new int[len][];
        ans[0] = intervals[0];
        int ansLastIndex = 0;
        for (int i = 1; i < len;i++) {
            int[] last = ans[ansLastIndex];
            int[] compare = intervals[i];
            if(last[1] < compare[0]){ //当前结束时间小于下一个开始时间,不连续,直接将下一个添加到数组
                ans[++ansLastIndex] = intervals[i];
            } else if(last[1] <= compare[1]){ //当前结束时间大于下一个开始时间,但小于或等于下一个结束时间,将当前结束时间改为下一个的结束时间
                last[1] = compare[1];
            }else {} //当前结束时间大与下一个的结束时间
        }
        int[][] ansCompact = new int[ansLastIndex + 1][2];
        System.arraycopy(ans, 0, ansCompact, 0, ansLastIndex + 1);
        return ansCompact;
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        int[][] intervals = { {1, 3}, {2, 6}, {8, 10}, {15, 18} };
        int[][] merge = t1.merge(intervals);
        int[][] intervals1 = {{1, 4}, {4, 5}};
        int[][] merge1 = t1.merge(intervals1);
        System.out.println(1);
    }
}
