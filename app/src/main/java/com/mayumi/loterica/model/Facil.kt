package com.mayumi.loterica.model

class Facil(
    var concurso: Concurso3,
    var proximo_concurso: Proximo3
)

class Concurso3(
    var numero: String,
    var cidade: String,
    var dezenas: ArrayList<Int>,
    var premiacao: Premiacao3
)

class Premiacao3(
    var acertos_15 : Acertos_15,
    var acertos_14 : Acertos_14,
    var acertos_13 : Acertos_13,
    var acertos_12 : Acertos_12,
    var acertos_11 : Acertos_11
)

class Acertos_15(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_14(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_13(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_12(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_11(
    var ganhadores: String,
    var valor_pago: String
)

class Proximo3(
    var data: String,
    var valor_estimado: String
)