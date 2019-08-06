package com.mayumi.loterica.model

class Dia (
    var concurso: Concurso7,
    var proximo_concurso: Proximo7
)

class Concurso7(
    var numero: String,
    var cidade: String,
    var dezenas: ArrayList<Int>,
    var premiacao: Premiacao7,
    var mes: String
)

class Premiacao7(
    var acertos_7: Acertos_7D,
    var acertos_6: Acertos_6D,
    var acertos_5: Acertos_5D,
    var acertos_4: Acertos_4D,
    var mes_sorte: MesSorteD
)

class Acertos_7D(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_6D(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_5D(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_4D(
    var ganhadores: String,
    var valor_pago: String
)

class MesSorteD(
    var ganhadores: String,
    var valor_pago: String
)

class Proximo7(
    var data: String,
    var valor_estimado: String
)