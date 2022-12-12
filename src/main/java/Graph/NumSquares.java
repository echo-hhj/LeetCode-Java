package Graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/28/18:15
 * @Description:
 */
public class NumSquares {
    public static int numSquares(int n) {
        Deque<Integer> q = new ArrayDeque<>();
        //根节点0放入队列
        q.push( 0 );
        int count = 0;
        while( !q.isEmpty()) {
            int size = q.size();
            for( int i = 0; i < size; i++ ) {
                int front = q.poll();
                //循环次数是小于n的完全平方数个数
                for( int j = 1, temp = 1; temp <= n; j++ ) {
                    temp = j * j;
                    //如果满足根节点=n，直接return
                    if( temp + front == n ) {
                        return count + 1;
                    }
                    //如果根节点>n,不满足条件，退出循环
                    if( temp + front > n ) {
                        break;
                    }
                    //满足条件的根节点入队列
                    q.offer( temp + front );
                }
            }
            count++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
