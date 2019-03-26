/**
 * This program displays the nth combination of a vector of size M.
 * Note1: It displays the combination and not the coefficient.
 * Note2: For large combinations, update this code with BigInteger.
 * 
 * @author Pedro H. Chaves <pedrohcd@hotmail.com>
 * 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
*/
public class NthCombination {

	/**
	 * The coefficient is used for algorithm jumps the coefficients
	 * 
	 * @param n 
	 * @param k
	 * @return
	 */
	static long comb(int n, int k) {
	    if(k > n / 2) 
	    	k = n - k;
	    long ans = 1;
	    int i;
	    for(i = 1; i <= k; i++)
	        ans = (ans * (n - k + i)) / i;
	    return ans;
	}
	
	/**
	 * Returns a string with the nth combination, it can be modified with
	 * a Stack for example to get the elements.
	 * 
	 * @param i Position (Call with 0)
	 * @param n Amount
	 * @param k Combination k by k
	 * @param nth Combination of interest
	 * @param offset Offset (Call with 0)
	 * @return String with nth combination
	 */
	public static String nthComb(int i, int n, int k, long nth, long offset) {
		if(k == 0) return "";
		for(; i<(n-k); i++) {
			long c = comb(n - (i + 1), k - 1);
			if(offset + c > nth)
				break;
			offset += c;
		}
		return (i+1) + " " + nthComb(i + 1, n, k - 1, nth, offset);
	}
	
	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Testing
		int total = 10;
		int by = 5;
		long nth = NthCombination.comb(10, 5) - 1; // Last combination
		
		System.out.println(nthComb(0, total, by, nth, 0));
	}
}
