package spring.app.chitchat.entities;


import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private int userId;
    @Column(name="USERNAME")
    private String username;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="GROUP_ID")
    private int groupId;

    public User(int userId, String username, String email, String password, int groupId) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.groupId = groupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
