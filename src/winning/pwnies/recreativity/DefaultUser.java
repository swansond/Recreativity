package winning.pwnies.recreativity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Swanson
 *
 */
public class DefaultUser implements User {
	private final List<Submission> submissions;
	private int receivedStars;
	
	public DefaultUser() {
		submissions = new ArrayList<Submission>();
	}

	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.User#submissions()
	 */
	@Override
	public List<Submission> submissions() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.User#numStars()
	 */
	@Override
	public int numStars() {
		return receivedStars;
	}

	@Override
	public void addStar() {
		receivedStars++;
	}

	@Override
	public void removeStar() {
		receivedStars--;
		if (receivedStars < 0) {
			receivedStars = 0;	
		}
	}

}
