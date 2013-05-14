package winning.pwnies.recreativity;

public class FlowView {
	private Flow flow;
	private int current;
	
	public FlowView(Flow f) {
		flow = f;
		current = flow.keyframe();
	}
	
	/**
	 * Gets the submisison at the provided index
	 * @param index the index to get the submission at
	 * @return Submission object for that index
	 */
	public Submission getAt(int index) {
		return flow.get(index);
	}
	
	/**
	 * Gets the number of submissions in the flow
	 * @return
	 */
	public int numElements() {
		return flow.size();
	}
	
	/**
	 * Moves the current focus to the element at the provided index
	 * @param index the index to move the focus to
	 */
	public void moveTo(int index) {
		current = index;
	}
	
	public Submission current() {
		return flow.get(current);
	}
}