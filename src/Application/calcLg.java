package Application;

import java.util.Stack;
import java.util.Arrays;

public class calcLg {
    public boolean isOperator(char a){
        if(a == '+') return true;
        else if(a == '-') return true;
        else if(a == '*') return true;
        else if(a == '/') return true;
        else if(a == '(' || a ==')') return true;
        return false;
    }

    public int getPriority(char ch){
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public boolean isOperatorO(char a){
        if(a == '+') return true;
        else if(a == '-') return true;
        else if(a == '*') return true;
        else if(a == '/') return true;
        return false;
    }

    double operation(char op, double a, double b){
        System.out.println("OPERATION CALL "+op+a + ": "+ b);
        switch(op){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0.0;
    }

    public boolean isValidNum(String in){
        try{
            Double d = Double.parseDouble(in);
            return true;
        }catch(Exception e){}
        return false;
    }

    public boolean isOperatorOnly(String str){ return str.length() == 1 && isOperator(str.charAt(0)); }

    public String calculate(Stack <String> content){
        String cpy = "";
        for(int x = 0; x < content.size(); x++)
            cpy+=(content.get(x))+(x == content.size()-1?"":",");
        System.out.println("calculating ->"+cpy);

        String str [] = cpy.split(",");

        Stack <Double> nums = new Stack<>();
        try {
            for (int x = 0; x < str.length; x++) {
                System.out.println("Focus -.->" + str[x]);
                if (!isOperatorOnly(str[x])) {
                    System.out.println("Pushing " + str[x]);
                    nums.push(Double.parseDouble(str[x]));
                } else {
                    System.out.println("This is an operator -> " + str[x]);
                    double a = nums.pop(), b = nums.pop();
                    nums.push(operation(str[x].charAt(0), b, a));
                    System.out.println(nums.peek());
                }
            }
        }catch (Exception e){
            return "Mali Syntax My Dude";
        }
        return nums.pop().toString();
    }

    public String toPost(String [] inf) {
        Stack <String> postF = new Stack<>();
        Stack <String> ops = new Stack<>();
        try {
            for (int x = 0; x < inf.length; x++) {
                String focus = inf[x];
                System.out.println("-> " + focus);
                if (isValidNum(focus)) {
                    postF.push(focus);
                } else if (focus.contains("(")) {
                    ops.push(focus);
                } else if (focus.contains(")")) {
                    while (!ops.isEmpty() && !ops.peek().contains("("))
                        postF.push(ops.pop());
                    if (!ops.isEmpty() && !ops.peek().contains("("))
                        return "Mali Syntax My Dude";
                    else
                        ops.pop();
                } else {
                    while (!ops.isEmpty() && getPriority(focus.charAt(0)) <= getPriority(ops.peek().charAt(0))) {
                        if (ops.peek().contains("("))
                            return "Mali Syntax My Dude";
                        postF.push(ops.pop());
                    }
                    ops.push(focus);
                }
            }

            while (!ops.isEmpty()) {
                if (ops.peek().contains("("))
                    return "Mali Syntax My Dude";
                postF.push(ops.pop());
            }

            System.out.println("F ->" + postF.toString());
        }catch (Exception e){
            return "Mali Syntax My Dude";
        }
        return calculate(postF) + "";
    }

    String formated(String r){
        String exp = "";
        for(int x = 0 ; x < r.length(); x++){
            char cc = r.charAt(x);
            System.out.println("Cur -> "+cc);
            if(isOperator(cc)){
                if(cc == '(')
                    exp += cc+",";
                else if(x+1 <= r.length()-1){
                    if(Character.isLetterOrDigit(r.charAt(x+1))){
                        if(isOperatorO(cc))
                            exp+=cc+",";
                        for(int y = x; y < r.length(); y++){
                            char c1 = r.charAt(y);
                            if(isOperator(c1))
                                break;
                            exp+=c1;
                            x++;
                        }
                    }else{
                        exp+=cc+",";
                    }
                }else{
                    exp+=cc+",";
                    break;
                }
            }else{
                int cop = x;
                for(int y = x; y < r.length(); y++){
                    char c1 = r.charAt(y);
                    if(isOperator(c1)){
                        exp+=","+c1+",";
                        break;
                    }
                    exp+=c1;
                    x++;
                }
            }
        }

        System.out.println("PF: "+exp);
        if(Character.isLetterOrDigit(exp.charAt(exp.length()-1))){
            int x = exp.length()-1;
            boolean sign = false;
            for(; x >= 0; x--)
                if(isOperator(exp.charAt(x))) break;
            char c3 = exp.charAt(x-2);
            System.out.println(c3);
            if(!isOperatorO(c3))
                exp = exp.substring(0, x+1) +","+ exp.substring(x+1);
        }
        String str[] = exp.split(",");
        int notEmpty = 0;
        for(String strr: str)
            if(!strr.isEmpty()) notEmpty++;
        String st[] = new String[notEmpty];
        int p1 = 0;
        for(int x = 0 ; x < str.length; x++){
            if(str[x].length() != 0){
                st[p1] = str[x];
                ++p1;
            }
        }
        System.out.println(Arrays.toString(st)+" not "+notEmpty);
        System.out.println("::"+Arrays.toString(st));
        System.out.println(toPost(st));
        return toPost(st);
    }
}
