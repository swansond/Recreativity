package winning.pwnies.recreativity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SearchResults extends Activity {
	private List<FlowDisplay> views;
	@SuppressWarnings("unused")
	private Button viewFlowButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Collection<Flow> col = Data.getAllFlows();
		views = new ArrayList<FlowDisplay>();
		for (Flow f : col) {
			views.add(new FlowDisplay(f));
		}
		setContentView(R.layout.search_results);
		int i = 0;
		for (FlowDisplay f : views) {
			View itemView = getLayoutInflater().inflate(R.layout.flow_view_layout, (ViewGroup) findViewById(R.id.mama), false);
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
		// first flow
		findViewById(R.id.flow5sub1).setOnClickListener(new SubmissionListener(5, 0));
		findViewById(R.id.flow5sub2).setOnClickListener(new SubmissionListener(5, 1));
		findViewById(R.id.flow5sub3).setOnClickListener(new SubmissionListener(5, 2));
		findViewById(R.id.flow5sub4).setOnClickListener(new SubmissionListener(5, 3));
		findViewById(R.id.flow5sub5).setOnClickListener(new SubmissionListener(5, 4));

		// second flow
		findViewById(R.id.flow6sub1).setOnClickListener(new SubmissionListener(6, 0));
		findViewById(R.id.flow6sub2).setOnClickListener(new SubmissionListener(6, 1));
		findViewById(R.id.flow6sub3).setOnClickListener(new SubmissionListener(6, 2));
		findViewById(R.id.flow6sub4).setOnClickListener(new SubmissionListener(6, 3));
		findViewById(R.id.flow6sub5).setOnClickListener(new SubmissionListener(6, 4));

		// third flow
		findViewById(R.id.flow7sub1).setOnClickListener(new SubmissionListener(7, 0));
		findViewById(R.id.flow7sub2).setOnClickListener(new SubmissionListener(7, 1));
		findViewById(R.id.flow7sub3).setOnClickListener(new SubmissionListener(7, 2));
		findViewById(R.id.flow7sub4).setOnClickListener(new SubmissionListener(7, 3));
		findViewById(R.id.flow7sub5).setOnClickListener(new SubmissionListener(7, 4));
		findViewById(R.id.flow7sub6).setOnClickListener(new SubmissionListener(7, 5));
		findViewById(R.id.flow7sub7).setOnClickListener(new SubmissionListener(7, 6));
	}

	public void goToFlow(int flow, int submission) {
		Intent intent = new Intent(this, ViewSubmissionActivity.class);
		intent.putExtra(Data.FLOW, flow);
		intent.putExtra(Data.SUBMISSION, submission);
		startActivity(intent);
	}

	private class SubmissionListener implements View.OnClickListener {
		private final int flow;
		private final int submission;

		public SubmissionListener(int flow, int submission) {
			this.flow = flow;
			this.submission = submission;
		}

		public void onClick(View v) {
			Flow f = Data.getFlow(flow);
			Log.d("Search Results", f.serialNumber() + "");
			goToFlow(flow, submission);
		}
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
		case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
		default:
			break;
		}
		return true;
	}
}
