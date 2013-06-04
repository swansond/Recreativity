package winning.pwnies.recreativity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class ProfileActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_layout);
		
		LinearLayout playButton = (LinearLayout) findViewById(R.id.menu_play_profile);
		playButton.setOnClickListener(new LinearLayout.OnClickListener() {
		    public void onClick(View v) {
		    	Intent myIntent = new Intent(ProfileActivity.this, PlayActivity.class);
		    	ProfileActivity.this.startActivity(myIntent);
		    }
		});
		
		LinearLayout exploreButton = (LinearLayout) findViewById(R.id.menu_explore_profile);
		exploreButton.setOnClickListener(new LinearLayout.OnClickListener() {
		    public void onClick(View v) {
		    	Intent myIntent = new Intent(ProfileActivity.this, ExploreActivity.class);
		    	ProfileActivity.this.startActivity(myIntent);
		    }
		});
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
	        return true;
		default:
			break;
		}
		return true;
	}
}
