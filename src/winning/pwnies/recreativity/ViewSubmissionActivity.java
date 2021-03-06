package winning.pwnies.recreativity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class ViewSubmissionActivity extends FragmentActivity {

	SubmissionPagerAdapter pagerAdapter;
	ViewPager pager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_submission);
		Intent intent = getIntent();
		Bundle b = intent.getExtras();
		int flowID = b.getInt(Data.FLOW);
		int submissionNumber = b.getInt(Data.SUBMISSION);
		pagerAdapter = new SubmissionPagerAdapter(getSupportFragmentManager(), Data.getFlow(flowID));
		pager = (ViewPager) findViewById(R.id.submission_pager);
		pager.setAdapter(pagerAdapter);
		pager.setOffscreenPageLimit(20);
		pager.setCurrentItem(submissionNumber);
		
		LinearLayout playButton = (LinearLayout) findViewById(R.id.menu_play_explore);
		playButton.setOnClickListener(new LinearLayout.OnClickListener() {
			public void onClick(View v) {
				Intent myIntent = new Intent(ViewSubmissionActivity.this, PlayActivity.class);
				ViewSubmissionActivity.this.startActivity(myIntent);
			}
		});

		LinearLayout profileButton = (LinearLayout) findViewById(R.id.menu_profile_explore);
		profileButton.setOnClickListener(new LinearLayout.OnClickListener() {
			public void onClick(View v) {
				Intent myIntent = new Intent(ViewSubmissionActivity.this, ProfileActivity.class);
				ViewSubmissionActivity.this.startActivity(myIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		default:
			break;
		}
		// return true;
		return super.onOptionsItemSelected(item);
	}
}
