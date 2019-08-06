package com.mayumi.loterica.util

fun formatar(string: String): String{
    val formatado = String.format("%02d", Integer.parseInt(string))
    return formatado
}