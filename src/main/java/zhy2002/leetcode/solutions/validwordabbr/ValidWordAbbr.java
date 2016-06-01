package zhy2002.leetcode.solutions.validwordabbr;

import java.util.HashMap;
import java.util.HashSet;

/**
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 * i|nternationalizatio|n  --> i18n
 * l|ocalizatio|n          --> l10n
 *
 * EX:
 *
 *1) [“dog”]; isUnique(“dig”);
 * //False, because “dig” has the same abbreviation with “dog" and “dog” is already in the dictionary. It’s not unique.
 *
 * 2) [“dog”, “dog"]; isUnique(“dog”);
 * //True, because “dog” is the only word that has “d1g” abbreviation.
 *
 *3) [“dog”, “dig”]; isUnique(“dog”);
 * //False, because if we have more than one word match to the same abbreviation, this abbreviation will never be unique.
 */
public class ValidWordAbbr {

    private final HashMap<Long, Boolean> abbrUnique = new HashMap<>();
    private final HashSet<String> words = new HashSet<>();

    public ValidWordAbbr(String[] dictionary) {
        for(String word : dictionary) {
            add(word);
        }
    }

    private void add(String word) {
        Long abbrKey = abbrKey(word);
        if(abbrUnique.containsKey(abbrKey)) {
            if(abbrUnique.get(abbrKey)) {
                if(!words.contains(word)) {
                    abbrUnique.put(abbrKey, false);
                }
            }
        } else {
            abbrUnique.put(abbrKey, true);
            words.add(word);
        }
    }

    private static long abbrKey(String word) {
        char first = 0, second = 0;
        int abbrLen = word.length() - 2;
        if(word.length() > 0) {
            first = word.charAt(0);
            if(word.length() > 1) {
                second = word.charAt(word.length() - 1);
            }
        }
        return (((long)first << 48) | ((long)second << 32) | ((long)abbrLen << 32 >>> 32));
    }

    public boolean isUnique(String word) {
        Long abbrKey = abbrKey(word);
        if(abbrUnique.containsKey(abbrKey)) {
            if(abbrUnique.get(abbrKey)) {
                return words.contains(word);
            }
            return false;
        } else {
            return true;
        }
    }
}
