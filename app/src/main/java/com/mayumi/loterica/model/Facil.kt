package com.mayumi.loterica.model

class Facil(
    var numero_concurso: String,
    var local_realizacao: String,
    var dezenas: ArrayList<Int>,
    var premiacao:ArrayList<PremiacaoFacil>,
    var valor_estimado_proximo_concurso: String
)

class PremiacaoFacil(
    var quantidade_ganhadores: String,
    var valor_total: String)