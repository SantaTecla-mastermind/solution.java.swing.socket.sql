package usantatecla.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

public class BoundedIntDialogTest {

  private BoundedIntDialog limitedIntDialog;
  private String title = "TITLE";

  @Mock
  private Console console;

  @BeforeEach
  void before() {
    this.limitedIntDialog = new BoundedIntDialog(-1, 1);
  }

  @Test
  public void testGivenLimitedIntDialogWhenReadInsideThenValue() {
    final int[] VALUES = new int[] { -1, 1 };
    for (int i = 0; i < VALUES.length; i++) {
      when(this.console.readInt("")).thenReturn(VALUES[i]);
      assertThat(this.limitedIntDialog.read(this.title), is(VALUES[i]));
    }
  }

  @Test
  public void testGivenLimitedIntDialogWhenReadOutsideThenRepeat() {
    when(this.console.readInt("")).thenReturn(-2, 2, 0);
    assertThat(this.limitedIntDialog.read(this.title), is(0));
  }

}
