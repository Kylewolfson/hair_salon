
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();


  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @ClassRule
  public static DatabaseRule database = new DatabaseRule();



  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Barbershop");
  }

  @Test
public void stylist_addedToPage_true() {
  goTo("http://localhost:4567/");
  fill("#stylist").with("Rook");
  submit(".btn");
  assertThat(pageSource()).contains("Rook");
}

@Test
  public void client_addedToStylistPage_true() {
    goTo("http://localhost:4567/");
    fill("#stylist").with("Rook");
    submit(".btn");
    click("a", withText("Rook"));
    fill("#client").with("Kyle");
    submit(".btn");
    assertThat(pageSource()).contains("Kyle");
  }
}
