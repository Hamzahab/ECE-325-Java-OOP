package ece325;

import java.util.ArrayList;
/**
 * Lab 5: Java Collection Framework and Skip List <br />
 * The {@code SkipList} class
 * @param <K>           {@code K} key of each skip list node
 * @param <V>           {@code V} value of each skip list node
 */
public class SkipList<K extends Comparable<K>, V> {

    /**
     * The {@code Node} class for {@code SkipList}
     */
    private class Node {
        public K key;
        public V value;
        public ArrayList<Node> forwards = new ArrayList<Node>();
        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            for (int i = 0; i < level; i++)
                forwards.add(null);
        }
        public String toString() {
            return String.format("%s(%s,%d)", value, key, forwards.size());
        }
    }

    /**
     * Level of the skip list. An empty skip list has a level of 1
     */
    private int level = 1;
 
    private Node head = new Node(null, null, level);


    /**
     * Size of the skip list
     */
    private int size = 0;
    /**
     * Insert an new element into the skip list
     * @param key       {@code K} key of the new element
     * @param value     {@code V} value of the new element
     */
    public void insert(K key, V value) {
        ArrayList<Node> update = new ArrayList<Node>();
        Node curr = head;
        //create 
    	for(int i = 0; i < this.level; i++) {
    		update.add(null);
        }
        
    	for(int i = level-1; i >= 0; i--) {
    	   while((curr.forwards.get(i) != null) && (curr.forwards.get(i).key.compareTo(key) < 0)) {
    		   curr = curr.forwards.get(i);
    	   }
    	   update.set(i, curr);
       }
    	curr = curr.forwards.get(0);
    	//simply update
    	if (curr != null && curr.key.compareTo(key) == 0) {
            curr.value = value;
            return;
        }
        //create new random level
    	else {
            int newLevel = randomLevel();
            curr = new Node(key, value, newLevel);
    		if(newLevel > this.level) {
    			for(int i = level-1;i < newLevel; i++ ) {
    				this.head.forwards.add(null);
                    update.add(this.head);
    			}
    			level = newLevel;
    		}
    		for(int i = 0; i < newLevel; i++) {
    			curr.forwards.set(i, update.get(i).forwards.get(i));
    			update.get(i).forwards.set(i, curr);
    		}
			size += 1;
    	}
    }


    /**
     * Remove an element by the key
     * @param key       {@code K} key of the element
     * @return          {@code V} value of the removed element
     */
    public V remove(K key) {
        Node curr = head;
        ArrayList<Node> update = new ArrayList<Node>();
        V returnVal = null;
    	for(int i = 0; i < this.level; i++) {
            update.add(null);
        }
        
    	for(int i = level-1; i >= 0; i--) {
    	   while((curr.forwards.get(i) != null) && (curr.forwards.get(i).key.compareTo(key) < 0)) {
    		   curr = curr.forwards.get(i);
    	   }
    	   update.set(i, curr);
       }
        curr = curr.forwards.get(0);
       //if key were looking for, copy val and remove
    	if(curr != null && curr.key.compareTo(key) == 0) {
            returnVal = curr.value;
            this.size--;
    		for(int i = 0; i < level; i++) {
    			if(update.get(i).forwards.get(i) != curr) {
    				break;
    			}
    			update.get(i).forwards.set(i, curr.forwards.get(i));
            }
            //decrease levels by 1
    		while((level > 0) && (head.forwards.get(level-1) == null )) {
    			level -= 1;
    		}
    		return returnVal;
    	}
        return null;
    }

    /**
     * Search for an element by the key
     * @param key       {@code K} key of the element
     * @return          {@code V} value of the target element
     */
    public V search(K key) {
        // TODO: Lab 5 Part 1-3 -- skip list node search
        Node curr = this.head;
        //for through each level: w/in level, check if next key
        //key is less than key in list: is so, get next
        //if not, break and go through next level until you get it
        for (int i = this.level - 1; i>=0; i--) {
            while (curr.forwards.get(i) != null && curr.forwards.get(i).key.compareTo(key) < 0){
                curr = curr.forwards.get(i);
            }
        }
        //get key searched for
        curr = curr.forwards.get(0);
        //is key
        if (curr != null && curr.key.compareTo(key) == 0)
            return curr.value;
        //not key
        return null;
        }

    /**
     * Get the level of the skip list
     * @return          {@code int} level of the skip list
     */
    public int level() {
        return level;
    }
    private int randomLevel() {
        int newLevel = 1;
    	while(Math.random() < 0.5) {
    		newLevel++;
    	}
    	return newLevel;
    }
    /**
     * Get the size of the skip list
     * @return          {@code int} size of the skip list
     */
    public int size() {
        return size;
    }

    /**
     * Print the skip list
     * @return          {@code String} the string format of the skip list
     */
    public String toString() {
        String result = this.head.toString();
        Node curr = this.head.forwards.get(0);

        while (curr != null){
            result = result + " " + curr;
            curr = curr.forwards.get(0);
        }
        
        return result;
    }

    /**
     * Main entry
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        SkipList<Integer, String> list = new SkipList<Integer, String>();
        int[] keys = new int[10];
        for (int i = 0; i < 10; i++) {                          // Insert elements
            keys[i] = (int) (Math.random() * 200);
            list.insert(keys[i], "\"" + keys[i] + "\"");
        }

        System.out.println(list);

        for (int i = 0; i < 10; i += 3) {
            int key = keys[i];
            // Search elements
            System.out.println(String.format("Find element             %3d: value=%s", key, list.search(key)));
            // Remove some elements
            System.out.println(String.format("Remove element           %3d: value=%s", key, list.remove(key)));
            // Search the removed elements
            System.out.println(String.format("Find the removed element %3d: value=%s", key, list.search(key)));
        }

        System.out.println(list);
    }

}
