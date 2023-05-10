package com.smac.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import com.smac.dto.HelpDTO;
import com.smac.dto.HelpDTO;
import com.smac.dto.StaffDTO;
import com.smac.entity.Help;
import com.smac.entity.Staff;
import com.smac.repository.HelpRepository;
import com.smac.repository.StaffRepository;
import com.smac.service.HelpService;

import jakarta.validation.Valid;

// TODO: Auto-generated Javadoc
/**
 * The Class HelpServiceImpl.
 */
@Service
public class HelpServiceImpl implements HelpService {

	/** The help repo. */
	@Autowired
	private HelpRepository helpRepo;

	/** The staff repo. */
	@Autowired
	private StaffRepository staffRepo;

	/**
	 * Creates the help.
	 *
	 * @param helpDTO the help DTO
	 * @return the boolean
	 * @throws Exception the exception
	 */
	@Override
	public Boolean createHelp(@Valid @RequestBody HelpDTO helpDTO) throws Exception {
		Help help = new Help();
		help.setHelpName(helpDTO.getHelpName());
		help.setParent(helpDTO.getParent());
		help.setContent(helpDTO.getContent());
		help.setPosition(helpDTO.getPosition());
		help.setType(helpDTO.getType());
		help.setCreatedUser(helpDTO.getCreatedUser());
		help.setStatus(helpDTO.getStatus());
		helpRepo.save(help);
		return true;
	}

	/**
	 * Update help.
	 *
	 * @param helpId  the help id
	 * @param helpDTO the help DTO
	 * @return the boolean
	 * @throws Exception the exception
	 */
	@Override
	public Boolean updateHelp(long helpId, @Valid @RequestBody HelpDTO helpDTO) throws Exception {
		List<Help> lstHelp = helpRepo.findAll();
		for (Help helps : lstHelp) {
			if (helps.getHelpId() == helpId) {
				helps.setContent(helpDTO.getContent());
				helps.setCreatedUser(helpDTO.getCreatedUser());
				helps.setParent(helpDTO.getParent());
				helps.setHelpName(helpDTO.getHelpName());
				helps.setPosition(helpDTO.getPosition());
				helps.setStatus(helpDTO.getStatus());
				helps.setType(helpDTO.getType());
				helpRepo.save(helps);
				return true;
			}
		}
		return false;
	}

	/**
	 * Delete help.
	 *
	 * @param helpId the help id
	 * @return the boolean
	 * @throws Exception the exception
	 */
	@Override
	public Boolean deleteHelp(long helpId) throws Exception {
		List<Help> lstHelp = helpRepo.findAll();
		for (Help helps : lstHelp) {
			if (helps.getHelpId() == helpId) {
				helps.setStatus("0");
				helpRepo.save(helps);
				return true;
			}
		}
		return false;
	}

	/**
	 * Search helps.
	 *
	 * @return the list
	 */
	@Override
	public List<HelpDTO> searchHelps() {
		List<Staff> staffs = staffRepo.findAll();
		List<HelpDTO> lstHelpDTO = new ArrayList<>();
		for (Staff staff : staffs) {
			List<Help> helps = helpRepo.findByCreatedUser(staff.getStaffCode());
			for (Help help : helps) {
				HelpDTO helpDTO = new HelpDTO();
				helpDTO.setParent(help.getParent());
				helpDTO.setShopId(staff.getShopId());
				helpDTO.setStaffId(staff.getStaffId());
				helpDTO.setStatus(help.getStatus());
				helpDTO.setType(help.getType());
				lstHelpDTO.add(helpDTO);
			}
		}
		return lstHelpDTO;
	}

}
