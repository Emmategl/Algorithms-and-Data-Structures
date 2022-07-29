import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//Final solution inspired by exercise on https://algs4.cs.princeton.edu/13stacks/Parentheses.java.html

public class Balance2{
public static void main(String[] args) {
        String line = StdIn.readLine();
        if (balanced(line)){
            StdOut.println("1");
        }
       else {
        StdOut.println("0");  
       }
}

public static boolean balanced(String line) {
    Stack<Character> stackOfParentheses = new Stack<Character>();

for (int stack = 0; stack < line.length(); stack++){
    if (line.charAt(stack) == '('){
        stackOfParentheses.push('(');
    }
    else if (line.charAt(stack) == '['){
        stackOfParentheses.push('['); 
    }
   

    else if (line.charAt(stack) == ')'){
        if (!stackOfParentheses.isEmpty()){
            if (stackOfParentheses.peek() == '('){
                stackOfParentheses.pop();
            }
            
            else if (stackOfParentheses.peek() != '('){
                return false;}
                }

                else {
                    return false;
                }
            }
    
        else if (line.charAt(stack) == ']'){
            if (!stackOfParentheses.isEmpty()){
                if (stackOfParentheses.peek() == '['){
                    stackOfParentheses.pop();
                }
                else if (stackOfParentheses.peek() != '['){
                    return false;
                }
        } 
        else {
            return false;
        }
    
    }
    }

if (stackOfParentheses.isEmpty()){
    return true;
}
return false;

}
}
