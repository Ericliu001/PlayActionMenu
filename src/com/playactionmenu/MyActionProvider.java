package com.playactionmenu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

class MyActionProvider extends ActionProvider implements OnMenuItemClickListener{
	private Context context;
	private int count = 5;
	private String[] titles = {"First" , "Second", "Third" , "Fourth", " Fifth"};
	
	public MyActionProvider(Context context) {
		super(context);
		this.context = context;
		// TODO Auto-generated constructor stub
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
		
		for (int i = 0; i < count; i++) {
			subMenu.add(0, i, i, titles[i]).setIcon(R.drawable.ic_launcher).setOnMenuItemClickListener(this);
		}
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		Toast.makeText(context, titles[item.getItemId()], Toast.LENGTH_SHORT).show();
		return true;
	}
	
}