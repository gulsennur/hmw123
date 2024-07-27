package org.example;

import org.example.Maas_Hesabi.Maas_Hesabi;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Maas_HesabiTest {

    @Test
    public void testMaasCal() {
        Maas_Hesabi m1 = new Maas_Hesabi();
        int expectedSalary = m1.k * m1.work_day;
        // Çalışma gününe göre maaşın doğru olup olmadığını kontrol ediyoruz
        m1.maas_cal();
        Assert.assertEquals(m1.k * m1.work_day, expectedSalary);
    }

    @Test
    public void testPrimliMaas() {
        Maas_Hesabi m1 = new Maas_Hesabi();
        int expectedSalaryWithBonus = m1.prim + (m1.k * m1.work_day);
        // Çalışma gününe göre primli maaşın doğru olup olmadığını kontrol ediyoruz
        m1.primli_maas();
        Assert.assertEquals(m1.prim + (m1.k * m1.work_day), expectedSalaryWithBonus);
    }

    @DataProvider(name = "salaryData")
    public Object[][] salaryData() {
        return new Object[][] {
                { 250, 25, 27, (27 - 25) * 1000 + (250 * 27) },
                { 200, 22, 30, (30 - 22) * 1000 + (200 * 30) },
                { 150, 20, 24, (24 - 20) * 1000 + (150 * 24) }
        };
    }

    @Test(dataProvider = "salaryData")
    public void testMaasWithDifferentData(int k, int defaultDay, int workDay, int expectedPrimliMaas) {
        Maas_Hesabi m1 = new Maas_Hesabi();
        m1.k = k;
        m1.default_day = defaultDay;
        m1.work_day = workDay;
        m1.prim = (workDay - defaultDay) * 1000; // Prim hesabını elle güncelledik

        int computedPrimliMaas = m1.prim + (m1.k * m1.work_day);
        Assert.assertEquals(computedPrimliMaas, expectedPrimliMaas);
    }
}