import java.util.*;
public class test{
	public static void main(String [] args){
		HashMap<String, Integer> hs = new HashMap<String, Integer>();

		hs.put("one", 1);
		hs.put("two", 2);

		System.out.println(hs.toString());

		object1 obj1 = new object1();

		changeObject(obj1);
		System.out.println(obj1.getSize());
		
		List<String> a_str = new LinkedList<String>();

		Iterator<String> itr = a_str.iterator();
		while(itr.hasNext()){
			System.out.println("Hi");
		}
		System.out.println("End loop");

	}

	public static void changeObject(object1 test){ 
		System.out.println("Before" + test.getSize());
		System.out.println ("After" + test.boost());
	}
}
	
