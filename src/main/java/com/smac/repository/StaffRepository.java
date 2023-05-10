package com.smac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smac.entity.Help;
import com.smac.entity.Staff;

/**
 * The Interface StaffRepository.
 */
@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

}
