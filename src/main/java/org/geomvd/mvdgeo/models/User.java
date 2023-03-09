package org.geomvd.mvdgeo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nsyst")
    private long nsyst;
    @Column(name = "login")
    private String login;
    @Column(name = "pwd")
    private String password;
    @Column(name = "fam")
    private String fam;
    @Column(name = "imj")
    private String imj;
    @Column(name = "otch")
    private String otch;
    @Column(name = "email")
    private String email;
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user"))
    @JoinTable(name="users_roles",
            joinColumns = @JoinColumn(name="id_role", insertable = false),
            inverseJoinColumns = @JoinColumn(name="id_user"))
    private List<Role> roles;
}
