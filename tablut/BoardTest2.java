package tablut;

import org.junit.Test;
import static org.junit.Assert.*;
import static tablut.Piece.*;


public class BoardTest2 {
    @Test
    public void testInit() {
        Board b = new Board();
        assertEquals(0, b.getMemory().size());
        assertEquals(0, b.getEncodedMemory().size());
        b.makeMove(b.getSq(5, 0), b.getSq(5, 2));
        assertEquals(2, b.getEncodedMemory().size());
        assertEquals(2, b.getMemory().size());
        assertEquals(1, b.moveCount());
        assertEquals(null, b.winner());
        assertEquals(b.getSq(4, 4), b.kingPosition());
        assertTrue(b.getSq(5, 0).isEdge());
    }
    @Test
    public void testSimpleMove() {
        Board b = new Board();
        b.makeMove(b.getSq(5, 0), b.getSq(5, 1));
        b.makeMove(b.getSq(5, 4), b.getSq(5, 3));
        assertEquals(EMPTY, b.get(5, 4));
        assertEquals(WHITE, b.get(5, 3));
        assertEquals(null, b.winner());

    }
    @Test
    public void testUndo() {
        Board b = new Board();
        b.makeMove(b.getSq(5, 0), b.getSq(5, 2));
        b.makeMove(b.getSq(4, 5), b.getSq(7, 5));
        b.undo();
        assertEquals(WHITE, b.get(4, 5));
        assertEquals(EMPTY, b.get(7, 5));
    }
    @Test
    public void testRepeat() {
        Board b1 = new Board();

        String s1 = b1.encodedBoard();

        b1.makeMove(b1.getSq(5, 0), b1.getSq(5, 1));

        b1.makeMove(b1.getSq(5, 4), b1.getSq(5, 5));

        b1.makeMove(b1.getSq(5, 1), b1.getSq(5, 0));

        b1.makeMove(b1.getSq(5, 5), b1.getSq(5, 4));
        String s2  = b1.encodedBoard();
        assertEquals(s1, s2);
        assertEquals(5, b1.getEncodedMemory().size());
    }
    @Test
    public void testEdgeMove() {
        Board b = new Board();
        b.makeMove(b.getSq(3, 0), b.getSq(3, 1));
        assertFalse(b.edgeMove(b.getSq(4, 4)));
        b.makeMove(b.getSq(5, 4), b.getSq(5, 2));
        b.makeMove(b.getSq(3, 1), b.getSq(3, 2));
        b.makeMove(b.getSq(4, 4), b.getSq(5, 4));
        b.makeMove(b.getSq(3, 2), b.getSq(3, 3));
        b.makeMove(b.getSq(5, 4), b.getSq(5, 6));
        assertTrue(b.edgeMove(b.getSq(5, 6)));
    }
    @Test
    public void testCapture() {
        Board b = new Board();
        b.makeMove(b.getSq(0, 3), b.getSq(1, 3));
        b.makeMove(b.getSq(4, 3), b.getSq(6, 3));
        b.makeMove(b.getSq(1, 3), b.getSq(2, 3));
        b.makeMove(b.getSq(4, 2), b.getSq(6, 2));
        b.makeMove(b.getSq(2, 3), b.getSq(4, 3));
        b.makeMove(b.getSq(6, 2), b.getSq(4, 2));
        assertEquals(EMPTY, b.get(4, 3));
    }
    @Test
    public void testOrthAdjOppo() {
        Board b = new Board();
        b.makeMove(b.getSq(5, 0), b.getSq(5, 3));
        b.makeMove(b.getSq(5, 4), b.getSq(5, 6));
        b.makeMove(b.getSq(5, 3), b.getSq(5, 4));
        b.makeMove(b.getSq(4, 5), b.getSq(1, 5));
        b.makeMove(b.getSq(8, 5), b.getSq(4, 5));
        b.makeMove(b.getSq(3, 4), b.getSq(3, 7));
        b.makeMove(b.getSq(3, 0), b.getSq(3, 4));
        b.makeMove(b.getSq(4, 3), b.getSq(1, 3));
        b.makeMove(b.getSq(8, 3), b.getSq(4, 3));
    }
    @Test
    public void testAroundKing() {
        Board b = new Board();
        b.makeMove(b.getSq(5, 0), b.getSq(5, 1));
        System.out.println(b.getSq(5, 4).adjacent(b.getSq(4, 4)));


        System.out.println(b);
    }

}
