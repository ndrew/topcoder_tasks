import java.math.BigInteger;
import java.util.Arrays;


public class YetAnotherIncredibleMachine {

	public int countWays(int[] platformMount, int[] platformLength, int[] balls) {

		// count the maximum area that can be covered by platforms
		
		int max_left = 10000; 
		int max_right = -10000;

		for (int i = 0; i < platformMount.length; i++) {
			if ( platformMount[i]-platformLength[i] < max_left ) {
				max_left = platformMount[i]-platformLength[i];
			}

			if ( platformMount[i]+platformLength[i] > max_right ) {
				max_right = platformMount[i]+platformLength[i];
			}
			
		}

//		System.out.println(max_left);
//		System.out.println(max_right);

		int[] b = new int[balls.length+2];
		b[0] = max_left;
		System.arraycopy(balls, 0, b, 1, balls.length);
		b[balls.length+1] = max_right;
		
		int start = max_left;

		int cnt[] = new int[platformMount.length];
		Arrays.fill(cnt, 0);
		
		for (int i = 0; i < platformMount.length; i++) {

			for (int j = 0; j < b.length; j++) {
				int end = b[j];
				int d = end - start;

				if (platformLength[i]<d) {
		
					
					
					int l = (start > platformMount[i]-platformLength[i] ) ? start : platformMount[i]-platformLength[i];
					
					int count = end - (l+platformLength[i]);
					if (count <0) {
						count = -count;
					}
					cnt[i] = cnt[i] + count;
					
					// System.out.println(i+ ") " + count + " positions");
					
//					 System.out.println("["+start+";"+end+"] and ["+l);
	//				 System.out.println(cnt[i]);
				} 
				start = end;				
			}
		}

		
		BigInteger res = BigInteger.valueOf(cnt[0]);
		
		for (int i = 1; i < cnt.length; i++) {
			res = res.multiply(BigInteger.valueOf(cnt[i]));
		}

		res.or(BigInteger.valueOf(1000000009));
		return res.intValue();
	}
	
	public static void main(String[] args) {
		
		// test cases
		/*
		int[] platformMount = new int[]{7};
		int[] platformLength = new int[]{10};
		int[] balls = new int[]{3,4};
		*/

		/*
		int[] platformMount = new int[]{0};
		int[] platformLength = new int[]{1};
		int[] balls = new int[]{0};
	*/
		
/*		
		int[] platformMount = new int[]{100, -4215, 251};
		int[] platformLength = new int[]{400, 10000, 2121};
		int[] balls = new int[]{5000, 2270, 8512, 6122}; */
		
		int[] platformMount = new int[]{1,4};
		int[] platformLength = new int[]{3,3};
		int[] balls = new int[]{2,7};
		
		
		System.out.println(new YetAnotherIncredibleMachine().countWays(platformMount, platformLength, balls));
		
	}

	
}
