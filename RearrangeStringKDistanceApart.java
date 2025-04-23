import java.util.*;

public class RearrangeStringKDistanceApart {

    static class CharFreq {
        char ch;
        int freq;

        CharFreq(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static String rearrangeString(String s, int k) {
        if (k == 0) return s;

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray())
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

        PriorityQueue<CharFreq> maxHeap = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq
        );

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet())
            maxHeap.offer(new CharFreq(entry.getKey(), entry.getValue()));

        Queue<CharFreq> waitQueue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            CharFreq current = maxHeap.poll();
            result.append(current.ch);
            current.freq--;

            waitQueue.offer(current);

            if (waitQueue.size() >= k) {
                CharFreq front = waitQueue.poll();
                if (front.freq > 0)
                    maxHeap.offer(front);
            }
        }

        return result.length() == s.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(rearrangeString("aabbcc", 3)); // Output: abcabc
        System.out.println(rearrangeString("aaabc", 3));  // Output: (empty string)
        System.out.println(rearrangeString("aaadbbcc", 2)); // Output: abacabcd (or valid variant)
    }
}
