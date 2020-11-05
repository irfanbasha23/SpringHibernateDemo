package com.example.demo.contract;

import java.io.Serializable;

import com.example.demo.entity.Panel;

public class PanelContract implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5832422123965615973L;

	private String techStream;
	
	private Panel panel;

	/**
	 * @return the techStream
	 */
	public String getTechStream() {
		return techStream;
	}

	/**
	 * @param techStream the techStream to set
	 */
	public void setTechStream(String techStream) {
		this.techStream = techStream;
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
