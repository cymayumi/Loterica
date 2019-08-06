package com.mayumi.loterica.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mayumi.loterica.R
import com.mayumi.loterica.model.Mania
import com.mayumi.loterica.service.ServiceBuilder
import com.mayumi.loterica.service.WebAPI
import com.mayumi.loterica.util.formatar
import kotlinx.android.synthetic.main.mania_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ManiaFrag : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.mania_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initVar()
        initActions()
    }

    private fun initVar() {

    }

    private fun initActions() {
        resultadoMania()
    }

    private fun resultadoMania() {
        val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
        val requestCall = destinationService.resultMania()

        requestCall.enqueue(object : Callback<Mania> {

            override fun onResponse(call: Call<Mania>, response: Response<Mania>) {
                if (isAdded && response.isSuccessful) {
                    val result = response.body()!!
                    tv_num_concurso.text = result.concurso.numero
                    tv_cidade_concurso.text = result.concurso.cidade

                    tv_ganhadores_20.text = result.concurso.premiacao.acertos_20.ganhadores
                    tv_valor_20.text = result.concurso.premiacao.acertos_20.valor_pago

                    tv_ganhadores_19.text = result.concurso.premiacao.acertos_19.ganhadores
                    tv_valor_19.text = result.concurso.premiacao.acertos_19.valor_pago

                    tv_ganhadores_18.text = result.concurso.premiacao.acertos_18.ganhadores
                    tv_valor_18.text = result.concurso.premiacao.acertos_18.valor_pago

                    tv_ganhadores_17.text = result.concurso.premiacao.acertos_17.ganhadores
                    tv_valor_17.text = result.concurso.premiacao.acertos_17.valor_pago

                    tv_ganhadores_16.text = result.concurso.premiacao.acertos_16.ganhadores
                    tv_valor_16.text = result.concurso.premiacao.acertos_16.valor_pago

                    tv_ganhadores_15.text = result.concurso.premiacao.acertos_15.ganhadores
                    tv_valor_15.text = result.concurso.premiacao.acertos_15.valor_pago

                    tv_ganhadores_00.text = result.concurso.premiacao.acertos_0.ganhadores
                    tv_valor_00.text = result.concurso.premiacao.acertos_0.valor_pago

                    tv_data.text = result.proximo_concurso.data
                    tv_valor_proximo.text = result.proximo_concurso.valor_estimado

                    val dezenas = result.concurso.dezenas

                    tv_1.text = formatar(dezenas[0].toString())
                    tv_2.text = formatar(dezenas[1].toString())
                    tv_3.text = formatar(dezenas[2].toString())
                    tv_4.text = formatar(dezenas[3].toString())
                    tv_5.text = formatar(dezenas[4].toString())
                    tv_6.text = formatar(dezenas[5].toString())
                    tv_7.text = formatar(dezenas[6].toString())
                    tv_8.text = formatar(dezenas[7].toString())
                    tv_9.text = formatar(dezenas[8].toString())
                    tv_10.text = formatar(dezenas[9].toString())
                    tv_11.text = formatar(dezenas[10].toString())
                    tv_12.text = formatar(dezenas[11].toString())
                    tv_13.text = formatar(dezenas[12].toString())
                    tv_14.text = formatar(dezenas[13].toString())
                    tv_15.text = formatar(dezenas[14].toString())
                    tv_16.text = formatar(dezenas[15].toString())
                    tv_17.text = formatar(dezenas[16].toString())
                    tv_18.text = formatar(dezenas[17].toString())
                    tv_19.text = formatar(dezenas[18].toString())
                    tv_20.text = formatar(dezenas[19].toString())
                }

            }

            override fun onFailure(call: Call<Mania>, t: Throwable) {
                if (isAdded) {
                    Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
                }
            }
        })

    }
}