package winning.pwnies.recreativity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;




public class Play extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.play_layout, container, false);
		
		Fragment prompt = new Prompt();
		FragmentTransaction trans = getChildFragmentManager().beginTransaction();
		trans.add(R.id.prompt_fragment, prompt).commit();
		
		return view;
	}


	final OnClickListener imageButton1_OnClickListener = new OnClickListener() {
		public void onClick(final View v) {
			Fragment compose = new Compose();
			FragmentTransaction trans = getChildFragmentManager().beginTransaction();
			trans.add(R.id.compose_fragment, compose).commit();
		}
	};
}
