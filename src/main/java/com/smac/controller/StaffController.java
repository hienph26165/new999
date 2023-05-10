package com.smac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smac.dto.HelpDTO;
import com.smac.dto.StaffDTO;
import com.smac.service.StaffService;

// TODO: Auto-generated Javadoc
/**
 * The Class StaffController.
 */
@RestController
@RequestMapping("/api/staff")
public class StaffController {

	/** The staff service. */
	@Autowired
	private StaffService staffService;

	/**
	 * Gets the staffs.
	 *
	 * @return the staffs
	 */
	@GetMapping("/staffs")
	public List<StaffDTO> getStaffs() {
		return staffService.searchStaffs();
	}

}
