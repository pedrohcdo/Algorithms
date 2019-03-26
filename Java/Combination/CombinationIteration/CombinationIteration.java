import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * This program interacts with all possible combinations of n k by k
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
public class CombinationIteration {

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//
		int size = 5;
		int by = 3;
		
		
		// Create stack and fill with first combination
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<by; i++)
			s.push(i);
		
		// Iterate
		while(s.size() > 0) {
			
			// Print current combination
			for(int i=0; i<by; i++)
				System.out.print((s.get(i)+1) + " ");
			System.out.println();
			
			// Next combination
			while(s.size() > 0) {
				int pos = s.pop() + 1;
				if(pos + (by-s.size()-1) < size) {
					int q = (by-s.size());
					for(int i=0; i<q; i++)
						s.push(pos + i);
					break;
				}
			}
		}
	}
}
