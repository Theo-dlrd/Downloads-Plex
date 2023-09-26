import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;


public class Scrape {
    private static final String id = "Th1roX";
    private static final String pwd = "Theo72650";

    private static int connexion(WebDriver driver) throws IOException{
        //Aller sur le bouton se connecter
        WebElement login = driver.findElement(By.id("register"));
        login.click();
        //Rentrer le nom d'utilisateur
        WebElement user = driver.findElement(By.name("id"));
        user.sendKeys(id);
        //Rentrer le mot de passe
        WebElement passwd = driver.findElement(By.name("pass"));
        passwd.sendKeys(pwd);
        //Connexion
        WebElement submit = driver.findElement(By.tagName("button"));
        submit.click();

        return 1;
    }

    private static int search(WebDriver driver, String titre) throws IOException{
        //Saisie du média à rechercher
        WebElement text = driver.findElement(By.name("name"));
        text.sendKeys(titre);
        //Cliquer sur rechercher
        WebElement srch = driver.findElement(By.name("Button"));
        srch..click();


        return 1;
    }


    public static void main(String[] args) throws IOException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www3.yggtorrent.wtf");

        connexion(driver);
        search(driver, "La reine des neiges");
    }
}
