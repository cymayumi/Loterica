package com.mayumi.loterica.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

import com.mayumi.loterica.model.Mega
import com.mayumi.loterica.service.ServiceBuilder
import com.mayumi.loterica.service.WebAPI
import kotlinx.android.synthetic.main.mega_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.mayumi.loterica.util.formatar
import android.R.string.cancel


class MegaFrag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.mayumi.loterica.R.layout.mega_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVar()
        initActions()
    }

    private fun initVar() {

    }

    private fun initActions() {
        resultadoMega()
    }

    private fun resultadoMega() {
        val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
        val requestCall = destinationService.resultMega()

        requestCall.enqueue(object : Callback<Mega> {

            override fun onResponse(call: Call<Mega>, response: Response<Mega>) {

                if (isAdded && response.isSuccessful) {
                    val result = response.body()!!
                    tv_num_concurso.text = result.concurso.numero
                    tv_cidade_concurso.text = result.concurso.cidade

                    tv_ganhadores_sena.text = result.concurso.premiacao.sena.ganhadores
                    tv_valor_sena.text = result.concurso.premiacao.sena.valor_pago

                    tv_ganhadores_quina.text = result.concurso.premiacao.quina.ganhadores
                    tv_valor_quina.text = result.concurso.premiacao.quina.valor_pago

                    tv_valor_quadra.text = result.concurso.premiacao.quadra.valor_pago
                    tv_ganhadores_quadra.text = result.concurso.premiacao.quadra.ganhadores

                    tv_valor_proximo.text = result.proximo_concurso.valor_estimado
                    tv_data.text = result.proximo_concurso.data


                    val dezenas = result.concurso.dezenas

                    tv_1.text = formatar(dezenas[0].toString())
                    tv_2.text = formatar(dezenas[1].toString())
                    tv_3.text = formatar(dezenas[2].toString())
                    tv_4.text = formatar(dezenas[3].toString())
                    tv_5.text = formatar(dezenas[4].toString())
                    tv_6.text = formatar(dezenas[5].toString())
                }
            }

            override fun onFailure(call: Call<Mega>, t: Throwable) {
                if (isAdded) {
                    Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
                }
            }

        })

    }

}