package winning.pwnies.recreativity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Explore extends Fragment {
	private List<FlowView> views;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Collection<Flow> col = Data.getAllFlows();
		views = new ArrayList<FlowView>();
		for (Flow f : col) {
			views.add(new FlowView(f));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View myFragmentView = inflater.inflate(R.layout.explore_layout, container, false);
		LinearLayout ll = (LinearLayout)myFragmentView.findViewById(R.id.flowlistview);
		int i = 0;
		for (FlowView f : views) {
			View itemView = inflater.inflate(R.layout.flow_view_layout, ll);
			
			ContentView left = (ContentView) itemView.findViewById(R.id.contentViewLeft);
			ContentView center = (ContentView) itemView.findViewById(R.id.contentViewMiddle);
			ContentView right = (ContentView) itemView.findViewById(R.id.contentViewRight);
			Submission[] out = f.view();
			if (out[0] != null) {
				left.setContent(out[0].getContent());
			}
			center.setContent(out[1].getContent());
			if (out[2] != null) {
				right.setContent(out[2].getContent());
			}
			Log.e("counter", Integer.toString(++i));
		}
		return myFragmentView;
	}

}


