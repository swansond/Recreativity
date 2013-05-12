package winning.pwnies.recreativity;

public interface Flow {
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
	
	public int size();
	
	/**
	 * Returns a FlowView object for this flow
	 * @return FlowView for this flow.
	 */
	public FlowView getView();
	
}
