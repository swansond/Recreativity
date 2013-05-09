package winning.pwnies.recreativity;

import java.util.List;
/**
 * Represents a user of the application
 * @author David Swanson
 *
 */
public interface User {
	/**
	 * Gets the Submissions that this user has submitted.
	 * @return a list of the submissions authored by this user
	 */
	public List<Submission> submissions();
	
	/**
	 * Gets the number of stars the user has received for their work
	 * @return number of stars received by user
	 */
	public int numStars();
}
