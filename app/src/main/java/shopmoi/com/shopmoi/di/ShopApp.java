package shopmoi.com.shopmoi.di;

import android.app.Application;

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
