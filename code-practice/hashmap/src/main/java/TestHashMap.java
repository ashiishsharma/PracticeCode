public class TestHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0 ; i < 100 ; i ++) {
			map.put(i, i+"");
			//System.out.println(map.get(i));
		}		
		System.out.println(map.get(91));
		System.out.println("Size" + map.size());
		for (int i = 0 ; i < 100 ; i ++) {
			System.out.println(map.get(i));
		}
		
		
	}

}
