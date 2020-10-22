package org.example;

import java.text.NumberFormat;

/**
 * CuentaCorriente es una cuenta bancaria con servicios básicos para
 * depositar dinero, sacar dinero y manejar el interés.
 */
public class CuentaCorriente
{
    private final NumberFormat fmt = NumberFormat.getCurrencyInstance();

    private final float ratioInteres = 0.045f;  // ratio de interés del 4.5%

    private long numeroCC;
    private float saldo;
    public final String nombre;

    /**
     * Inicializa una cuenta estableciendo el propietario, el número y el saldo
     * @param owner Nombre del propietario
     * @param account número de cuenta, identificador
     * @param initial saldo inicial
     */
    public CuentaCorriente(String owner, long account, float initial)
    {
        nombre = owner;
        numeroCC = account;
        saldo = initial;
    }

    public CuentaCorriente(String owner) {
        nombre = owner;
    }

    /**
     *  Ingresar una determinada cantidad de dinero en la cuenta
     *  @param amount Cantidad de dinero a ingresar (e incrementar el balance)
     *  @return true Si el saldo es no negativo. false si
     *  es negativo; indica que el saldo no ha cambiado
     */
    public boolean deposit(float amount)
    {
        boolean result = true;
        // is amount invalid?
        if (amount < 0)
        {
            result = false;
        }
        else
        {
            saldo = saldo + amount;
        }

        return result;
    }

    /**
     *  Retirada de una determinada cantidad de dinero de la cuenta,
     *  a no ser que el importe sea negativo, la cuota sea negativa, o
     *  la cantidad exceda el saldo.
     *  @param amount valor a ser deducido del saldo
     *  @param fee la cuota por realizar la operación
     *  @return true si la transacción fue exitosa, false en otro caso;
     */
    public boolean withdraw(float amount, float fee)
    {
        // validate parameters
        if (isValidWithdrawl(amount, fee))
        {
            amount += fee;
            saldo = saldo - amount;
        }
        return isValidWithdrawl(amount, fee);
    }

    /* Determina si los parámetros de una retirada de dinero son válidos */
    private boolean isValidWithdrawl(float amount, float fee)
    {
        return amount >= 0 && fee >= 0 && amount <= saldo;
    }

    /**
     *  Añade interés al saldo de la cuenta
     */
    public void addInterest()
    {

        saldo += (saldo * ratioInteres);
    }

    /**
     * Obtener el saldo actual
     * @return saldo actual
     *
     */
    public float getSaldo()
    {
        return saldo;
    }

    /**
     * Obtener el número de cuenta
     * @return número de cuenta
     */
    public long getAccountNumber()
    {
        return numeroCC;
    }

    /**
     *  Devuelve una descripción en una línea de la cuenta
     *  @return línea debidamente formateada
     */
    public String toString()
    {
        return (numeroCC + "\t" + nombre + "\t" + fmt.format(saldo));
    }
}
