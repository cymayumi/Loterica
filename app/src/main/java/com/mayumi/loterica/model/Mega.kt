package com.mayumi.loterica.model

class Mega(
    var numero_concurso: String,
    var local_realizacao: String,
    var dezenas: ArrayList<Int>,
    var premiacao:ArrayList<Premiacao>,
    var valor_estimado_proximo_concurso: String
)

class Premiacao(
    var quantidade_ganhadores: String,
    var valor_total: String)