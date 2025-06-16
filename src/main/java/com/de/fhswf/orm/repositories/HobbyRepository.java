package com.de.fhswf.orm.repositories;

import com.de.fhswf.orm.entity.Hobby;
import com.de.fhswf.orm.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby,Long> {
}
