package winning.pwnies.recreativity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

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
		pager.setOffscreenPageLimit(5);
		pager.setCurrentItem(submissionNumber);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_explore:
			Data.goToExplore(this);
			break;
		case R.id.menu_play:
			Data.goToPlay(this);
			break;
		case R.id.menu_profile:
			Data.goToProfile(this);
			break;
		default:
			break;
		}
		return true;
	}
}
