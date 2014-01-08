import java.util.HashMap;


public class WordCalc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashMap<String, Integer> map = new HashMap<String, Integer> ();
		
		
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		
		System.out.println("Enter a number in a string form: ");
		
		for (String s: args) {
            if (map.containsKey(s))
            {
            	System.out.println(map.get(s));
            };
        }
		
		

	}

}
