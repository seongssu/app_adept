package com.android.adept_0822

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomItemAdapter(val mContext: Context, val mItems: MutableList<MyItem> ): BaseAdapter() {

    override fun getCount(): Int {
        return character.size
    }
    override fun getItem(position: Int): Any {
        return character[position]
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if(convertView == null) convertView = LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false)
        val item : MyItem = character[position]

        val iconImageView = convertView?.findViewById<View>(R.id.iconItem) as ImageView
        val tv_name = convertView?.findViewById<View>(R.id.textItem1) as TextView
        val tv_age = convertView?.findViewById<View>(R.id.textItem2) as TextView

        iconImageView.setImageResource(item.aIcon)
        tv_name.text = item.aName
        tv_name.text = item.aAge
    }

}