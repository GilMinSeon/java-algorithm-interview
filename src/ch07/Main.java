package src.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;
import java.util.stream.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// BOJ 18428 감시피하기
public class Main {

    public static void main(String[] args) {
        //int res = trap(new int[]{3, 1, 1, 1, 4});
        int res = trap(new int[]{4,3,2,1,5});
        System.out.println(res);
    }

    public static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            // 변곡점을 만나는 경우
            System.out.println("i >>>>" + i);
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                System.out.println("스택 진입");
                // 스택에서 꺼낸다.
                Integer top = stack.pop();

                if (stack.isEmpty())
                    break;

                // 스택의 마지막 위치까지를 거리로 계산
                int distance = i - stack.peek() - 1;
                System.out.println(stack.peek() + "      !!!!");
                // 현재 높이 또는 스택의 마지막 위치 높이 중 낮은 값에 방금 꺼낸 높이의 차이를 물 높이로 지정
                int waters = Math.min(height[i], height[stack.peek()]) - height[top];

                System.out.println("waters >>>>" + waters + "    distance :::" + distance);
                // 물이 쌓이는 양은 거리와 물 높이의 곱
                volume += distance * waters;
                System.out.println("vol :::" + volume);

            }

            // 진행하면서 현재 위치를 스택에 삽입
            stack.push(i);
            System.out.println("stack >>" + stack);
            System.out.println(i + "    for문 end");
            System.out.println();

        }
        return volume;
    }
}


