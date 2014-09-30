package sk.upjs.ics.paz1c.citatr;

import org.junit.Test;
import static org.junit.Assert.*;

public class CitatDaoTest {
    private CitatDao citatDao;

    @Before
    public void setUp() {
        citatDao = new CitatDao();
    }
    
    @Test
    public void test() {
        Citat citat = new Citat();
        citat.setText("Byť či nebyť");
        citat.setAutor("Shakespeare");
        
        int pocetCitatovPred = citatDao.count();

        citatDao.save(citat);
       
        int pocetCitatovPo = citatDao.count();

        assertTrue(pocetCitatovPo == pocetCitatovPred + 1);
    }
    
    @Test
    public void testFindById() {
        Citat ocakavanyCitat = new Citat();
        ocakavanyCitat.setText("E = mc^2");
        ocakavanyCitat.setAutor("Einstein");
        
        Citat najdenyCitat = citatDao.findById(1L);
        assertNotNull(najdenyCitat);
        assertEquals(ocakavanyCitat.getText(), najdenyCitat.getText());
        assertEquals(ocakavanyCitat.getAutor(), najdenyCitat.getAutor());
        
    }    
       
   
}