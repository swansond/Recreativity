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
	private static int currentSerial = 1;
	
	private String entry;
	private static Paint p = new Paint();
	private int serial;

	private boolean isPrompt;
	
	private TextContent(String in) {
		entry = in;
		p.setColor(-1);
		p.setTextSize(40);
		serial = currentSerial++;
	}
	
	public static TextContent createTextContent(String in) {
		TextContent out = new TextContent(in);
		Data.addContent(out.serial, out);
		return out;
	}
	
	public TextContent(Parcel in) {
		entry = in.readString();
	}
	
	public void isPrompt(boolean isPrompt) {
		this.isPrompt = isPrompt;
	}
	

	@Override
	public void draw(Canvas canvas) {
		int      lineHeight = 0;
	    int      yoffset    = 0;
	    int 	 xoffset = 0;
	    String[] lines      = entry.split(" ");
	    
	    
	    Rect drawSpace;
//	    if (isPrompt) {  	
	    	p.setColor(Color.WHITE);
	    	canvas.drawRect(75, 10, canvas.getWidth()-120, canvas.getHeight()-400, p);
	    	p.setColor(Color.DKGRAY);
	    	canvas.drawRect(80, 15, canvas.getWidth()-130, canvas.getHeight()-410, p);
	    	drawSpace = new Rect(83,15,canvas.getWidth()-145,canvas.getHeight()-710);
	    	p.setColor(Color.WHITE);
	    	xoffset = 35;
//	    } else {	    
//	    	drawSpace = new Rect(0,0,canvas.getWidth()-75,canvas.getHeight());
//	    }

	    // set height of each line (height of text + 20%)
	    lineHeight = (int) (calculateHeightFromFontSize(entry, 40) * 1.2);
	    // draw each line
	    String line = "";
	    for (int i = 0; i < lines.length; ++i) {

	        if(calculateWidthFromFontSize(line + " " + lines[i], 40) <= drawSpace.width()
	        		&& !lines[i].contains("\n")){
	            line = line + " " + lines[i];

	        }else{
	        	while (line.length() > 0 && line.substring(0, 1).equals(" ")) {  // sometimes accidentally starts with a space so delete it
	        		line = line.substring(1);
	        	}
	            canvas.drawText(line, 50 + xoffset, 70 + yoffset, p);
	            yoffset = yoffset + lineHeight;
	            if (line.contains("\n")) {
	            	line = "";
	            } else {
	            	line = lines[i];
	            }
	        }
	    }
	    
	    while (line.substring(0, 1).equals(" ")) {  // sometimes accidentally starts with a space so delete it
    		line = line.substring(1);
    	}
	    canvas.drawText(line, 50+xoffset, 70 + yoffset, p);
	    
	    if (isPrompt) {
//	    	isPrompt = false;  // TODO check
	    }
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

	@Override
	public int serialNumber() {
		return serial;
	}
}
