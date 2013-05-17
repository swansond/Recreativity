package winning.pwnies.recreativity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
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
		int      lineHeight = 0;
	    int      yoffset    = 0;
	    String[] lines      = entry.split(" ");
	    Rect drawSpace = new Rect(0,0,canvas.getWidth()-75,canvas.getHeight());

	    // set height of each line (height of text + 20%)
	    lineHeight = (int) (calculateHeightFromFontSize(entry, 50) * 1.2);
	    // draw each line
	    String line = "";
	    for (int i = 0; i < lines.length; ++i) {

	        if(calculateWidthFromFontSize(line + " " + lines[i], 50) <= drawSpace.width()){
	            line = line + " " + lines[i];

	        }else{
	            canvas.drawText(line, 50, 200 + yoffset, p);
	            yoffset = yoffset + lineHeight;
	            line = lines[i];
	        }
	    }
	    canvas.drawText(line, 50, 200 + yoffset, p);
	}
	
	private int calculateWidthFromFontSize(String testString, int currentSize)
	{
	    Rect bounds = new Rect();
	    Paint paint = new Paint();
	    paint.setTextSize(currentSize);
	    paint.getTextBounds(testString, 0, testString.length(), bounds);

	    return (int) Math.ceil( bounds.width());
	}

	private int calculateHeightFromFontSize(String testString, int currentSize)
	{
	    Rect bounds = new Rect();
	    Paint paint = new Paint();
	    paint.setTextSize(currentSize);
	    paint.getTextBounds(testString, 0, testString.length(), bounds);

	    return (int) Math.ceil( bounds.height());
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
