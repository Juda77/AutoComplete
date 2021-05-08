
public class Trie {

	TrieNode head = new TrieNode();
	
	public Trie() {}
	
	public void insert(String phrase) {
		head.insert(phrase, 0);
	}
	
	//print 
	public void autocomplete(String phrase) {
		if (phrase.length() == 0) {
			System.out.println("Your input is empty");
			return;
		}
		
		/*
		 * algo: traverse trie until end of phrase
		*/
		head.traverse(phrase, 0);
	}

}
