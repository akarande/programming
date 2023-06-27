package leetcode.practice2020;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author akarande
 **/
public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int b : barcodes) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        Comparator< Map.Entry<Integer,Integer> > descFreqComparator = (e1, e2) -> e2.getValue() - e1.getValue();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(descFreqComparator);
        for(Map.Entry entry : map.entrySet()) queue.offer(entry);
        int result[] = new int[barcodes.length];
        int k = 0;
        while(!queue.isEmpty()) {
            Map.Entry<Integer, Integer> firstEntry = queue.poll();
            Map.Entry<Integer, Integer> secondEntry = queue.poll();
            result[k++] = firstEntry.getKey();
            if(secondEntry == null) break;
            result[k++] = secondEntry.getKey();
            map.put(firstEntry.getKey(), map.get(firstEntry.getKey()) - 1);
            map.put(secondEntry.getKey(), map.get(secondEntry.getKey()) - 1);
            checkAndRemove(firstEntry, queue, map);
            checkAndRemove(secondEntry, queue, map);
        }
        return result;
    }

    private void checkAndRemove(Map.Entry<Integer, Integer> mapEntry, PriorityQueue<Map.Entry<Integer, Integer>> queue, Map<Integer, Integer> map) {
        if(map.get(mapEntry.getKey()) == 0) {
            queue.remove(mapEntry);
            map.remove(mapEntry.getKey());
        }
        else {
            mapEntry.setValue(map.get(mapEntry.getKey()));
            queue.offer(mapEntry);
        }
    }

    public static void main(String[] args) {
        DistantBarcodes distantBarcodes = new DistantBarcodes();
        int a[] = {7,7,7,8,5,7,5,5,5,8};//{1,1,2};//{3,4,4,4,2,1,3,5,5,2,2,1};
        int[] ans = distantBarcodes.rearrangeBarcodes(a);
        System.out.println("ans = " + Arrays.toString(ans));
    }
}
