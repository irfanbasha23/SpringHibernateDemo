package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.contract.PanelContract;
import com.example.demo.result.PanelResult;

@Service
public interface PanelOperationsService {
	
	public PanelResult getPanelByTechStream(final PanelContract panelContract);
	
	public PanelResult updatePanelData(final PanelContract panelContract);
	
	public void deletePanel(final PanelContract panelContract);
}
