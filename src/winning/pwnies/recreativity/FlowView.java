package winning.pwnies.recreativity;

public class FlowView {
	private Flow flow;
	private int current;
	
	public FlowView(Flow f) {
		flow = f;
		current = flow.keyframe();
	}
	
	/**
	 * Moves the current focus to the element at the provided index
	 * @param index the index to move the focus to
	 */
	// TODO This will be used for implementing the slider functionality
	public Submission moveTo(int index) {
		return flow.get(index);
	}
}
