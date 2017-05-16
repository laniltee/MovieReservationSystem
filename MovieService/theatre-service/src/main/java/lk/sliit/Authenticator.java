package lk.sliit;

/**
 * Created by VMARALA on 5/16/2017.
 */
public class Authenticator {
    private boolean isAuthenticated;
    private User u;

    public Authenticator(boolean isAuthenticated, User u) {
        this.isAuthenticated = isAuthenticated;
        this.u = u;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
}
