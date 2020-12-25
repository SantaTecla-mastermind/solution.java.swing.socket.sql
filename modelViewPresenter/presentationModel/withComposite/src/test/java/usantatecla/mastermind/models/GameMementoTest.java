package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import usantatecla.mastermind.types.Color;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GameMementoTest {
    private Game game;
    private List<Color> colors;
    private Memento memento;
    private Memento mementoWinner;

    public GameMementoTest(){
        this.game = new Game();
        this.colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.ORANGE);
        colors.add(Color.PURPLE);
        this.memento = new Memento(this.game);
    }

    @Test
    public void testAddProposedCombinationAndVerifyFirstColor(){
        this.game.addProposedCombination(colors);
        assertThat(this.game.getColors(0).get(0), is(Color.BLUE));
        this.game.clear();

    }

    @Test
    public void testCreateMementoAndCompareAttemps(){
        this.game.addProposedCombination(colors);
        this.game.createMemento();
        assertThat(this.game.getAttempts(), is(1));
        this.game.clear();
    }
    @Test
    public void testGetWidthThenReturn4(){
        assertThat(this.game.getWidth(), is(4));
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
        assertThat(this.game.isLooser(), is(true));
        this.game.clear();
    }

}