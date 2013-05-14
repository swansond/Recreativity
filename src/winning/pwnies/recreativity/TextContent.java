package winning.pwnies.recreativity;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;

/**
 * @author David Swanson
 *
 */
public class TextContent implements Content {
	
	private String entry;
	
	public TextContent(String in) {
		entry = in;
	}
	
	public TextContent(Parcel in) {
		entry = in.readString();
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.drawText(entry, 0, 0, new Paint());
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(entry);
	}
	
}
