package com.smac.service;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.smac.dto.HelpDTO;
import com.smac.dto.HelpDTO;
import com.smac.entity.Help;

import jakarta.validation.Valid;

// TODO: Auto-generated Javadoc
/**
 * The Interface HelpService.
 */
public interface HelpService {

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	List<HelpDTO> searchHelps();

	/**
	 * Update help.
	 *
	 * @param helpId  the help id
	 * @param helpDTO the help DTO
	 * @return the boolean
	 * @throws Exception the exception
	 */
	Boolean updateHelp(long helpId, HelpDTO helpDTO) throws Exception;

	/**
	 * Delete help.
	 *
	 * @param helpId the help id
	 * @return the boolean
	 * @throws Exception the exception
	 */
	Boolean deleteHelp(long helpId) throws Exception;

	/**
	 * Creates the help.
	 *
	 * @param helpDTO the help DTO
	 * @return the boolean
	 * @throws Exception the exception
	 */
	Boolean createHelp(@Valid HelpDTO helpDTO) throws Exception;

}
