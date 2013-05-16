package winning.pwnies.recreativity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Data {

	private static Map<Integer, Flow> flows = new HashMap<Integer, Flow>();
	private static Map<Integer, Comment> comments = new HashMap<Integer, Comment>();
	private static Map<Integer, User> users = new HashMap<Integer, User>();
	
	
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
}
