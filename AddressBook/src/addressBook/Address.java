package addressBook;

/**
 * @author Adam Ross
 *
 */
public class Address {
	private String address1;
	private String address2;
	private String city;
	private State state;
	private int zip;

	/**
	 * @param address1
	 * @param address2
	 * @param city
	 * @param state
	 * @param zip
	 */
	public Address(String address1, String address2, String city, State state, int zip) {
		this.address1 = address1;

		if (address2 == null)
			this.address2 = "";
		else
			this.address2 = address2;

		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		if (address2 == null)
			this.address2 = "";
		else
			this.address2 = address2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %d", address1, address2, city, state.toString(), zip);
	}
}
