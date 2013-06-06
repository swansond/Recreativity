package winning.pwnies.recreativity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class SubmissionPagerAdapter extends FragmentStatePagerAdapter {
	
	Flow flow;

	public SubmissionPagerAdapter(FragmentManager fm, Flow f) {
		super(fm);
		flow = f;
	}
	
	@Override
	public Fragment getItem(int i) {
		Fragment fragment = new SubmissionFragment();
		Bundle args = new Bundle();
		args.putParcelable(Data.ARG_OBJECT, flow.get(i));
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {
		return flow.size();
	}

}
