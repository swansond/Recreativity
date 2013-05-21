package winning.pwnies.recreativity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SubmissionFragment extends Fragment {
	public static final String ARG_OBJECT = "object";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Bundle args = getArguments();
		Submission submission = args.getParcelable(ARG_OBJECT);
		
		ContentView newView = (ContentView) inflater.inflate(R.layout.content_layout, container, false);
		newView.setContent(submission.getContent());
		return newView;
	}

}
