package com.smac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smac.dto.HelpDTO;
import com.smac.entity.Help;

/**
 * The Interface HelpRepository.
 */
@Repository
public interface HelpRepository extends JpaRepository<Help, Long> {

	/**
	 * Find by created user.
	 *
	 * @param createdUser the created user
	 * @return the list
	 */
	@Query(value = "SELECT u FROM Help u where u.createdUser = ?1")
	List<Help> findByCreatedUser(String createdUser);

}