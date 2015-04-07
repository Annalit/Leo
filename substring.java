//Suppose you have a String with parentheses
//For example: (a(bc)d)efg(h)
//Write a function to check, whether these parentheses are valid
//Your function prototype would be:
//Boolean isValid(String s)
#bug line 14
#bug line 19
Boolean isValid(String a){

    if(a==null||a.length==0)
    return true;
 Stack<Character> s=new Stack<Character>()
 
 int len=a.length();//len=8
 for(int i=0;i<=len;i++){
     if(a.charAt(i)=='(') {//)
         s.push(a.charAt(i));
     } else if(a.charAt(i)==')'){
         if(s.peek()=='(')){
             s.pop();
         }else {
             return false
         }
     }else 
         continue;
 }
 if(s.empty)
 return true;
 else 
 return false;


}

//Follow up:
//Write a function that output the substring in parentheses.
//Example: you should output a(bc)d, bc, h
//List<String> output(String s)

List<String> output(String s){
    LinkedList<String> out = new LinkedList<String>();
    Stack<Character> stack = new Stack<Character>();
    if (s == null|| s.length == 0){
        return out;
    }
    len=s.length();
    for( int i=0; i<len; i++ ){
        Character temp = s.charAt(i);
        if (temp == '('){
            stack.push(i);
        } else if (temp ==')'){
            int left = stack.pop();
            int right = i;
            out.add(s.subString(left,right));  
        } else {
            continue;
        }
    }
    return out;
}
