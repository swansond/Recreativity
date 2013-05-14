package winning.pwnies.recreativity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.os.Parcel;

/**
 * @author David Swanson
 *
 */
public class DefaultUser implements User {
	private List<Submission> submissions;
	private int receivedStars;
	
	public DefaultUser() {
		submissions = new ArrayList<Submission>();
	}
	
	public DefaultUser(Parcel in) {
		receivedStars = in.readInt();
		in.readList(submissions, Submission.class.getClassLoader());
	}

	/* (non-Javadoc)
	 * @see winning.pwnies.recreativity.User#submissions()
	 */
	@Override
	public List<Submission> submissions() {
		return Collections.unmodifiableList(submissions);
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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(receivedStars);
		dest.writeList(submissions);
	}

}
