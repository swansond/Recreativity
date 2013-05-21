package winning.pwnies.recreativity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;

public class Data {

	public static final String SUBMISSION = "submission";
	public static final String ARG_OBJECT = "object";
	public static final String FLOW = "flow";
	private static Map<Integer, Flow> flows = new HashMap<Integer, Flow>();
	private static Map<Integer, Comment> comments = new HashMap<Integer, Comment>();
	private static Map<Integer, User> users = new HashMap<Integer, User>();
	
	static {
        User u = DefaultUser.newDefaultUser();
       	User u2 = DefaultUser.newDefaultUser();
		Flow f = BasicFlow.newBasicFlow();
		Content c = new TextContent("It's a wonderful world");
		Submission s = new BasicSubmission(c, u);
		f.addItem(s);
		Comment com = BasicComment.newBasicComment("This is sad", u2);
		s.addComment(com);
		Content c2 = new TextContent("It's a beautiful morning");
		Submission s2 = new BasicSubmission(c2, u2);
		f.addItem(s2);
		User u3 = DefaultUser.newDefaultUser();
		Content c3 = new TextContent("Th-th-th-that's all folks!");
		Submission s3 = new BasicSubmission(c3, u3);
		f.addItem(s3);
		Content c4 = new TextContent("Bugs Bunny really likes to eat carrots");//ImageContent(BitmapFactory.decodeResource(getResources(), R.drawable.pic0));
		Submission s4 = new BasicSubmission(c4, u);
		f.addItem(s4);
		Content c5 = new ImageContent(BitmapFactory.decodeResource(Recreativity.context().getResources(), R.drawable.pic1));
		Submission s5 = new BasicSubmission(c5, u);
		f.addItem(s5);
		Content c6 = new ImageContent(BitmapFactory.decodeResource(Recreativity.context().getResources(), R.drawable.pic2));
				// This is how large images should be called, if the code from the android developer site worked...
				// http://developer.android.com/training/displaying-bitmaps/load-bitmap.html
				//new ImageContent(decodeSampledBitmapFromResource(getResources(), R.drawable.pic2, 300, 500));
		Submission s6 = new BasicSubmission(c6, u);
		f.addItem(s6);
		Content c8 = new TextContent("There once was a really beautiful flower in a meadow");
		Submission s8 = new BasicSubmission(c8, u);
		f.addItem(s8);
        
		Flow f2 = BasicFlow.newBasicFlow();
		addImageToFlow(f2, u3, R.drawable.pic4);
		addImageToFlow(f2, u, R.drawable.pic6);
		addImageToFlow(f2, u2, R.drawable.pic5);
		
		Flow f3 = BasicFlow.newBasicFlow();
		addImageToFlow(f3, u, R.drawable.image2);
		addImageToFlow(f3, u2, R.drawable.image4);
		addImageToFlow(f3, u3, R.drawable.image3);
				
		Flow f4 = BasicFlow.newBasicFlow();
		addImageToFlow(f4, u2, R.drawable.pic2);
		addImageToFlow(f4, u3, R.drawable.pic4);
		addImageToFlow(f4, u, R.drawable.pic3);
	}
	
	
	public static void addFlow(int serial, Flow flow) {
		flows.put(serial, flow);
	}
	
	public static Flow getFlow(int serial) {
		return flows.get(serial);
	}
	
	public static void addComment(int serial, Comment comment) {
		comments.put(serial, comment);
	}
	
	public static Comment getComment(int serial) {
		return comments.get(serial);
	}
	
	public static void addUser(int serial, User user) {
		users.put(serial, user);
	}
	
	public static User getUser(int serial) {
		return users.get(serial);
	}

	public static Collection<Flow> getAllFlows() {
		return Collections.unmodifiableCollection(flows.values());
	}
	
	public static void dump() {
		flows.clear();
		flows = null;
		comments.clear();
		comments = null;
		users.clear();
		users = null;
	}

    private static void addImageToFlow(Flow flow, User user, int image) {
		Content pic = new ImageContent(BitmapFactory.decodeResource(Recreativity.context().getResources(), image));
		Submission sub = new BasicSubmission(pic, user);
		flow.addItem(sub);
    }
    
	public static void goToExplore(Context context) {
		Intent intent = new Intent(context, ExploreActivity.class);
		context.startActivity(intent);
	}
	
	public static void goToProfile(Context context) {
		Intent intent = new Intent(context, ProfileActivity.class);
		context.startActivity(intent);
	}
	
	public static void goToPlay(Context context) {
		Intent intent = new Intent(context, PlayActivity.class);
		context.startActivity(intent);
	}
}
