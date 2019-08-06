package com.mayumi.loterica.model

class Time (
    var concurso: Concurso6,
    var proximo_concurso: Proximo6
)

class Concurso6(
    var numero: String,
    var cidade: String,
    var dezenas: ArrayList<Int>,
    var premiacao: Premiacao6,
    var time_coracao: Coracao
)

class Premiacao6(
    var acertos_7: Acertos_7,
    var acertos_6: Acertos_6,
    var acertos_5: Acertos_5,
    var acertos_4: Acertos_4,
    var acertos_3: Acertos_3
)

class Acertos_7(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_6(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_5(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_4(
    var ganhadores: String,
    var valor_pago: String
)

class Acertos_3(
    var ganhadores: String,
    var valor_pago: String
)

class Coracao(
    var time: String
)

class Proximo6(
    var data: String,
    var valor_estimado: String
)