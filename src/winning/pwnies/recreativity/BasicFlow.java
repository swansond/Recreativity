package winning.pwnies.recreativity;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class BasicFlow implements Flow {
	private List<Submission> items;
	// private int key -- the cached keyFrame?
	
	
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
	}

}
