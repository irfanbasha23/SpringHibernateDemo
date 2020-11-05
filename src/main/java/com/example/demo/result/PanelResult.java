package com.example.demo.result;

import java.io.Serializable;
import java.util.List;

import com.example.demo.entity.Panel;

public class PanelResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -683653052440630272L;
	private List<Panel> panelList;
	private Panel panel;

	/**
	 * @return the panelList
	 */
	public List<Panel> getPanelList() {
		return panelList;
	}

	/**
	 * @param panelList the panelList to set
	 */
	public void setPanelList(List<Panel> panelList) {
		this.panelList = panelList;
	}

	/**
	 * @return the panel
	 */
	public Panel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(Panel panel) {
		this.panel = panel;
	}
	
	
}
