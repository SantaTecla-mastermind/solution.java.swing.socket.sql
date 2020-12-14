package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usantatecla.mastermind.types.Color;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.List;


import usantatecla.mastermind.models.Session;

public class PlayControllerTest {
    private PlayController playController;
    private Session session;
    private List<Color> colors;
    private List<Color> colors2;

    @BeforeEach
    void PlayControllerTest() {
        this.session = new Session(null);
        this.playController = new PlayController(session,null);
        colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.ORANGE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        
        colors2 = new ArrayList<>();
        colors2.add(Color.YELLOW);
        colors2.add(Color.PURPLE);
        colors2.add(Color.ORANGE);
        colors2.add(Color.RED);
        
    }

    @Test
    public void testIsWinnerAtTheGameBeginsThenIsFalse(){
        assertThat(this.playController.isWinner(), is(false));
    }
    @Test
    public void testIsLooserAtTheGameBeginsThenIsFalse(){
        assertThat(this.playController.isLooser(), is(false));
    }
    @Test
    public void testGetAttempsAtTheGameBeginsThenIs0(){
        assertThat(this.playController.getAttempts(),is(0));
    }
    @Test
    public void testRedoableAtTheGameBeginsThenIsFalse(){
        assertThat(this.playController.redoable(), is(false));
    }
    @Test
    public void testUndoableAtTheGameBeginsThenIsFalse(){
        assertThat(this.playController.undoable(), is(false));
    }
    @Test
    public void testGetColorsAfterProposeACombination(){
        this.playController.addProposedCombination(colors);
        assertThat(this.playController.getColors(0), is(colors));
    }

    @Test
    public void testUndoAfterPropose2CombinationsThenReturnColorsBeforeLast(){
        this.playController.addProposedCombination(colors);
        this.playController.addProposedCombination(colors2);
        this.playController.undo();
        assertThat(this.playController.getColors(0), is(colors));
        //this.session.clearGame();
    }

    @Test
    public void testRedoAfterPropose2CombinationsThenReturnColorsBeforeLast(){
        this.playController.addProposedCombination(colors);
        this.playController.addProposedCombination(colors2);
        this.playController.undo();
        this.playController.redo();
        assertThat(this.playController.getColors(1), is(colors2));
        assertThat(this.playController.getAttempts(), is(2));
        //this.session.clearGame();
    }



    @Test
    public void testGetWhitesAfterProposeCombination(){
        /*List<Color> colors = new ArrayList<>();
        colors.add(Color.ORANGE);
        colors.add(Color.PURPLE);
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        this.playController.addProposedCombination(colors);
        assertThat(this.playController.getWhites(0), is(0));*/
    }
    @Test
    public void testGetBlacksAfterProposeCombination(){
        /*List<Color> colors = new ArrayList<>();
        colors.add(Color.ORANGE);
        colors.add(Color.PURPLE);
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        this.playController.addProposedCombination(colors);
        assertThat(this.playController.getBlacks(0), is(0));*/
    }
}
