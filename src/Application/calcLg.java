package Application;

import java.util.Stack;

public class calcLg {

    public boolean isOperator(char a){
        if(a == '+') return true;
        else if(a == '-') return true;
        else if(a == '*') return true;
        else if(a == '^') return true;
        else if(a == '/') return true;
        else if(a == '(' || a ==')') return true;
        return false;
    }

    public int getPriority(char ch){
        switch (ch) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    public boolean isOperatorO(char a){
        if(a == '+') return true;
        else if(a == '-') return true;
        else if(a == '*') return true;
        else if(a == '^') return true;
        else if(a == '/') return true;
        return false;
    }

    double operation(char op, double a, double b){
        System.out.println("OPERATION CALL "+op+a + ": "+ b);
        switch(op){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            case '^': return Math.pow(a,b);
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
        for(int x = 0; x < content.size(); x++) cpy+=(content.get(x))+(x == content.size()-1?"":",");

        String str [] = cpy.split(",");

        Stack <Double> nums = new Stack<>();
        try {
            for (int x = 0; x < str.length; x++) {
                System.out.println("Focus -.->" + str[x]);
                if (!isOperatorOnly(str[x])) { nums.push(Double.parseDouble(str[x])); }
                else {
                    double a = nums.pop(), b = nums.pop();
                    nums.push(operation(str[x].charAt(0), b, a));
                }
            }
        }catch (Exception e){ return "Mali Syntax My Dude"; }
        return nums.pop().toString();
    }

    public String toPost(String [] inf) {
        Stack <String> postF = new Stack<>();
        Stack <String> ops = new Stack<>();
        try {
            for (int x = 0; x < inf.length; x++) {
                String focus = inf[x];
                System.out.println("-> " + focus);
                if (isValidNum(focus)) { postF.push(focus); }
                else if (focus.contains("(")) { ops.push(focus); }
                else if (focus.contains(")")) {
                    while (!ops.isEmpty() && !ops.peek().contains("(")) postF.push(ops.pop());
                    if (!ops.isEmpty() && !ops.peek().contains("(")) return "Mali Syntax My Dude";
                    else ops.pop();
                } else {
                    while (!ops.isEmpty() && getPriority(focus.charAt(0)) <= getPriority(ops.peek().charAt(0))) {
                        if (ops.peek().contains("(")) return "Mali Syntax My Dude";
                        postF.push(ops.pop());
                    }
                    ops.push(focus);
                }
            }

            while (!ops.isEmpty()) {
                if (ops.peek().contains("(")) return "Mali Syntax My Dude";
                postF.push(ops.pop());
            }
        }catch (Exception e){ return "Mali Syntax My Dude"; }
        return calculate(postF) + "";
    }

    public String formated(String str){
        String finalStr = "";

        int len = str.length();
        boolean isPrevO = false;

        for(int x = 0; x < len; x++){
            char f = str.charAt(x);

            if(isOperator(f)){
                if(x-1 >= 0)
                    if(!isOperator(str.charAt(x-1))) isPrevO = true;
                    else isPrevO = false;
                else isPrevO = false;
            }else isPrevO = false;

            if(f == '(' || f == ')') finalStr += f+",";
            else if(isValidNum(f+"")){
                finalStr += f;
                isPrevO = false;
                for(int y = x+1; y < len; y++){
                    char ff = str.charAt(y);
                    if(isOperator(ff)){
                        finalStr+=',';
                        break;
                    }
                    finalStr+=ff;
                    x++;
                }
            }
            else if(f == '-' || f == '+' && !isPrevO){
                finalStr += f;
                isPrevO = false;
                if(x - 1 >= 0)
                    if(isValidNum(""+str.charAt(x-1))){
                        finalStr+=",";
                        continue;
                    }
                for(int y = x+1; y < len; y++){
                    char ff = str.charAt(y);
                    if(isOperator(ff)){
                        finalStr+=',';
                        break;
                    }
                    finalStr+=ff;
                    x++;
                }
            }else if(isOperatorO(f)) finalStr += f +",";
        }
        return toPost(finalStr.split(","));
    }
}
