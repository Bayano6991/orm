package com.de.fhswf.orm.repositories;

import com.de.fhswf.orm.entity.Child;
import com.de.fhswf.orm.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child,Long> {
}
