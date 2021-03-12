package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class BoardBuilder {

    private Board board;
    private List<String> proposedCombinationsStrings;
    private Integer blacks;
    private Integer whites;

    public BoardBuilder() {
        this.proposedCombinationsStrings = new ArrayList<>();
    }

    public BoardBuilder proposedCombinations(String... proposedCombinations) {
        assert proposedCombinations.length <= 10;
        for (String proposedCombination : proposedCombinations) {
            assert Pattern.matches("[" + Color.getAllInitials() + "]{4}", proposedCombination);
            this.proposedCombinationsStrings.add(proposedCombination);
        }
        return this;
    }

    public BoardBuilder proposedCombinations(int times, String proposedCombination) {
        assert Pattern.matches("[" + Color.getAllInitials() + "]{4}", proposedCombination);
        for (int i = 0; i < times; i++) {
            this.proposedCombinationsStrings.add(proposedCombination);
        }
        return this;
    }

    public BoardBuilder blacks(int blacks) {
        this.blacks = blacks;
        return this;
    }

    public BoardBuilder whites(int whites) {
        this.whites = whites;
        return this;
    }

    public Board build() {
        this.board = spy(new Board());
        if (this.blacks != null && this.whites != null) {
            doReturn(new Result(this.blacks, this.whites)).when(this.board).getResult(any());
            doReturn(this.blacks).when(this.board).getBlacks(any(Integer.class));
            doReturn(this.whites).when(this.board).getWhites(any(Integer.class));
        }
        if (!this.proposedCombinationsStrings.isEmpty()) {
            for (String proposedCombinationsString : this.proposedCombinationsStrings) {
                this.board.add(Color.get(proposedCombinationsString));
            }
        }
        return this.board;
    }

}
