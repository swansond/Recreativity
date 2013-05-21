package winning.pwnies.recreativity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author David Swanson
 *
 */
public class DefaultUser implements User {
	private static int currentSerial = 1;
	
	private List<Submission> submissions;
	private int receivedStars;
	private int serial;
	
	public static DefaultUser newDefaultUser() {
		DefaultUser out = new DefaultUser();
		Data.addUser(out.serial, out);
		return out;
	}
	
	private DefaultUser() {
		submissions = new ArrayList<Submission>();
		serial = currentSerial++;
	}
	
	public DefaultUser(Parcel in) {
		receivedStars = in.readInt();
		serial = in.readInt();
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
		dest.writeInt(serial);
		dest.writeList(submissions);
	}

	@Override
	public int serialNumber() {
		return serial;
	}

	public static final Parcelable.Creator<DefaultUser> CREATOR = new Parcelable.Creator<DefaultUser>() {
		public DefaultUser createFromParcel(Parcel in) {
			return new DefaultUser(in);
		}
		
		public DefaultUser[] newArray(int size) {
			return new DefaultUser[size];
		}
	};
	
}
