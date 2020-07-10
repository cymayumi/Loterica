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
import kotlinx.coroutines.*


class MegaFrag : Fragment() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        uiScope.launch {
            val response = withContext(Dispatchers.IO) {
                val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
                return@withContext destinationService.resultMega()
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

                tv_ganhadores_sena.text = result.premiacao[0].quantidade_ganhadores
                tv_ganhadores_quina.text = result.premiacao[1].quantidade_ganhadores
                tv_ganhadores_quadra.text = result.premiacao[2].quantidade_ganhadores

                tv_valor_sena.text = result.premiacao[0].valor_total
                tv_valor_quina.text = result.premiacao[1].valor_total
                tv_valor_quadra.text = result.premiacao[2].valor_total

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
