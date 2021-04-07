package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class SessionImplementationBuilder {

    private SessionImplementation session;
    private List<String> proposedCombinationsStrings;
    private StateValue stateValue;
    private Integer blacks;
    private Integer whites;

    public SessionImplementationBuilder() {
        this.proposedCombinationsStrings = new ArrayList<>();
    }

    public SessionImplementationBuilder proposedCombinations(String... proposedCombinations) {
        assert proposedCombinations.length <= 10;
        for (String proposedCombination : proposedCombinations) {
            assert Pattern.matches("[" + Color.getAllInitials() + "]{4}", proposedCombination);
            this.proposedCombinationsStrings.add(proposedCombination);
        }
        return this;
    }

    public SessionImplementationBuilder proposedCombinations(int times, String proposedCombination) {
        assert Pattern.matches("[" + Color.getAllInitials() + "]{4}", proposedCombination);
        for (int i = 0; i < times; i++) {
            this.proposedCombinationsStrings.add(proposedCombination);
        }
        return this;
    }

    public SessionImplementationBuilder state(StateValue stateValue) {
        this.stateValue = stateValue;
        return this;
    }

    public SessionImplementationBuilder blacks(int blacks) {
        this.blacks = blacks;
        return this;
    }

    public SessionImplementationBuilder whites(int whites) {
        this.whites = whites;
        return this;
    }

    public SessionImplementation build() {
        this.session = spy(new SessionImplementation());
        if(this.stateValue != null) {
            while (this.stateValue != this.session.getValueState()) {
                this.session.nextState();
            }
        }
        if (this.blacks != null && this.whites != null) {
            doReturn(this.blacks).when(this.session).getBlacks(any(Integer.class));
            doReturn(this.whites).when(this.session).getWhites(any(Integer.class));
        }
        if (!this.proposedCombinationsStrings.isEmpty()) {
            for (String proposedCombinationsString : this.proposedCombinationsStrings) {
                this.session.add(Color.get(proposedCombinationsString));
            }
        }
        return this.session;
    }

}
