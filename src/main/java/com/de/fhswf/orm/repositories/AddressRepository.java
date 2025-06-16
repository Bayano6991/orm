package com.de.fhswf.orm.repositories;

import com.de.fhswf.orm.entity.Address;
import com.de.fhswf.orm.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
