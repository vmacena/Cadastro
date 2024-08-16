package com.ifsp.cadastro

data class Formulario(
    val nomeCompleto: String,
    val telefone: String,
    val email: String,
    val ingressarListaEmails: Boolean,
    val sexo: String,
    val cidade: String,
    val uf: String
) {
    override fun toString(): String {
        return "Nome Completo: $nomeCompleto\n" +
                "Telefone: $telefone\n" +
                "E-mail: $email\n" +
                "Ingressar na lista de e-mails: $ingressarListaEmails\n" +
                "Sexo: $sexo\n" +
                "Cidade: $cidade\n" +
                "UF: $uf"
    }
}