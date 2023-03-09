package org.geomvd.mvdgeo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_role")
    private long id_role;

    @Column(nullable=false, unique=true, name = "name")
    private String name;

    public Role(String name){
        this.name = name;
    }
}