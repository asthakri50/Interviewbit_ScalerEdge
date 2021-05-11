// Tennis Logs
// Three friends P, Q and R are playing tennis, and they play in such a way that:

// P and Q start playing initially, R is spectating.
// Whoever loses, becomes the spectator, and the winner plays with the person who was spectating.
// It is given that no draws take place.
// A games are played, and a log of each game with the winner is made, but the players are not sure if the log is correct or not.
// In the log, every time P wins, it is represented by the integer 1, when Q wins it is represented as 2, when R wins, 3.

// You are given the log of N integers, you are supposed to return "Yes" if the log is correct, else return "No", without double quotes.

// Input:

// A: Number of log entries
// B: Array of A integers.
// Output:

// "Yes" if the log is correct, else "No".
// Constraints:

// 1 <= A <= 100
// 1 <= Elements of array B <= 3
// Example:

// Input: 
// N: 2
// A: 1 3 

// Output:
// Yes

// Initially 1 wins, so 1 plays against 3, and then 3 wins the next game.

// Input: 
// N: 3
// A: 3 1 1

// Output:
// No

// Initially 1 and 2 play, but the log says that 3 wins, hence it is wrong.

public class Solution {
    public String solve(int A, ArrayList<Integer> B) {
        if (B.size() != A)
            return "No";

        int spec = 3;
        int p1 = 1;
        int p2 = 2;

        for (int i = 0; i < B.size(); i++) {

            if (B.get(i) == spec)
                return "No";

            if (B.get(i) == p1) {
                int temp = p2;
                p2 = spec;
                spec = temp;
            }

            if (B.get(i) == p2) {
                int temp = p1;
                p1 = spec;
                spec = temp;
            }
        }
        return "Yes";
    }
}
