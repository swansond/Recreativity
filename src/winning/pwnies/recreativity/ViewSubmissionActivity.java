package winning.pwnies.recreativity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

@SuppressWarnings("deprecation")
public class ViewSubmissionActivity extends FragmentActivity implements OnDrawerOpenListener,
OnDrawerCloseListener {

	SubmissionPagerAdapter pagerAdapter;
	ViewPager pager;
	SlidingDrawer slidingDrawer;
	Button close;

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
		slidingDrawer = (SlidingDrawer) findViewById(R.id.commentPanel);
		close = (Button) findViewById(R.id.anon);

		slidingDrawer.setOnDrawerOpenListener(this);

		slidingDrawer.setOnDrawerCloseListener(this);
	}
	@Override
	public void onDrawerOpened() { 
		pager.setVisibility(ListView.GONE);
		close.setVisibility(ListView.VISIBLE);
	}

	@Override
	public void onDrawerClosed() {           
		pager.setVisibility(ListView.VISIBLE);
		close.setVisibility(ListView.GONE);
	}

	public void closeDrawer(View v) {
		slidingDrawer.animateToggle();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.submission, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.commentHere:
			Submission s = pagerAdapter.flow.get(pager.getCurrentItem());
			addCommentPopup(s, Data.getUser(1));
			return true;
		default:
			break;
		}
		// return true;
		return super.onOptionsItemSelected(item);
	}
	private void addCommentPopup(final Submission s, final User user) {
		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		alert.setTitle("New comment");

		// Set an EditText view to get user input 
		final EditText input = new EditText(this);
		alert.setView(input);

		alert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				String value = input.getText().toString();
				s.addComment(BasicComment.newBasicComment(value, user));
			}
		});

		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			}
		});

		alert.show();
	}
}
