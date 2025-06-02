package cms.auth.spring_auth_mybank.dto;

public class UserDTO {
    private String username;
    private String password;
    private String email;
    private String mobile;
    private Integer roleID;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String email, String mobile, Integer roleID) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.roleID = roleID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }
}
