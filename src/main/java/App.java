
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("stylists", Stylist.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/newstylist", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylist = request.queryParams("stylist");
      Stylist newStylist = new Stylist(stylist);
      newStylist.save();
      response.redirect("/");
      return null;
    });

    get("/stylist_detail/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      model.put("stylist", stylist);
      model.put("clients", stylist.getClients());
      model.put("template", "templates/stylist_detail.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/assignclient/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Integer id = Integer.parseInt(request.queryParams("stylistId"));

      Stylist stylist = Stylist.find(id);

      String clientName = request.queryParams("client");
      Client newClient = new Client(clientName);
      newClient.save();
      newClient.assignStylist(id);
      response.redirect("/stylist_detail/" + id.toString());
      return null;
    });

  }
}
