package com.smac.service;

import java.util.List;

import com.smac.dto.HelpDTO;
import com.smac.dto.StaffDTO;
import com.smac.entity.Help;

/**
 * The Interface StaffService.
 */
public interface StaffService {

	List<StaffDTO> searchStaffs();

}
