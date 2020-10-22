package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CuentaCorrienteTest {


    static CuentaCorriente cuenta,cuenta2;



    @BeforeAll
    public static void init(){
        cuenta = new CuentaCorriente("pablo",40000,450);
        cuenta2 = new CuentaCorriente("pablo",40000,450);
        System.out.println("Cuenta creada");
    }

    @Test
    @DisplayName("DepositoTrue")
    public void depositoTrue(){
        assertEquals(true,cuenta.deposit(10),"Deposito Positivo debe ser true");
    }

    @Test
    @DisplayName("DepositoFalse")
    public void depositoFalse(){
        assertEquals(false,cuenta.deposit(-10),"Deposito Negativo debe ser falso");
    }

    @Test
    @DisplayName("RetiradaTrue")
    public void retiradaTrue(){
        assertEquals(true,cuenta.withdraw(10,1),"Retirada Positiva, cuota positiva debe ser positiva");
    }

    @Test
    @DisplayName("RetiradaFalsa")
    public void retiradaFalse(){
        assertEquals(false,cuenta.withdraw(-10,1),"Retirada Negativa,cuota positiva debe dar falso");
    }

    @Test
    @DisplayName("RetiradaFalsa2")
    public void retiradaFalse2(){
        assertEquals(false,cuenta.withdraw(10,-1),"Retirada Positiva,cuota negativa debe ser falso");
    }

    @Test
    @DisplayName("RetiradaFalsa3")
    public void retiradaFalse3(){
        assertEquals(false,cuenta.withdraw(-10,-1),"Retirada Negativa,cuota negativa debe ser falso");
    }

    @Test
    @DisplayName("AgregarInteres")
    void agregarInteres(){
        cuenta.addInterest();
        assertNotEquals(cuenta.getSaldo(), cuenta2.getSaldo());
    }


}
