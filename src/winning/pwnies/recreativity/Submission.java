package winning.pwnies.recreativity;

import java.util.List;

import android.os.Parcelable;

/**
 * Represents an individual entry in a flow.
 * @author David Swanson
 *
 */
public interface Submission extends Parcelable {

	/**
	 * Adds a comment to this entry
	 * @param in the comment to be added
	 */
	// TODO delete comments
	public void addComment(Comment in);
	
	/**
	 * Add or remove a star for this entry
	 * @param name the user attempting to star this submission
	 */
	public void toggleStar(User name);
	
	/**
	 * Gets the list of comments for this submission
	 * @return list of comments associated with this submission
	 */
	public List<Comment> viewComments(); 
	
	/**
	 * Gets the number of stars this submission has received
	 * @return number of stars for this submission
	 */
	public int stars();
	
	/**
	 * Returns the user-created content held by this submission
	 * @return a Content object representing this submission
	 */
	public Content getContent();
	
	/**
	 * Returns the user who created this submission
	 * @return a User object representing the author of this submission
	 */
	public User getAuthor();
	
	/**
	 * Returns whether there is another submission after this one
	 * @return true if there is another submission, false otherwise
	 */
	public boolean hasNext();
	
	/**
	 * Returns whether there is another submission before this one
	 * @return true if there is another submission, false otherwise
	 */
	public boolean hasPrev();
	
	/**
	 * Gets the next submission in the flow
	 * @return the submission after this submission
	 * @throws NoSuchElementException if hasNext is false
	 */
	public Submission next();
	
	/**
	 * Gets the previous submission in the flow
	 * @return the submission immediately preceding this submission
	 * @throws NoSuchElementException if hasNext is false
	 */
	public Submission prev();
	
	/**
	 * Sets this submission's place in a flow
	 * Only call this method once per submission
	 * @param f The flow this submission is being added to
	 * @param i The index of this submission in the destination flow
	 */
	public void setFlow(Flow f, int i);
	
}
