// The ship company
// Problem Description

// The local ship renting service has a special rate plan:

// It is up to a passenger to choose a ship.
// If the chosen ship has X (X > 0) vacant places at the given moment, then the ticket for such a ship costs X.
// The passengers buy tickets in turn, the first person in the queue goes first, then goes the second one, and so on up to A-th person.

// You need to tell the maximum and the minimum money that the ship company can earn if all A passengers buy tickets.

// Problem Constraints
// 1 ≤ A ≤ 3000
// 1 ≤ B ≤ 1000
// 1 ≤ C[i] ≤ 1000
// It is guaranteed that there are at least A empty seats in total.

// Input Format
// First argument is a integer A denoting the number of passengers in the queue.
// Second arugument is a integer B deonting the number of ships.
// Third argument is an integer array C of size B where C[i] denotes the number of empty seats in the i-th ship before the ticket office starts selling tickets.

// Output Format
// Return an array of size 2 denoting the maximum and minimum money that the ship company can earn.

// Example Input
// Input 1:

//  A = 4
//  B = 3
//  C = [2, 1, 1]
// Input 2:

//  A = 4
//  B = 3
//  C = [2, 2, 2]

// Example Output
// Output 1:

//  [5, 5]
// Output 2:

// [7, 6]

// Example Explanation
// Explantion 1:

//  Maximum money can be earned if the passenger choose : 2(first ship) + 1(first ship) + 1(second ship) + 1(third ship).
//  So, the cost will be 5.
//  Minimum money can be earned if the passenger choose : 1(senocd ship) + 2(first ship) + 1(first ship) + 1(third ship).
//  So, the cost will be 5.
// Explanation 2:

//  Maximum money can be earned if the passenger choose : 2(first ship) + 2(second ship) + 2(third ship) + 1(first ship).
//  So, the cost will be 7.
//  Minimum money can be earned if the passenger choose : 2(senocd ship) + 2(first ship) + 1(first ship) + 1(second ship).
//  So, the cost will be 6.

public class Solution {
    public ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {
        ArrayList<Integer> temp = new ArrayList<Integer>();

        for (int i = 0; i < C.size(); i++)
            temp.add(C.get(i));

        int global_max = 0;
        int global_min = 0;
        int max_idx = 0;
        int min_idx = 0;
        ArrayList<Integer> li = new ArrayList<Integer>();

        // find the maximum money earned
        for (int i = 0; i < A; i++) {

            int maximum = Integer.MIN_VALUE;

            for (int j = 0; j < C.size(); j++) {
                if (C.get(j) > 0 && maximum < C.get(j)) {
                    max_idx = j;
                    maximum = C.get(j);
                }

            }
            global_max += maximum;
            C.set(max_idx, maximum - 1);
        }

        li.add(global_max);

        // Find the minimum money earned
        for (int i = 0; i < A; i++) {

            int minimum = Integer.MAX_VALUE;

            for (int j = 0; j < temp.size(); j++) {

                if (temp.get(j) > 0 && minimum > temp.get(j)) {
                    min_idx = j;
                    minimum = temp.get(j);
                }
            }
            // System.out.println(minimum) ;
            global_min += minimum;
            temp.set(min_idx, minimum - 1);
        }

        li.add(global_min);

        return li;
    }
}

// Approach2->

public class Solution {
    public int[] solve(int A, int B, int[] C) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(new CustomComp());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int a : C) {
            maxHeap.offer(a);
            minHeap.offer(a);
        }
        int[] res = new int[2];
        int maxe = 0;
        int mine = 0;
        int i = 0;
        while (maxHeap.size() > 0 && i < A) {
            i++;
            int val = maxHeap.poll();

            if (val > 1) {
                maxHeap.offer(val - 1);
            }
            maxe += val;
        }
        i = 0;
        while (minHeap.size() > 0 && i < A) {
            i++;
            int val = minHeap.poll();

            if (val > 1) {
                minHeap.offer(val - 1);
            }
            mine += val;
        }
        res[0] = maxe;
        res[1] = mine;
        return res;
    }
}

class CustomComp implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}