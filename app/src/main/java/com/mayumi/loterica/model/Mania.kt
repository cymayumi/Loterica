package com.mayumi.loterica.model

class Mania(
    var numero_concurso: String,
    var local_realizacao: String,
    var dezenas: ArrayList<Int>,
    var premiacao:ArrayList<PremiacaoMania>,
    var valor_estimado_proximo_concurso: String
)

class PremiacaoMania(
    var quantidade_ganhadores: String,
    var valor_total: String)