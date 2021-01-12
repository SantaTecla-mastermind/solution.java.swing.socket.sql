package usantatecla.mastermind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO Añadir mas tests y arreglar nombre
public class ResultTest {

    @Test
    public void testColorIsNull(){
        Result result = new Result(4, 0);
        assertTrue(result.isWinner());
    }
}
