package test;	

import java.util.Arrays;

public class ForbiddenStrings {

/*	int total = 0;
	int forbade = 0;
	
	char[] z = new char[] {'A','B','C'};
	
	void print(int[] a) {
		if (forbidden(a)) {
		for (int i = 0; i < a.length; i++) {
			//System.err.print(a[i]);
			System.err.print(z[a[i]]);
		}
		System.err.println("\t" + true);
		}
	} 
	
	boolean forbidden(int[] a) {
		total++;
		if (a.length < 2) {
			return false;
		}
		
		for (int i = 0; i < a.length-2; i++) {
			int a1 = a[i];
			int a2 = a[i+1];
			int a3 = a[i+2];
			
			// System.out.println("a1, a2, a3 " + a1 + " "+ a2 +" "+ a3);
			
			if ( (a1 == 0 && a2 == 1 && a3 == 2) ||
				 (a1 == 0 && a2 == 2 && a3 == 1) || 
				 (a1 == 1 && a2 == 0 && a3 == 2) || 
				 (a1 == 1 && a2 == 2 && a3 == 0) ||
				 (a1 == 2 && a2 == 0 && a3 == 1) ||
				 (a1 == 2 && a2 == 1 && a3 == 0)
				)
			{
				forbade++;
				return true;
			}
		}
		return false;
		
	}
	*/
	long countNotForbidden(int n) {
		int[] aa = new int[31];
		int[] ax = new int[31];
		
		Arrays.fill(aa, 0);
		Arrays.fill(ax, 0);

		aa[1] = 0;
		aa[2] = 3;
		
		ax[1] = 3;
		ax[2] = 6;
		
		for ( int i = 3; i<=n; i++) {
			aa[i] = aa[i-1] + ax[i-1];
			ax[i] = 2*aa[i-1] + ax[i-1];
		}

		return ax[n] + aa[n];
		
/*		int[] a = new int[n];
		Arrays.fill(a, 0);
		
		boolean done = false;
		
		print(a);
		
		while (!done) {
			int i = n-1;

			while ( (i>=0) && (a[i] == 2)) {
				a[i] = 0;
				i--;
			}
			if ( i >= 0) {
				a[i]++;
				
				print(a);
			} else {
				done = true;
			}
		}
	*/	
		// return 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ForbiddenStrings s = new ForbiddenStrings();
		
//		for (int i = 0; i < 4; i++) {
	//		System.out.println("i=" + i);
			
		int i = 5;
			System.out.println(s.countNotForbidden(i));
		//	System.out.println();
		//}
		
		//System.out.println(s.forbade + " from " + s.total);
	}

}
