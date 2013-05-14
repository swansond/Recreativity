package winning.pwnies.recreativity;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author David Swanson
 *
 */
public class TextContent implements Content {
	
	private String entry;
	private static Paint p = new Paint();
	
	public TextContent(String in) {
		entry = in;
		p.setColor(-1);
		p.setTextSize(50);
	}
	
	public TextContent(Parcel in) {
		entry = in.readString();
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.drawText(entry, 50, 200, p);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(entry);
	}
	
	public static final Parcelable.Creator<TextContent> CREATOR = new Parcelable.Creator<TextContent>() {
		public TextContent createFromParcel(Parcel in) {
			return new TextContent(in);
		}
		
		public TextContent[] newArray(int size) {
			return new TextContent[size];
		}
	};
	
}
