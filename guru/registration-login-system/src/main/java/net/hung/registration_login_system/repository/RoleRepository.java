package net.hung.registration_login_system.repository;

import net.hung.registration_login_system.entity.Role;
import net.hung.registration_login_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
