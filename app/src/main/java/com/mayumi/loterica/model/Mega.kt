package com.mayumi.loterica.model

class Mega(
    var concurso: Concurso,
    var proximo_concurso: Proximo
)

class Concurso(
    var numero: String,
    var cidade: String,
    var dezenas: ArrayList<Int>,
    var premiacao: Premiacao
)

class Premiacao(
    var sena: Sena,
    var quina: Quinaa,
    var quadra: Quadra
)

class Sena(
    var ganhadores: String,
    var valor_pago: String
)

class Quinaa(
    var ganhadores: String,
    var valor_pago: String
)

class Quadra(
    var ganhadores : String,
    var valor_pago: String
)

class Proximo(
    var data: String,
    var valor_estimado: String
)