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
import kotlinx.android.synthetic.main.dupla_fragment.tv_1
import kotlinx.android.synthetic.main.dupla_fragment.tv_2
import kotlinx.android.synthetic.main.dupla_fragment.tv_3
import kotlinx.android.synthetic.main.dupla_fragment.tv_4
import kotlinx.android.synthetic.main.dupla_fragment.tv_5
import kotlinx.android.synthetic.main.dupla_fragment.tv_6
import kotlinx.android.synthetic.main.dupla_fragment.tv_cidade_concurso
import kotlinx.android.synthetic.main.dupla_fragment.tv_num_concurso
import kotlinx.android.synthetic.main.dupla_fragment.tv_valor_proximo
import kotlinx.android.synthetic.main.mega_fragment.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DuplaFrag : Fragment() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

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
        uiScope.launch {
            val response = withContext(Dispatchers.IO) {
                val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
                return@withContext destinationService.resultDupla()
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

                val dezenas2 = result.dezenas_2
                tv_11.text = formatar(dezenas2[0].toString())
                tv_22.text = formatar(dezenas2[1].toString())
                tv_33.text = formatar(dezenas2[2].toString())
                tv_44.text = formatar(dezenas2[3].toString())
                tv_55.text = formatar(dezenas2[4].toString())
                tv_66.text = formatar(dezenas2[5].toString())

                tv_ganhadores_sena1.text = result.premiacao[0].quantidade_ganhadores
                tv_ganhadores_quina1.text = result.premiacao[1].quantidade_ganhadores
                tv_ganhadores_quadra1.text = result.premiacao[2].quantidade_ganhadores
                tv_ganhadores_terno1.text = result.premiacao[3].quantidade_ganhadores

                tv_valor_sena1.text = result.premiacao[0].valor_total
                tv_valor_quina1.text = result.premiacao[1].valor_total
                tv_valor_quadra1.text = result.premiacao[2].valor_total
                tv_valor_terno1.text = result.premiacao[2].valor_total

                tv_ganhadores_sena2.text = result.premiacao_2[0].quantidade_ganhadores
                tv_ganhadores_quina2.text = result.premiacao_2[1].quantidade_ganhadores
                tv_ganhadores_quadra2.text = result.premiacao_2[2].quantidade_ganhadores
                tv_ganhadores_terno2.text = result.premiacao_2[3].quantidade_ganhadores

                tv_valor_sena2.text = result.premiacao_2[0].valor_total
                tv_valor_quina2.text = result.premiacao_2[1].valor_total
                tv_valor_quadra2.text = result.premiacao_2[2].valor_total
                tv_valor_terno2.text = result.premiacao_2[3].valor_total

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