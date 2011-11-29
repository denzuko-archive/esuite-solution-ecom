package org.javavitamins.beans;

import org.javavitamins.defaults.IDefaults;
import org.javavitamins.defaults.IOperationStatus;
import org.javavitamins.utilities.BeanUtilities;

public class BaseBean extends BeanUtilities implements IDefaults, IOperationStatus {
	
	private boolean readOnly = false;
	private boolean editMode = false;
	private boolean viewMode = false;
	private boolean actionPanel = true;
	
	
	
	public BaseBean() {
		
	}
	
	/**
	 * @return the readOnly
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * @param readOnly the readOnly to set
	 */
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	/**
	 * @return the actionPanel
	 */
	public boolean isActionPanel() {
		return actionPanel;
	}

	/**
	 * @param actionPanel the actionPanel to set
	 */
	public void setActionPanel(boolean actionPanel) {
		this.actionPanel = actionPanel;
	}

	/**
	 * @return the editMode
	 */
	public boolean isEditMode() {
		return editMode;
	}

	/**
	 * @param editMode the editMode to set
	 */
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	/**
	 * @return the viewMode
	 */
	public boolean isViewMode() {
		return viewMode;
	}

	/**
	 * @param viewMode the viewMode to set
	 */
	public void setViewMode(boolean viewMode) {
		this.viewMode = viewMode;
	}
	
	
	

}
