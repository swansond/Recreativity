package winning.pwnies.recreativity;

import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;

public class ExploreActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		Intent intent = getIntent();
	    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
	    	setContentView(R.layout.search_results);
	    } else {
	    	setContentView(R.layout.explore_layout);

			// fourth flow (default flow from Play)
			findViewById(R.id.flow1sub1).setOnClickListener(new SubmissionListener(1, 0));
			findViewById(R.id.flow1sub2).setOnClickListener(new SubmissionListener(1, 1));
			findViewById(R.id.flow1sub3).setOnClickListener(new SubmissionListener(1, 2));
			findViewById(R.id.flow1sub4).setOnClickListener(new SubmissionListener(1, 3));
			findViewById(R.id.flow1sub5).setOnClickListener(new SubmissionListener(1, 4));
			findViewById(R.id.flow1sub6).setOnClickListener(new SubmissionListener(1, 5));
			findViewById(R.id.flow1sub7).setOnClickListener(new SubmissionListener(1, 6));
	    }

		LinearLayout playButton = (LinearLayout) findViewById(R.id.menu_play_explore);
		playButton.setOnClickListener(new LinearLayout.OnClickListener() {
		    public void onClick(View v) {
		    	Intent myIntent = new Intent(ExploreActivity.this, PlayActivity.class);
		    	ExploreActivity.this.startActivity(myIntent);
		    }
		});
		
		LinearLayout profileButton = (LinearLayout) findViewById(R.id.menu_profile_explore);
		profileButton.setOnClickListener(new LinearLayout.OnClickListener() {
		    public void onClick(View v) {
		    	Intent myIntent = new Intent(ExploreActivity.this, ProfileActivity.class);
		    	ExploreActivity.this.startActivity(myIntent);
		    }
		});
	    
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
		
		Log.i("search", "end of onCreate");
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
		getMenuInflater().inflate(R.menu.search_menu, menu);
		
	    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
	    SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
	    SearchableInfo info = searchManager.getSearchableInfo(getComponentName());
	    searchView.setSearchableInfo(info);
	    
	    Intent intent = getIntent();
	    Log.i("search", "got intent");
	    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
	    	Log.i("search", "setting query and iconified");
	    	searchView.setIconified(false);
	    	searchView.setQuery("flower", false);
	    	searchView.clearFocus();
	    }
    
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
	        return true;
		default:
			break;
		}
		return true;
	}
}




