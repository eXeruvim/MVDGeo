package org.geomvd.mvdgeo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_roles")
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ur_id")
    private Long nsyst;

    @Column(nullable=false, unique=true, name = "name")
    private String name;

    @ManyToMany(mappedBy="roles")
    @Column(name = "user_id")
    private List<User> user;
}