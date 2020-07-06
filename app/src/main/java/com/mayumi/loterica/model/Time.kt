package com.mayumi.loterica.model

class Time (
    var numero_concurso: String,
    var local_realizacao: String,
    var dezenas: ArrayList<Int>,
    var premiacao:ArrayList<PremiacaoTime>,
    var valor_estimado_proximo_concurso: String,
    var nome_time_coracao: String
)

class PremiacaoTime(
    var quantidade_ganhadores: String,
    var valor_total: String)