/**
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
 * @author Pedro H. Chaves <pedrohcd@hotmail.com>
*/
public class CORDIC {
	
	/* */
	static int ITERATIONS = 32;
	static double SCALE_PRECISION = 1e9;
	
	/* */
	static double[] tanTable = new double[ITERATIONS];
	static long preScale;
	static {
		long p2 = 1;
		double dPreScale = 1;
		for(int i=0; i<ITERATIONS; i++) {
			tanTable[i] = Math.atan(1.0 / p2);
			dPreScale *= Math.cos(tanTable[i]);
			p2 <<= 1;
		}
		preScale = (int)(dPreScale * SCALE_PRECISION);
	}
	
	public static double[] cordic(double angle) {
		long x = preScale;
		long y = 0;
		for(int i=0; i<ITERATIONS; i++) {
			int o = 1;
			if(angle < 0) o = -1;
			long tx = x - (y>>i) * o;
			long ty = y + (x>>i) * o;
			x = tx;
			y = ty;
			angle = angle - tanTable[i] * o;
		}
		return new double[] {(x * 1.0) / SCALE_PRECISION, (y * 1.0) / SCALE_PRECISION};
	}
	
	public static double cos(double rad) {
		return cordic(rad)[0];
	}
	
	public static double sin(double rad) {
		return cordic(rad)[1];
	}
	
	public static void main(String[] args) {
		System.out.println(sin((18 * Math.PI) / 180));
	}	
}
