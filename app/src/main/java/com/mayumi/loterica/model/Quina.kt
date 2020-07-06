package com.mayumi.loterica.model

class Quina(
    var numero_concurso: String,
    var local_realizacao: String,
    var dezenas: ArrayList<Int>,
    var premiacao:ArrayList<PremiacaoQuina>,
    var valor_estimado_proximo_concurso: String
)

class PremiacaoQuina(
    var quantidade_ganhadores: String,
    var valor_total: String)