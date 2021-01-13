package usantatecla.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsoleTest {

  @Mock
  private BufferedReader bufferedReader;

  @InjectMocks
  Console console;

  @Mock
  private PrintStream outputStream;

  @BeforeEach
  public void beforeEach() {
    System.setOut(this.outputStream);
  }

  @Test
  public void testGivenConsoleWhenReadStringThenValue() throws IOException {
    String string = "***";
    when(this.bufferedReader.readLine()).thenReturn(string);
    assertThat(this.console.readString("TITLE"), is(string));
  }

  @Test
  public void testGivenConsoleWhenReadIntThenValue() throws IOException {
    String string = "123";
    when(this.bufferedReader.readLine()).thenReturn("", "***", string);
    assertThat(this.console.readInt("TITLE"), is(Integer.parseInt(string)));
  }

  @Test
  public void testGivenConsoleWhenReadCharThenValue() throws IOException {
    String string = "b";
    when(this.bufferedReader.readLine()).thenReturn("", "***", string);
    assertThat(this.console.readChar("TITLE"), is(string.charAt(0)));
  }


  @Test
  public void testGivenConsoleWhenWriteStringThenDisplay(){
    String string = "***";
    Console.getInstance().write(string);
    verify(this.outputStream).print(string);
  }

  @Test
  public void testGivenConsoleWhenWriteIntThenDisplay(){
    int integer = 123;
    Console.getInstance().write(integer);
    verify(this.outputStream).print(integer);
  }

  @Test
  public void testGivenConsoleWhenWriteCharacterThenDisplay(){
    char character = 'a';
    Console.getInstance().write(character);
    verify(this.outputStream).print(character);
  }

  @Test
  public void testGivenConsoleWhenWritelnThenDisplay(){
    Console.getInstance().writeln();
    verify(this.outputStream).println();
  }

  @Test
  public void testGivenConsoleWhenWritelnStringThenDisplay(){
    String string = "***";
    Console.getInstance().writeln(string);
    verify(this.outputStream).println(string);
  }

  @Test
  public void testGivenConsoleWhenWritelnIntegerThenDisplay(){
    int integer = 123;
    Console.getInstance().writeln(integer);
    verify(this.outputStream).println(integer);
  }

  @Test
  public void testGivenConsoleWhenWriteErrorThenDisplay(){
    String format = "(a | b)";
    Console.getInstance().writeError(format);
    verify(this.outputStream).println("FORMAT ERROR! " + "Enter a " + format + " formatted value.");
  }
}
