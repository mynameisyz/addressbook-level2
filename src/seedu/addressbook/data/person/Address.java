package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final int BLOCK_INDEX = 0;
    public static final int STREET_INDEX = 1;
    public static final int UNIT_INDEX = 2;
    public static final int POSTALCODE_INDEX = 3;

    private final String fullAddress;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        String[] addressFields = trimmedAddress.split(",");
        if (!isValidAddress(trimmedAddress) || addressFields.length!=4) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.fullAddress = new String(trimmedAddress);       
        this.block = new Block(addressFields[BLOCK_INDEX]);
        this.street = new Street(addressFields[STREET_INDEX]);
        this.unit = new Unit(addressFields[UNIT_INDEX]);
        this.postalCode = new PostalCode(addressFields[POSTALCODE_INDEX]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return getFullAddress();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getFullAddress().equals(((Address) other).getFullAddress())); // state check
    }

    @Override
    public int hashCode() {
        return getFullAddress().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

	public String getFullAddress() {
		return fullAddress;
	}
}
