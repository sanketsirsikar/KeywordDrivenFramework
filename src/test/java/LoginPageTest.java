import com.bridgelabz.KeyWord.Engine.KeyWordEngine;
import org.testng.annotations.Test;

public class LoginPageTest {
    KeyWordEngine keywordEngine;

    @Test
    public void loginPageTest(){
        keywordEngine=new KeyWordEngine();
        keywordEngine.starExecution("Login");
    }
}

