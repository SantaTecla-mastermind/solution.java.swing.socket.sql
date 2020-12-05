package usantatecla.mastermind.views.graphics;

class ErrorView extends usantatecla.mastermind.views.ErrorView {

    ErrorView() {
    }

    @Override
    protected String colorInitials() {
        return new ColorView().allInitials();
    }
}
