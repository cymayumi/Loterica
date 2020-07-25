
package com.mayumi.loterica.model

class Dia(
    var numero_concurso: String,
    var local_realizacao: String,
    var dezenas: ArrayList<Int>,
    var premiacao:ArrayList<PremiacaoDia>,
    var valor_estimado_proximo_concurso: String,
    var nome_mes_sorte: String
)

class PremiacaoDia(
    var quantidade_ganhadores: String,
    var valor_total: String)