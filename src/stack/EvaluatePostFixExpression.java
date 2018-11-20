package stack;

public class EvaluatePostFixExpression {
    public int evaluate(String[] tokens){
        FixedSizeArrayStack<Integer> stack = new FixedSizeArrayStack(tokens.length);
        int result = 0;
        try{
            for(String token :tokens){
                switch (token){
                    case "+":
                        int op1 = stack.pop();
                        int opt2 =stack.pop();
                        stack.push(op1+opt2);
                        break;
                    case "-":
                        int op3 = stack.pop();
                        int opt4 =stack.pop();
                        stack.push(opt4-op3);
                        break;
                    case "/":
                        int op5 = stack.pop();
                        int opt6 =stack.pop();
                        stack.push(opt6 /op5);
                        break;
                    case "*":
                        int op7 = stack.pop();
                        int opt8 =stack.pop();
                        stack.push(op7*opt8);
                        break;

                    default:stack.push(Integer.valueOf(token));
                }


            }
            result =  stack.pop();
        }catch (Exception e){

        }
        return result;
    }
}
