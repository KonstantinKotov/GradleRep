package entity;

import java.util.Collection;

/**
 * Created by k.kotov on 11.09.2017.
 */
public class UsersAccessEntity {
    private int accessId;
    private String accessLogin;
    private String accessPassword;
    private Collection<UsersEntity> usersByAccessId;

    public int getAccessId() {
        return accessId;
    }

    public void setAccessId(int accessId) {
        this.accessId = accessId;
    }

    public String getAccessLogin() {
        return accessLogin;
    }

    public void setAccessLogin(String accessLogin) {
        this.accessLogin = accessLogin;
    }

    public String getAccessPassword() {
        return accessPassword;
    }

    public void setAccessPassword(String accessPassword) {
        this.accessPassword = accessPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersAccessEntity that = (UsersAccessEntity) o;

        if (accessId != that.accessId) return false;
        if (accessLogin != null ? !accessLogin.equals(that.accessLogin) : that.accessLogin != null) return false;
        if (accessPassword != null ? !accessPassword.equals(that.accessPassword) : that.accessPassword != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accessId;
        result = 31 * result + (accessLogin != null ? accessLogin.hashCode() : 0);
        result = 31 * result + (accessPassword != null ? accessPassword.hashCode() : 0);
        return result;
    }

    public Collection<UsersEntity> getUsersByAccessId() {
        return usersByAccessId;
    }

    public void setUsersByAccessId(Collection<UsersEntity> usersByAccessId) {
        this.usersByAccessId = usersByAccessId;
    }
}
