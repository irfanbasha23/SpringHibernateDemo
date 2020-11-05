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
	
	@PreAuthorize("hasPermission('ROLE','HR')")
	public void deletePanel(final PanelContract panelContract) {
		if(panelContract.getPanel() != null && panelContract.getPanel().getPanelId() !=0) {
			Optional<Panel> panel = panelRepository.findById(panelContract.getPanel().getPanelId());
			if(panel.get() != null) {
				panelRepository.delete(panel.get());
			}
		}
	}
	
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
