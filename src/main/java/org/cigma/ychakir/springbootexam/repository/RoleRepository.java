package org.cigma.ychakir.springbootexam.repository;

import java.util.Optional;
import org.cigma.ychakir.springbootexam.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional<Role> findByName(String name);
}
