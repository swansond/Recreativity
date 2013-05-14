package winning.pwnies.recreativity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;


public class ImageContent implements Content {

	private Bitmap image;
	
	public ImageContent(Bitmap in) {
		image = in;
	}
	
	public ImageContent(Parcel in) {
		image = in.readParcelable(Bitmap.class.getClassLoader());
	}
	
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelable(image, 0);
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(image, 0, 0, new Paint());
	}

	public static final Parcelable.Creator<ImageContent> CREATOR = new Parcelable.Creator<ImageContent>() {
		public ImageContent createFromParcel(Parcel in) {
			return new ImageContent(in);
		}
		
		public ImageContent[] newArray(int size) {
			return new ImageContent[size];
		}
	};

}

