import java.io.*;
import java.util.HashSet;
import java.util.Set;
public class TesterClass {

	public static void main(String[] args) {
		
		Trie trie = new Trie();
		String[] phrases = {
				
			"Spider Man",
			"Spidey",
			"Spy",
			"Iron Man",
			"Iron Maiden"
				
		};
		
		
		//create our trie/dictionary
		
		for (int i = 0; i < phrases.length; i++) {
			trie.insert(phrases[i]);
		}
		
		
		trie.autocomplete("Spiderman is you");
		
		
		test(new HashSet<>(), 1);
		
	}
	
	
	public static void test(Set<String> s, int count) {
		
		System.out.println("hi");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
