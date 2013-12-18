package cliffy.web.cliffordcorner.controllers;

import cliffy.data.*;
import cliffy.web.cliffordcorner.*;
import cliffy.web.cliffordcorner.config.*;

import java.util.*;

import org.apache.commons.configuration.ConfigurationException;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseController extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	protected IBlogRepository blogRepo;
	protected IPhotographRepository photoRepo;
	protected CliffordCornerConfigProperties config;

	public List<CliffordCornerLink> getFeaturedAlbums() {
		ArrayList<CliffordCornerLink> output = new ArrayList<CliffordCornerLink>();
		if (config != null) {
			output.addAll(this.config.getNavigation().subList(0, 3));
		}
		return output;
	}
	
	public List<CliffordCornerLink> getOtherAlbums() {
		ArrayList<CliffordCornerLink> output = new ArrayList<CliffordCornerLink>();
		if (config != null) {
			List<CliffordCornerLink> navigation = this.config.getNavigation(); 
			output.addAll(navigation.subList(3, navigation.size() - 1));
		}
		return output;
	}

	public BaseController() {
    	this.blogRepo = Repositories.getBlogRepository();
    	this.photoRepo = Repositories.getPhotographRepository();
    	
    	try {
			this.config = new CliffordCornerConfigProperties();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
}