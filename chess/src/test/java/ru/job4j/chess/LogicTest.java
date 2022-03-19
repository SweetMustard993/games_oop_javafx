package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Test
    public void moveFigureNotFound()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        try {
            logic.move(Cell.C2, Cell.H6);
            Assert.fail("Expected FigureNotFoundException");
        } catch (FigureNotFoundException exception) {
            Assert.assertNotEquals("", exception.getMessage());
        }
    }

    @Test
    public void moveOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.G5));
        try {
            logic.move(Cell.C1, Cell.H6);
            Assert.fail("Expected OccupiedCellException");
        } catch (OccupiedCellException exception) {
            Assert.assertNotEquals("", exception.getMessage());
        }
    }

    @Test
    public void moveImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        try {
            logic.move(Cell.C1, Cell.G6);
            Assert.fail("Expected ImpossibleMoveException");
        } catch (ImpossibleMoveException exception) {
            Assert.assertNotEquals("", exception.getMessage());
        }
    }
}