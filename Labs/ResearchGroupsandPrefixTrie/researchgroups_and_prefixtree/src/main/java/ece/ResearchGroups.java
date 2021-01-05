//import sun.font.TrueTypeFont;
// package ResearchGroupsandPrefixTrie;

package ece;

import java.util.*;
import msort.MergeSort;
/**
 * Lab 2: Debugging with an IDE and Prefix Tree) <br />
 * The {@code ResearchGroup} class uses a 2D array to store the names of group members
 */


public class ResearchGroups {

    /**
     * Search a person to check whether he/she is in the groups.
     * @param groups    {@code String[]} The 2D array of groups to be searched
     * @param name      {@code String} name of the person
     * 

     */
    public static void searchMember(final String[][] groups, final String name) {
        // TODO: Lab 2 Part 1-1 -- search and print the results here
        boolean isNameInGroups = false;
        boolean isLeader = false;
        int groupNumber = 0;
        // check if name exists in group. If so, break immediately
        outer: for (int row = 0; row < groups.length; row++) {
            for (int column = 0; column < groups[row].length; column++) {
                // check if name exists at any point
                if (groups[row][column] == name) {
                    isNameInGroups = true;
                    groupNumber = row;
                    // check if leader
                    if (column == 0) {
                        isLeader = true;
                    }
                    break outer;
                }
            }
        }
        // check if name exists and output accordingly
        if (isNameInGroups) {
            System.out.print("Name exists in Group. Group number: " + groupNumber + ". ");

            if (isLeader) {
                System.out.println(name + " is Leader of Group");
            } else {
                System.out.println(name + " is not Leader of Group");
            }
        } else {
            System.out.println("Name does not exist in Group");

        }

    }

    /**
     * Sort groups by number of members <br />
     * 
     * @param groups (<code>String[][]</code>) The 2D array of groups to be sorted
     */
    public static void sortGroups(final String[][] groups) {
        //hashmap creation
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] organizedLengths = new int[groups.length];
        int[] a = new int[groups.length];

        for (int row = 0; row < groups.length; row++) {
            map.put(row, groups[row].length);//store row and associated length
            a[row] = groups[row].length;// row length values
        }

        organizedLengths = MergeSort.sort(a);// sorted values 
        
        // get corresponding key to value (from sorted organizedLengths)
        for (int i = 0;i < organizedLengths.length;i++){
            int key = getKey(map,organizedLengths[i]);
            //if valid
            if(key != -1){
                // remove the key value from the map 
                map.remove(key);
                // print corresponding line  
                System.out.println(Arrays.toString(groups[key] )); 
            }
        }
    }

    //returns corresponding key to provided value
    public static <K, V> K getKey(Map<K, V> map, V value) {
		for (K key : map.keySet()) {
			if (value.equals(map.get(key))) {
				return key;
			}
		}
		return null;
	}

    /**
     * Main entry
     * 
     * @param args {@code String[]} Command line arguments
     */
    public static void main(final String[] args) {
        final String[][] groups = { { "Bob", "Carol", "Eric", "Matt" }, // 0
                              {"Jim", "Lucy", "Terry", "Brenda", "Ben"},    // 1
                              {"Susan", "Brad", "Jim"},                     // 2
                              {"Sue", "Wendy", "Sam"},                      // 3
                              {"Kate", "Jack", "James", "Sydney"},          // 4
                              {"Mohammad", "Tim", "Kian"},                  // 5
                              {"Emma", "Carol"},                            // 6
                              {"Nick", "Osama", "Harry", "Ben"},            // 7
                              {"Mary", "John", "Ricky"} };                  // 8

        ResearchGroups.searchMember(groups, "Jim");
        ResearchGroups.searchMember(groups, "Lucy");
        ResearchGroups.searchMember(groups, "John Doe");
        ResearchGroups.sortGroups(groups);
    }

}
