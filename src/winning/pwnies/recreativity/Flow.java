package winning.pwnies.recreativity;

public interface Flow {
	/**
	 * Adds an item to the end of the flow
	 * @param sub the new submission to be added
	 */
	public void addItem(Submission sub);
	
	/**
	 * Returns the submission at the current index.
	 * Defaults to the keyframe, but can be moved
	 * @return the submission currently focused on
	 */
	public Submission getCurrent();
	
	/**
	 * Moves the current focus to the next (right, more recent) element.
	 */
	public void next();
	
	/**
	 * Returns the next (right, more recent) element without moving the focus
	 * @return the next submission in the flow
	 */
	public Submission getNext();
	
	/**
	 * Moves the current focus to the previous (left, less recent) element.
	 */
	public void prev();
	
	/**
	 * Returns the previous (left, less recent) element without moving the focus
	 * @return the previous submission in the flow
	 */
	public Submission getPrev();
	
	/**
	 * Moves the current focus to the element at the provided index
	 * @param index the index to move the focus to
	 */
	// TODO This will be used for implementing the slider functionality
	public void moveTo(int index);
	
	/**
	 * Returns the index of the keyframe, the most important (highest rated?)
	 * submission in the flow
	 * @return index of the highest rated frame
	 */
	// TODO Potentially find a better name for this?
	public int keyframe();
	
}
