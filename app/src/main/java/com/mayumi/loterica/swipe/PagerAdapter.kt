package com.mayumi.loterica.swipe

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mayumi.loterica.frags.*
import com.mayumi.loterica.model.Dia

class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MegaFrag()
            1 -> QuinaFrag()
            2 -> FacilFrag()
            3 -> ManiaFrag()
            4 -> DuplaFrag()
            5 -> TimeFrag()
            6 -> DiaFrag()
            else -> MegaFrag()
        }
    }

    override fun getCount(): Int {
        return 7
    }
}