package winning.pwnies.recreativity;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class ContentView extends View {
	boolean isPrompt;

	public ContentView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ContentView(Context context) {
		super(context);
	}

	private Content data;

	public void setContent(Content c) {
		data = c;
	}
	
	public void setContent(Content c, boolean isPrompt) {
		this.isPrompt = isPrompt;
		setContent(c);
	}
	
	public void isPrompt(boolean isPrompt) {
		this.isPrompt = isPrompt;
		data.isPrompt(isPrompt);
	}
	 
	@Override
	public void onDraw(Canvas canvas) {
		canvas.drawARGB(255, 20, 20, 20);
		if (data != null) {
			if (isPrompt) {
				System.out.println("WAS HERE");  // TODO delete
				data.isPrompt(true);
				data.draw(canvas);
			}
			
			data.draw(canvas);
		}
	}
	
}
