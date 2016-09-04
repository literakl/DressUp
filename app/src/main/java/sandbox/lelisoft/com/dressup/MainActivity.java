package sandbox.lelisoft.com.dressup;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    protected final String FRAGMENT_TAG = "main_fragment";
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);
        if (state == null) {
            loadFragment(null);
        } else {
            loadFragment(getLoadedFragment());
        }
    }

    /**
     * Return fragment to attach into {@code R.id.fragment_container} view.
     * <p>Returned object has to be instance of {@code android.support.v4.app.Fragment} or {@code android.app.Fragment}.
     * <p>If returned object is null or not instance of any Fragment class, nothing is attached to {@code R.id.fragment} view.</p>
     * @param oldFragment previously attached fragment. Return it if it is not null
     * @return fragment you want to attach or null if nothing has to be attached
     */
    protected Object getFragmentToLoad(Object oldFragment) {
        if (oldFragment == null) {
            currentFragment = new DressFigureFragment();
        } else {
            currentFragment = (Fragment) oldFragment;
        }
        return currentFragment;
    }

    protected Object getLoadedFragment() {
        Object o = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (o != null) {
            return o;
        }
        return getFragmentManager().findFragmentById(R.id.fragment_container);
    }

    private void loadFragment(Object oldFragment) {
        Object fragment = getFragmentToLoad(oldFragment);
        if (fragment == oldFragment) {
            return;
        }

        if (fragment instanceof android.support.v4.app.Fragment) {
            attachSupportFragment((android.support.v4.app.Fragment) fragment);
        } else if (fragment instanceof android.app.Fragment) {
            attachFragment((android.app.Fragment) fragment);
        }
    }

    private void attachSupportFragment(android.support.v4.app.Fragment fragment) {
        fragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container, fragment, FRAGMENT_TAG).
                commit();
    }

    private void attachFragment(android.app.Fragment fragment) {
        fragment.setArguments(getIntent().getExtras());
        getFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container, fragment, FRAGMENT_TAG).
                commit();
    }
}
