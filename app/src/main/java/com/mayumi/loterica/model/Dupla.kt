package com.mayumi.loterica.model

class Dupla (
    var concurso: Concurso5,
    var proximo_concurso: Proximo5
)

class Concurso5(
    var numero: String,
    var cidade: String,
    var dezenas_1: ArrayList<Int>,
    var dezenas_2: ArrayList<Int>,
    var premiacao_1: Premiacao5_1,
    var premiacao_2: Premiacao5_2
)

class Premiacao5_1(
    var sena: SenaD1,
    var quina: QuinaD1,
    var quadra: QuadraD1,
    var terno: TernoD1
)

class SenaD1(
    var ganhadores: String,
    var valor_pago: String
)

class QuinaD1(
    var ganhadores: String,
    var valor_pago: String
)

class QuadraD1(
    var ganhadores: String,
    var valor_pago: String
)

class TernoD1(
    var ganhadores: String,
    var valor_pago: String
)
class Premiacao5_2(
    var sena: SenaD2,
    var quina: QuinaD2,
    var quadra: QuadraD2,
    var terno: TernoD2
)

class SenaD2(
    var ganhadores: String,
    var valor_pago: String
)

class QuinaD2(
    var ganhadores: String,
    var valor_pago: String
)

class QuadraD2(
    var ganhadores: String,
    var valor_pago: String
)

class TernoD2(
    var ganhadores: String,
    var valor_pago: String
)

class Proximo5(
    var data: String,
    var valor_estimado: String
)