package winning.pwnies.recreativity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * @author David Swanson
 *
 */
public class BasicSubmission implements Submission {
	private final List<Comment> comments;
	private final Set<User> starred;
	private int stars;
	private final int id;
	private final User author;
	private final Content entry;
	private Flow flow;
	private int index;
	
	
	public BasicSubmission(Content c, User a) {
		id = 0;
		entry = c;
		author = a;
		comments = new ArrayList<Comment>();
		starred = new HashSet<User>();
	}
	
	public void setFlow(Flow f, int i) {
		flow = f;
		index = i;
	}
	
	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.Submission#addComment(winning.pwnies.recreativity.Comment)
	 */
	@Override
	public void addComment(Comment in) {
		comments.add(in);
	}

	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.Submission#star(winning.pwnies.recreativity.User)
	 */
	@Override
	public void toggleStar(User name) {
		if (!starred.add(name)) {
			name.removeStar();
			starred.remove(name);
		} else {
			name.addStar();
		}
	}

	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.Submission#getComments()
	 */
	@Override
	public List<Comment> viewComments() {
		return Collections.unmodifiableList(comments);
	}

	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.Submission#stars()
	 */
	@Override
	public int stars() {
		return stars;
	}

	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.Submission#getContent()
	 */
	@Override
	public Content getContent() {
		return entry;
	}

	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.Submission#getAuthor()
	 */
	@Override
	public User getAuthor() {
		return author;
	}
	
	@Override
	public Submission next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return flow.get(index + 1);
	}
	
	@Override
	public Submission prev() {
		if (!hasPrev()) {
			throw new NoSuchElementException();
		}
		return flow.get(index - 1);
	}

	@Override
	public boolean hasNext() {
		return index + 1 < flow.size();
	}

	@Override
	public boolean hasPrev() {
		return index > 0;
	}


}
