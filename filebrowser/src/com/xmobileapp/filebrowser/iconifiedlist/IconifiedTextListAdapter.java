/*
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xmobileapp.filebrowser.iconifiedlist;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


public class IconifiedTextListAdapter extends BaseAdapter {

	
	private Context mContext;

	private List<IconifiedText> mItems = new ArrayList<IconifiedText>();

	public IconifiedTextListAdapter(Context context) {
		mContext = context;
	}

	public void addItem(IconifiedText it) { mItems.add(it); }

	public void setListItems(List<IconifiedText> lit) { mItems = lit; }

	public int getCount() { return mItems.size(); }

	public Object getItem(int position) { return mItems.get(position); }

	public boolean areAllItemsSelectable() { return false; }

	public boolean isSelectable(int position) { 
		return mItems.get(position).isSelectable();
	}

	public long getItemId(int position) {
		return position;
	}


	public View getView(int position, View convertView, ViewGroup parent) {
		IconifiedTextView btv;
		if (convertView == null) {
			btv = new IconifiedTextView(mContext, mItems.get(position));
		} else { 
			btv = (IconifiedTextView) convertView;
			btv.setText(mItems.get(position).getText());
			btv.setIcon(mItems.get(position).getIcon());
		}
		return btv;
	}
}