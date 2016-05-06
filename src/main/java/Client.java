import java.util.List;
import org.sql2o.*;

public class Client {
  private String name;
  private int id;
  private int stylist_id;

  public Client(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public static List<Client> all() {
    String sql = "SELECT * FROM clients";
    try (Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients(name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .executeUpdate()
      .getKey();
    }
  }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE id = :id";
      return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Client.class);
    }
  }

  @Override
    public boolean equals(Object otherClient) {
      if (!(otherClient instanceof Client)) {
        return false;
      } else {
        Client newClient = (Client) otherClient;
        return this.getName().equals(newClient.getName()) &&
               this.getId() == newClient.getId();
    }
  }

  public void assignStylist(int stylist_id) {
  try(Connection con = DB.sql2o.open()) {
    int id = this.getId();
    this.stylist_id = stylist_id;
    String sql = "UPDATE clients SET stylist_id = :stylist_id WHERE id = :client_id";
    con.createQuery(sql)
    .addParameter("stylist_id", stylist_id)
    .addParameter("client_id", id)
    .executeUpdate();
    }
}

}
