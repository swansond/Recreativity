package winning.pwnies.recreativity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class CommentActivity extends Activity {
	Submission submission;
	CommentAdapter cAdapter;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_comments);
		Intent intent = getIntent();
		Bundle b = intent.getExtras();
		submission = b.getParcelable(Data.SUBMISSION);
		ListView commentList = (ListView)findViewById(R.id.comment_list);
		((Button)findViewById(R.id.comment_count)).setText("Comments (" + submission.viewComments().size() + ")");
		cAdapter = new CommentAdapter(this, R.id.comment_list, submission.viewComments());
		commentList.setAdapter(cAdapter);
		final ImageButton starButton = (ImageButton) findViewById(R.id.starButton_view);
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
		if (submission.stars() == 0) {
			starButton.setImageDrawable(getResources().getDrawable(R.drawable.star1));
		} else {
			starButton.setImageDrawable(getResources().getDrawable(R.drawable.star2));
		}
	}
}
