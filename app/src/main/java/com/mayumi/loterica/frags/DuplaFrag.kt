package com.mayumi.loterica.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mayumi.loterica.model.Dupla
import com.mayumi.loterica.service.ServiceBuilder
import com.mayumi.loterica.service.WebAPI
import com.mayumi.loterica.util.formatar
import kotlinx.android.synthetic.main.dupla_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DuplaFrag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.mayumi.loterica.R.layout.dupla_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVar()
        initActions()
    }

    private fun initVar() {

    }

    private fun initActions() {
        resultadoDupla()
    }

    private fun resultadoDupla() {
        val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
        val requestCall = destinationService.resultDupla()

        requestCall.enqueue(object : Callback<Dupla> {

            override fun onResponse(call: Call<Dupla>, response: Response<Dupla>) {
                if (isAdded && response.isSuccessful) {
                    val result = response.body()!!
                    tv_num_concurso.text = result.concurso.numero
                    tv_cidade_concurso.text = result.concurso.cidade

                    tv_ganhadores_sena1.text = result.concurso.premiacao_1.sena.ganhadores
                    tv_valor_sena1.text = result.concurso.premiacao_1.sena.valor_pago

                    tv_ganhadores_quina1.text = result.concurso.premiacao_1.quina.ganhadores
                    tv_valor_quina1.text = result.concurso.premiacao_1.quina.valor_pago

                    tv_ganhadores_quadra1.text = result.concurso.premiacao_1.quadra.ganhadores
                    tv_valor_quadra1.text = result.concurso.premiacao_1.quadra.valor_pago

                    tv_ganhadores_terno1.text = result.concurso.premiacao_1.terno.ganhadores
                    tv_valor_terno1.text = result.concurso.premiacao_1.terno.valor_pago


                    tv_ganhadores_sena2.text = result.concurso.premiacao_2.sena.ganhadores
                    tv_valor_sena2.text = result.concurso.premiacao_2.sena.valor_pago

                    tv_ganhadores_quina2.text = result.concurso.premiacao_2.quina.ganhadores
                    tv_valor_quina2.text = result.concurso.premiacao_2.quina.valor_pago

                    tv_ganhadores_quadra2.text = result.concurso.premiacao_2.quadra.ganhadores
                    tv_valor_quadra2.text = result.concurso.premiacao_2.quadra.valor_pago

                    tv_ganhadores_terno2.text = result.concurso.premiacao_2.terno.ganhadores
                    tv_valor_terno2.text = result.concurso.premiacao_2.terno.valor_pago


                    tv_valor_proximo.text = result.proximo_concurso.valor_estimado
                    tv_data.text = result.proximo_concurso.data


                    val dezenas = result.concurso.dezenas_1

                    tv_1.text = formatar(dezenas[0].toString())
                    tv_2.text = formatar(dezenas[1].toString())
                    tv_3.text = formatar(dezenas[2].toString())
                    tv_4.text = formatar(dezenas[3].toString())
                    tv_5.text = formatar(dezenas[4].toString())
                    tv_6.text = formatar(dezenas[5].toString())

                    val dezenas2 = result.concurso.dezenas_2

                    tv_11.text = formatar(dezenas2[0].toString())
                    tv_22.text = formatar(dezenas2[1].toString())
                    tv_33.text = formatar(dezenas2[2].toString())
                    tv_44.text = formatar(dezenas2[3].toString())
                    tv_55.text = formatar(dezenas2[4].toString())
                    tv_66.text = formatar(dezenas2[5].toString())


                }
            }

            override fun onFailure(call: Call<Dupla>, t: Throwable) {
                if (isAdded) {
                    Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}