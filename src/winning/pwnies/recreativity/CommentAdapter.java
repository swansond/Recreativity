package winning.pwnies.recreativity;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CommentAdapter extends ArrayAdapter<Comment> {
	List<Comment> comments;
	Context c;

	public CommentAdapter(Context context, int resource, List<Comment> objects) {
		super(context, resource, objects);
		comments = objects;
		c = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TextView author;
        TextView text;
        if (v == null) {
            LayoutInflater vi =
                (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.comment_layout, null); 
        } 
        author = (TextView) v.findViewById(R.id.comment_author);
        text = (TextView) v.findViewById(R.id.comment_text);
 
        final Comment comment = comments.get(position);
        if (comment != null) {
            author.setText(comment.getAuthor());
            text.setText(comment.getText());
        } else {
        	author.setText("No comments");
        	text.setText("");
        }
        return v;

	}

}
