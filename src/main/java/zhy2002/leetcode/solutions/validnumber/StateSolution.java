package zhy2002.leetcode.solutions.validnumber;

/**
 * State machine based solution.
 * The commented code prohibits the first digit of integer part being 0, e.g. 0124.
 */
public class StateSolution implements Solution{
    // [+-]000.000[eE][+-]000.000
    //0 1  2  34   5   6  7  89
    @Override
    public boolean isNumber(String s) {
        if (s == null)
            return false;

        s = s.trim();
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-') {
                if (state == 0) {
                    state = 1;
                } else if (state == 5) {
                    state = 6;
                } else {
                    state = -1;
                    break;
                }
            } else if (ch >= '0' && ch <= '9') {
                if (state == 0 || state == 1) {
//                    if(ch == '0'){
//                        if(!(s.length() == 1 || i + 1 < s.length() && s.charAt(i + 1) == '.')){
//                            state = -1;
//                            break;
//                        }
//                    }
                    state = 2;
                } else if (state == 3) {
                    state = 4;
                } else if (state == 5 || state == 6) {
//                    if(ch == '0'){
//                        if(!(s.length() == 1 || i + 1 < s.length() && s.charAt(i + 1) == '.')){
//                            state = -1;
//                            break;
//                        }
//                    }
                    state = 7;
                } else if (state == 8) {
                    state = 9;
                }
            } else if (ch == '+' || ch == '-') {
                if (state == 0) {
                    state = 1;
                } else if (state == 2 || state == 4 || state == 5) {
                    state = 6;
                } else {
                    state = -1;
                    break;
                }
            } else if (ch == 'e' || ch == 'E') {
                if (state == 2 || state == 3 || state == 4) {
                    state = 5;
                } else {
                    state = -1;
                    break;
                }
            } else if (ch == '.') {
                if (!(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') && !(i - 1 >= 0 && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9')) {
                    state = -1;
                    break;
                }
                if (state == 0 || state == 1 || state == 2) {
                    state = 3;
                } else if (state == 5 || state == 6 || state == 7) {
                    state = 8;
                } else {
                    state = -1;
                    break;
                }
            } else {
                state = -1;
                break;
            }
        }
        return state == 2 || state == 3 || state == 4 || state == 7;
    }
}
