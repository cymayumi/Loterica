package com.mayumi.loterica.model

class Quina(
    var concurso: Concurso2,
    var proximo_concurso: Proximo2
)

class Concurso2(
    var numero: String,
    var cidade: String,
    var dezenas: ArrayList<Int>,
    var premiacao: Premiacao2
)

class Premiacao2(
    var quina: Quina2,
    var quadra: Quadra2,
    var terno: Terno2,
    var duque: Duque2
)

class Quina2(
    var ganhadores: String,
    var valor_pago: String
)

class Quadra2(
    var ganhadores: String,
    var valor_pago: String
)

class Terno2(
    var ganhadores: String,
    var valor_pago: String
)

class Duque2(
    var ganhadores: String,
    var valor_pago: String
)

class Proximo2(
    var data: String,
    var valor_estimado: String
)
