// Meeting rooms
// Given an array of array of integers A of size N x 2 denoting time intervals of different meetings.

// Where:

// A[i][0] = start time of the ith meeting.

// A[i][1] = end time of the ith meeting.

// find the minimum number of conference rooms required so that all meetings can be done.

// Input Format

// The only argument given is the matrix A.
// Output Format

// Return the minimum number of conference rooms required so that all meetings can be done.
// Constraints

// 1 <= N <= 100000
// 0 <= A[i][0] < A[i][1] <= 2 * 10^9
// For Example

// Input 1:
//     A = [   [0, 30]
//             [5, 10]
//             [15, 20] ]    
// Output 1:
//     2
//     Meeting one can be done in conference room 1 form 0 - 30.
//     Meeting two can be done in conference room 2 form 5 - 10.
//     Meeting one can be done in conference room 2 form 15 - 20 as it is free in this interval.

// Input 2:
//    A =  [   [1, 18]
//             [18, 23]
//             [15, 29]
//             [4, 15]
//             [2, 11]
//             [5, 13] ]
// Output 2:
//     4
//     Meeting one can be done in conference room 1 from 1 - 18.
//     Meeting five can be done in conference room 2 from 2 - 11.
//     Meeting four can be done in conference room 3 from 4 - 15.
//     Meeting six can be done in conference room 4 from 5 - 13.
//     Meeting three can be done in conference room 2 from 15 - 29 as it is free in this interval.
//     Meeting two can be done in conference room 4 from 18 - 23 as it is free in this interval.

public class Solution {
    static class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Meeting> meetings = new ArrayList<>();

        for (ArrayList<Integer> li : A)
            meetings.add(new Meeting(li.get(0), li.get(1)));

        // Sort meetings on the basis of start time
        Collections.sort(meetings, (a, b) -> a.start - b.start);

        // for(int i = 0 ; i < meetings.size() ; i++)
        // System.out.println(meetings.get(i).start ) ;

        // Min Heap containing the end time of meetings happening so far
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        heap.add(meetings.get(0).end);
        int count = 1;

        for (int i = 1; i < meetings.size(); i++) {

            // if one of the meeting i.e the meeting with least end time has already ended
            if (heap.peek() <= meetings.get(i).start) {
                heap.poll();
                heap.add(meetings.get(i).end);
            } else {
                heap.add(meetings.get(i).end);
                count = count + 1;
            }
        }

        return count;
    }
}
