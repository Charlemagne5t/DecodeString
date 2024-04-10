import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Deque<String> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            //System.out.println(stack);
            char ch = s.charAt(i);
            if(ch != ']' ){
                stack.push(ch + "") ;
            }else {
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek().charAt(0) >= 'a' && stack.peek().charAt(0) <= 'z'){
                    sb.insert(0, stack.pop());
                }

                if(!stack.isEmpty() && stack.peek().equals("[")){
                    stack.pop();
                }

                int num = 0;
                int pow = 0;

                while(!stack.isEmpty() && (stack.peek().charAt(0) -'0') >= 0 && (stack.peek().charAt(0) -'0') <= 9){
                    num = num + (int) Math.pow(10, pow++) * (stack.pop().charAt(0) - '0');

                }
                if(num == 0){
                    stack.push(sb.toString());
                }else{
                    String spread = copy(sb.toString(), num);
                    stack.push(spread);
                }

            }
        }
        //System.out.println(stack);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    String copy(String s, int mult){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < mult; i++){
            sb.append(s);
        }

        return sb.toString();
    }
}
