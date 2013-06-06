package winning.pwnies.recreativity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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
		LinearLayout playButton = (LinearLayout) findViewById(R.id.menu_play_explore);
		playButton.setOnClickListener(new LinearLayout.OnClickListener() {
		    public void onClick(View v) {
		    	Intent myIntent = new Intent(CommentActivity.this, PlayActivity.class);
		    	CommentActivity.this.startActivity(myIntent);
		    }
		});
		
		LinearLayout profileButton = (LinearLayout) findViewById(R.id.menu_profile_explore);
		profileButton.setOnClickListener(new LinearLayout.OnClickListener() {
		    public void onClick(View v) {
		    	Intent myIntent = new Intent(CommentActivity.this, ProfileActivity.class);
		    	CommentActivity.this.startActivity(myIntent);
		    }
		});
		
		ImageButton submitComment = (ImageButton) findViewById(R.id.submit_comment);
		submitComment.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
			}
		});
	}
	
	
}
