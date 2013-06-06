package winning.pwnies.recreativity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SlidingDrawer;

@SuppressWarnings("deprecation")
public class SubmissionFragment extends Fragment {
	private CommentAdapter cAdapter;
	private SlidingDrawer drawer;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Bundle args = getArguments();
		final Submission submission = args.getParcelable(Data.ARG_OBJECT);
		final LinearLayout casing = (LinearLayout) inflater.inflate(R.layout.content_layout, container, false);
		
		final ImageButton starButton = (ImageButton) casing.findViewById(R.id.starButton);
		starButton.setImageDrawable(getResources().getDrawable(R.drawable.star1));
		starButton.setOnClickListener(new View.OnClickListener() {
			boolean starred = true;

			@Override
			public void onClick(View v) {
				submission.toggleStar(Data.getUser(1));
				if (starred) {					
					starButton.setImageDrawable(getResources().getDrawable(R.drawable.star2));
					starred = false;
				} else {
					starButton.setImageDrawable(getResources().getDrawable(R.drawable.star1));
					starred = true;
				}
			}
		});
		if (submission.stars() == 1) {
			starButton.setImageDrawable(getResources().getDrawable(R.drawable.star2));
		} else {
			starButton.setImageDrawable(getResources().getDrawable(R.drawable.star1));
		}
		((Button)casing.findViewById(R.id.commentToggle)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				drawer.animateToggle();
			}
		});
		ContentView newView = (ContentView) casing.findViewById(R.id.contentView);
		newView.setContent(submission.getContent());
		return casing;
	}

}
