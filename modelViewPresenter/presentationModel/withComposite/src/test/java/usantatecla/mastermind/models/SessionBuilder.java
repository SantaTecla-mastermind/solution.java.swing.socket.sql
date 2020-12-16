package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SessionBuilder {
    private List<String> proposedCombinationsStrings;

    public SessionBuilder() {
        this.proposedCombinationsStrings = new ArrayList<>();
    }

    public SessionBuilder proposedCombinations(String... proposedCombinations) {
        assert proposedCombinations.length <= 10;
        for (String proposedCombination : proposedCombinations) {
            assert Pattern.matches("[rgbyop]{4}", proposedCombination);
            this.proposedCombinationsStrings.add(proposedCombination);
        }
        return this;
    }

    public SessionBuilder proposedCombinations(int times, String proposedCombination) {
        assert Pattern.matches("[rgbyop]{4}", proposedCombination);
        for (int i = 0; i < times; i++) {
            this.proposedCombinationsStrings.add(proposedCombination);
        }
        return this;
    }

    public Session build() {
        if (this.proposedCombinationsStrings.isEmpty())
            return new Session();

        Session session = new Session();
        for (String proposedCombinationsString : this.proposedCombinationsStrings) {
            this.setProposedCombination(session, proposedCombinationsString);
        }
        return session;
    }

    private void setProposedCombination(Session session, String proposedCombinationString) {
        ProposedCombination proposedCombination = new ProposedCombination(new ArrayList<>());
        for (int i = 0; i < proposedCombinationString.length(); i++) {
            Color color = this.getColor(proposedCombinationString.charAt(i));
            proposedCombination.colors.add(color);
        }

        session.addProposedCombination(proposedCombination.colors);
    }

    private Color getColor(char character) {
        switch (character) {
            case 'r':
                return Color.RED;
            case 'g':
                return Color.GREEN;
            case 'b':
                return Color.BLUE;
            case 'y':
                return Color.YELLOW;
            case 'o':
                return Color.ORANGE;
            case 'p':
                return Color.PURPLE;
            default:
                return Color.NULL;
        }
    }
}
