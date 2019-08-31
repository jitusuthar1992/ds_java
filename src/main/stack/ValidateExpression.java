package main.stack;

public class ValidateExpression {

    public boolean validateExpression(String exp){
        FixedSizeArrayStack stack = new FixedSizeArrayStack(exp.length());

        if(null == exp || exp.isEmpty())
            return true;
        for(char c : exp.toCharArray()){
            try{
                if(c == '[') {
                    stack.push(c);
                }
                if (c == ']'){
                    if(!stack.isEmpty() && stack.top == '[')
                        stack.pop();
                    return false;
                }

                if(c == '{') {
                    stack.push(c);
                }
                if (c == '}'){
                    if(!stack.isEmpty() && stack.top == '{')
                        stack.pop();
                    return false;
                }

                if(c == '(') {
                    stack.push(c);
                }
                if (c == ')'){
                    if(!stack.isEmpty() && stack.top == '(')
                        stack.pop();
                    return false;
                }

            }catch(Exception e ){

            }


        }
        if(stack.isEmpty())
            return true;
            return false;
    }

}
