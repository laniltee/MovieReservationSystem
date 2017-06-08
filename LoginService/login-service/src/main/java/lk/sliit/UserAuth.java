package lk.sliit;

import java.time.LocalDateTime;

/**
 * Created by Lanil Marasinghe on 6/9/2017.
 */
public class UserAuth {
    private String user;
    private String timestamp;
    private boolean status;
    private String message;
    private int statusCode;

    public UserAuth() {
        this.timestamp = LocalDateTime.now().toString().replace("T", " ").substring(0, 19);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
