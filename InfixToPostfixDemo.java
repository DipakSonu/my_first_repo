import java.util.Stack;

class InfixToPostfixDemo{
    
    static String result="";

    static Stack<Character> stack = new Stack<Character>();
    public static void main(String[] args) {
        
        //String exp = "{A+B*(C^D-E)}";
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        //String exp="A+b-c*d";
        //String exp="(K +L-M*N+(O^P)*W/U/V*T+ Q)";
        
        exp=exp.replaceAll("\\s", "");

        System.out.println("Infix Expression: " + exp);

        System.out.println(infixToPostfix(exp));
    }


    static int precedence(char c){
        
        switch(c){

            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }

        return 0;
    }


    static String infixToPostfix(String exp){


        for(int i=0; i<exp.length(); i++) {
            
            char c = exp.charAt(i);
            
            if(Character.isLetterOrDigit(c)){
                
                result = result+c;
                
            }
            else if(c=='('){
                
                stack.push(c);
                stack.pop();
                
            }
            else if(c==')'){
                
                while(!stack.isEmpty() && stack.peek()!='('){

                    result=result+stack.peek();
                    stack.pop();
                }
                stack.pop();
        
            }
            else{
            
                while(!stack.isEmpty() && precedence(c)<=precedence(stack.peek())){
                
                    result = result+stack.peek();
                    stack.pop();
                }
                stack.push(c);
                
            }
        }

        while(!stack.isEmpty()){
            
            if(stack.peek()=='('){
                return "Invalid Expression ";
            }
            else{
                result=result+stack.peek();
                stack.pop();
            }
        }
        
        return result;
    }
}