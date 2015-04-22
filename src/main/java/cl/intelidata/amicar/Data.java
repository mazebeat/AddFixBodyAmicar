/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar;

import java.util.ArrayList;

/**
 * @author Maze
 */
public class Data {

	private String            docInstanceId;
	private String            urlRead;
	private String            urlClick;
	private String            title;
	private ArrayList<String> listFiles;

	/**
	 *
	 */
	public Data() {
		this.docInstanceId = "";
		this.urlRead = "";
		this.urlClick = "";
		this.listFiles = new ArrayList<String>();
	}

	/**
	 *
	 */
	public void clearListFiles() {
		if (!this.getListFiles().isEmpty()) {
			this.getListFiles().clear();
		}
	}

	/**
	 * @return the listFiles
	 */
	public ArrayList<String> getListFiles() {
		return listFiles;
	}

	/**
	 * @param listFiles the listFiles to set
	 */
	public void setListFiles(ArrayList<String> listFiles) {
		this.listFiles = listFiles;
	}

	/**
	 * @param value
	 */
	public void addListFiles(String value) {
		if (!value.isEmpty()) {
			this.getListFiles().add(value.trim());
		}
	}

	/**
	 * @return the docInstanceId
	 */
	public String getDocInstanceId() {
		return docInstanceId;
	}

	/**
	 * @param docInstanceId the docInstanceId to set
	 */
	public void setDocInstanceId(String docInstanceId) {
		this.docInstanceId = docInstanceId;
	}

	/**
	 * @return the urlRead
	 */
	public String getUrlRead() {
		return urlRead;
	}

	/**
	 * @param urlRead the urlRead to set
	 */
	public void setUrlRead(String urlRead) {
		this.urlRead = urlRead;
	}

	/**
	 * @return the urlClick
	 */
	public String getUrlClick() {
		return urlClick;
	}

	/**
	 * @param urlClick the urlClick to set
	 */
	public void setUrlClick(String urlClick) {
		this.urlClick = urlClick;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
