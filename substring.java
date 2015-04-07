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
