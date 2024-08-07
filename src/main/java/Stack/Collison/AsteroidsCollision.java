package Stack.Collison;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class AsteroidsCollision {

    // without stack
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> result = new ArrayList<>();

        for (int asteroid : asteroids) {
            boolean added = true;

            // Process collisions
            while (!result.isEmpty() && asteroid < 0 && result.get(result.size() - 1) > 0) {
                int top = result.get(result.size() - 1);
                int sum = top + asteroid;

                if (sum < 0) {
                    // The top asteroid is destroyed, remove it
                    result.remove(result.size() - 1);
                } else if (sum > 0) {
                    // The incoming asteroid is destroyed
                    added = false;
                    break;
                } else {
                    // Both asteroids are destroyed
                    result.remove(result.size() - 1);
                    added = false;
                    break;
                }
            }

            // If the asteroid was not destroyed, add it to the result list
            if (added) {
                result.add(asteroid);
            }
        }

        return result.stream().mapToInt(a -> a).boxed().mapToInt(a -> a).toArray();
    }

    public int[] asteroidCollisionWithoutStack(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int sum = a + stack.peek();
                if (sum < 0) {
                    stack.pop();
                } else if (sum > 0) {
                    a = 0;
                    break;
                } else {
                    stack.pop();
                    a = 0;
                }
            }

            if (a != 0) {
                stack.push(a);
            }
        }

        int size = stack.size();
        int[] result = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;

    }

}