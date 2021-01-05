package ece;
/**
 * Lab 2: Debugging with an IDE and Prefix Tree)
 * 
 */

class Trie {
	
	static final int ALPHABET_SIZE = 26;
	
	static class TrieNode {
  
	        TrieNode[] child = new TrieNode[ALPHABET_SIZE];
	        boolean isEndOfWord;
	        
	        TrieNode(){ 
				isEndOfWord = false; 
				for (int i = 0; i < ALPHABET_SIZE; i++) 
					child[i] = null; 
			}
	        
	    }
	
    /**
     * Root node of the Prefix Tree
     */	 
	static TrieNode root; 

    //inserting word into prefix tree: set isEndofWord to true for final letter (node) added
    public static void insert(String word) {
		//set starting point as root
		TrieNode curr = root;
		//iterate through characters, add and update node, set flag to true when complete
		for(char c : word.toCharArray()){
			//get index of array
			int index = c - 'a';
			// no prefix exists: insert
			if(curr.child[index] == null){
				TrieNode newNode = new TrieNode();
				//insert node
				curr.child[index] = newNode;
				//point to new node
				curr = newNode;
			}
			else{
				//exists, therefore point to existing node
				curr = curr.child[index];
			}
		}
		//reached end of word
		curr.isEndOfWord = true;
    }
    
    
    public static boolean search(String word) {
		// TODO: Returns if the word is in the Prefix Tree
		TrieNode curr = root;
		for(char c : word.toCharArray()){
			//get index of array
			int index = c - 'a';
			// letter exists
			if(curr.child[index] != null){
				curr = curr.child[index];
			}
			//doesnt exist
			else{
				return false;
			}
		}
		//if empty
		if (curr == root){
			return false;
		}
		//if end of word
		else if (curr.isEndOfWord){
			return true;
		}
		else{
			return false;
		}
    	
    }
    
   
    public static boolean startWith(String prefix) {
		// TODO: Returns if there is any word in the Prefix Tree that starts with the given prefix.
		TrieNode curr = root;
		for(char c : prefix.toCharArray()){
			int index = c - 'a';
			if(curr.child[index] != null){
				curr = curr.child[index];
			}
			else{
				return false;
			}
		}
    	//if empty
		if (curr == root){
			return false;
		}
		else{
			return true;
		}
    }

   
    
    
    public static void main(String args[]) 
	{ 
		
		String words[] = {"ece", "lab", "java", "jar", "car", 
						"cat", "care", "laboratory", "ebook"}; 
	
		String output[] = {"is NOT in the prefix tree", "is in the prefix tree"}; 
	
	
		root = new TrieNode(); 
	
		// Construct trie 
		int i; 
		for (i = 0; i < words.length ; i++) 
			insert(words[i]); 
	
		// Search for different keys 
		if(search("lab") == true) 
			System.out.println("lab --- " + output[1]); 
		else System.out.println("lab --- " + output[0]); 
		
		if(search("java") == true) 
			System.out.println("java --- " + output[1]); 
		else System.out.println("java --- " + output[0]); 
		
		if(startWith("eced") == true) 
			System.out.println("eced --- " + output[1]); 
		else System.out.println("eced --- " + output[0]);
		
		if(search("book") == true) 
			System.out.println("book --- " + output[1]); 
		else System.out.println("book --- " + output[0]); 
		
	} 


}


