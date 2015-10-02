这题自己敲出来了。。好不容易哦=   =感动得哭了。。
网上有个版本在最下面，思路差不多，但是好简洁。。而且没有用hashmap，因为是26个字母，所以直接用的是数组
然后一一对应。。真是聪明。。
import java.util.Map.Entry;
public class WordDictionary {
    class TrieNode{
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isWord;
        char val;
        public TrieNode() {}
     
        public TrieNode(char c){
            this.val = c;
        }
    }
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> hm = null;
        for(int i = 0; i < word.length(); i++) {
            hm = cur.children;
            char c = word.charAt(i);
            if (hm.containsKey(c)) {
                cur = hm.get(c);
            } else {
                cur = new TrieNode(c);
                hm.put(c, cur);
            }
            if (i == word.length() - 1) {
                cur.isWord = true;
            }
        }
    }

     public boolean search(String word) {
		    	return helper(word, root, 0);
		    }

		    // Returns if the word is in the data structure. A word could
		    // contain the dot character '.' to represent any one letter.
		     public boolean helper(String word, TrieNode cur, int i) {
	            HashMap<Character, TrieNode> hm = cur.children; 
	            if (i == word.length()) {
	                return cur.isWord;
	            }
	            char c = word.charAt(i);

	            if (c != '.') {
	                if (hm.containsKey(c)) {
	                    cur = hm.get(c);
	                    return helper(word, cur, i + 1);
	                } else {
	                    return false;
	                }
	            } else {
	                if (hm.isEmpty()) {
	                    return false;
	                } else {
	                    Iterator<Entry<Character, TrieNode>> iterator = hm.entrySet().iterator();
	                    while(iterator.hasNext()) {
	                        Entry<Character, TrieNode> entry = iterator.next();
	                        if (helper(word, entry.getValue(), i + 1)) {
	                            return true;
	                        }
	                    }
	                }
	                return false;
	            }
		         
		     }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    
}
————————————————————————————网上的代码
public class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }

    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode runner = root;
        for (char c : word.toCharArray()) {
            if (runner.children[c - 'a'] == null) {
                runner.children[c - 'a'] = new TrieNode();
            }
            runner = runner.children[c - 'a'];
        }
        runner.isEndOfWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    public boolean match(char[] word, int k, TrieNode node) {
        if (k == word.length) return node.isEndOfWord;
        if (word[k] != '.') {
            return node.children[word[k] - 'a'] != null && match(word, k+1, node.children[word[k] - 'a']);
        }
        else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(word, k+1, node.children[i])) return true;
                }
            }
        }
        return false;
    }
}
