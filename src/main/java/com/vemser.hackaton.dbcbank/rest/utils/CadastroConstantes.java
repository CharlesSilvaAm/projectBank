package com.vemser.hackaton.dbcbank.rest.utils;

public class CadastroConstantes {
    public static final String CADASTRO= "/auth/register";
    public static final String MSG_CADASTRO_VALIDO = "Cadastro realizado com sucesso. Verifique seu e-mail.";
    public static final String MSG_CADASTRO_SEM_NAME = "Nome é obrigatório.";
    public static final String MSG_CADASTRO_SEM_DOCUMENT = "Documento (CPF) é obrigatório.";
    public static final String MSG_CADASTRO_SEM_PHONE = "Documento (CPF) é obrigatório.";
    public static final String MSG_CADASTRO_SEM_EMAIL = "E-mail é obrigatório.";
    public static final String MSG_CADASTRO_SEM_EMAIL_CONFIRMATION = "Confirmação de e-mail é obrigatória.";
    public static final String MSG_CADASTRO_SEM_LOGIN_PASSWORD = "A senha de login e a confirmação devem ser iguais.";
    public static final String MSG_CADASTRO_SEM_LOGIN_PASSWORD_CONFIRMATION = "Confirmação de senha de login é obrigatória.";
    public static final String MSG_CADASTRO_SEM_TRANSACTION_PASSWORD = "Senha de transação é obrigatória.";
    public static final String MSG_CADASTRO_SEM_TRANSACTION_PASSWORD_CONFIRMATION = "Confirmação da senha de transação é obrigatória.";
    public static final String MSG_CADASTRO_SEM_DATEBIRTH = "A data de nascimento é obrigatória.";
    public static final String MSG_CADASTRO_DOCUMENT_INVALID = "Número de CPF inválido.";
    public static final String MSG_CADASTRO_PHONE_INVALID = "Formato de número de telefone inválido. Utilize (xx) xxxxx-xxxx.";
    public static final String MSG_CADASTRO_EMAIL_INVALID = "Formato de e-mail inválido.";
    public static final String MSG_CADASTRO_EMAIL_CONFIRMATION_INVALID = "O e-mail e a confirmação de e-mail devem ser iguais.";
    public static final String MSG_CADASTRO_LOGIN_PASSWORD_INVALID = "A senha de login deve conter pelo menos uma letra minúscula, uma letra maiúscula, um número e um caractere especial.";
    public static final String MSG_CADASTRO_LOGIN_PASSWORD_CONFIRMATION_INVALID = "A senha de login e a confirmação devem ser iguais.";
    public static final String MSG_CADASTRO_TRANSACTION_PASSWORD_INVALID = "A senha de transação deve ter exatamente 4 dígitos.";
    public static final String MSG_CADASTRO_TRANSACION_PASSWORD_CONFIRMATION_INVALID = "A senha de transação e a confirmação devem ser iguais.";
    public static final String MSG_CADASTRO_DATEBIRTH_INVALID = "A data de nascimento deve estar no formato dd/MM/yyyy";
}
