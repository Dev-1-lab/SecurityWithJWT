package com.example.securitywithjwt.repository;

import com.example.securitywithjwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
