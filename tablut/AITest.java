package tablut;

import org.junit.Test;

public class AITest {
    @Test
    public void testStaticScore() {
        Board b = new Board();
        b.makeMove(b.getSq(5, 0), b.getSq(5, 2));
        AI ai = new AI();
    }
    @Test
    public void testStaticScore2() {
        Board b = new Board();
        AI ai = new AI();
        b.makeMove(b.getSq(3, 0), b.getSq(3, 1));
        b.makeMove(b.getSq(5, 4), b.getSq(5, 2));
        b.makeMove(b.getSq(3, 1), b.getSq(3, 2));
        b.makeMove(b.getSq(4, 4), b.getSq(5, 4));
        b.makeMove(b.getSq(3, 2), b.getSq(3, 3));
        b.makeMove(b.getSq(5, 4), b.getSq(5, 6));
    }

}
