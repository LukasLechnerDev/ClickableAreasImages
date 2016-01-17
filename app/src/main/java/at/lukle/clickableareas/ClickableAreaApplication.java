package at.lukle.clickableareas;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Lukas on 1/17/2016.
 */
public class ClickableAreaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
