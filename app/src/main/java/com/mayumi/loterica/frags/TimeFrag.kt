package com.mayumi.loterica.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mayumi.loterica.service.ServiceBuilder
import com.mayumi.loterica.service.WebAPI
import com.mayumi.loterica.util.formatar
import kotlinx.android.synthetic.main.time_fragment.*
import kotlinx.android.synthetic.main.time_fragment.tv_1
import kotlinx.android.synthetic.main.time_fragment.tv_2
import kotlinx.android.synthetic.main.time_fragment.tv_3
import kotlinx.android.synthetic.main.time_fragment.tv_4
import kotlinx.android.synthetic.main.time_fragment.tv_5
import kotlinx.android.synthetic.main.time_fragment.tv_6
import kotlinx.android.synthetic.main.time_fragment.tv_cidade_concurso
import kotlinx.android.synthetic.main.time_fragment.tv_num_concurso
import kotlinx.android.synthetic.main.time_fragment.tv_valor_proximo
import kotlinx.coroutines.*

class TimeFrag : Fragment() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.mayumi.loterica.R.layout.time_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVar()
        initActions()
    }

    private fun initVar() {

    }

    private fun initActions() {
        resultadoTime()
    }

    private fun resultadoTime() {
        uiScope.launch {
            val response = withContext(Dispatchers.IO) {
                val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
                return@withContext destinationService.resultTime()
            }

            if (response.isSuccessful) {
                val result = response.body()!!

                tv_num_concurso.text = result.numero_concurso
                tv_cidade_concurso.text = result.local_realizacao
                tv_time.text = result.nome_time_coracao

                val dezenas = result.dezenas
                tv_1.text = formatar(dezenas[0].toString())
                tv_2.text = formatar(dezenas[1].toString())
                tv_3.text = formatar(dezenas[2].toString())
                tv_4.text = formatar(dezenas[3].toString())
                tv_5.text = formatar(dezenas[4].toString())
                tv_6.text = formatar(dezenas[5].toString())
                tv_7.text = formatar(dezenas[6].toString())

                tv_ganhadores_sete.text = result.premiacao[0].quantidade_ganhadores
                tv_ganhadores_seis.text = result.premiacao[1].quantidade_ganhadores
                tv_ganhadores_cinco.text = result.premiacao[2].quantidade_ganhadores
                tv_ganhadores_quatro.text = result.premiacao[3].quantidade_ganhadores
                tv_ganhadores_tres.text = result.premiacao[4].quantidade_ganhadores
                tv_ganhadores_cora.text = result.premiacao[5].quantidade_ganhadores

                tv_valor_sete.text = result.premiacao[0].valor_total
                tv_valor_seis.text = result.premiacao[1].valor_total
                tv_valor_cinco.text = result.premiacao[2].valor_total
                tv_valor_quatro.text = result.premiacao[3].valor_total
                tv_valor_tres.text = result.premiacao[4].valor_total
                tv_valor_cora.text = result.premiacao[5].valor_total

                tv_valor_proximo.text = result.valor_estimado_proximo_concurso

            } else {
                Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
            }
        }
    }
}