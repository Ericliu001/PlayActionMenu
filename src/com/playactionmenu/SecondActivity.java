package com.playactionmenu;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.playactionmenu.base.BaseActivity;
import com.playactionmenu.base.BaseFragment;

public class SecondActivity extends BaseActivity implements TabListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		actionBar.addTab(actionBar.newTab().setText("First")
				.setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("Second")
				.setTabListener(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.second, menu);

		super.onCreateOptionsMenu(menu);
		String[] subMenuTitles = { "First", "Second" };
		showMenuItem(R.id.action_create, "Haha", subMenuTitles);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.action_create:
			Toast.makeText(this, "Option handled from Activity", Toast.LENGTH_SHORT).show();
			Log.d("eric", "Option handled from Activity");
			break;

		default:
			break;
		}
		return false;
	}

	@Override
	protected void onSubMenuItemClicked(int menuItemId, int subItemId) {
		Toast.makeText(this, "You've clicked: " + menuItemId + "." + subItemId,
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		switch (tab.getPosition()) {
		case 0:
			FirstFragment frag1 = (FirstFragment) getFragmentManager()
					.findFragmentByTag("First");
			if (frag1 == null) {
				frag1 = new FirstFragment();
			}
			getFragmentManager().beginTransaction()
					.replace(R.id.container, frag1, "First").commit();

			break;

		case 1:
			SecondFragment frag2 = (SecondFragment) getFragmentManager()
					.findFragmentByTag("Second");
			if (frag2 == null) {
				frag2 = new SecondFragment();
			}
			getFragmentManager().beginTransaction()
					.replace(R.id.container, frag2, "Second").commit();

			break;

		default:
			break;
		}
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	private class FirstFragment extends BaseFragment {
		@Override
		public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
			
			super.onCreateOptionsMenu(menu, inflater);
			String[] subMenuTitles = {"1","2"};
			showMenuItem(R.id.action_save, "Save", subMenuTitles);
			
		}
		
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			
			switch (item.getItemId()) {
			case R.id.action_create:
				Toast.makeText(getActivity(), "Option handled from FirstFragment", Toast.LENGTH_SHORT).show();
				Log.d("eric", "Option handled from Fragment");
				break;

			default:
				break;
			}
			return true;
		}
	}

	private class SecondFragment extends BaseFragment {
		@Override
		public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
			
			super.onCreateOptionsMenu(menu, inflater);
			showMenuItem(R.id.action_settings, null, null);
		}
	}
}
