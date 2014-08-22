package com.playactionmenu;

import com.playactionmenu.base.BaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		super.onCreateOptionsMenu(menu);

//		int[] ids = { R.id.action_cancel, R.id.action_create };
		String[] subMenuTitles = {"Good", "Bad"};
		showMenuItem(R.id.action_cancel, null, subMenuTitles);
		showMenuItem(R.id.action_create, null, null);

		return true;
	}
	
	
	
	
	public void onButtonClicked(View v){
		Intent intent = new Intent(this, SecondActivity.class);
		startActivity(intent);
	}
	
	@Override
	protected void onSubMenuItemClicked( int menuItemId, int subItemId) {
		Toast.makeText(this, "You've clicked: " + menuItemId + "." + subItemId, Toast.LENGTH_SHORT).show();
	}

}
