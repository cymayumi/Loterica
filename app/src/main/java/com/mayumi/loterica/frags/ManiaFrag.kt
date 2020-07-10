package com.mayumi.loterica.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mayumi.loterica.R
import com.mayumi.loterica.service.ServiceBuilder
import com.mayumi.loterica.service.WebAPI
import com.mayumi.loterica.util.formatar
import kotlinx.android.synthetic.main.mania_fragment.*
import kotlinx.android.synthetic.main.mania_fragment.tv_1
import kotlinx.android.synthetic.main.mania_fragment.tv_2
import kotlinx.android.synthetic.main.mania_fragment.tv_3
import kotlinx.android.synthetic.main.mania_fragment.tv_4
import kotlinx.android.synthetic.main.mania_fragment.tv_5
import kotlinx.android.synthetic.main.mania_fragment.tv_6
import kotlinx.android.synthetic.main.mania_fragment.tv_cidade_concurso
import kotlinx.android.synthetic.main.mania_fragment.tv_num_concurso
import kotlinx.android.synthetic.main.mania_fragment.tv_valor_proximo
import kotlinx.coroutines.*

class ManiaFrag : Fragment() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        uiScope.launch {
            val response = withContext(Dispatchers.IO) {
                val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
                return@withContext destinationService.resultMania()
            }

            if (response.isSuccessful) {
                val result = response.body()!!

                tv_num_concurso.text = result.numero_concurso
                tv_cidade_concurso.text = result.local_realizacao

                val dezenas = result.dezenas
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

                tv_ganhadores_20.text = result.premiacao[0].quantidade_ganhadores
                tv_ganhadores_19.text = result.premiacao[1].quantidade_ganhadores
                tv_ganhadores_18.text = result.premiacao[2].quantidade_ganhadores
                tv_ganhadores_17.text = result.premiacao[3].quantidade_ganhadores
                tv_ganhadores_16.text = result.premiacao[4].quantidade_ganhadores
                tv_ganhadores_15.text = result.premiacao[5].quantidade_ganhadores
                tv_ganhadores_00.text = result.premiacao[6].quantidade_ganhadores

                tv_valor_20.text = result.premiacao[0].valor_total
                tv_valor_19.text = result.premiacao[1].valor_total
                tv_valor_18.text = result.premiacao[2].valor_total
                tv_valor_17.text = result.premiacao[3].valor_total
                tv_valor_16.text = result.premiacao[4].valor_total
                tv_valor_15.text = result.premiacao[5].valor_total
                tv_valor_00.text = result.premiacao[6].valor_total

                tv_valor_proximo.text = result.valor_estimado_proximo_concurso

            } else {
                Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
            }
        }
    }
    override fun onDetach() {
        super.onDetach()
        viewModelJob.cancel()
    }
}
