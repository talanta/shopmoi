package shopmoi.com.core.presenters;


import shopmoi.com.core.views.View;

/**
 * Created by machome on 06/03/15.
 */
public abstract class Presenter<T extends View>  {
    protected T view;

    public void setView(T view) {
        this.view = view;
    }

    public abstract void initialize();

    public abstract void resume();

    public abstract void pause();

    public abstract void destroy();
}
