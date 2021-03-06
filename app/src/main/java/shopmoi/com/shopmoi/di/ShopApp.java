package shopmoi.com.shopmoi.di;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.facebook.drawee.backends.pipeline.Fresco;

import io.fabric.sdk.android.Fabric;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by machome on 20/04/15.
 */
public class ShopApp extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        Fresco.initialize(this);
        // init twitter config..
        injectDependencies();
    }

    private void injectDependencies() {
        objectGraph = ObjectGraph.create(new RootModule(this));
        objectGraph.inject(this);
    }

    public ObjectGraph buildGraphWithAditionalModules(List<Object> modules) {
        if (modules == null) {
            throw new IllegalArgumentException(
                    "You can't plus a null module, review your getModules() implementation");
        }
        return objectGraph.plus(modules.toArray());
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }
}
