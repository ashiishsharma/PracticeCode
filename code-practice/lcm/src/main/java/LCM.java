/**
 * LCD of 
 * 300 200 is 600
 * 800 500 is 4000
 *
 */
public class LCM {

	
	public static void main(String[] args) {

		int p = 800;
		int q = 500;
		
		System.out.println("LCM " +lcm(p,q));
		
	}

	private static int lcm(int p, int q) {
		int hcf = gcd(p,q);
		System.out.println("GCD " + hcf);
		return (hcf * (p/hcf)*(q/hcf));
	}

	private static int gcd(int p, int q) {
		if(q==0) {
			return p;
		}
		
		return gcd(q,p%q);
	}

}
