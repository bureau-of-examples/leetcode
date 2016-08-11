package zhy2002.leetcode.solutions.ransomnote;

/**
 * https://leetcode.com/problems/ransom-note/
 * <p>
 * Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.
 * <p>
 * Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() == 0)
            return true;

        int[] counts = new int[26];
        int mask = 0;
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if(counts[index] == 0) {
                mask |= Integer.MIN_VALUE >>> index;
            }
            counts[index]++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            counts[index]--;
            if (counts[index] == 0) {
                mask &= ~(Integer.MIN_VALUE >>> index);
                if (mask == 0)
                    return true;
            }
        }
        return false;
    }
}
