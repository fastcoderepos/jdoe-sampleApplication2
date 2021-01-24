package com.fastcode.dvdrental.domain.core.actor;

import com.fastcode.dvdrental.domain.core.abstractentity.AbstractEntity;
import com.fastcode.dvdrental.domain.core.filmactor.FilmActorEntity;
import java.time.*;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ACTOR")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class ActorEntity extends AbstractEntity {

    @Basic
    @Column(name = "FIRST_NAME", nullable = false, length = 45)
    private String firstName;

    @Basic
    @Column(name = "LAST_NAME", nullable = false, length = 45)
    private String lastName;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACTOR_ID", nullable = false)
    private Integer actorId;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    private Set<FilmActorEntity> filmActorsSet = new HashSet<FilmActorEntity>();
}
