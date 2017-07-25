package rs3.persistence.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import rs3.tools.customObjectSerializer.CustomObjectRoleListSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @JsonSerialize(using= CustomObjectRoleListSerializer.class)
    @OneToMany(targetEntity=Role.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Role> rolesList=new ArrayList<>();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getName() {
        return login;
    }
    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setName(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
