package ece325;

/**
 * Lab 4: Generics <br />
 * The {@code GenericTrie} class <br />
 * Reference: <a href="https://en.wikipedia.org/wiki/Trie">
 *              https://en.wikipedia.org/wiki/Trie
 *            </a>
 */
public class GenericTrie<K extends CharSequence, V>
{
		
    /**
     * Root node of the Prefix Tree
     */	 
	TrieNode<V> root = new TrieNode<V>();

    TODO: Insert a new element to the Prefix Tree
    public void insert(K word, V value) {
        TrieNode<V> curr = root;
        for(char c : word.toString().toCharArray()){
            //get index of array
            int index = c - 'a';
            // no prefix exists: insert
			if(curr.child[index] == null){
				TrieNode<V> newNode;
				//if last letter
				if(word.toString().length() == word.toString().lastIndexOf(c) + 1)
					newNode = new TrieNode<V>(value);
				//if not
				else
					newNode = new TrieNode<V>();

                
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

    }

	//Returns the value associated with the word is in the Prefix Tree
    public V search(K word) {
    	TrieNode<V> curr = root;
		for(char c : word.toString().toCharArray()){
			//get index of array
			int index = c - 'a';
			// letter exists
			if(curr.child[index] != null){
				curr = curr.child[index];
			}
			//doesnt exist
			else{
				return root.value;
			}
		}
		if (curr.isEndOfWord){
			return curr.value;
		}
		else{
			return root.value;
		}
    }

	//Returns if there is any word in the Prefix Tree that starts with the given prefix.    public boolean startWith(K prefix) {    
    public boolean startWith(K prefix) {
        TrieNode<V> curr = root;
		for(char c : prefix.toString().toCharArray()){
			int index = c - 'a';
			//exists
			if(curr.child[index] != null)
				curr = curr.child[index];
			//doesnt exist
			else
				return false;
		}
		if(curr == root)
			return false;
		return true;
    }
	//removes word from generic trie, returning the value associated with it
    public V remove(K word) throws Exception {	
		TrieNode<V> curr = root;
		int indexFinal = 0;
		V finalVal = null;
		for(char c : word.toString().toCharArray()){
			int index = c - 'a';
			indexFinal = index;
			//exists
			if(curr.child[index] != null){
				curr = curr.child[index];
			}
			//doesnt exist
			else
				throw new Exception("Word does not exist");
			
			if(curr.isEndOfWord){
				finalVal = curr.value;

			}
		}
		//check if we have any children; if does, is a prefix, cannot be removed
		if(hasChildren(curr.child))
			throw new Exception("is an existing prefix");
		//can remove: recurse
		if(word.length() == 0)
			return finalVal;
		else{
			curr= null;
			remove((K) word.subSequence(0, word.length() - 1));
		}
		return finalVal;
		
	}
	
	public boolean hasChildren(TrieNode<V>[] myArray){
		for(TrieNode<V> node:myArray){
			if(node != null)
				return true;
		}
		return false;
	}

	// public static void main(String args[]) throws Exception 
	// { 
		
	// 	String words[] = {"ece", "lab", "java", "jar", "car", 
	// 					"cat", "care", "laboratory", "ebook"}; 
	
	// 	String output[] = {"is NOT in the prefix tree", "is in the prefix tree"}; 
	
	// 	Integer keys[] = {10, 15, 1, 11, 5, 
	// 					3, 2, 4, 10}; 
						
		
	// 	GenericTrie<String,Integer> myTrie = new GenericTrie<String,Integer>();
	// 	myTrie.root = new TrieNode<Integer>();
	// 	// Construct trie 
	// 	int i; 
	// 	for (i = 0; i < words.length ; i++) 
	// 		myTrie.insert(words[i],keys[i]); 

	// 	if(myTrie.search("ece") == 10) 
	// 		System.out.println("ece --- " + output[1]); 
	// 	else System.out.println("ece --- " + output[0]); 


	// 	if(myTrie.startWith("ec") == true) 
	// 		System.out.println("la --- " + output[1]); 
	// 	else System.out.println("la --- " + output[0]);

 
	// 	myTrie.remove("ece");

	// }

}

