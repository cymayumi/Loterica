package com.mayumi.loterica.lista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.mayumi.loterica.R


class JogosAdapter(
    context: Context,
    private var dataParent: ArrayList<String>,
    private var dataChild: ArrayList<String>,
    private var dataChildDia: ArrayList<String>
) : BaseExpandableListAdapter() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var mView = convertView

        if (mView == null) {
            mView = mInflater.inflate(R.layout.celula_layout, null)
        }

        val ll_fundo = mView?.findViewById<LinearLayout>(R.id.cel_fundo)
        val tv_jogo = mView?.findViewById<TextView>(R.id.tv_jogo)


        val item = dataParent[groupPosition]

        tv_jogo?.text = item

        if (groupPosition == 0) {
            ll_fundo?.setBackgroundResource(R.drawable.borda_mega)
        }
        if (groupPosition == 1) {
            ll_fundo?.setBackgroundResource(R.drawable.borda_facil)
        }
        if (groupPosition == 2) {
            ll_fundo?.setBackgroundResource(R.drawable.borda_quina)
        }
        if (groupPosition == 3) {
            ll_fundo?.setBackgroundResource(R.drawable.borda_mania)
        }
        if (groupPosition == 4) {
            ll_fundo?.setBackgroundResource(R.drawable.borda_dia)
        }
        if (groupPosition == 5) {
            ll_fundo?.setBackgroundResource(R.drawable.borda_dupla)
        }
        if (groupPosition == 6) {
            ll_fundo?.setBackgroundResource(R.drawable.borda_time)
        }
        if (groupPosition == 7) {
            ll_fundo?.setBackgroundResource(R.drawable.borda_loto)
        }
        if (groupPosition == 8) {
            ll_fundo?.setBackgroundResource(R.drawable.borda_gol)
        }

        return mView!!
    }

    override fun getGroup(groupPosition: Int): Any {
        return dataParent[groupPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return this.dataParent.size
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {

        var mView = convertView

        if (mView == null) {
            mView = mInflater.inflate(R.layout.expande_layout, null)
        }

        val tv_teste = mView?.findViewById<TextView>(R.id.texto_exp)
        val tv_dia = mView?.findViewById<TextView>(R.id.texto_dia)

        val dia = dataChildDia[groupPosition]
        val expl = dataChild[groupPosition]

        tv_teste?.text = expl
        tv_dia?.text = dia

        return mView!!
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return 1
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return dataChild[groupPosition]//.answer
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

}