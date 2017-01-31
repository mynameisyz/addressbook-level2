package seedu.addressbook.data.person;

/**
 * Represents a Street in a Person's address in the address book.
 */

public class Street {
	public Street(String value) {
		super();
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	} 
}
