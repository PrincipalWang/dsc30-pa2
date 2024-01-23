import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WebBrowserTest {
    @org.junit.jupiter.api.Test
    public void totalTest() {
        WebBrowser web1 = new WebBrowser();
        assertEquals("google.com", web1.getCurrentPage());
        web1.openNewPage("a.com");
        assertEquals("a.com", web1.getCurrentPage());
        web1.previousPage();
        assertEquals("google.com", web1.getCurrentPage());
        assertThrows(IllegalStateException.class, () -> {
            web1.previousPage();
        });
        web1.nextPage();
        assertEquals("a.com", web1.getCurrentPage());
        assertThrows(IllegalStateException.class, () -> {
            web1.nextPage();
        });
        web1.newTab();
        assertThrows(IllegalStateException.class, () -> {
            web1.previousPage();
        });
        assertThrows(IllegalStateException.class, () -> {
            web1.nextPage();
        });
        ArrayList<String> res1 = new ArrayList<>();
        res1.add("a.com");
        res1.add("google.com");
        res1.add("a.com");
        ArrayList<String> res2 = web1.getHistory();
        assertEquals(res1.size(),res2.size());
        for(int i = 0 ; i < res1.size() ; i++){
            assertEquals(res1.get(i), res2.get(i));
        }
        assertTrue(web1.findLink("a.com"));
        web1.clearHistory();
        web1.newTab();
        web1.openNewPage("google.com");
        assertTrue(web1.findLink("google.com"));
        web1.clearHistory();
        web1.newTab();
        assertFalse(web1.findLink("b.com"));
        web1.openNewPage("b.com");
        ArrayList<String> res3 = web1.getHistory();
        assertEquals(1,res2.size());
        assertEquals("b.com",res2.get(0));
        assertFalse(web1.findLink("google.com"));
        web1.clearHistory();
        ArrayList<String> res4 = web1.getHistory();
        assertEquals(0,res2.size());
    }
}