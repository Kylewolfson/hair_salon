import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void client_instantiates () {
    Client myClient = new Client("Rook");
    assertTrue(myClient instanceof Client);
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Client.all().size(), 0);
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Client myClient = new Client("Rook");
    myClient.save();
    assertTrue(Client.all().get(0).equals(myClient));
  }

  @Test
 public void find_findsClientInDatabase_true() {
   Client myClient = new Client("Rook");
   myClient.save();
   Client savedClient = Client.find(myClient.getId());
   assertTrue(myClient.equals(savedClient));
 }

}
