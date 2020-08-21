package com.nkechinnaji.learningretrofit.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.nkechinnaji.learningretrofit.R
import com.nkechinnaji.learningretrofit.model.GitHubRepo

/**
 * Created by Nkechi Nnaji on 8/21/20.
 * Description:
 */
class GitHubRepoAdapter( contxt: Context,  var list: List<GitHubRepo> ) : ArrayAdapter<GitHubRepo?>(contxt, R.layout.list_item_pagination, list) {

    override fun getView(position: Int, convertView: View?,parent: ViewGroup): View {

        var row = convertView

        if (row == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            row = inflater.inflate(R.layout.list_item_pagination, parent, false)
        }

        val textView = row!!.findViewById<View>(R.id.list_item_pagination_text) as TextView
        val item = list[position]
        val message = item.getName()
        textView.text = message
        return row
    }

}