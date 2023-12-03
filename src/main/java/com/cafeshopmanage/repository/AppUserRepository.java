package com.cafeshopmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cafeshopmanage.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	@Query("SELECT e FROM AppUser e " + "Where e.userName = :userName")
	AppUser findUserAccount(@Param("userName") String userName);
	
	AppUser findByUserName(String userName);

	long countByRoleId(int roleUser);
}