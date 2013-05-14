package winning.pwnies.recreativity;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 
 * @author David Swanson
 *
 */
public class BasicFlow implements Flow {
	private static int currentSerial = 1;
	
	private List<Submission> items;
	private int serial;
	// private int key -- the cached keyFrame?
	
	public BasicFlow(Parcel in) {
		serial = in.readInt();
		in.readList(items, Submission.class.getClassLoader());
	}
	
	public BasicFlow() {
		items = new ArrayList<Submission>();
		serial = currentSerial++;
		Data.addFlow(serial, this);
	}

	@Override
	public void addItem(Submission sub) {
		int size = items.size();
		items.add(sub);
		sub.setFlow(this, size);
	}

	@Override
	public int keyframe() {
		// TODO Scan the list and return the highest rated entry.
		// Alternatively, cache the highest rated entry and recalculate sometimes
		return 0;
	}

	@Override
	public Submission get(int index) {
		return items.get(index);
	}

	@Override
	public FlowView getView() {
		return new FlowView(this);
	}

	@Override
	public int size() {
		return items.size();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(serial);
		dest.writeList(items);
	}

	public static final Parcelable.Creator<BasicFlow> CREATOR = new Parcelable.Creator<BasicFlow>() {
		public BasicFlow createFromParcel(Parcel in) {
			return new BasicFlow(in);
		}
		
		public BasicFlow[] newArray(int size) {
			return new BasicFlow[size];
		}
	};

	@Override
	public int serialNumber() {
		return serial;
	}
	
}
