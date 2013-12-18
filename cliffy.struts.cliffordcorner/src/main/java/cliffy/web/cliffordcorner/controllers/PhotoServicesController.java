package cliffy.web.cliffordcorner.controllers;

import cliffy.common.*;

import java.util.*;

//import org.apache.struts2.json.annotations.JSON;

public class PhotoServicesController extends BaseController {
	private static final long serialVersionUID = 1L;

	private PhotographAlbum model;
	private String tag;
	private int count;
	private int page;

	public PhotographAlbum getModel() {
		return model;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void setPage(int page) {
		this.page = page;
	}

	public PhotoServicesController() {
		this.count = 10;
		this.page = 0;
		this.tag = "";
	}
    
    public String execute() throws Exception {
    	ArrayList<String> tags = new ArrayList<String>();
    	if (this.tag != null && this.tag.length() > 0) {
    		tags.add(tag);
    	}
    	
    	this.model = this.photoRepo.getPhotographs(tags, count, page);
    	
        return SUCCESS;
    }
}