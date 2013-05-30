package winning.pwnies.recreativity;

import android.graphics.Canvas;
import android.os.Parcelable;

public interface Content extends Parcelable {

	public void draw(Canvas canvas);
	
	public void isPrompt(boolean isPrompt);
	
	public int serialNumber();
	
}
