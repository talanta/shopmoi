package shopmoi.com.core.di;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by machome on 09/03/15.
 */
@Qualifier
@Retention(RUNTIME)
public @interface ActivityContext {
}