package winning.pwnies.recreativity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
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
	private User u3;
	private Content c3;
	private Submission s3;
	private Content c4;
	private Submission s4;
	private Content c5;
	private BasicSubmission s5;
	private ImageContent c6;
	private BasicSubmission s6;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Populate with initial data
        u = new DefaultUser();
        Data.addUser(u.serialNumber(), u);
		u2 = new DefaultUser();
		Data.addUser(u2.serialNumber(), u2);
		f = new BasicFlow();
		Data.addFlow(f.serialNumber(), f);
		c = new TextContent("It's a wonderful world");
		s = new BasicSubmission(c, u);
		f.addItem(s);
		com = new BasicComment("This is sad", u2);
		s.addComment(com);
		c2 = new TextContent("It's a beautiful morning");
		s2 = new BasicSubmission(c2, u2);
		f.addItem(s2);
		u3 = new DefaultUser();
		Data.addUser(u3.serialNumber(), u3);
		c3 = new TextContent("Th-th-th-that's all folks!");
		s3 = new BasicSubmission(c3, u3);
		f.addItem(s3);
		c4 = new TextContent("Fourth string");//ImageContent(BitmapFactory.decodeResource(getResources(), R.drawable.pic0));
		s4 = new BasicSubmission(c4, u);
		f.addItem(s4);
		c5 = new ImageContent(BitmapFactory.decodeResource(getResources(), R.drawable.pic1));
		s5 = new BasicSubmission(c5, u);
		f.addItem(s5);
		c6 = new ImageContent(BitmapFactory.decodeResource(getResources(), R.drawable.pic2));
		s6 = new BasicSubmission(c6, u);
		f.addItem(s6);
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
	
	public void goToMainAppPage(View view) {
		startActivity(new Intent(this, TabActivity.class));
	}
} 
