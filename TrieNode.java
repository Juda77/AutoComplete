
public class TrieNode {

	TrieNode[] children = new TrieNode[27];
	boolean atEndOfAPhrase = false;

	
	public TrieNode() {
		
	}
	
	public void insert(String phrase, int currIndex) {
		
		char currLetter = Character.toLowerCase(phrase.charAt(currIndex));
		
		if (currLetter == ' ') {
			if (children[26] == null) {
				children[26] = new TrieNode();
			}
			children[26].insert(phrase, currIndex + 1);
			return;
		}

		if (children[currLetter - 'a'] == null) {
			children[currLetter - 'a'] = new TrieNode();
		}
		if (currIndex < phrase.length() - 1) {
			
			children[currLetter - 'a'].insert(phrase, currIndex + 1);
			
		} else {
			children[currLetter - 'a'].atEndOfAPhrase = true;
		}

	}
	
	
	
	//traverse until we get to the input phrase's end
	public void traverse(String phrase, int index) {
		
		
		//we've reached the end of the word, begin autocomplete generation
		if (index == phrase.length()) {
			StringBuilder sb = new StringBuilder();
			sb.append(phrase);
			findPhrasesToAutoGenerate(sb, this);
				
			return;
		}
		
		
		char currLetter = Character.toLowerCase(phrase.charAt(index));
		
		//check if the phrase actually exists in the dictionary/trie in the first place
		if (children[currLetter - 'a'] == null) {
			System.out.println("There is no such phrase");
		} else {
			
			children[currLetter - 'a'].traverse(phrase, index + 1);
			
		}
		
		
		
		
		
	}
	
	public void findPhrasesToAutoGenerate(StringBuilder currPhrase, TrieNode curr) {
		
		if (curr.atEndOfAPhrase == true) {
			System.out.println(currPhrase.toString());
		} 
			
		for (int i = 0; i < 27; i++) {
				
			if (curr.children[i] != null) {
					
				if (i == 26) {
					currPhrase.append(' ');
				} else {
					currPhrase.append((char)(i + 97));
				}
				
				findPhrasesToAutoGenerate(currPhrase, curr.children[i]);
				currPhrase.setLength(currPhrase.length() - 1);
					
			}
				
				
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
