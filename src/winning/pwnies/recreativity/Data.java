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
	public static final String STATUS = "status";
	public static final int PROMPT = 0;
	public static final int COMPOSE = 1;
	private static Map<Integer, Flow> flows = new HashMap<Integer, Flow>();
	private static Map<Integer, Comment> comments = new HashMap<Integer, Comment>();
	private static Map<Integer, User> users = new HashMap<Integer, User>();
	private static Map<Integer, Content> content = new HashMap<Integer, Content>();
	
	static {
		DefaultUser u = DefaultUser.newDefaultUser("Sample User");
		Data.addUser(u.serialNumber(), u);
		DefaultUser u2 = DefaultUser.newDefaultUser("Janette S");
		Data.addUser(u2.serialNumber(), u2);
		BasicFlow f = BasicFlow.newBasicFlow();
		Data.addFlow(f.serialNumber(), f);
		TextContent c = TextContent.createTextContent("Flowers \n are everywhere \n in trees, in houses, in gardens \n Flowers");
		BasicSubmission s = new BasicSubmission(c, u);
		f.addItem(s);
		BasicComment com = BasicComment.newBasicComment("Nature heals the soul \n Heals ailments, coughs, and sneezes \n Nature heals my heart ", u2);
		s.addComment(com);
		TextContent c2 = TextContent.createTextContent("Haikus aren't funny \n Haikus are overrated \n Refrigerator");
		BasicSubmission s2 = new BasicSubmission(c2, u2);
		f.addItem(s2);
		DefaultUser u3 = DefaultUser.newDefaultUser("David S");
		Data.addUser(u3.serialNumber(), u3);
		TextContent c3 = TextContent.createTextContent("I don't like poetry \n not one bit \n but some times I feel \n like making one fit");
		BasicSubmission s3 = new BasicSubmission(c3, u3);
		f.addItem(s3);
		TextContent c4 = TextContent.createTextContent("Read my poetry \n My poetry is enough \n My poetry is independent \n My poetry creates itself.");
		BasicSubmission s4 = new BasicSubmission(c4, u);
		f.addItem(s4);
		Content c5 = ImageContent.createImageContent(BitmapFactory.decodeResource(Recreativity.context().getResources(), R.drawable.rose_pic));
		BasicSubmission s5 = new BasicSubmission(c5, u);
		f.addItem(s5);
		Content c6 = ImageContent.createImageContent(BitmapFactory.decodeResource(Recreativity.context().getResources(), R.drawable.roses));
					// This is how large images should be called, if the code from the android developer site worked...
					// http://developer.android.com/training/displaying-bitmaps/load-bitmap.html
					//new ImageContent(decodeSampledBitmapFromResource(getResources(), R.drawable.pic2, 300, 500));
		BasicSubmission s6 = new BasicSubmission(c6, u);
		f.addItem(s6);
		TextContent c7 = TextContent.createTextContent("Morning dew sparkles \n Tiger lilies greet the day \n Summer has arrived");
		BasicSubmission s7 = new BasicSubmission(c7, u);
		f.addItem(s7);
        
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
		
		Flow f5 = BasicFlow.newBasicFlow();
		TextContent tc1 = TextContent.createTextContent("Flowers are blooming \n Bursts of colors come alive \n Fragrant smells around us!");
		BasicSubmission sub1 = new BasicSubmission(tc1, u);
		f5.addItem(sub1);
		addImageToFlow(f5, u, R.drawable.flow5sub2);
		addImageToFlow(f5, u2, R.drawable.flow5sub3);
		addImageToFlow(f5, u3, R.drawable.flow5sub4);
		addImageToFlow(f5, u, R.drawable.flow5sub5);
		
		Flow f6 = BasicFlow.newBasicFlow();
		addImageToFlow(f6, u2, R.drawable.flow6sub1);
		addImageToFlow(f6, u3, R.drawable.flow6sub2);
		addImageToFlow(f6, u, R.drawable.flow6sub3);
		addImageToFlow(f6, u2, R.drawable.flow6sub4);
		addImageToFlow(f6, u3, R.drawable.flow6sub5);
		
		Flow f7 = BasicFlow.newBasicFlow();
		addImageToFlow(f7, u3, R.drawable.flow7sub1);
		addImageToFlow(f7, u2, R.drawable.flow7sub2);
		addImageToFlow(f7, u, R.drawable.flow7sub3);
		addImageToFlow(f7, u3, R.drawable.flow7sub4);
		addImageToFlow(f7, u2, R.drawable.flow7sub5);
		addImageToFlow(f7, u, R.drawable.flow7sub6);
		addImageToFlow(f7, u, R.drawable.flow7sub7);
		
		User test1 = DefaultUser.newDefaultUser("Angela");
		User test2 = DefaultUser.newDefaultUser("Alex");
		User test3 = DefaultUser.newDefaultUser("Shahaf");
		
		User[] users = {test1, test2, test3};
		String[] options = {
				"This really speaks to me",
				"This reminds me of a book I read last week",
				"There are few things I have ever seen that stand out like this does",
				"Dude, this is awesome!",
				"I love it!",
				"This looks like something my daughter brought home from kindergarten!",
				"Beautful!",
				"This is fantastic!",
				"This is really cool!",
				"Wow!",
				"Amazing!",
				"Great way to develop the idea!"
		};
		for (Flow flow : Data.getAllFlows()) {
			for (int i = 0; i < flow.size(); i++) {
				Submission sub = flow.get(i);
				int nextUser = (int) (Math.random() * users.length);
				int change = Math.random() < .5 ? -1 : 1;
				for (int j = 0; j < Math.random() * 3; j++) {
					sub.addComment(
							BasicComment.newBasicComment(
									options[(int) (Math.random() * options.length)], 
									users[((nextUser += change) + 3 ) % users.length]));
				}
			}
		}
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

	public static Content getContent(int serial) {
		return content.get(serial);
	}
	
	public static void addContent(int serial, Content c) {
		content.put(serial, c);
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
		Content pic = ImageContent.createImageContent(BitmapFactory.decodeResource(Recreativity.context().getResources(), image));
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
