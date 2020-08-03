package com.product.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.Role;

public interface RoleJpa extends JpaRepository<Role, Integer> {

	Optional<Role> findByRole(Integer roleId);
}
