package winning.pwnies.recreativity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import android.os.Parcel;
import android.os.Parcelable;

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
	
	public BasicSubmission(Parcel in) {
		stars = in.readInt();
		id = in.readInt();
		author = Data.getUser(in.readInt());
		entry = Data.getContent(in.readInt());
		flow = Data.getFlow(in.readInt());
		index = in.readInt();
		int size = in.readInt();
		starred = new HashSet<User>();
		for (int i = 0; i < size; i++) {
			starred.add(Data.getUser(in.readInt()));
		}
		comments = new ArrayList<Comment>();
		size = in.readInt();
		for (int i = 0; i < size; i++) {
			comments.add(Data.getComment(in.readInt()));
		}
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
			stars--;
			starred.remove(name);
		} else {
			name.addStar();
			stars++;
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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(stars);
		dest.writeInt(id);
		dest.writeInt(author.serialNumber());
		dest.writeInt(entry.serialNumber());
		dest.writeInt(flow.serialNumber());
		dest.writeInt(index);
		dest.writeInt(starred.size());
		for (User u : starred) {
			dest.writeInt(u.serialNumber());
		}
		dest.writeInt(comments.size());
		for (Comment c : comments) {
			dest.writeInt(c.serialNumber());
		}
	}

	public static final Parcelable.Creator<BasicSubmission> CREATOR = new Parcelable.Creator<BasicSubmission>() {
		public BasicSubmission createFromParcel(Parcel in) {
			return new BasicSubmission(in);
		}
		
		public BasicSubmission[] newArray(int size) {
			return new BasicSubmission[size];
		}
	};

	@Override
	public int index() {
		return flow == null ? -1 : index;
	}

}
