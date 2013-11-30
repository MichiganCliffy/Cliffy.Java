package cliffy.web.cliffordcorner.controllers;

import cliffy.common.*;

public class AlbumController extends BaseController {
	private static final long serialVersionUID = 1L;
	
	private PhotographAlbum model;
	private String id; 
    
    public String getId() {
    	return this.id;
    }
    
    public void setId(String id) {
    	this.id = id;
    }
    
    public PhotographAlbum getModel() {
    	return this.model;
    }
	
    public AlbumController() {
		this.id = "Pool";
    }
    
    public String execute() throws Exception {
    	this.model = this.photoRepo.getAlbum(null, this.id); 
    	
        return SUCCESS;
    }
}