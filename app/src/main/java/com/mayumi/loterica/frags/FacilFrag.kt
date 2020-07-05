package com.mayumi.loterica.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mayumi.loterica.R
import com.mayumi.loterica.util.formatar
import com.mayumi.loterica.model.Facil
import com.mayumi.loterica.service.ServiceBuilder
import com.mayumi.loterica.service.WebAPI
import kotlinx.android.synthetic.main.facil_fragment.*
import kotlinx.android.synthetic.main.quina_fragment.tv_cidade_concurso
import kotlinx.android.synthetic.main.quina_fragment.tv_data
import kotlinx.android.synthetic.main.quina_fragment.tv_num_concurso
import kotlinx.android.synthetic.main.quina_fragment.tv_valor_proximo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FacilFrag : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.facil_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVar()
        initActions()
    }

    private fun initVar() {

    }

    private fun initActions() {
        resultadoFacil()
    }

    private fun resultadoFacil() {
        /*  val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
         val requestCall = destinationService.resultFacil()

         requestCall.enqueue(object : Callback<Facil> {

             override fun onResponse(call: Call<Facil>, response: Response<Facil>) {
                 if (isAdded && response.isSuccessful) {
                     val result = response.body()!!
                    tv_num_concurso.text = result.concurso.numero
                     tv_cidade_concurso.text = result.concurso.cidade

                     tv_ganhadores_15.text = result.concurso.premiacao.acertos_15.ganhadores
                     tv_valor_15.text = result.concurso.premiacao.acertos_15.valor_pago

                     tv_ganhadores_14.text = result.concurso.premiacao.acertos_14.ganhadores
                     tv_valor_14.text = result.concurso.premiacao.acertos_14.valor_pago

                     tv_ganhadores_13.text = result.concurso.premiacao.acertos_13.ganhadores
                     tv_valor_13.text = result.concurso.premiacao.acertos_13.valor_pago

                     tv_ganhadores_12.text = result.concurso.premiacao.acertos_12.ganhadores
                     tv_valor_12.text = result.concurso.premiacao.acertos_12.valor_pago

                     tv_ganhadores_11.text = result.concurso.premiacao.acertos_11.ganhadores
                     tv_valor_11.text = result.concurso.premiacao.acertos_11.valor_pago

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


                 }
             }

             override fun onFailure(call: Call<Facil>, t: Throwable) {
                 if (isAdded) {
                     Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
                 }
             }
         })*/

    }
}