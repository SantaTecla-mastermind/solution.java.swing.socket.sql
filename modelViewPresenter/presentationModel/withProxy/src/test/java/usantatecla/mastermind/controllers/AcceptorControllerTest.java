package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Session;

@ExtendWith(MockitoExtension.class)
public abstract class AcceptorControllerTest {

    @Mock
    protected Session session;

    protected AcceptorController acceptorController;

}
