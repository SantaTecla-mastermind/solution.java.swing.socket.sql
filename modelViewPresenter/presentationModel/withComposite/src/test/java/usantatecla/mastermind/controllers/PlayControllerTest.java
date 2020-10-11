package usantatecla.mastermind.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import usantatecla.mastermind.models.Session;

public class PlayControllerTest {
    private PlayController playController;
    private Session session;
    private List<Color> colors;
    private List<Color> colors2;

    public PlayControllerTest() {
        this.session = new Session();
        this.playController = new PlayController(session);
        colors = new ArrayList<Color>();
        colors.add(Color.BLUE);
        colors.add(Color.ORANGE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        
        colors2 = new ArrayList<Color>();
        colors2.add(Color.YELLOW);
        colors2.add(Color.PURPLE);
        colors2.add(Color.ORANGE);
        colors2.add(Color.RED);
        
    }

    @Test
    public void testIsWinnerAtTheGameBeginsThenIsFalse(){
        assertFalse(this.playController.isWinner());
    }

    @Test
    public void testIsLooserAtTheGameBeginsThenIsFalse(){
        assertFalse(this.playController.isLooser());
    }

    @Test
    public void testGetAttempsAtTheGameBeginsThenIs0(){
        assertEquals(this.playController.getAttempts(),0);
    }
    @Test
    public void testRedoableAtTheGameBeginsThenIsFalse(){
        assertFalse(this.playController.redoable());
    }
    @Test
    public void testUndoableAtTheGameBeginsThenIsFalse(){
        assertFalse(this.playController.undoable());
    }
    @Test
    public void testGetColorsAfterProposeACombination(){
        this.playController.addProposedCombination(colors);
        assertEquals(colors, this.playController.getColors(0));
    }

    @Test
    public void testUndoAfterPropose2CombinationsThenReturnColorsBeforeLast(){
        this.playController.addProposedCombination(colors);
        this.playController.addProposedCombination(colors2);
        this.playController.undo();
        assertEquals(colors, this.playController.getColors(0));
      //  this.session.clearGame();
    }

    @Test
    public void testRedoAfterPropose2CombinationsThenReturnColorsBeforeLast(){
        this.playController.addProposedCombination(colors);
        this.playController.addProposedCombination(colors2);
        this.playController.undo();
        this.playController.redo();
        assertEquals(colors2, this.playController.getColors(1));
        assertEquals(2, this.playController.getAttempts());
      //  this.session.clearGame();
    }



    @Test
    public void testGetWhitesAfterProposeCombination(){
       // List<Color> colors = this.playController.session.getSecretCombination();
       // this.playController.addProposedCombination(colors);
       // assertEquals(0, this.playController.getWhites(0));
    }
    @Test
    public void testGetBlacksAfterProposeCombination(){
      //  List<Color> colors = this.playController.session.getSecretCombination();
       // this.playController.addProposedCombination(colors);
      //  assertEquals(4, this.playController.getBlacks(0));
    }
}