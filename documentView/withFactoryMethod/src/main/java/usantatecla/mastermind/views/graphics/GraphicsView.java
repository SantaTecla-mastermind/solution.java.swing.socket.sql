package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;

public class GraphicsView extends View {

    private BoardView boardView;

    public GraphicsView(Board board) {
        super(board);
        this.boardView = new BoardView(this.board);
    }

    @Override
    public void start() {
        this.boardView.start();
    }

    @Override
    public void play() {
        do {
            this.boardView.play();
        } while (!this.board.isFinished());
        this.boardView.drawGameOver();
    }

    @Override
    public boolean resume() {
        ResumeDialog resumeDialog = new ResumeDialog();
        boolean newGame = resumeDialog.isNewGame();
        if (newGame) {
            this.board.reset();
            this.boardView = new BoardView(this.board);
            return true;
        } else {
            this.boardView.setVisible(false);
            System.exit(0);
            return false;
        }
    }

}
