import java.util.Stack;

public class BasicCalculator {

       
    public int calculator(String s){

        
        //parse the string
        //check if its a digit or operator
        //if digit append to the current number
        //if operator is + append the current number to the stack
        //if the operator is - , multiply the number with -1 and append to the stack
        //if operator is * or /
        //create the next number, pop from stack, eval the operation, push back to stack
        //once the string is parsed, add all the elements present in the stack
        int result =0;

        int len = s.length();

        Stack<Integer> evalStack = new Stack<>();

        char operation = '+';
        int currentNumber =0;
        
        for(int i =0; i<len; i++){

            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                currentNumber = currentNumber*10 + ch-'0';
            }
            if(!Character.isWhitespace(ch) && !Character.isDigit(ch) || i == len-1){
                switch(operation){
                    case '+':
                        evalStack.push(currentNumber);
                        break;
                    case '-':
                        evalStack.push(-1 * currentNumber);
                        break;
                    case '*':
                        evalStack.push(evalStack.pop() * currentNumber);
                        break;
                    case '/':
                        evalStack.push(evalStack.pop() / currentNumber);
                        break;
                }
                operation =ch;
                currentNumber =0;
            }
            
        }
        System.out.println(evalStack);
        while(!evalStack.isEmpty()){
            result = result + evalStack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator basic_calc = new BasicCalculator();

        String s =" 3/2 ";

        System.out.println(basic_calc.calculator(s));
    }
}
