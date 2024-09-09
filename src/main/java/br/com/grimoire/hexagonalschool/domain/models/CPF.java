package br.com.grimoire.hexagonalschool.domain.models;

import java.util.InputMismatchException;

public class CPF {

    private static final int DEFAULT_SIZE_CPF = 11;

    private String cpfValue;

    public CPF(String cpfValue) {
        String cpfOnlyNumbers = removeFormatting(cpfValue);
        if (!isValidCPF(cpfOnlyNumbers)) {
            throw new IllegalArgumentException("CPF is invalid.");
        }
        this.cpfValue = cpfOnlyNumbers;
    }

    public String getCpfValue() {
        return cpfValue;
    }

    public String getFormattedCPF() {
        return cpfValue.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    private boolean isValidCPF(String cpfOnlyNumbers) {

        if (cpfOnlyNumbers.length() != DEFAULT_SIZE_CPF)
            return false;

        boolean everyDigitAreTheSame = cpfOnlyNumbers.matches("(\\d)\\1{10}");
        if (everyDigitAreTheSame)
            return false;

        return isCalculationCpfValid(cpfOnlyNumbers);
    }

    private boolean isCalculationCpfValid(String cpfOnlyNumbers) {
        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {

                sum += (convertCharToInt(cpfOnlyNumbers.charAt(i))) * (10 - i);
            }
            int firstCheckDigit = DEFAULT_SIZE_CPF - (sum % DEFAULT_SIZE_CPF);
            if (firstCheckDigit >= 10) {
                firstCheckDigit = 0;
            }

            // Verificação do primeiro dígito
            if (firstCheckDigit != convertCharToInt(cpfOnlyNumbers.charAt(9))) {
                return false;
            }

            // Cálculo do segundo dígito verificador
            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += (convertCharToInt(cpfOnlyNumbers.charAt(i))) * (DEFAULT_SIZE_CPF - i);
            }
            int secondCheckDigit = DEFAULT_SIZE_CPF - (sum % DEFAULT_SIZE_CPF);
            if (secondCheckDigit >= 10) {
                secondCheckDigit = 0;
            }

            // Verificação do segundo dígito

            return secondCheckDigit == convertCharToInt(cpfOnlyNumbers.charAt(10));

        } catch (InputMismatchException e) {
            return false;
        }
    }

    // Subtrair um char com '0' transforma o char em seu número inteiro
    // correspondente
    private int convertCharToInt(char charNumber) {
        return charNumber - '0';
    }

    public static String removeFormatting(String cpf) {
        return cpf.replaceAll("[^\\d]", "");
    }

    @Override
    public String toString() {
        return cpfValue;
    }
}

/*
 * Regras para a validação de um CPF
 * 
 * O cálculo de um CPF (Cadastro de Pessoa Física) no Brasil envolve a geração e
 * validação de dois dígitos verificadores que garantem a autenticidade do
 * número. O CPF é composto por 11 dígitos, sendo os 9 primeiros os dígitos base
 * e os 2 últimos os dígitos verificadores.
 * 
 * Como Funciona o Cálculo dos Dígitos Verificadores
 * Primeiro Dígito Verificador:
 * 
 * O cálculo do primeiro dígito verificador (10º dígito do CPF) é feito a partir
 * dos 9 primeiros dígitos.
 * Cada dígito é multiplicado por um peso decrescente, que começa em 10 e vai
 * até 2.
 * Em seguida, soma-se o resultado dessas multiplicações.
 * O resultado dessa soma é dividido por 11, e calcula-se o resto da divisão.
 * Se o resto da divisão for menor que 2, o primeiro dígito verificador é 0.
 * Caso contrário, o dígito verificador é dado por 11 - resto.
 * Exemplo:
 * 
 * Suponha que o CPF seja 123.456.789-XX (onde XX são os dígitos verificadores a
 * serem calculados).
 * 
 * Multiplicamos os 9 primeiros dígitos pelos pesos decrescentes:
 * 
 * (1×10) + (2×9) + (3×8) + (4×7) + (5×6) + (6×5) + (7×4) + (8×3) + (9×2)
 *
 * Isso resulta em:
 * 10 + 18 + 24 + 28 + 30 + 30 + 28 + 24 + 18 = 210
 *
 * Agora, dividimos a soma por 11:
 * 210 ÷ 11 = 19 (resto 1 )
 
 * Como o resto é 1 (menor que 2), o primeiro dígito verificador será 0.
 * 
 * Segundo Dígito Verificador:
 * 
 * O cálculo do segundo dígito verificador (11º dígito do CPF) é feito a partir
 * dos 9 dígitos base mais o primeiro dígito verificador.
 * O procedimento é similar ao cálculo do primeiro dígito verificador, mas agora
 * o peso começa em 11 e vai até 2.
 * Soma-se o resultado das multiplicações e, em seguida, aplica-se a mesma regra
 * do resto da divisão por 11.
 * Exemplo:
 * 
 * Usando o CPF com o primeiro dígito verificador calculado, 123.456.789-0X:
 * 
 * Multiplicamos os 9 primeiros dígitos mais o primeiro dígito verificador pelos
 * pesos decrescentes:
 * (1×11) + (2×10) + (3×9) + (4×8) + (5×7) + (6×6) + (7×5) + (8×4) + (9×3) + (0×2)
 *
 * Isso resulta em:
 * 11+20+27+32+35+36+35+32+27+0=255
 * 
 * Agora, dividimos a soma por 11:
 * 255÷11=23 (resto 2)
 * Como o resto é 2, o segundo dígito verificador será 11 - 2 = 9.
 * 
 * Resumo das Regras:
 * Multiplicação: Multiplicar cada dígito do CPF por pesos decrescentes,
 * começando em 10 para o primeiro dígito verificador e em 11 para o segundo.
 * Soma: Somar todos os resultados das multiplicações.
 * Divisão e resto: Dividir a soma por 11 e encontrar o resto.
 * Dígito verificador: Se o resto for menor que 2, o dígito verificador será 0.
 * Se o resto for 2 ou maior, o dígito verificador será 11 - resto.
 * Exemplo Completo:
 * Dado o CPF base 123.456.789, o cálculo seria:
 * 
 * Primeiro dígito verificador:
 * 
 * Soma ponderada = 210
 * Resto da divisão por 11 = 1
 * Primeiro dígito verificador = 0
 * Segundo dígito verificador:
 * 
 * Soma ponderada = 255
 * Resto da divisão por 11 = 2
 * Segundo dígito verificador = 9
 * Portanto, o CPF completo seria 123.456.789-09.
 * 
 * Validação de CPF:
 * Para validar um CPF, basta recalcular os dígitos verificadores de acordo com
 * os 9 primeiros dígitos e verificar se eles correspondem aos dois últimos
 * dígitos do CPF fornecido. Se forem iguais, o CPF é válido; caso contrário, é
 * inválido.
 * 
 */