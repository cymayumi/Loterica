package com.mayumi.loterica.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mayumi.loterica.swipe.PagerAdapter
import com.mayumi.loterica.R
import kotlinx.android.synthetic.main.resultados_fragment.*

class ResultadosFragment : Fragment() {

    private lateinit var pagerAdapter: PagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.resultados_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVar()
        initActions()
    }

    private fun initVar() {
        pagerAdapter = PagerAdapter(childFragmentManager)
        viewPager.adapter = pagerAdapter
    }

    private fun initActions() {

    }
}