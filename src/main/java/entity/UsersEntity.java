package entity;

import java.sql.Date;

/**
 * Created by k.kotov on 11.09.2017.
 */
public class UsersEntity {
    private int userId;
    private String userFirstName;
    private String userSecondName;
    private String userMidName;
    private String userSex;
    private Date userBirthDate;
    private Date userWorkFromDate;
    private String userPosition;
    private String userDepartment;
    private int userMaterialId;
    private int userLogin;
    private MaterialsEntity materialsByUserMaterialId;
    private UsersAccessEntity usersAccessByUserLogin;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserSecondName() {
        return userSecondName;
    }

    public void setUserSecondName(String userSecondName) {
        this.userSecondName = userSecondName;
    }

    public String getUserMidName() {
        return userMidName;
    }

    public void setUserMidName(String userMidName) {
        this.userMidName = userMidName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(Date userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public Date getUserWorkFromDate() {
        return userWorkFromDate;
    }

    public void setUserWorkFromDate(Date userWorkFromDate) {
        this.userWorkFromDate = userWorkFromDate;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public int getUserMaterialId() {
        return userMaterialId;
    }

    public void setUserMaterialId(int userMaterialId) {
        this.userMaterialId = userMaterialId;
    }

    public int getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(int userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != that.userId) return false;
        if (userMaterialId != that.userMaterialId) return false;
        if (userLogin != that.userLogin) return false;
        if (userFirstName != null ? !userFirstName.equals(that.userFirstName) : that.userFirstName != null)
            return false;
        if (userSecondName != null ? !userSecondName.equals(that.userSecondName) : that.userSecondName != null)
            return false;
        if (userMidName != null ? !userMidName.equals(that.userMidName) : that.userMidName != null) return false;
        if (userSex != null ? !userSex.equals(that.userSex) : that.userSex != null) return false;
        if (userBirthDate != null ? !userBirthDate.equals(that.userBirthDate) : that.userBirthDate != null)
            return false;
        if (userWorkFromDate != null ? !userWorkFromDate.equals(that.userWorkFromDate) : that.userWorkFromDate != null)
            return false;
        if (userPosition != null ? !userPosition.equals(that.userPosition) : that.userPosition != null) return false;
        if (userDepartment != null ? !userDepartment.equals(that.userDepartment) : that.userDepartment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userFirstName != null ? userFirstName.hashCode() : 0);
        result = 31 * result + (userSecondName != null ? userSecondName.hashCode() : 0);
        result = 31 * result + (userMidName != null ? userMidName.hashCode() : 0);
        result = 31 * result + (userSex != null ? userSex.hashCode() : 0);
        result = 31 * result + (userBirthDate != null ? userBirthDate.hashCode() : 0);
        result = 31 * result + (userWorkFromDate != null ? userWorkFromDate.hashCode() : 0);
        result = 31 * result + (userPosition != null ? userPosition.hashCode() : 0);
        result = 31 * result + (userDepartment != null ? userDepartment.hashCode() : 0);
        result = 31 * result + userMaterialId;
        result = 31 * result + userLogin;
        return result;
    }

    public MaterialsEntity getMaterialsByUserMaterialId() {
        return materialsByUserMaterialId;
    }

    public void setMaterialsByUserMaterialId(MaterialsEntity materialsByUserMaterialId) {
        this.materialsByUserMaterialId = materialsByUserMaterialId;
    }

    public UsersAccessEntity getUsersAccessByUserLogin() {
        return usersAccessByUserLogin;
    }

    public void setUsersAccessByUserLogin(UsersAccessEntity usersAccessByUserLogin) {
        this.usersAccessByUserLogin = usersAccessByUserLogin;
    }
}
