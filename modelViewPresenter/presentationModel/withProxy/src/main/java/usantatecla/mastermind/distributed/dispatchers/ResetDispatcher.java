package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.implementation.ResumeControllerImplementation;

public class ResetDispatcher extends Dispatcher {

    public ResetDispatcher(ResumeControllerImplementation resumeControllerImplementation) {
        super(resumeControllerImplementation);
    }

    @Override
    public void dispatch() {
        ((ResumeControllerImplementation) this.acceptorControllerImplementation).reset();
    }
}
