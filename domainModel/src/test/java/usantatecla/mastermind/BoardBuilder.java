package usantatecla.mastermind;

import org.mockito.MockedStatic;
import usantatecla.utils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.mockito.Mockito.*;

public class BoardBuilder {

    private Board board;

    private List<String> proposedCombinationsStrings;

    private Result result;

    public BoardBuilder() {
        this.proposedCombinationsStrings = new ArrayList<>();
    }

    public BoardBuilder proposedCombinations(String... proposedCombinations) {
        assert proposedCombinations.length <= 10;
        for (String proposedCombination : proposedCombinations) {
            assert Pattern.matches("[rgybmc]{4}", proposedCombination);
            this.proposedCombinationsStrings.add(proposedCombination);
        }
        return this;
    }


    public BoardBuilder proposedCombinations(int times, String proposedCombination) {
        assert Pattern.matches("[rgybmc]{4}", proposedCombination);
        for (int i = 0; i < times; i++) {
            this.proposedCombinationsStrings.add(proposedCombination);
        }
        return this;
    }

    public Board build() {
        this.board = spy(new Board());
        if (this.proposedCombinationsStrings.isEmpty()){
            return this.board;
        }
        for (String proposedCombinationsString : this.proposedCombinationsStrings) {
            this.setProposedCombination(proposedCombinationsString);
        }
        return this.board;
    }

    private void setProposedCombination(String proposedCombinationString) {
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            when(console.readString()).thenReturn(proposedCombinationString);
            ProposedCombination proposedCombination = new ProposedCombination();
            proposedCombination.read();
            if(this.result!=null){
                when(this.board.getResult(proposedCombination)).thenReturn(result);
            }
            this.board.add(proposedCombination);
        }
    }
    public BoardBuilder result(Result result){
        this.result = result;
        return this;
    }

}
