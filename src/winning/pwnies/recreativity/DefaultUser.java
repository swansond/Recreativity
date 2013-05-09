package winning.pwnies.recreativity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author David Swanson
 *
 */
public class DefaultUser implements User {
	private final Set<Integer> starred;
	private final List<Submission> submissions;
	private int receivedStars;
	
	public DefaultUser() {
		starred = new HashSet<Integer>();
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
		// TODO Auto-generated method stub
		return 0;
	}

}
