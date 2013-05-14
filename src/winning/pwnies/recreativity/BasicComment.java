package winning.pwnies.recreativity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author David Swanson
 *
 */
public class BasicComment implements Comment {
	private String text;
	private User author;
	
	public BasicComment(String text, User author) {
		this.text = text;
		this.author = author;
	}
	
	public BasicComment(Parcel in) {
		text = in.readString();
		author = in.readParcelable(User.class.getClassLoader());
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(text);
		dest.writeParcelable(author, 0);
	}
	
	public static final Parcelable.Creator<BasicComment> CREATOR = new Parcelable.Creator<BasicComment>() {
		public BasicComment createFromParcel(Parcel in) {
			return new BasicComment(in);
		}
		
		public BasicComment[] newArray(int size) {
			return new BasicComment[size];
		}
	};
}
