package com.algo.stack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

//Problem: https://leetcode.com/problems/car-fleet/description/
//Problem: https://neetcode.io/problems/car-fleet/question
public class CarFleet853 {
    static void main() {
        int[] position = {6, 8};
        int[] speed = {3, 2};
        int target = 10;
        System.out.println(countFleet(position, speed, target));
    }

    private static int countFleet(int[] position, int[] speed, int target) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < speed.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        cars.sort(Comparator.comparing(Car::pos).reversed());
        Stack<Float> stack = new Stack<>();
        for (Car car : cars) {
            var tta = (float) (target - car.pos) / car.speed;
            if (stack.isEmpty() || tta > stack.peek()) {
                stack.push(tta);
            }

        }
        return stack.size();
    }

    private record Car(int pos, int speed) {
    }
}
