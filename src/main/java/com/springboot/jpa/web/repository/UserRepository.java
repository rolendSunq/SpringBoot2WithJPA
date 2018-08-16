package com.springboot.jpa.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u where u.userid = :userid")
	public User findByUserId(@Param("userid") String userid);
}
