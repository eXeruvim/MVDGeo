package org.geomvd.mvdgeo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geomvd.mvdgeo.models.consts.ERole;

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

    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role(ERole name){
        this.name = name;
    }
}

