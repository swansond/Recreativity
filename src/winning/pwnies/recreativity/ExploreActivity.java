package winning.pwnies.recreativity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ExploreActivity extends Activity {
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
		setContentView(R.layout.explore_layout);
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
		View pic1 = findViewById(R.id.imageView1);
		pic1.setOnClickListener(new SubmissionListener(2, 0));
		View pic2 = findViewById(R.id.imageView2);
		pic2.setOnClickListener(new SubmissionListener(2, 1));
		View pic3 = findViewById(R.id.imageView3);
		pic3.setOnClickListener(new SubmissionListener(2, 2));

		// second flow
		View pic4 = findViewById(R.id.imageView4);
		pic4.setOnClickListener(new SubmissionListener(3, 0));
		View pic6 = findViewById(R.id.imageView6);
		pic6.setOnClickListener(new SubmissionListener(3, 1));
		View pic5 = findViewById(R.id.imageView5);
		pic5.setOnClickListener(new SubmissionListener(3, 2));

		// third flow
		View pic7 = findViewById(R.id.imageView7);
		pic7.setOnClickListener(new SubmissionListener(4, 0));
		View pic9 = findViewById(R.id.imageView9);
		pic9.setOnClickListener(new SubmissionListener(4, 1));
		View pic8 = findViewById(R.id.imageView8);
		pic8.setOnClickListener(new SubmissionListener(4, 2));
		
		Button playButton = (Button) findViewById(R.id.menu_play);
		playButton.setOnClickListener(new Button.OnClickListener() {
		    public void onClick(View v) {
		    	Intent myIntent = new Intent(ExploreActivity.this, PlayActivity.class);
		    	ExploreActivity.this.startActivity(myIntent);
		    }
		});
		
		Button profileButton = (Button) findViewById(R.id.menu_profile);
		playButton.setOnClickListener(new Button.OnClickListener() {
		    public void onClick(View v) {
		    	Intent myIntent = new Intent(ExploreActivity.this, ProfileActivity.class);
		    	ExploreActivity.this.startActivity(myIntent);
		    }
		});
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
			Log.d("Explore", f.serialNumber() + "");
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
		default:
			break;
		}
		return true;
	}
}




