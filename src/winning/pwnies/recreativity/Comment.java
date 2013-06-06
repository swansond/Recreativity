package winning.pwnies.recreativity;

import android.os.Parcelable;

public interface Comment extends Parcelable {

	/**
	 * Gets the serial number for this comment
	 * @return the serial number for this comment
	 */
	public int serialNumber();
	
	/**
	 * Gets the author of this comment
	 * @return Name of the author
	 */
	public String getAuthor();
	
	/**
	 * Gets the text of this comment
	 * @return The text contained in this comment
	 */
	public String getText();

}
