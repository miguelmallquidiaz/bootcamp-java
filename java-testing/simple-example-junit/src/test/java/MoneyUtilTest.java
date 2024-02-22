import org.junit.Assert;
import org.junit.Test;

public class MoneyUtilTest {
    @Test
    public void moneyTest() {
        String money = MoneyUtil.format(1000);
        // comparación de algo con otro
        Assert.assertEquals("$1000.00", money);
    }

    @Test
    public void negativeMoneyTest() {
        String money = MoneyUtil.format(-1000);
        //comparación de algo con otro
        Assert.assertEquals("-$1000.00", money);
    }

    @Test
    public void euroMoneyTest(){
        String money = MoneyUtil.format(-1000.0, "€");
        //comparación de algo con otro
        Assert.assertEquals("-€1000.00", money);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notNullExceptionMoneyTest(){
        MoneyUtil.format(-1000.0, null);
        //Lo que debe devolver es un error
    }

}
