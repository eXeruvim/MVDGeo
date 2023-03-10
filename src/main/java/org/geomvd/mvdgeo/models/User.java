package org.geomvd.mvdgeo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Set;

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
    @Column(name = "dt_reg")
    @DateTimeFormat(fallbackPatterns = "dd-MM-yyy")
    private final LocalDateTime dt_reg = LocalDateTime.now();
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="users_roles",
            joinColumns = @JoinColumn(name="id_user"),
            inverseJoinColumns = @JoinColumn(name="id_role"))
    private Set<Role> roles;

    public String getRole(){
        return roles.toString().replaceAll("[^\\[]*(?=\\W\\w)", "").replaceAll("[]\\[=)]", "");
    }
}
