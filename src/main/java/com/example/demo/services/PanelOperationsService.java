package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.contract.PanelContract;
import com.example.demo.result.PanelResult;

@Service
public interface PanelOperationsService {
	
	public PanelResult getPanelByTechStream(final PanelContract panelContract);
	
	/**
 * Updates panel information based on the details provided in the given contract.
 *
 * @param panelContract the contract containing updated panel data
 * @return the result of the update operation, including status and any relevant data
 */
public PanelResult updatePanelData(final PanelContract panelContract);
	
	/**
 * Deletes a panel as specified by the provided contract.
 *
 * @param panelContract the contract containing details of the panel to delete
 */
public void deletePanel(final PanelContract panelContract);

	/**
 * Adds a new panel using the details provided in the given contract.
 *
 * @param panelContract the contract containing information for the new panel
 */
public void addPanel(final PanelContract panelContract);
}
