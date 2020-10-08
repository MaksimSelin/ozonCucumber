package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static ru.appline.ozon.managers.InitManager.closeFramework;
import static ru.appline.ozon.managers.InitManager.initFramework;

public class Hooks {

    @Before
    public void start(){
        initFramework();
    }

    @After
    public void close(){
        closeFramework();
    }
}
