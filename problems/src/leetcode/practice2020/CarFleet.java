package leetcode.practice2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author akarande
 * 853. Car Fleet
 * https://leetcode.com/problems/car-fleet/submissions/
 **/
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> list = new ArrayList<>();
        for(int i = 0; i < position.length; i++) {
            list.add(new Car(position[i], speed[i]));
        }
        Collections.sort(list, (a, b) -> b.position - a.position);
        double lastTime = -1.0;
        int fleet = 0;
        for(int i = 0; i < list.size(); i++) {
            Car curr = list.get(i);
            double currTime = 1. * (target - curr.position) / (1. * curr.speed);
            if(lastTime < 0) {
                lastTime = currTime;
                fleet++;
            }
            else if(currTime > lastTime) {
                lastTime = currTime;
                fleet++;
            }
        }
        return fleet;
    }

    class Car {
        int position;
        int speed;
        public Car(int p, int s) {
            this.position = p;
            this.speed = s;
        }
    }

    public static void main(String[] args) {
        CarFleet carFleet = new CarFleet();
        int target = 12;
        int[] speed = {2,4,1,1,3};
        int[] positions = {10,8,0,5,3};
        int ans = carFleet.carFleet(target, positions, speed);
        System.out.println("ans = " + ans);
    }
}
