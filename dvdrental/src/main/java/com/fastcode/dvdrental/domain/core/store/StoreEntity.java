package com.fastcode.dvdrental.domain.core.store;

import com.fastcode.dvdrental.domain.core.abstractentity.AbstractEntity;
import com.fastcode.dvdrental.domain.core.address.AddressEntity;
import com.fastcode.dvdrental.domain.core.staff.StaffEntity;
import java.time.*;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "STORE")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class StoreEntity extends AbstractEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORE_ID", nullable = false)
    private Integer storeId;

    @ManyToOne
    @JoinColumn(name = "MANAGER_STAFF_ID")
    private StaffEntity staff;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private AddressEntity address;
}
