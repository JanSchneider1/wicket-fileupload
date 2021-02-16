package application;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import pages.HomePage;

public class WicketApplication extends WebApplication {
    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    public void init() {
        super.init();
        mountPage("/home", HomePage.class);
        getApplicationSettings().setUploadProgressUpdatesEnabled(true);
    }
}