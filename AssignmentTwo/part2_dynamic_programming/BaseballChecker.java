package part2_dynamic_programming;

public class BaseballChecker {

	public static void main(String[] args) {
		int numToWinA = 50;
		int numToWinB = 40;
		final long startTime = System.currentTimeMillis();
		System.out.println(dpSolution(numToWinA, numToWinB));
		final long endTime = System.currentTimeMillis();
		System.out.println("Dynamic solusion takes "+ (endTime-startTime) +  " milliSeconds");
		
		final long startTime2 = System.currentTimeMillis();
		System.out.println(recursionSolution(numToWinA, numToWinB));
		final long endTime2 = System.currentTimeMillis();
		System.out.println("Recursion solusion takes "+ (endTime2-startTime2) +  " milliSeconds");
	}

	/*
	 * pre numToWinA > 0, numToWinB > 0
	 * the probability of A wins the serials will be returned
	 */
	private static double dpSolution(int numToWinA, int numToWinB) {
		double[][] result = new double[numToWinA + 1][numToWinB + 1];

		for (int i = 0; i <= numToWinA; i++) {
			result[i][0] = 0;
		}
		for (int j = 0; j <= numToWinB; j++) {
			result[0][j] = 1;
		}
		
		/*
		 * So P(i-1,j) is the probability that the Pirates will win the series
		 * after winning the next game and P(i,j-1) is the probability that the
		 * Pirates will win after losing the next game. Since each team is
		 * equally likely to win, we sum these probabilities and compute an
		 * average by dividing by 2
		 */

		for (int i = 1; i <= numToWinA; i++) {
			for (int j = 1; j <= numToWinB; j++) {
				result[i][j] = (result[i - 1][j] + result[i][j - 1]) / 2;
			}
		}

		return result[numToWinA][numToWinB];
	}

	/*
	 * pre numToWinA > 0, numToWinB > 0
	 * the probability of A wins the serials will be returned
	 */
	private static double recursionSolution(int numToWinA, int numToWinB) {
		double ret = recursion(numToWinA, numToWinB);
		return ret;
	}

	/*
	 * During recursion, there may exist a case where same sub-problems are solved multiple times.
	 */
	private static double recursion(int A, int B) {
		if (A == 0) {
			return 1;
		} else if (B == 0) {
			return 0;
		}
		return (recursion(A-1, B) + recursion(A, B-1))/2;
	}

}
