package com.playactionmenu;

import android.app.Activity;
import android.content.Context;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class BaseActivity extends Activity {
	
	private Menu menu;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_base, menu);
		this.menu = menu;
		menu.findItem(R.id.action_create).setActionProvider(new MyActionProvider(this));
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
	
	
	protected void showMenuItems(int[] ids) {
		for(int id: ids){
			menu.findItem(id).setVisible(true);
		}
	}
	
	
	
	
	
	
//	private class MyActionProvider extends ActionProvider{
//
//		public MyActionProvider(Context context) {
//			super(context);
//			// TODO Auto-generated constructor stub
//		}
//
//		@Override
//		public View onCreateActionView() {
//			LayoutInflater inflater = LayoutInflater.from(BaseActivity.this);
//			View rootView = inflater.inflate(R.layout.action_submenu_create, null);
//			
//			
//			return rootView;
//		}
//		
//	}

}
