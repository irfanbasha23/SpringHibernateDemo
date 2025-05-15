package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.contract.PanelContract;
import com.example.demo.entity.Panel;
import com.example.demo.repository.PanelRepository;
import com.example.demo.result.PanelResult;
import com.example.demo.services.PanelOperationsService;

@Service
public class PanelOperationsServiceImpl implements PanelOperationsService{

	@Autowired
	private PanelRepository panelRepository;
	
	public PanelResult getPanelByTechStream(PanelContract panelContract) {
		PanelResult panelResult = new PanelResult();
		if(panelContract != null && !"".equals(panelContract.getTechStream())) {
			List<Panel> panelList = panelRepository.findByTechStreams(panelContract.getTechStream());
			panelResult.setPanelList(panelList);
		}
	    return panelResult; 
	}

	@PreAuthorize("hasPermission('ROLE','HR')")
	public PanelResult updatePanelData(final PanelContract panelContract) {
		PanelResult panelResult = new PanelResult();
		if(panelContract.getPanel() != null && panelContract.getPanel().getPanelId() !=0) {
			Optional<Panel> panel = panelRepository.findById(panelContract.getPanel().getPanelId());
			if(panel.get() != null) {
				Panel newpPanel = populateNewPanelData(panel.get(), panelContract.getPanel());
				panelResult.setPanel(panelRepository.save(newpPanel));
			}
		}
		return panelResult;
	}
	
	/**
	 * Deletes a panel entity specified in the given contract if it exists and has a valid ID.
	 *
	 * Only users with HR role permission can perform this operation.
	 *
	 * @param panelContract contract containing the panel to be deleted
	 */
	@PreAuthorize("hasPermission('ROLE','HR')")
	public void deletePanel(final PanelContract panelContract) {
		if(panelContract.getPanel() != null && panelContract.getPanel().getPanelId() !=0) {
			Optional<Panel> panel = panelRepository.findById(panelContract.getPanel().getPanelId());
			if(panel.get() != null) {
				panelRepository.delete(panel.get());
			}
		}
	}

 /**
  * Adds an existing panel to the repository if the provided contract contains a valid panel with a non-zero ID.
  *
  * Access is restricted to users with HR role permissions.
  *
  * @param panelContract the contract containing the panel to be added
  */
 @PreAuthorize("hasPermission('ROLE','HR')")
 public void addPanel(final PanelContract panelContract) {
     if(panelContract.getPanel() != null && panelContract.getPanel().getPanelId() != 0) {
         Optional<Panel> panel = panelRepository.findById(panelContract.getPanel().getPanelId());
         if(panel.isPresent()) {
             panelRepository.add(panel.get());
         }
     }
 }
	
	/**
	 * Updates the fields of an existing Panel entity with values from another Panel instance.
	 *
	 * @param oldPanel the Panel entity to be updated
	 * @param newPanel the Panel containing updated field values
	 * @return the updated Panel entity
	 */
	public Panel populateNewPanelData(final Panel oldPanel, final Panel newPanel) {
		oldPanel.setName(newPanel.getName());
		oldPanel.setTechStreams(newPanel.getTechStreams());
		oldPanel.setDetailTechStack(newPanel.getDetailTechStack());
		
		oldPanel.setFirstLevel(newPanel.getFirstLevel());
		oldPanel.setManagerial(newPanel.getManagerial());
		oldPanel.setSecondLevel(newPanel.getSecondLevel());
		return oldPanel;
	}

}
