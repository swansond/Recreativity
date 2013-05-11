package winning.pwnies.recreativity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Swanson
 *
 */
public class BasicSubmission implements Submission {
	private final List<Comment> comments;
	private int stars;
	private final int id;
	private final User author;
	private final Content entry;
	
	public BasicSubmission(Content c, User a) {
		id = 0;
		entry = c;
		author = a;
		comments = new ArrayList<Comment>();
	}
	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.Submission#addComment(winning.pwnies.recreativity.Comment)
	 */
	@Override
	public void addComment(Comment in) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.Submission#star(winning.pwnies.recreativity.User)
	 */
	@Override
	public boolean star(User name) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.Submission#getComments()
	 */
	@Override
	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.Submission#stars()
	 */
	@Override
	public int stars() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.Submission#getContent()
	 */
	@Override
	public Content getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.Submission#getAuthor()
	 */
	@Override
	public User getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

}
