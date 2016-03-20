package problems;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class PrimePattern {

	static int[] first11PrimeNos = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
	
	/**
	 * http://www.codechef.com/problems/PRIMPATT
	 */
	public static void main(String[] args) {
		
		InputReader buf = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		
		StringBuilder sb = new StringBuilder("");
//		int maxDimAbs = 2000001;
		int tcs = Integer.parseInt(buf.next());
		
		for(int tc = 0; tc < tcs; tc++){
			int x = buf.readInt();
			int y = buf.readInt();
			
			boolean isPrime = isNoAtLocationPrime(x, y);
			if(isPrime)
				sb.append("0\n");
			else{
				int distance = 1;
				while(true){
					// 	check NORTH
					isPrime = isNoAtLocationPrime(x, y + distance);
					if(isPrime)
						break;
					// 	check SOUTH
					isPrime = isNoAtLocationPrime(x, y - distance);
					if(isPrime)
						break;
					// 	check EAST
					isPrime = isNoAtLocationPrime(x + distance, y);
					if(isPrime)
						break;
					// 	check WEST
					isPrime = isNoAtLocationPrime(x - distance, y);
					if(isPrime)
						break; 
					
					// 	check NORTH-EAST
					for(int i = 1; i < distance; i++){
						isPrime = isNoAtLocationPrime(x + i, y + (distance - i));
						if(isPrime)
							break;
					}
					if(isPrime)
						break;
					
					// 	check NORTH-WEST
					for(int i = 1; i < distance; i++){
						isPrime = isNoAtLocationPrime(x - i, y + (distance - i));
						if(isPrime)
							break;
					}
					if(isPrime)
						break;
 
					// 	check SOUTH-EAST
					for(int i = 1; i < distance; i++){
						isPrime = isNoAtLocationPrime(x + i, y - (distance - i));
						if(isPrime)
							break;
					}
					if(isPrime)
						break;
 
					// 	check SOUTH-WEST
					for(int i = 1; i < distance; i++){
						isPrime = isNoAtLocationPrime(x - i, y - (distance - i));
						if(isPrime)
							break;
					}
					if(isPrime)
						break;
					distance++;
				}
				if(isPrime)
					sb.append(distance + "\n");
				else
					sb.append("0\n");
			}
		}
		out.printLine(sb);
		out.close();
	}
	
	
	private static boolean isNoAtLocationPrime(int x, int y){
		long numberAtCell = getNumber(x, y);
		if(numberAtCell == 0L || numberAtCell == 1L ){
			return false;
		}
		
		boolean isPrime = true;
 
		for(int i = 0; i < 10; i++){
			int primeNo = first11PrimeNos[i];
			if(primeNo == numberAtCell){
				break;
			}else if(numberAtCell % primeNo == 0){
				isPrime = false;
				break;
			}
		}
		if(isPrime){
			BigInteger no = BigInteger.valueOf(numberAtCell);
			isPrime = no.isProbablePrime(10);
		}
		return isPrime;
	}
	
	private static long getNumber(long x, long y){
		long result = 0;
		if(x == 0 && y == 0)
			return result;
		long absX = Math.abs(x);
		long absY = Math.abs(y);
		if(x > 0 && absX > absY){
			result = (x * x) << 2; //10000 = 16
			result = result - (3 * x) + y; // 16-6 = 10
		}else if(y > 0 && absY >= absX){
			result = (y * y) << 2;
			result = result - x - y;
		}else if(x <= 0 && absX > absY){
			result = (x * x) << 2;
			result = result - x - y;
		}else if(y <= 0 && absY >= absX){
			result = (y * y) << 2;
			result = result + x - (3 * y);
		}
		return result;
	}
	
	static class InputReader {
		 
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
	 
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
	 
		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
	 
		public int readInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
	 
		public String readString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
	 
		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	 
		public String next() {
			return readString();
		}
	}
 
	static class OutputWriter {
		private final PrintWriter writer;
	 
		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
	 
		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
	 
		public void print(Object...objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}
	 
	    public void printLine(Object...objects) {
			print(objects);
			writer.println();
		}
	 
		public void close() {
			writer.close();
		}
	} 

}
