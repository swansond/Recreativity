package winning.pwnies.recreativity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;

public class ViewSubmissionActivity extends FragmentActivity {
	public static final String SUBMISSION = "submission";
	public static final String FLOW = "flow";
	
	SubmissionPagerAdapter pagerAdapter;
	ViewPager pager;


	private boolean starred;
	private ImageButton starButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_submission);
		Intent intent = getIntent();

		Bundle b = intent.getExtras();
		int flowID = b.getInt(FLOW);
		int submissionNumber = b.getInt(SUBMISSION);
		
		pagerAdapter = new SubmissionPagerAdapter(getSupportFragmentManager(), Data.getFlow(flowID));
		pager = (ViewPager) findViewById(R.id.submission_pager);
		pager.setAdapter(pagerAdapter);
		pager.setCurrentItem(submissionNumber);
		
		starButton = (ImageButton)findViewById(R.id.starButton);
		starButton.setImageDrawable(getResources().getDrawable(R.drawable.star1));
		starButton.setOnClickListener(new View.OnClickListener() {	
			
			@Override
			public void onClick(View v) {
				if (starred) {					
					starButton.setImageDrawable(getResources().getDrawable(R.drawable.star2));
					starred = false;
				} else {
					starButton.setImageDrawable(getResources().getDrawable(R.drawable.star1));
					starred = true;
				}
			}
		});
		
		starred = false;
	}
	
	public void star_clicked(View view) {
		starred = true;
	}
}
