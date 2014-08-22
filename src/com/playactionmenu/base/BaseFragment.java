package com.playactionmenu.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

import com.playactionmenu.R;

public class BaseFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	private Menu menu;

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

		inflater.inflate(R.menu.menu_base, menu);
		this.menu = menu;

	}

	protected void showMenuItem(int menuItemId, String label,
			String[] subMenuTitles) {
		MenuItem item = menu.findItem(menuItemId);
		item.setVisible(true);
		if (label != null) {
			item.setTitle(label);
			item.setIcon(null);
		}
		if (subMenuTitles != null && subMenuTitles.length > 0) {
			item.setActionProvider(new MyFragmetnActionProvider(getActivity(), item.getItemId(),
					subMenuTitles));
		}
	}

	protected void onSubMenuItemClicked(int menuItemId, int subItemId) {

	};

	private class MyFragmetnActionProvider extends ActionProvider implements
			OnMenuItemClickListener {
		private Context context;
		private int menuItemId;
		private String[] titles;

		public MyFragmetnActionProvider(Context context, int menuItemId,
				String[] subMenuTitles) {
			super(context);
			this.context = context;
			this.menuItemId = menuItemId;
			titles = subMenuTitles;
		}

		@Override
		public View onCreateActionView() {
			// LayoutInflater inflater = LayoutInflater.from(context);
			// View rootView = inflater.inflate(R.layout.action_submenu_create,
			// null);

			return null;
		}

		@Override
		public boolean hasSubMenu() {

			return true;
		}

		@Override
		public void onPrepareSubMenu(SubMenu subMenu) {
			subMenu.clear();

			for (int i = 0; i < titles.length; i++) {
				subMenu.add(0, i, i, titles[i]).setIcon(R.drawable.ic_launcher)
						.setOnMenuItemClickListener(this);
			}
		}

		@Override
		public boolean onMenuItemClick(MenuItem item) {

			onSubMenuItemClicked(menuItemId, item.getItemId());

			return true;
		}

	}

}
