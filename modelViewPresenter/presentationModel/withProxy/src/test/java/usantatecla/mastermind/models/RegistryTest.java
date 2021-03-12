package usantatecla.mastermind.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.mastermind.types.Color;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RegistryTest {

    private static String INITIALS = "rgby";

    private Board board;
    private Registry registry;

    @BeforeEach
    public void beforeEach() {
        this.board = new Board();
        this.registry = new Registry(this.board);
    }

    @Test
    public void givenEmptyRegistryWhenUndoableOrRedoableThenFalse() {
        assertThat(this.registry.undoable(), is(false));
        assertThat(this.registry.redoable(), is(false));
    }

    @Test
    public void givenRegistryWhenResetThenIsNotUndoableNorRedoable() {
        this.registry.register();
        this.registry.reset();
        assertThat(this.registry.undoable(), is(false));
        assertThat(this.registry.redoable(), is(false));
    }

    @Test
    void givenRegistryWhenRegisterThenIsUndoableAndNotRedoable() {
        this.registry.register();
        assertThat(this.registry.undoable(), is(true));
        assertThat(this.registry.redoable(), is(false));
    }

    @Test
    void givenRegistryWhenUndoAndRegisterThenNotRedoable() {
        this.registry.register();
        this.registry.undo();
        this.registry.register();
        assertThat(this.registry.redoable(), is(false));
    }

    @Test
    void givenRegistryWhenUndoThenBoardChangedCorrectly() {
        this.board = new BoardBuilder()
                .proposedCombinations(RegistryTest.INITIALS)
                .blacks(2)
                .whites(2)
                .build();
        this.registry = new Registry(this.board);
        this.board.add(Color.get(RegistryTest.INITIALS));
        this.registry.register();
        this.registry.undo();
        assertThat(this.board.getAttempts(), is(1));
        assertThat(this.board.getProposedCombinationColors(0), is(Color.get(RegistryTest.INITIALS)));
        assertThat(this.board.getBlacks(0), is(2));
    }

    @Test
    void givenRegistryWhenRedoThenBoardChangedCorrectly() {
        this.board = new BoardBuilder()
                .proposedCombinations(RegistryTest.INITIALS)
                .blacks(2)
                .whites(2)
                .build();
        this.registry = new Registry(this.board);
        this.board.add(Color.get(RegistryTest.INITIALS));
        this.registry.register();
        this.board.add(Color.get(RegistryTest.INITIALS));
        this.registry.register();
        this.registry.undo();
        this.registry.undo();
        this.registry.redo();
        assertThat(this.board.getAttempts(), is(2));
        assertThat(this.board.getProposedCombinationColors(1), is(Color.get(RegistryTest.INITIALS)));
        assertThat(this.board.getBlacks(1), is(2));
    }

}
