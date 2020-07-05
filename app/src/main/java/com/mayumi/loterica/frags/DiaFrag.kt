package com.mayumi.loterica.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mayumi.loterica.model.Dia
import com.mayumi.loterica.service.ServiceBuilder
import com.mayumi.loterica.service.WebAPI
import com.mayumi.loterica.util.formatar
import kotlinx.android.synthetic.main.dia_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DiaFrag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.mayumi.loterica.R.layout.dia_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initVar()
        initActions()
    }

    private fun initVar() {

    }

    private fun initActions() {
        resultadoDia()
    }

    private fun resultadoDia() {
        /*  val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
        val requestCall = destinationService.resultDia()

       requestCall.enqueue(object : Callback<Dia> {

             override fun onResponse(call: Call<Dia>, response: Response<Dia>) {
                 if (isAdded && response.isSuccessful) {
                     val result = response.body()!!
                     tv_num_concurso.text = result.concurso.numero
                     tv_cidade_concurso.text = result.concurso.cidade

                     tv_ganhadores_sete.text = result.concurso.premiacao.acertos_7.ganhadores
                     tv_valor_sete.text = result.concurso.premiacao.acertos_7.valor_pago

                     tv_ganhadores_seis.text = result.concurso.premiacao.acertos_6.ganhadores
                     tv_valor_seis.text = result.concurso.premiacao.acertos_6.valor_pago

                     tv_ganhadores_cinco.text = result.concurso.premiacao.acertos_5.ganhadores
                     tv_valor_cinco.text = result.concurso.premiacao.acertos_5.valor_pago

                     tv_ganhadores_quatro.text = result.concurso.premiacao.acertos_4.ganhadores
                     tv_valor_quatro.text = result.concurso.premiacao.acertos_4.valor_pago

                     tv_ganhadores_mes.text = result.concurso.premiacao.mes_sorte.ganhadores
                     tv_valor_mes.text = result.concurso.premiacao.mes_sorte.valor_pago

                     tv_valor_proximo.text = result.proximo_concurso.valor_estimado
                     tv_data.text = result.proximo_concurso.data

                     val dezenas = result.concurso.dezenas

                     tv_1.text = formatar(dezenas[0].toString())
                     tv_2.text = formatar(dezenas[1].toString())
                     tv_3.text = formatar(dezenas[2].toString())
                     tv_4.text = formatar(dezenas[3].toString())
                     tv_5.text = formatar(dezenas[4].toString())
                     tv_6.text = formatar(dezenas[5].toString())
                     tv_7.text = formatar(dezenas[6].toString())

                     tv_mes.text = result.concurso.mes
                }
            }

            override fun onFailure(call: Call<Dia>, t: Throwable) {
                if (isAdded) {
                    Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
                }
            }

        })*/
    }
}