package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.models.Error;

class ErrorView extends usantatecla.mastermind.views.ErrorView {

    ErrorView() { }

    ErrorView(Error error) {
        super(error);
    }

    @Override
    protected String colorInitials() {
        return new ColorView().allInitials();
    }
}
