package com.android.adept_0822

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomItemAdapter(val mContext: Context, val character: MutableList<MyItem> ): BaseAdapter() {

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
        // convertView :재활용을 위해 이전에 표시한 뷰
        // 이 변수가 null이 아닌경우 이전에 표시한 뷰를 재사용 할 수 있다.
        if(convertView == null) convertView = LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false)
        //LayoutInflater.from(parent?.context) : 어댑터뷰(parent)의 context 사용해서  LayoutInflater의 객체를 생성한다.
        //R.layout.item : 사용할 xml파일의 ID
        //false : 부모 뷰에 즉시 첨부하지 않도록 설정
        val item : MyItem = character[position]

        val iconImageView = convertView?.findViewById<View>(R.id.iconItem) as ImageView
        val tv_name = convertView?.findViewById<View>(R.id.textItem1) as TextView
        val tv_age = convertView?.findViewById<View>(R.id.textItem2) as TextView

        iconImageView.setImageResource(item.aIcon)
        //setImageResource : 이미지 뷰에 이미지를 설정하는 역할
        //item.aIcon : 이미지 리소스와 리소스 ID (item : 데이터클래스, aIcon : item데이터 클래스에서 이미지아이콘을 나타내는 변수)
        tv_name.text = item.aName
        tv_age.text = item.aAge

        return convertView
    }
}