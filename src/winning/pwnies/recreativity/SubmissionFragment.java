package winning.pwnies.recreativity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class SubmissionFragment extends Fragment {
	int sub;
	int flow;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Bundle args = getArguments();
		flow = args.getInt(Data.FLOW);
		sub = args.getInt(Data.SUBMISSION);
		final Submission submission = Data.getFlow(flow).get(sub);
		final LinearLayout casing = (LinearLayout) inflater.inflate(R.layout.content_layout, container, false);
		final ImageButton starButton = (ImageButton) casing.findViewById(R.id.starButton);
		starButton.setImageDrawable(getResources().getDrawable(R.drawable.star1));
		starButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				submission.toggleStar(Data.getUser(1));
				if (submission.stars() == 0) {			
					starButton.setImageDrawable(getResources().getDrawable(R.drawable.star1));
				} else {
					starButton.setImageDrawable(getResources().getDrawable(R.drawable.star2));
				}
			}
		});
		if (submission.stars() == 0) {
			starButton.setImageDrawable(getResources().getDrawable(R.drawable.star1));
		} else {
			starButton.setImageDrawable(getResources().getDrawable(R.drawable.star2));
		}
		Button button = (Button)casing.findViewById(R.id.comment);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), CommentActivity.class);
				intent.putExtra(Data.SUBMISSION, sub);
				intent.putExtra(Data.FLOW, flow);
				startActivity(intent);
			}
		});
		button.setText("Comments (" + submission.viewComments().size() + ")");
		
		ContentView newView = (ContentView) casing.findViewById(R.id.contentView);
		newView.setContent(submission.getContent());
		return casing;
	}

}
