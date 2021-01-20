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
    private Result result;

    public BoardBuilder() {
        this.proposedCombinationsStrings = new ArrayList<>();
    }

    public BoardBuilder proposedCombinations(int times, String proposedCombination) {
        assert Pattern.matches("[" + Color.getAllInitials() + "]{4}", proposedCombination);
        for (int i = 0; i < times; i++) {
            this.proposedCombinationsStrings.add(proposedCombination);
        }
        return this;
    }

    public BoardBuilder result(Result result) {
        this.result = result;
        return this;
    }

    public Board build() {
        this.board = spy(new Board());
        if (this.result != null) {
            doReturn(this.result).when(this.board).getResult(any());
        }
        if (!this.proposedCombinationsStrings.isEmpty()) {
            for (String proposedCombinationsString : this.proposedCombinationsStrings) {
                this.setProposedCombination(proposedCombinationsString);
            }
        }
        return this.board;
    }

    private void setProposedCombination(String proposedCombinationString) {
        ProposedCombination proposedCombination = new ProposedCombination();//TODO Constructor con colores
        proposedCombination.add(Color.get(proposedCombinationString));
        this.board.add(proposedCombination);
    }

}
