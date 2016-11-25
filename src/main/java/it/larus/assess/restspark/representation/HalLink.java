package it.larus.assess.restspark.representation;

/**
 * href representation in HAL
 * 
 * @author omar
 *
 */
public class HalLink {
	private String href;
	
	public HalLink() {
	}

	public HalLink(String href) {
		super();
		this.href = href;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

}
