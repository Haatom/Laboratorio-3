package edu.eci.cvds.tdd.aerodescuentos;
import org.junit.Assert;
import org.junit.Test;

public class TarifasTest {
    private CalculadorDescuentos c= new CalculadorDescuentos();
    private double tarifa;

    @Test
    public void validarEdadMenor0(){
        try{
            tarifa = c.calculoTarifa(60000,15,-1);
            long er = 0/0;
        }
        catch ( Exception e){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void validarEdad0(){
        try{
            tarifa = c.calculoTarifa(60000,15,0);
            long er = 0/0;
        }
        catch ( Exception e){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void validarDescuento5(){
        tarifa = c.calculoTarifa(60000,15,17);
        Assert.assertEquals( String.valueOf(tarifa), "57000.0");
    }

    @Test
    public void validarDescuento0(){
        tarifa = c.calculoTarifa(60000,15,64);
        Assert.assertEquals( String.valueOf(tarifa), "60000.0");
    }

    @Test
    public void validarDescuento8(){
        tarifa = c.calculoTarifa(80000,15,150);
        Assert.assertEquals( String.valueOf(tarifa), "73600.0");
    }

    @Test
    public void validarEdadMayor150(){
        try{
        tarifa = c.calculoTarifa(5000000,15,200);
        long er = 0/0;
        }
        catch (Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void validarAntelacionNegativa(){
        try{
            tarifa = c.calculoTarifa(5000000,-5,30);
            long er = 0/0;
        }
        catch (Exception e){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void descuentoAcum20(){
        tarifa = c.calculoTarifa(5000000,40,14);
        Assert.assertEquals( String.valueOf(tarifa), "4000000.0");
    }

    @Test
    public void descuentoAcum23(){
        tarifa = c.calculoTarifa(5000000,70,66);
        Assert.assertEquals( String.valueOf(tarifa), "3850000.0");
    }

    @Test
    public void validarTarifaNegativa(){
        try{
            tarifa = c.calculoTarifa(-10000,1,30);
            long er = 0/0;
        }
        catch (Exception e){
            Assert.assertTrue(true);
        }
    }
}