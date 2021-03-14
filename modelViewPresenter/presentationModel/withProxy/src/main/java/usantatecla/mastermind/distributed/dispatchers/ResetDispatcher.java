package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.ResumeController;

public class ResetDispatcher extends Dispatcher {

    public ResetDispatcher(ResumeController resumeController) {
        super(resumeController);
    }

    @Override
    public void dispatch() {
        ((ResumeController) this.acceptorController).reset();
    }
}
