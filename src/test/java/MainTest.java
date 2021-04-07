import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static WebDriver driver;
    private final static String CHROME_PATH = "src/main/resources/chromedriver";

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.devmedia.com.br/");
    }

    @AfterAll
    static void closePage() {
        driver.quit();
    }

    @Test
    @DisplayName("Should Check The Title")
    public void checkTitle() {

        String title = driver.getTitle();
        assertNotEquals("DevMedia | Plataforma para Programadores", title);
        assertEquals("DevMedia | Plataforma para Programadores Teste grátis por 7 dias", title);
        System.out.println(title);
    }

    @Nested
    class SubscriptionsButtonCheck{

        @Test
        @DisplayName("Should Check Subscribe Button")
        void goCheckSubscribeButton(){
            WebElement subscribeBtn = driver.findElement(By.className("button1"));

            String href = subscribeBtn.getAttribute("href");
            assertEquals("https://www.devmedia.com.br/join/?cadastro", href);

            String text = subscribeBtn.getText();
            assertEquals("Crie uma conta grátis", text);
        }

        @Test
        @DisplayName("Should Have A Link To Free 7-day Trial")
        void demoPage(){
            WebElement freeTrialBtn = driver.findElement(By.className("tgratis"));

            String text = freeTrialBtn.getText();
            assertEquals("Teste Grátis", text);

            String href = freeTrialBtn.getAttribute("href");
            assertEquals("https://www.devmedia.com.br/join/", href);
        }

        @Test
        @DisplayName("Should Have A Link To Individual Plan Subscription")
        void individualPlan(){
            WebElement planBox = driver.findElement(By.xpath("//*[@id=\"planos-container\"]/div[2]/div/div[2]/div[1]"));
            String typeOfPlan = planBox.getText().replace(" ", "").trim();
            assertEquals("Plano\nIndividual", typeOfPlan);

            WebElement firstInnerBox = driver.findElement(By.xpath("//*[@id=\"planos-container\"]/div[2]/div/div[2]/div[2]/a"));
            String individualPlanHref = firstInnerBox.getAttribute("href");
            assertEquals("https://www.devmedia.com.br/shop/?individual", individualPlanHref);
        }

        @Test
        @DisplayName("Should Have A Link To Duo Plan")
        void duoPlan(){
            WebElement planBox = driver.findElement(By.xpath("//*[@id=\"planos-container\"]/div[2]/div/div[3]/div[1]"));
            String typeOfPlan = planBox.getText();
            assertEquals("Plano\nDuo\n2 integrantes", typeOfPlan);

            WebElement innerBox = driver.findElement(By.xpath("//*[@id=\"planos-container\"]/div[2]/div/div[3]/a"));
            String duoPlanHref = innerBox.getAttribute("href");
            assertEquals("https://www.devmedia.com.br/shop/?duo", duoPlanHref);
        }

        @Test
        @DisplayName("Should Have A Link To Enterprise Plan")
        void enterprisePlan(){
            WebElement planBox = driver.findElement(By.xpath("//*[@id=\"planos-container\"]/div[2]/a[1]"));
            String typeOfPlan = planBox.getText();
            assertEquals("Planos\nEmpresariais", typeOfPlan);
            assertFalse(typeOfPlan.isEmpty()||typeOfPlan.isBlank());

            String href = planBox.getAttribute("href");
            assertFalse(href.isEmpty()||href.isBlank());
            assertEquals("https://www.devmedia.com.br/empresarial/", href);
        }

        @Test
        @DisplayName("Should Have A Link To Group Plan")
        void groupPlan(){
            WebElement planBox = driver.findElement(By.xpath("//*[@id=\"planos-container\"]/div[2]/a[2]"));
            String typeOfPlan = planBox.getText();
            assertEquals("Para assinaturas a partir de 3 usuários, clique aqui.", typeOfPlan);

            String href = planBox.getAttribute("href");
            assertEquals("https://www.devmedia.com.br/marketing/assinatura-grupo", href);
        }
    }

    @Nested
    class FooterTechnologyGuides{

        @Test
        @DisplayName("Should Link To Guides")
        void htmlCss(){
            WebElement item = driver.findElement(By.xpath("/html/body/section/footer/div/div[2]/div[2]/div/div[2]/div[1]/a"));
            String text = item.getText();
            assertEquals("HTML e CSS", text);
            assertNotNull(text);

            String href = item.getAttribute("href");
            assertEquals("https://www.devmedia.com.br/guias/html-e-css", href);
        }

        @Test
        @DisplayName("Should Link To JavaScript Guides")
        void javaScript(){
            WebElement item = driver.findElement(By.xpath("/html/body/section/footer/div/div[2]/div[2]/div/div[2]/div[2]/a"));
            String text = item.getText();
            assertEquals("JavaScript", text);
            assertNotNull(text);

            String href = item.getAttribute("href");
            assertEquals("https://www.devmedia.com.br/guias/javascript", href);
        }

        @Test
        @DisplayName("Should Link To Node Guides")
        void node(){
            WebElement item = driver.findElement(By.xpath("/html/body/section/footer/div/div[2]/div[2]/div/div[2]/div[3]/a"));
            String text = item.getText();
            assertEquals("Node", text);
            assertNotNull(text);

            String href = item.getAttribute("href");
            assertEquals("https://www.devmedia.com.br/guias/node-js", href);
        }

        @Test
        @DisplayName("Should Link To React Native Guides")
        void reactNative(){
            WebElement item = driver.findElement(By.xpath("/html/body/section/footer/div/div[2]/div[2]/div/div[2]/div[4]/a"));
            String text = item.getText();
            assertEquals("React Native", text);
            assertNotNull(text);

            String href = item.getAttribute("href");
            assertEquals("https://www.devmedia.com.br/guias/react-native", href);
        }

        @Test
        @DisplayName("Should Link To Flutter Guides")
        void flutter(){
            WebElement item = driver.findElement(By.xpath("/html/body/section/footer/div/div[2]/div[2]/div/div[2]/div[5]/a"));
            String text = item.getText();
            assertEquals("Flutter", text);
            assertNotNull(text);

            String href = item.getAttribute("href");
            assertEquals("https://www.devmedia.com.br/guias/flutter", href);
        }

        @Test
        @DisplayName("Should Link To Databases Guides")
        void dataBase(){
            WebElement item = driver.findElement(By.xpath("/html/body/section/footer/div/div[2]/div[2]/div/div[2]/div[6]/a"));
            String text = item.getText();
            assertEquals("Banco de Dados", text);
            assertNotNull(text);

            String href = item.getAttribute("href");
            assertEquals("https://www.devmedia.com.br/guias/banco-de-dados", href);
        }
    }

    @Nested
    class SocialMedias{

        @Test
        @DisplayName("Should Link To GitHub")
        void github(){
            WebElement socialMedia = driver.findElement(By.xpath("/html/body/section/footer/div/div[3]/div[1]/a[1]"));
            String href = socialMedia.getAttribute("href");
            assertEquals("https://github.com/DevMedia", href);
        }

        @Test
        @DisplayName("Should Link To Facebook")
        void facebook(){
            WebElement socialMedia = driver.findElement(By.xpath("/html/body/section/footer/div/div[3]/div[1]/a[2]"));
            String href = socialMedia.getAttribute("href");
            assertEquals("https://www.facebook.com/devmedia.com.br/", href);
        }

        @Test
        @DisplayName("Should Link To Twitter")
        void twitter(){
            WebElement socialMedia = driver.findElement(By.xpath("/html/body/section/footer/div/div[3]/div[1]/a[3]"));
            String href = socialMedia.getAttribute("href");
            assertEquals("http://twitter.com/devmedia", href);
        }

        @Test
        @DisplayName("Should Link To Instagram")
        void instagram(){
            WebElement socialMedia = driver.findElement(By.xpath("/html/body/section/footer/div/div[3]/div[1]/a[4]"));
            String href = socialMedia.getAttribute("href");
            assertEquals("https://www.instagram.com/devmedia.com.br/", href);
        }

        @Test
        @DisplayName("Should Link To YouTube")
        void youtube(){
            WebElement socialMedia = driver.findElement(By.xpath("/html/body/section/footer/div/div[3]/div[1]/a[5]"));
            String href = socialMedia.getAttribute("href");
            assertEquals("https://www.youtube.com/c/DevmediaBrasil", href);
        }
    }
}