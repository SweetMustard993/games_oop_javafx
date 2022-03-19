package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void positionCorrect() {
        Cell startPosition = Cell.B8;
        Figure bishopBlack = new BishopBlack(startPosition);
        assertThat(Cell.B8.equals(bishopBlack.position()), is(true));
    }

    @Test
    public void copyCorrect() {
        Cell position = Cell.B8;
        Figure bishopBlack = new BishopBlack(position);
        bishopBlack = bishopBlack.copy(position);
        assertThat(Cell.B8.equals(bishopBlack.position()), is(true));
    }

    @Test
    public void wayCorrect() {
        Cell dest = Cell.G5;
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] rsl = bishopBlack.way(dest);
        assertThat(rsl, is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test
    public void wayIncorrect() throws ImpossibleMoveException {
        Cell dest = Cell.G6;
        Figure bishopBlack = new BishopBlack(Cell.C1);
        try {
            Cell[] rsl = bishopBlack.way(dest);
            Assert.fail("Expected ImpossibleMoveException");
        } catch (ImpossibleMoveException exception) {
            Assert.assertNotEquals("", exception.getMessage());
        }
    }
}