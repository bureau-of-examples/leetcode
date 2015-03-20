package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.Point;
import zhy2002.leetcode.solutions.maxpointsonaline.Solution;

import static org.junit.Assert.*;

public class MaxPointsOnALineTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        int result = solution.maxPoints(new Point[]{new Point(0, 0), new Point(1, 1), new Point(1, -1)});
        assertEquals(2, result);

        result = solution.maxPoints(new Point[]{new Point(3, 10), new Point(0, 2), new Point(0, 2), new Point(3, 10)});
        assertEquals(4, result);

        result = solution.maxPoints(new Point[]{new Point(0, -12), new Point(5, 2), new Point(2, 5), new Point(0, -5), new Point(1, 5), new Point(2, -2), new Point(5, -4), new Point(3, 4), new Point(-2, 4), new Point(-1, 4), new Point(0, -5), new Point(0, -8), new Point(-2, -1), new Point(0, -11), new Point(0, -9)});
        assertEquals(6, result);

        result = solution.maxPoints(new Point[]{new Point(84, 250), new Point(0, 0), new Point(1, 0), new Point(0, -70), new Point(0, -70), new Point(1, -1), new Point(21, 10), new Point(42, 90), new Point(-42, -230)});
        assertEquals(6, result);

        result = solution.maxPoints(new Point[]{new Point(0, 9), new Point(138, 429), new Point(115, 359), new Point(115, 359), new Point(-30, -102), new Point(230, 709), new Point(-150, -686), new Point(-135, -613), new Point(-60, -248), new Point(-161, -481), new Point(207, 639), new Point(23, 79), new Point(-230, -691), new Point(-115, -341), new Point(92, 289), new Point(60, 336), new Point(-105, -467), new Point(135, 701), new Point(-90, -394), new Point(-184, -551), new Point(150, 774)});
        assertEquals(12, result);

        result = solution.maxPoints(new Point[]{new Point(40,-23),new Point(9,138),new Point(429,115),new Point(50,-17),new Point(-3,80),new Point(-10,33),new Point(5,-21),new Point(-3,80),new Point(-6,-65),new Point(-18,26),new Point(-6,-65),new Point(5,72),new Point(0,77),new Point(-9,86),new Point(10,-2),new Point(-8,85),new Point(21,130),new Point(18,-6),new Point(-18,26),new Point(-1,-15),new Point(10,-2),new Point(8,69),new Point(-4,63),new Point(0,3),new Point(-4,40),new Point(-7,84),new Point(-8,7),new Point(30,154),new Point(16,-5),new Point(6,90),new Point(18,-6),new Point(5,77),new Point(-4,77),new Point(7,-13),new Point(-1,-45),new Point(16,-5),new Point(-9,86),new Point(-16,11),new Point(-7,84),new Point(1,76),new Point(3,77),new Point(10,67),new Point(1,-37),new Point(-10,-81),new Point(4,-11),new Point(-20,13),new Point(-10,77),new Point(6,-17),new Point(-27,2),new Point(-10,-81),new Point(10,-1),new Point(-9,1),new Point(-8,43),new Point(2,2),new Point(2,-21),new Point(3,82),new Point(8,-1),new Point(10,-1),new Point(-9,1),new Point(-12,42),new Point(16,-5),new Point(-5,-61),new Point(20,-7),new Point(9,-35),new Point(10,6),new Point(12,106),new Point(5,-21),new Point(-5,82),new Point(6,71),new Point(-15,34),new Point(-10,87),new Point(-14,-12),new Point(12,106),new Point(-5,82),new Point(-46,-45),new Point(-4,63),new Point(16,-5),new Point(4,1),new Point(-3,-53),new Point(0,-17),new Point(9,98),new Point(-18,26),new Point(-9,86),new Point(2,77),new Point(-2,-49),new Point(1,76),new Point(-3,-38),new Point(-8,7),new Point(-17,-37),new Point(5,72),new Point(10,-37),new Point(-4,-57),new Point(-3,-53),new Point(3,74),new Point(-3,-11),new Point(-8,7),new Point(1,88),new Point(-12,42),new Point(1,-37),new Point(2,77),new Point(-6,77),new Point(5,72),new Point(-4,-57),new Point(-18,-33),new Point(-12,42),new Point(-9,86),new Point(2,77),new Point(-8,77),new Point(-3,77),new Point(9,-42),new Point(16,41),new Point(-29,-37),new Point(0,-41),new Point(-21,18),new Point(-27,-34),new Point(0,77),new Point(3,74),new Point(-7,-69),new Point(-21,18),new Point(27,146),new Point(-20,13),new Point(21,130),new Point(-6,-65),new Point(14,-4),new Point(0,3),new Point(9,-5),new Point(6,-29),new Point(-2,73),new Point(-1,-15),new Point(1,76),new Point(-4,77),new Point(6,-29)});
        assertEquals(25, result);


    }
}
