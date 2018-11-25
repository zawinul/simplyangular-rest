package it.eng.sa.rest;

import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import it.eng.sa.model.ClientConfiguration;
import it.eng.sa.model.Configuration;
import it.eng.sa.web.ConfigurationHelper;

@Path("session")
public class Session   {
	    
	@Context
    private HttpServletRequest request;

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("configuration")
    public ClientConfiguration getconf() {
		ClientConfiguration conf = new ClientConfiguration();
		Configuration config = ConfigurationHelper.get(); 
		conf = new ClientConfiguration();
		conf.debug = config.isDebug;
		conf.appLabel = config.appLabel;
		return conf;
	}
	
	@GET
    @Produces(MediaType.TEXT_PLAIN) 
	@Path("logout")
	public String logout() {
		request.getSession().invalidate();
		return "ok";
	}

}
