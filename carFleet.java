class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n == 0) {
            return 0;
        }
        Car[] cars = new Car[n];
        for(int i = 0;i < n;i++) {
            cars[i] = new Car(position[i],(double)(target - position[i]) / speed[i]);
        } 
        //对每辆车的初始位置升序排序
        Arrays.sort(cars,new Comparator<Car>() {
            public int compare(Car o1,Car o2) {
                return o1.position - o2.position;
            }
        });
        int t = n - 1;
        int count = 1;
        while(t > 0) {
            if(cars[t].time < cars[t - 1].time) { //后车追不上前车，前车算一个车队
                count++;
            }else {
                cars[t - 1] = cars[t];
            }
            t--;
        }
        return count;
    }
}
class Car {
    int position;
    double time;
    Car(int p, double t) {
        position = p;
        time = t;
    }
}