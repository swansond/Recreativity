package winning.pwnies.recreativity;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class ContentView extends View {

	private Content data;
	
	public ContentView(Context context) {
		super(context);
	}

	public void setContent(Content c) {
		data = c;
	}
	
	public void onDraw(Canvas canvas) {
		data.draw(canvas);
	}
	
}
