import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_instantiates () {
    Stylist myStylist = new Stylist("Rook");
    assertTrue(myStylist instanceof Stylist);
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Stylist.all().size(), 0);
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Stylist myStylist = new Stylist("Rook");
    myStylist.save();
    assertTrue(Stylist.all().get(0).equals(myStylist));
  }

}
