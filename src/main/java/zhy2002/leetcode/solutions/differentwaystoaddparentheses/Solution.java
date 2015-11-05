package zhy2002.leetcode.solutions.differentwaystoaddparentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 */
public class Solution {

    //solve recursively
    //result = result when first operator is the root + result when 2nd operator is the root + ....
    public List<Integer> diffWaysToCompute(String input) {

        ArrayList<Object> tokens = parse(input);
        return compute(tokens, 0, tokens.size() - 1);
    }

    //get the results for token[start] to token[end]
    private List<Integer> compute(ArrayList<Object> tokens, int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        if(start == end){
            result.add((Integer)tokens.get(start));
        } else {
            for(int i=start + 1; i<end; i++){//find all operators
                if(tokens.get(i) instanceof Character){
                    Character operator = (Character)tokens.get(i);
                    List<Integer> leftResults = compute(tokens, start, i - 1);
                    List<Integer> rightResults = compute(tokens, i+1, end);
                    for(Integer left : leftResults){
                        for(Integer right : rightResults){
                            result.add(compute(operator, left, right));
                        }
                    }
                }
            }
        }
        return result;
    }

    private Integer compute(Character operator, Integer left, Integer right){
        if(operator.equals('+')){
            return left + right;
        } else if(operator.equals('-')){
            return left - right;
        } else if(operator.equals('*')){
            return left * right;
        }
        throw new IllegalArgumentException(String.valueOf(operator));
    }

    private ArrayList<Object> parse(String input){
        ArrayList<Object> result = new ArrayList<>();
        if(input.length() == 0)
            return result;
        int start = 0;
        for(int i=0; true; i++){
            if(i == input.length() || "+-*".indexOf(input.charAt(i)) >= 0){
                result.add(Integer.valueOf(input.substring(start, i).trim()));
                if(i == input.length())
                    break;
                result.add(input.charAt(i));
                start = i + 1;
            }
        }
        return result;
    }


}
