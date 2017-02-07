package seedu.addressbook.data.person;

/**
 * An abstract class for Contact of a Person
 */
public abstract class Contact {
	
	private String value;
	protected boolean isPrivate;
	
	public String toString(){
		return getValue();
	}
	
	public boolean isPrivate(){
		return isPrivate;
	}
	
	public int hashCode(){
		return getValue().hashCode();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
