package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.lettercombinationsofaphonenumber.Solution;
import java.util.List;
import static org.junit.Assert.*;

public class LetterCombinationsOfAPhoneNumberTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertArrayEquals(new String[]{}, solution.letterCombinations("").toArray());
        assertArrayEquals(new String[]{"a","b","c"}, solution.letterCombinations("2").toArray());
        assertArrayEquals(new String[]{"d","e","f"}, solution.letterCombinations("3").toArray());
        assertArrayEquals(new String[]{"g","h","i"}, solution.letterCombinations("4").toArray());
        assertArrayEquals(new String[]{"p","q","r","s"}, solution.letterCombinations("7").toArray());
        assertArrayEquals(new String[]{"t","u","v"}, solution.letterCombinations("8").toArray());
        assertArrayEquals(new String[]{"w","x","y","z"}, solution.letterCombinations("9").toArray());
        assertArrayEquals(new String[]{"ad","bd","cd","ae","be","ce","af","bf","cf"}, solution.letterCombinations("23").toArray());
        assertArrayEquals(new String[]{"pp","qp","rp","sp","pq","qq","rq","sq","pr","qr","rr","sr","ps","qs","rs","ss"}, solution.letterCombinations("77").toArray());
        assertArrayEquals(new String[]{"awtp","bwtp","cwtp","axtp","bxtp","cxtp","aytp","bytp","cytp","aztp","bztp","cztp","awup","bwup","cwup","axup","bxup","cxup","ayup","byup","cyup","azup","bzup","czup","awvp","bwvp","cwvp","axvp","bxvp","cxvp","ayvp","byvp","cyvp","azvp","bzvp","czvp","awtq","bwtq","cwtq","axtq","bxtq","cxtq","aytq","bytq","cytq","aztq","bztq","cztq","awuq","bwuq","cwuq","axuq","bxuq","cxuq","ayuq","byuq","cyuq","azuq","bzuq","czuq","awvq","bwvq","cwvq","axvq","bxvq","cxvq","ayvq","byvq","cyvq","azvq","bzvq","czvq","awtr","bwtr","cwtr","axtr","bxtr","cxtr","aytr","bytr","cytr","aztr","bztr","cztr","awur","bwur","cwur","axur","bxur","cxur","ayur","byur","cyur","azur","bzur","czur","awvr","bwvr","cwvr","axvr","bxvr","cxvr","ayvr","byvr","cyvr","azvr","bzvr","czvr","awts","bwts","cwts","axts","bxts","cxts","ayts","byts","cyts","azts","bzts","czts","awus","bwus","cwus","axus","bxus","cxus","ayus","byus","cyus","azus","bzus","czus","awvs","bwvs","cwvs","axvs","bxvs","cxvs","ayvs","byvs","cyvs","azvs","bzvs","czvs"}, solution.letterCombinations("2987").toArray());

    }
}
