import java.util.ArrayList;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station’s index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 解析：
 */
public class GasStation {

    public int gasStation(int[] gas,int[] cost ){
        int total = 0;
        int j = 0   ;
        //用于判断是否可以作为起点，如果小于0就要重新开始计算
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(sum < 0){
                j = i+1;
                sum = 0;
            }
        }
        return total >= 0 ? j : -1;
    }
}
