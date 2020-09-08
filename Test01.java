package hashmapz;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test01 {

	public static void main(String[] args) {
		HashMap<String , Integer> hm = new HashMap<>();
		hm.put("变形金刚",20);
		hm.put("海贼王", 30);
		hm.put("火影忍者", 40);
	    method(hm);
	    System.out.println("----------------------");
	    method_1(hm);
	    System.out.println("----------------------");
	    method_2(hm);
	    System.out.println("----------------------");
	    method_3(hm);
	}

    
    
    private static void method_3(HashMap<String, Integer> hm) {
		// TODO Auto-generated method stub
		hm.forEach((key,value)->{System.out.println(key + "---" + value);});	
    }




	private static void method_2(HashMap<String, Integer> hm) {
		// TODO Auto-generated method stub
		Set<String> keys = hm.keySet();
		for (String key : keys) {
			Integer value = hm.get(key);
			System.out.println(key + "---" + value);
		}
	}



	private static void method_1(HashMap<String, Integer> hm) {
		// TODO Auto-generated method stub
		Set<Map.Entry<String, Integer>> entries = hm.entrySet();
		for(Iterator<Map.Entry<String,Integer>> it = entries.iterator();it.hasNext();) {
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + "---" + entry.getValue());
		}
	}



	private static void method(HashMap<String, Integer> hm) {
		// TODO Auto-generated method stub
		Set<String> keys = hm.keySet();
		for(String key : keys) {
			System.out.println(key);
		}
		Collection<Integer> values = hm.values();
		for (Integer value : values) {
			System.out.println(value);
		}
	}

	
	
	
	
}
