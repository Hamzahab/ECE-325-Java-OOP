package ece325;

import ece325.GenericTrie;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Unit test for GenericTrie
 */
public class GenericTrieDoubleTest 
{

    static String[] words = {"ece", "lab", "java", "jar", "car", "cat", "care", "laboratory", "ebook"};
    static Double[] values = {10.5, 2.0, 3.33, 0.35, -4.0, 42.001, 6.0, -1.02, 45.9}; 
    
    static GenericTrie<String, Double> trie = new GenericTrie<String, Double>();

    @BeforeClass
    public static void initTrie() 
    {
        for (int i = 0; i < words.length ; i++) 
			trie.insert(words[i], values[i]); 
    }

    @Test
    public void searchLab()
    {   
        assertEquals(values[1],Double.valueOf(trie.search("lab"))); 
    }

    @Test
    public void searchJava()
    {   
        assertEquals(values[2],Double.valueOf(trie.search("java"))); 
    }

    @Test
    public void startWidthFalse()
    {   
        assertFalse(trie.startWith("ea"));
    }

    @Test
    public void startWidthTrue()
    {   
        assertTrue(trie.startWith("ec"));
    }
				
    @Test
    public void searchBook()
    {   
        assertEquals(null, trie.search("book"));
    }

    @Test
    public void removeInTrie()
    {   
        Double res = trie.search("jar");
        assertNotNull("'jar' should be in trie", res);
        assertEquals(0.35, res, 0);         
    }

    public void removeNotInTrie()
    {   
        Double res = trie.search("ece");
        assertNull("'ece' is not in trie", res);    }

}
