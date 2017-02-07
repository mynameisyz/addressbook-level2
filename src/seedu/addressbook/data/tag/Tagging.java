package seedu.addressbook.data.tag;

import java.util.ArrayList;
import seedu.addressbook.data.person.Person;

public class Tagging {
	
	private Person person;
	private Tag tag;
	private TagOperationFlag operation;
	
	/**
	 * Common container for all tagging association
	 */
	public static ArrayList<Tagging> TaggingList;
	
	public static enum TagOperationFlag{
		addTag, deleteTag
	}
	
	public Tagging(Person person, Tag tag, TagOperationFlag operation){
		this.person = person;
		this.tag = tag;
		this.operation = operation;
	}
	
	public static Tagging addTagging(Person person, Tag tag, int operation){
		Tagging tagging = new Tagging(person, tag, Tagging.TagOperationFlag.addTag);
		TaggingList.add(tagging);
		return tagging;
	}
	
	public static Tagging deleteTagging(Person person, Tag tag, int operation){
		Tagging tagging = new Tagging(person, tag, Tagging.TagOperationFlag.deleteTag);
		TaggingList.add(tagging);
		return tagging;
	}

}
