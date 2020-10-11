package usantatecla.mastermind.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import usantatecla.mastermind.types.Color;

public class GameTest {
    private Game game;
    private List<Color> colors;
    private Memento memento;
    private Memento mementoWinner;
    public GameTest(){
        this.game = new Game();
        this.colors = new ArrayList<Color>();
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.ORANGE);
        colors.add(Color.PURPLE);
        this.memento = new Memento(1);
        this.memento.set(new ProposedCombination(colors), new Result(2, 1));
        this.mementoWinner = new Memento(1);
        this.mementoWinner.set(new ProposedCombination(colors), new Result(4, 0));
    }

    @Test
    public void testAddProposedCombinationAndVerifyFirstColor(){
        this.game.addProposedCombination(colors);
        assertEquals(Color.BLUE, this.game.getColors(0).get(0));
        this.game.clear();

    }

    @Test
    public void testsetMementoAndCompareResults(){
        this.game.set(memento);
        assertEquals(2, this.game.getBlacks(0));
        assertEquals(1, this.game.getWhites(0));
        this.game.clear();
    }

    @Test
    public void testCreateMementoAndCompareAttemps(){
        this.game.addProposedCombination(colors);
        this.game.createMemento();
        assertEquals(1, this.game.getAttempts());
        this.game.clear();
    }
    @Test
    public void testGetWidthThenReturn4(){
        assertEquals(4, this.game.getWidth());
    }
    @Test
    public void testIsLooserAfter10AttempsThenGetTrue(){
        this.game.addProposedCombination(colors);
        this.game.addProposedCombination(colors);
        this.game.addProposedCombination(colors);
        this.game.addProposedCombination(colors);
        this.game.addProposedCombination(colors);
        this.game.addProposedCombination(colors);
        this.game.addProposedCombination(colors);
        this.game.addProposedCombination(colors);
        this.game.addProposedCombination(colors);
        this.game.addProposedCombination(colors);
        assertTrue(this.game.isLooser());
        this.game.clear();
    }

    @Test
    public void testisWinnerAfterAWinnerPropossedThenGetTrue(){
        this.game.set(mementoWinner);
        assertTrue(this.game.isWinner());
        this.game.clear();
    }
    
}