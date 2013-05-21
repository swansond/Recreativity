package winning.pwnies.recreativity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
	private Content c7;
	private Submission s7;
	private TextContent c8;
	private BasicSubmission s8;
	private ImageContent c9;
	private BasicSubmission s10;
	private BasicSubmission s9;
	private Content c10;
	
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
		c = new TextContent("It's a wonderful world!");
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
		c4 = new TextContent("Bugs Bunny really likes to eat carrots");//ImageContent(BitmapFactory.decodeResource(getResources(), R.drawable.pic0));
		s4 = new BasicSubmission(c4, u);
		f.addItem(s4);
		c5 = new ImageContent(BitmapFactory.decodeResource(getResources(), R.drawable.pic1));
		s5 = new BasicSubmission(c5, u);
		f.addItem(s5);
		c6 = new ImageContent(BitmapFactory.decodeResource(getResources(), R.drawable.pic2));
				// This is how large images should be called, if the code from the android developer site worked...
				// http://developer.android.com/training/displaying-bitmaps/load-bitmap.html
				//new ImageContent(decodeSampledBitmapFromResource(getResources(), R.drawable.pic2, 300, 500));
		s6 = new BasicSubmission(c6, u);
		f.addItem(s6);
		c8 = new TextContent("There once was a really beautiful flower in a meadow");
		s8 = new BasicSubmission(c8, u);
		f.addItem(s8);
//		c7 = new ImageContent(decodeSampledBitmapFromResource(getResources(), R.drawable.pic7, 300, 500));
//		s7 = new BasicSubmission(c7, u);
//		f.addItem(s7);
//		c9 = new ImageContent(decodeSampledBitmapFromResource(getResources(), R.drawable.pic3, 300, 500));
//		s9 = new BasicSubmission(c9, u);
//		f.addItem(s7);
//		c10 = new ImageContent(decodeSampledBitmapFromResource(getResources(), R.drawable.pic4, 300, 500));
//		s10 = new BasicSubmission(c10, u);
//		f.addItem(s7);
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
	
	
	// from: http://developer.android.com/training/displaying-bitmaps/load-bitmap.html
	public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
	    // Raw height and width of image
	    final int height = options.outHeight;
	    final int width = options.outWidth;
	    int inSampleSize = 1;
	
	    if (height > reqHeight || width > reqWidth) {
	
	        // Calculate ratios of height and width to requested height and width
	        final int heightRatio = Math.round((float) height / (float) reqHeight);
	        final int widthRatio = Math.round((float) width / (float) reqWidth);
	
	        // Choose the smallest ratio as inSampleSize value, this will guarantee
	        // a final image with both dimensions larger than or equal to the
	        // requested height and width.
	        inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
	    }
	
	    return inSampleSize;
	}
	
	private static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
	        int reqWidth, int reqHeight) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    BitmapFactory.decodeResource(res, resId, options);

	    // Calculate inSampleSize
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeResource(res, resId, options);
	}
} 
