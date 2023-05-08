import com.bridgelabz.KeyWord.Engine.KeyWordEngine;
import org.testng.annotations.Test;

public class HomePageTest {
    KeyWordEngine keywordEngine;
    @Test
    public void homePageTest(){
        keywordEngine=new KeyWordEngine();
        keywordEngine.starExecution("home");
    }
}
