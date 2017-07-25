package rs3.persistence.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import rs3.tools.customObjectSerializer.CustomObjectUserSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@Entity
@Table(name = "authority")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", length = 6, nullable = false)
    private Long roleId;

    @Column(name = "role")
    private String role;

    @JsonSerialize(using= CustomObjectUserSerializer.class)
    @ManyToOne
    @JoinColumn(name="user", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return roleId;
    }
    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.roleId = id;
    }
    public void setRole(String role) {
        this.role = role;
    }
}

