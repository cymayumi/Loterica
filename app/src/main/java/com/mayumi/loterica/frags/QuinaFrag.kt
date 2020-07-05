package com.mayumi.loterica.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mayumi.loterica.R
import com.mayumi.loterica.util.formatar
import com.mayumi.loterica.model.Quina
import com.mayumi.loterica.service.ServiceBuilder
import com.mayumi.loterica.service.WebAPI
import kotlinx.android.synthetic.main.quina_fragment.*
import kotlinx.android.synthetic.main.quina_fragment.tv_cidade_concurso
import kotlinx.android.synthetic.main.quina_fragment.tv_data
import kotlinx.android.synthetic.main.quina_fragment.tv_ganhadores_quadra
import kotlinx.android.synthetic.main.quina_fragment.tv_ganhadores_quina
import kotlinx.android.synthetic.main.quina_fragment.tv_num_concurso
import kotlinx.android.synthetic.main.quina_fragment.tv_valor_proximo
import kotlinx.android.synthetic.main.quina_fragment.tv_valor_quadra
import kotlinx.android.synthetic.main.quina_fragment.tv_valor_quina
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuinaFrag : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.quina_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVar()
        initActions()
    }

    private fun initVar() {

    }

    private fun initActions() {
        resultadoQuina()
    }

    private fun resultadoQuina() {
        /*    val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
          val requestCall = destinationService.resultQuina()

          requestCall.enqueue(object : Callback<Quina> {

              override fun onResponse(call: Call<Quina>, response: Response<Quina>) {
                  if (isAdded && response.isSuccessful) {
                      val result = response.body()!!
                    tv_num_concurso.text = result.concurso.numero
                      tv_cidade_concurso.text = result.concurso.cidade

                      tv_valor_quina.text = result.concurso.premiacao.quina.valor_pago
                      tv_ganhadores_quina.text = result.concurso.premiacao.quina.ganhadores

                      tv_valor_quadra.text = result.concurso.premiacao.quadra.valor_pago
                      tv_ganhadores_quadra.text = result.concurso.premiacao.quadra.ganhadores

                      tv_valor_terno.text = result.concurso.premiacao.terno.valor_pago
                      tv_ganhadores_terno.text = result.concurso.premiacao.terno.ganhadores

                      tv_valor_duque.text = result.concurso.premiacao.duque.valor_pago
                      tv_ganhadores_duque.text = result.concurso.premiacao.duque.ganhadores

                      tv_data.text = result.proximo_concurso.data
                      tv_valor_proximo.text = result.proximo_concurso.valor_estimado

                      val dezenas = result.concurso.dezenas
                      tv_1.text = formatar(dezenas[0].toString())
                      tv_2.text = formatar(dezenas[1].toString())
                      tv_3.text = formatar(dezenas[2].toString())
                      tv_4.text = formatar(dezenas[3].toString())
                      tv_5.text = formatar(dezenas[4].toString())

                  }
              }

              override fun onFailure(call: Call<Quina>, t: Throwable) {
                  if (isAdded) {
                      Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
                  }
              }
          })*/

    }
}