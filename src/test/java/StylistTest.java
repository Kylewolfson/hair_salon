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

  @Test
  public void find_findsStylistInDatabase_true() {
    Stylist myStylist = new Stylist("Rook");
    myStylist.save();
    Stylist savedStylist = Stylist.find(myStylist.getId());
    assertTrue(myStylist.equals(savedStylist));
  }

  @Test
  public void getClients_retrievesAllClientsOfStylistFromDataBase_patients() {
    Stylist myStylist = new Stylist ("Rook");
    myStylist.save();
    Client firstClient = new Client("Kyle");
    firstClient.save();
    firstClient.assignStylist(myStylist.getId());
    Client secondClient = new Client("Kelly");
    secondClient.save();
    secondClient.assignStylist(myStylist.getId());
    Client[] patients = new Client[] {firstClient, secondClient};
    assertTrue(myStylist.getClients().containsAll(Arrays.asList(patients)));
  }

}
