public class Solution {
	List<List<Integer>> result = new LinkedList<List<Integer>>();

	public List<List<Integer>> subsets(int[] s) {
		List<Integer> inner = new LinkedList<Integer>();
		Arrays.sort(s);
		helper(s, inner);
		return result;
	}

	void helper(int[] s, List<Integer> inner) {
		this.result.add(inner);
		if (s.length == 0) {
			return;
		}
		
		for (int i = 0; i < s.length; i++) {
			List<Integer> innertemp = new LinkedList<Integer>(inner);
			innertemp.add(s[i]);
			int[] temps=Arrays.copyOfRange(s, i + 1, s.length);
			helper(temps, innertemp);
		}

	}

}
