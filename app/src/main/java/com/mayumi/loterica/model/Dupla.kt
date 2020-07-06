package com.mayumi.loterica.model

class Dupla (
    var numero_concurso: String,
    var local_realizacao: String,
    var dezenas: ArrayList<Int>,
    var dezenas_2: ArrayList<Int>,
    var premiacao:ArrayList<PremiacaoDupla>,
    var premiacao_2: ArrayList<PremiacaoDupla2>,
    var valor_estimado_proximo_concurso: String
)

class PremiacaoDupla(
    var quantidade_ganhadores: String,
    var valor_total: String)

class PremiacaoDupla2(
    var quantidade_ganhadores: String,
    var valor_total: String)