这里比较转弯的地方是对于一个node里面childre的设置。
一开始只想用一个ArrayList,但是Arraylist的查找效率是On，对于插入来说效率还是太低了。
所以对于在ArrayList里面进行多次的一个匹配查找怎么办！
用hashset！
直接将val作为key.
所以孩子就变成了一个hashmap
所以孩子不是一个链表而是一个关系，或者说其实还是一个链表，引起这个链表只是通过值跟他对应而已。
其实数组什么的，本质也都是一个hashmap吧。

class TrieNode {
    // Initialize your data structure here.
        int val;
        HashMap<Character,TrieNode> children = new HashMap<Character,TrieNode>();
        boolean isWord;
    public TrieNode() {
    }
    public TrieNode(int val) {
        this.val = val;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
   	    public void insert(String word) {
		        char[] cur = word.toCharArray();
		        HashMap<Character, TrieNode> children = root.children;
		        for (int i = 0; i < word.length(); i++) {
		            TrieNode next;
		            if (children.containsKey(cur[i])) {
		                next = children.get(cur[i]);
		            } else {
		                next = new TrieNode(cur[i]);
		                children.put(cur[i], next);
		            }
		            children = next.children;
		            if (i == word.length() - 1) {
		                next.isWord = true;
		            }
		        }
		    }
            public boolean search(String word) {
                TrieNode t = searchNode(word);
                if (t != null && t.isWord)
                    return true;
                else 
                    return false;
            }
		    // Returns if the word is in the trie.
		    public TrieNode searchNode(String word) {
		        HashMap<Character, TrieNode> children = root.children;
		        TrieNode cur = null;
		        for (int i = 0; i < word.length(); i++) {
		            char c = word.charAt(i);
		            if(children.containsKey(c)) {
		                cur = children.get(c);
		                children = cur.children;
		            } else {
		                return null;
		            }
		        }
		        return cur;
		    }
		    // Returns if there is any word in the trie
		    // that starts with the given prefix.
		    public boolean startsWith(String prefix) {
		        if (searchNode(prefix) != null) {
		            return true;
		        } else {
		            return false;
		        }
		    }
		}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
