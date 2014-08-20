package com.playactionmenu;

import android.app.Activity;
import android.content.Context;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;

public  class BaseActivity extends Activity {
	
	private Menu menu;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_base, menu);
		this.menu = menu;
//		menu.findItem(R.id.action_create).setActionProvider(new MyActionProvider(this));
		
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	protected void showMenuItem(int menuItemId, String label, String[] subMenuTitles) {
			MenuItem item = menu.findItem(menuItemId);
			item.setVisible(true);
			if (label != null) {
				item.setTitle(label);
				item.setIcon(null);
			}
			if (subMenuTitles != null && subMenuTitles.length > 0) {
				item.setActionProvider(new MyActionProvider(this, subMenuTitles));
			}
	}
	
	protected  void onSubMenuItemClicked(int itemId){
		
	};
	
	
	
	
	
	
private class MyActionProvider extends ActionProvider implements OnMenuItemClickListener{
	private Context context;
	private String[] titles = {"First" , "Second", "Third" , "Fourth", " Fifth"};
	
	public MyActionProvider(Context context, String[] subMenuTitles) {
		super(context);
		this.context = context;
		titles = subMenuTitles;
	}

	@Override
	public View onCreateActionView() {
//		LayoutInflater inflater = LayoutInflater.from(context);
//		View rootView = inflater.inflate(R.layout.action_submenu_create, null);
		
		
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
			subMenu.add(0, i, i, titles[i]).setIcon(R.drawable.ic_launcher).setOnMenuItemClickListener(this);
		}
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		
		onSubMenuItemClicked(item.getItemId());
		
		return true;
	}
	
}

}
