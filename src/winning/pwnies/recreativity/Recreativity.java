package winning.pwnies.recreativity;

import android.app.Application;
import android.content.Context;

public class Recreativity extends Application {
	private static Recreativity singleton = null;
	
	@Override
	public void onCreate() {
		super.onCreate();
		singleton = this;
	}
	
	public static Context context() {
		return singleton.getApplicationContext();
	}
}
