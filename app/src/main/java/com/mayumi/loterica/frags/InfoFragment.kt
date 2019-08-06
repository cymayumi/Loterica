package com.mayumi.loterica.frags

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.mayumi.loterica.R
import com.mayumi.loterica.util.animar
import kotlinx.android.synthetic.main.info_fragment.*

class InfoFragment : Fragment() {

    private var latitude = 0.0
    private var longitude = 0.0

    private lateinit var lm: LocationManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.info_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animar(iv_loterica, R.anim.invisible_to_visible, context!!)
        animar(btn_site, R.anim.top_to_bottom, context!!)
        animar(btn_loterica, R.anim.top_to_bottom, context!!)

        initVar()
        initActions()
    }


    private fun initVar() {
        lm = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    @SuppressLint("MissingPermission")
    private fun initActions() {
        btn_site.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://loterias.caixa.gov.br/wps/portal/loterias")
            startActivity(openURL)
        }

        btn_loterica.setOnClickListener {
            if (hasGPSPermission()) {
                lm.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    0L,
                    0f,
                    listnerLocalizacao
                )

                val gmmIntentUri = Uri.parse("geo:$latitude,$longitude?q=lotericas")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            } else {
                requestGPSPermission()
            }
        }
    }

    private fun hasGPSPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            context!!,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestGPSPermission() {
        val permission = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
        requestPermissions(permission, 0)
    }

    private val listnerLocalizacao = object : LocationListener {
        override fun onLocationChanged(location: Location?) {
            latitude = location!!.latitude
            longitude = location.longitude

        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

        }

        override fun onProviderEnabled(provider: String?) {

        }

        override fun onProviderDisabled(provider: String?) {

        }
    }
}
