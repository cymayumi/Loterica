package com.mayumi.loterica.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mayumi.loterica.R
import com.mayumi.loterica.lista.JogosAdapter
import com.mayumi.loterica.util.animar
import kotlinx.android.synthetic.main.jogos_fragment.*

class JogosFragment : Fragment() {

    private lateinit var listaJogos: ArrayList<String>
    private lateinit var listaTeste: ArrayList<String>
    private lateinit var listaDia: ArrayList<String>
    private lateinit var jogosAdapter: JogosAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.jogos_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVar()
        initActions()
    }

    private fun initVar() {
        listaJogos = arrayListOf(
            "Mega-Sena",
            "Lotofácil",
            "Quina",
            "Lotomania",
            "Dia de Sorte",
            "Dupla Sena",
            "Timemania",
            "Loteca",
            "Lotogol"
        )

        listaTeste = arrayListOf(
            "A Mega-Sena paga milhões para o acertador dos 6 números sorteados. Ainda é possível ganhar prêmios ao acertar 4 ou 5 números dentre os 60 disponíveis no volante de apostas.\n" +
                    "\n" + "Para realizar o sonho de ser o próximo milionário, você deve marcar de 6 a 15 números do volante, podendo deixar que o sistema escolha os números para você (Surpresinha) e/ou concorrer com a mesma aposta por 2, 4 ou 8 concursos consecutivos (Teimosinha).",
            "A Lotofácil é, como o próprio nome diz, fácil de apostar e principalmente de ganhar. Você marca entre 15 a 18 números, dentre os 25 disponíveis no volante, e fatura o prêmio se acertar 11, 12, 13, 14 ou 15 números. Pode ainda deixar que o sistema escolha os números para você por meio da Surpresinha, ou concorrer com a mesma aposta por 3, 6, 9 ou 12 concursos consecutivos através da Teimosinha.",
            "Concorra a prêmios grandiosos com a Quina: basta marcar de 5 a 15 números dentre os 80 disponíveis no volante e torcer. Caso prefira o sistema pode escolher os números para você através da Surpresinha.\n" +
                    "\n" +
                    "Ganham prêmios os acertadores de 2, 3, 4 ou 5 números. Você ainda pode concorrer com a mesma aposta por 3, 6, 12, 18 ou 24 concursos consecutivos com a Teimosinha.",
            "A Lotomania é fácil de jogar e de ganhar: basta escolher 50 números e então concorrer a prêmios para acertos de 20, 19, 18, 17, 16, 15 ou nenhum número.\n" +
                    "\n" +
                    "Além da opção de marcar no volante, você ainda pode marcar menos que 50 números e deixar que o sistema complete o jogo para você; não marcar nada e deixar que o sistema escolha todos os números na Surpresinha e/ou concorrer com a mesma aposta por 2, 4 ou 8 concursos consecutivos com a Teimosinha. Outra opção é efetuar uma nova aposta com o sistema selecionando os outros 50 números não registrados no jogo original, através da Aposta-Espelho.",
            "O Dia de Sorte é a loteria onde você aposta seus números da sorte. Escolha de 7 a 15 números dentre os 31 disponíveis e mais 1 “Mês de Sorte”. São sorteados sete números e um “Mês de Sorte” por concurso. Você pode deixar, ainda, que o sistema escolha os números para você (Surpresinha) e/ou continuar com o seu jogo por 3, 6, 9 ou 12 concursos consecutivos (Teimosinha).",
            "Com apenas um bilhete da Dupla Sena, você tem o dobro de chances de ganhar: são dois sorteios por concurso e ganha acertando 3, 4, 5 ou 6 números no primeiro e/ou segundo sorteios.\n" +
                    "\n" +
                    "Basta escolher de 6 a 15 números dentre os 50 disponíveis e torcer. Você pode deixar, ainda, que o sistema escolha os números para você (Surpresinha) e/ou concorrer com a mesma aposta por 2, 4 ou 8, 3, 6, 9 ou 12 concursos consecutivos (Teimosinha).",
            "A Timemania é a loteria para os apaixonados por futebol. Além de o seu palpite valer uma bolada, você ainda ajuda o seu time do coração.\n" +
                    "\n" +
                    "Você escolhe dez números entre os oitenta disponíveis e um Time do Coração. São sorteados sete números e um Time do Coração por concurso. Se você tiver de três a sete acertos, ou acertar o time do coração, ganha.\n" +
                    "Você pode deixar, ainda, que o sistema escolha os números para você (Surpresinha) e/ou continuar com o seu jogo por 2 ou 4 concursos consecutivos (Teimosinha).",
            "A Loteca é ideal para você que entende de futebol e adora dar palpites sobre os resultados das partidas. Para apostar, basta marcar o seu palpite para cada um dos 14 jogos do concurso, assinalando uma das três colunas, duas delas (duplo) ou três (triplo). Os clubes participantes estão impressos nos bilhetes emitidos pelo terminal.",
            "Acerte a quantidade de gols feitas pelos times de futebol na rodada e concorra a uma bolada. Para apostar, basta marcar no volante o número de gols de cada time de futebol participante dos 5 jogos do concurso. Você pode assinalar 0, 1, 2, 3 ou mais gols (opção está representada pelo sinal +). Os clubes participantes estão impressos nos bilhetes emitidos pelo terminal."
        )

        listaDia = arrayListOf(
            "Os sorteios são realizados duas vezes por semana, às quartas e aos sábados.",
            "Os sorteios são realizados às segundas, quartas e sextas-feiras, sempre às 20h.",
            "São 6 sorteios semanais: de segunda-feira a sábado, às 20h.",
            "Os sorteios são realizados às terças-feiras e às sextas-feiras, às 20h.",
            "Os sorteios são realizados na terça-feira, quinta-feira e sábado às 20h.",
            "A Dupla Sena é sorteada às terças, quintas e sábados, sempre às 20h.",
            "Os sorteios da Timemania são realizados nas terças, quintas e sábados, a partir das 20h.",
            "Encerramento das apostas às 14h de sábado.",
            "Aposta são sazonais."
        )

        jogosAdapter = JogosAdapter(
            context!!,
            listaJogos,
            listaTeste,
            listaDia
        )

        animar(lv_jogos, R.anim.cel_fall, context!!)
        lv_jogos.setAdapter(jogosAdapter)
    }

    private fun initActions() {
    }

    companion object{
        //como não podemos instanciar um fragmento diretamente, criamos esta função que retorna o fragmento desejado
        fun newInstance(): JogosFragment{
            return JogosFragment()
        }
    }
}