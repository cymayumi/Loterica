package com.mayumi.loterica.model

class Mania (
    var concurso: Concurso4,
    var proximo_concurso: Proximo4
)

class Concurso4(
    var numero: String,
    var cidade: String,
    var dezenas: ArrayList<Int>,
    var premiacao: Premiacao4
)

class Premiacao4(
    var acertos_20 : Acertos_20,
    var acertos_19 : Acertos_19,
    var acertos_18 : Acertos_18,
    var acertos_17 : Acertos_17,
    var acertos_16 : Acertos_16,
    var acertos_15 : Acertos_15a,
    var acertos_0 : Acertos_0
)

class Acertos_20(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_19(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_18(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_17(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_16(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_15a(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_0(
    var ganhadores: String,
    var valor_pago: String
)

class Proximo4(
    var data: String,
    var valor_estimado: String
)