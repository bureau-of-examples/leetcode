package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/design-compressed-string-iterator/#/description
 */
public class DesignCompressedStringIteratorTests {

    @Test
    public void test() {
        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
        assertThat(iterator.next(), equalTo('L'));
        assertThat(iterator.next(), equalTo('e'));
        assertThat(iterator.next(), equalTo('e'));
        assertThat(iterator.next(), equalTo('t'));
        assertThat(iterator.next(), equalTo('C'));
        assertThat(iterator.next(), equalTo('o'));
        assertThat(iterator.next(), equalTo('d'));
        assertThat(iterator.next(), equalTo('e'));
        assertThat(iterator.next(), equalTo(' '));
    }

    private static class StringIterator {

        private Deque<Integer> counts = new ArrayDeque<>();
        private Queue<Character> chars = new ArrayDeque<>();

        public StringIterator(String compressedString) {
            parse(compressedString);
        }

        private void parse(String string) {
            int index = 0;
            while (index < string.length()) {
                char ch = string.charAt(index);
                if (Character.isLetter(ch)) {
                    chars.add(ch);
                }
                int numberEnd = index + 1;
                while (numberEnd < string.length() && !Character.isLetter(string.charAt(numberEnd))) {
                    numberEnd++;
                }
                int count = Integer.parseInt(string.substring(index + 1, numberEnd));
                counts.add(count);
                index = numberEnd;
            }
        }

        public char next() {
            if (hasNext()) {
                int count = counts.poll();
                char ch = chars.peek();
                count--;
                if (count == 0) {
                    chars.poll();
                } else {
                    counts.addFirst(count);
                }
                return ch;
            }

            return ' ';
        }

        public boolean hasNext() {
            return counts.size() > 0;
        }
    }
}
