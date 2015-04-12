Given two strings, check if they are anagrams.
An anagram is a type of word play, the result of rearranging the letters of a word or phrase to produce a new word or phrase, using all the original letters exactly once; for example Torchwood can be rearranged into Doctor Who. 
Note: All inputs will be in lower-case.

//Anagrams: are you searching "grams ana"
//Anagrams: cat, act // anagrams, gramsana

//Given two strings, check if they are anagrams.

//An anagram is a type of word play, the result of rearranging the letters of a word or phrase to produce a new word or phrase, //using all the original letters exactly once; for example Torchwood can be rearranged into DoctorWho.
//Note: All inputs will be in lower-case. No space. No punctuations.

//Time: O(nlogn) Space: O(n)
class Solution{//another function is Arrays.sort..but it is nlogn.
    Boolean anagrams(String s1, String s2){
        HashMap<Character, Integer> h1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> h2 = new HashMap<Character, Integer>();
        for(int i = 0; i < s1.length; i++){
            if(h1.containsKey(s1.charAt(i))){
                int temp = h1.get(s1.charAt(i))+1;
                h1.put(s1.charAt(i), temp);
            } else {
                h1.put(s1.charAt(i), 1);
            }
        }
        for(int i = 0; i < s2.length; i++){
            if(h2.containsKey(s2.charAt(i))){
                int temp = h2.get(s2.charAt(i))+1;
                h2.put(s2.charAt(i), temp);
            } else {
                h2.put(s2.charAt(i), 1);
            }
        }        
        if(h1.size()!= h2.size()){ 
            return false;
        }
        Iterator t = h1.iterator();
        while(t.hasNext()){
            Map.Entry pair = (Map.Entry)t.next();
            if(!h2.contains(pair.getKey()){
                return false;
            }
            if(h2.get(pair.getKey()) != pair.getValue)) {
                return false;      
            }
            return true;
        }
    }
}

Given a list of list of email addresses, output the email addresses that are in all lists
1: foo@amazon.com, bar@amazon.com
2. bar@amazon.com, foobar@amazon.com
3. bar@amazon.com, barfoo@amazon.com

output bar@amazon.com

List<String> commonAddress(List<List<String> lists) {
    Set<String> set = new HashSet<String>();
    List<String> result = new ArrayList<String>();
    for (int i = 0; i < lists.get(0).size()) {
        set.add(lists.get(0).get(i));
    }

    for (int i = 1; i < lists.size(); i++) {
        Set<String> tempSet = new HashSet<String>();
        for (int j = 0; j < lists.get(i).size(); j++) {
            String curr = lists.get(i).get(j);
            if (set.contains(curr)) {
                tempSet.add(curr);
            }
        }
        set = tempSet.clone();
    }
    
    for (String s : set) {
        result.add(s);
    }

    return result;
}
