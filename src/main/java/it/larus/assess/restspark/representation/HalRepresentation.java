package it.larus.assess.restspark.representation;

import java.util.HashMap;
import java.util.Map;

/**
 * Introduce _links for hypermedia application
 * @author omar
 *
 */
public class HalRepresentation {
	private Map<String, HalLink> _links;
	
	public HalRepresentation() {
		this._links = new HashMap<>();
	}

	/**
	 * Add or replace link into representation
	 * @param label
	 * @param href
	 */
	public void addLink(String label, String href)
	{
		this._links.put(label, new HalLink(href));
	}
	
	public Map<String, HalLink> get_links() {
		return _links;
	}

	public void set_links(Map<String, HalLink> _links) {
		this._links = _links;
	}
	
	
}
