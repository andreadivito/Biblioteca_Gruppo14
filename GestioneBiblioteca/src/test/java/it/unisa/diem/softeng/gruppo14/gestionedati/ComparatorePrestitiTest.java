/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo14.gestionedati;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Utente
 */
public class ComparatorePrestitiTest {
    
    private Prestito o1;
    private Prestito o2;
    private ComparatorePrestiti c;
    
    public ComparatorePrestitiTest() {
    }
    
    @BeforeEach
    public void setUp() {
        c = new ComparatorePrestiti();
    }
    
    /**
     * Test of compare method, of class ComparatorePrestiti.
     */
    @Test
    public void testCompare() {
        o1 = new Prestito(null, null, LocalDate.now());
        o2 = new Prestito(null, null, LocalDate.now());
        int expResult = 0;
        int result = c.compare(o1, o2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCompare1() {
        o1 = new Prestito(null, null, LocalDate.of(2025, 12, 10));
        o2 = new Prestito(null, null, LocalDate.of(2025, 12, 15));
        int result = c.compare(o1, o2);
        assertTrue(result < 0);
    }
    
    @Test
    public void testCompare2() {
        o1 = new Prestito(null, null, LocalDate.of(2025, 12, 15));
        o2 = new Prestito(null, null, LocalDate.of(2025, 12, 10));
        int result = c.compare(o1, o2);
        assertTrue(result > 0);
    }
    
    
}
