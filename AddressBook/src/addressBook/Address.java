package addressBook;

/**
 * Represents an address, which is used in the construction of a Contact object.
 * 
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
	 * Initializes the Address object.
	 * 
	 * @param address1 address line 1
	 * @param address2 address line 2
	 * @param city     the address' city
	 * @param state    the address' state
	 * @param zip      the address' zip code
	 */
	public Address(String address1, String address2, String city, State state,
			int zip) {
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	/**
	 * Gets the first line of the address.
	 * 
	 * @return address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * Sets the first line of the of address.
	 * 
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * Gets the second line of the address.
	 * 
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * Sets the second line of the address.
	 * 
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * Gets the city.
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 * 
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 * 
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * Sets the state.
	 * 
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * Returns the zip code.
	 * 
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}

	/**
	 * Sets the zip code.
	 * 
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}

	/**
	 * Formats the addres to the following format:<br>
	 * {address1},{address2},{city},{state},{zip}
	 * 
	 */
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%d", address1, address2, city,
				state.toString(), zip);
	}

}
