package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class EncodeAndDecodeTinyURLTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }



    public class Codec {

        private Map<String, Integer> indexMap = new HashMap<>();
        private Map<Integer, String> valueMap = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            Integer index = indexMap.get(longUrl);
            if (index == null) {
                index = indexMap.size();
                indexMap.put(longUrl, index);
                valueMap.put(index, longUrl);
            }
            return Integer.toString(index, 36);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int index = Integer.parseInt(shortUrl, 36);
            return valueMap.get(index);
        }
    }
}
