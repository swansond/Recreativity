package winning.pwnies.recreativity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private User u;
	private User u2;
	private Flow f;
	private Content c;
	private Submission s;
	private Comment com;
	private Content c2;
	private Submission s2;
	private DefaultUser u3;
	private TextContent c3;
	private BasicSubmission s3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Populate with initial data
        u = new DefaultUser();
		u2 = new DefaultUser();
		f = new BasicFlow();
		c = new TextContent("It's a wonderful world");
		s = new BasicSubmission(c, u);
		f.addItem(s);
		com = new BasicComment("This is sad", u2);
		s.addComment(com);
		c2 = new TextContent("It's a beautiful morning");
		s2 = new BasicSubmission(c2, u2);
		f.addItem(s2);
		u3 = new DefaultUser();
		c3 = new TextContent("Th-th-th-that's all folks!");
		s3 = new BasicSubmission(c3, u3);
		f.addItem(s3);
        setContentView(R.layout.activity_main);
    }


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	public void viewSubmission(View view) {
		Intent intent = new Intent(this, ViewSubmissionActivity.class);
		intent.putExtra("submission", s);
		startActivity(intent);
	}
} 
