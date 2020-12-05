package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GameBuilder {

    private List<String> proposedCombinationsStrings;

    public GameBuilder() {
        this.proposedCombinationsStrings = new ArrayList<>();
    }

    public GameBuilder proposedCombinations(String... proposedCombinations) {
        assert proposedCombinations.length <= 10;
        for (String proposedCombination : proposedCombinations) {
            assert Pattern.matches("[rgbyop]{4}", proposedCombination);
            this.proposedCombinationsStrings.add(proposedCombination);
        }
        return this;
    }

    public GameBuilder proposedCombinations(int times, String proposedCombination) {
        assert Pattern.matches("[rgbyop]{4}", proposedCombination);
        for (int i = 0; i < times; i++) {
            this.proposedCombinationsStrings.add(proposedCombination);
        }
        return this;
    }

    public Game build() {
        if (this.proposedCombinationsStrings.isEmpty())
            return new Game();

        Game game = new Game();
        for (String proposedCombinationsString : this.proposedCombinationsStrings) {
            this.setProposedCombination(game, proposedCombinationsString);
        }
        return game;
    }

    private void setProposedCombination(Game game, String proposedCombinationString) {
        ProposedCombination proposedCombination = new ProposedCombination();
        for (int i = 0; i < proposedCombinationString.length(); i++) {
            Color color = this.getColor(proposedCombinationString.charAt(i));
            proposedCombination.getColors().add(color);
        }

        game.addProposedCombination(proposedCombination);
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
