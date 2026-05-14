import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        /**
        양수랑 음수 뽀뽀쪽하면 터진다고 음
        그럼 스택에 숫자를 넣는데 다음 숫자가 반대편 숫자면 결투
        다 터지고 남은 거 출력
        */
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            // 넣기 전에 확인 부호가 같으면 걍 넣고 아니면 난리남
            if (stack.isEmpty() || stack.peek() < 0 || (stack.peek() > 0 && asteroids[i] > 0)) {
                stack.push(asteroids[i]);
            } else {
                // 넣는 게 더 크면 같거나 작아질 때까지 반복
                if (!stack.isEmpty() && stack.peek() < -asteroids[i]) {
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroids[i]) {
                        stack.pop();
                    }
                    if (stack.isEmpty() || Math.signum(stack.peek()) == Math.signum(asteroids[i])) stack.push(asteroids[i]);
                }
                // 같으면 빼고 넘어가기
                if (!stack.isEmpty() && stack.peek() == -asteroids[i]) {
                    stack.pop();
                }
                // 작으면 안 넣기
            }
        }

        int[] arr = new int[stack.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - (i + 1)] = stack.pop();
        }
        return arr;
    }
}