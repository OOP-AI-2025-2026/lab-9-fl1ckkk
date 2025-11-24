package ua.opnu;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = (list.size() / 2) * 2 - 2; i >= 0; i -= 2) {
            String s1 = list.get(i);
            String s2 = list.get(i + 1);

            if (s1.length() <= s2.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            String s = list.get(i);
            list.add(i + 1, s);
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return true;
        }

        java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            stack.push(n);
            queue.add(n);
        }

        boolean isPal = true;

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            int reverseN = stack.pop();

            if (n != reverseN) {
                isPal = false;
            }

            queue.add(n);
        }

        return isPal;
    }

    public void reorder(Queue<Integer> queue) {
        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();
        int size = queue.size();
        int count = 0;

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            if (n < 0) {
                stack.push(n);
            } else {
                queue.add(n);
                count++;
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < count; i++) {
            queue.add(queue.remove());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();
        int size = queue.size();
        int oddCount = 0;

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            if (n % 2 == 0) {
                stack.push(n);
            } else {
                queue.add(n);
                oddCount++;
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < oddCount; i++) {
            queue.add(queue.remove());
        }

        for (int i = 0; i < (size - oddCount); i++) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < oddCount; i++) {
            queue.add(queue.remove());
        }
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        java.util.Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            String s = itr.next();
            if (s.length() % 2 == 0) {
                itr.remove();
            }
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        java.util.Set<Integer> set1 = new java.util.HashSet<>(list1);
        java.util.Set<Integer> set2 = new java.util.HashSet<>(list2);

        set1.retainAll(set2);

        return set1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        java.util.Set<String> values = new java.util.HashSet<>(map.values());
        return values.size() == map.size();
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new java.util.HashMap<>();

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                Integer val1 = map1.get(key);
                Integer val2 = map2.get(key);

                if (val1.equals(val2)) {
                    result.put(key, val1);
                }
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> reversed = new java.util.HashMap<>();

        for (Integer key : map.keySet()) {
            String value = map.get(key);
            reversed.put(value, key);
        }

        return reversed;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Map<Integer, Integer> counts = new java.util.HashMap<>();

        for (Integer val : map.values()) {
            if (!counts.containsKey(val)) {
                counts.put(val, 0);
            }
            counts.put(val, counts.get(val) + 1);
        }

        int minCount = Integer.MAX_VALUE;
        int rarestVal = 0;

        for (Integer val : counts.keySet()) {
            int count = counts.get(val);

            if (count < minCount) {
                minCount = count;
                rarestVal = val;
            } else if (count == minCount) {
                if (val < rarestVal) {
                    rarestVal = val;
                }
            }
        }

        return rarestVal;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> map = new java.util.HashMap<>();

        for (int n : list) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        int max = 0;
        for (int count : map.values()) {
            if (count > max) {
                max = count;
            }
        }

        return max;
    }

}
