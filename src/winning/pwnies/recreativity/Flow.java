package winning.pwnies.recreativity;

import android.os.Parcelable;

public interface Flow extends Parcelable {
	/**
	 * Adds an item to the end of the flow
	 * @param sub the new submission to be added
	 */
	public void addItem(Submission sub);

	/**
	 * Gets the submission at the given index
	 * @param index the index of the requested submission
	 * @return the submission at the provided index
	 */
	public Submission get(int index);
	
	/**
	 * Returns the index of the keyframe, the most important (highest rated?)
	 * submission in the flow
	 * @return index of the highest rated frame
	 */
	// TODO Potentially find a better name for this?
	public int keyframe();
	
	/**
	 * The number of elements in this flow
	 * @return the number of elements in the flow
	 */
	public int size();
	
	/**
	 * Returns a FlowView object for this flow
	 * @return FlowView for this flow.
	 */
	public FlowDisplay display();
	
	/**
	 * The secret serial number for this flow
	 * @return the number for this flow.
	 */
	public int serialNumber();

}
