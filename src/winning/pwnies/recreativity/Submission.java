package winning.pwnies.recreativity;

import java.util.List;

/**
 * Represents an individual entry in a flow.
 * @author David Swanson
 *
 */
public interface Submission {
	
	/**
	 * Adds a comment to this entry
	 * @param in the comment to be added
	 */
	public void addComment(Comment in);
	
	/**
	 * Adds a star to this entry
	 * @param name the user attempting to star this submission
	 * @return false if the user already starred submission, true otherwise
	 */
	public boolean star(User name);
	
	/**
	 * Gets the list of comments for this submission
	 * @return list of comments associated with this submission
	 */
	public List<Comment> getComments(); // TODO figure out how to change comments 
	
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
	
	// TODO add a get flow method?
}
