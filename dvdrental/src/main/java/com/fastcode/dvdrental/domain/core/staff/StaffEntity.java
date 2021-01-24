package com.fastcode.dvdrental.domain.core.staff;

import com.fastcode.dvdrental.domain.core.abstractentity.AbstractEntity;
import com.fastcode.dvdrental.domain.core.address.AddressEntity;
import com.fastcode.dvdrental.domain.core.payment.PaymentEntity;
import com.fastcode.dvdrental.domain.core.rental.RentalEntity;
import com.fastcode.dvdrental.domain.core.store.StoreEntity;
import java.time.*;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "STAFF")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class StaffEntity extends AbstractEntity {

    @Basic
    @Column(name = "LAST_NAME", nullable = false, length = 45)
    private String lastName;

    @Basic
    @Column(name = "active", nullable = false)
    private Boolean active;

    @Basic
    @Column(name = "STORE_ID", nullable = false)
    private Short storeId;

    @Basic
    @Column(name = "FIRST_NAME", nullable = false, length = 45)
    private String firstName;

    @Basic
    @Column(name = "password", nullable = true, length = 40)
    private String password;

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    private String email;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STAFF_ID", nullable = false)
    private Integer staffId;

    @Basic
    @Column(name = "username", nullable = false, length = 16)
    private String username;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private AddressEntity address;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private Set<StoreEntity> storesSet = new HashSet<StoreEntity>();

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private Set<RentalEntity> rentalsSet = new HashSet<RentalEntity>();

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private Set<PaymentEntity> paymentsSet = new HashSet<PaymentEntity>();
}
