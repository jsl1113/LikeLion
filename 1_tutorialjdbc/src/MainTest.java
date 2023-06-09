import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void checkLeapYear() {
        assertEquals(false, MyUtils.checkLeapYear(1700));
    }

    @org.junit.jupiter.api.Test
    void testLeapYear() {
        assertEquals(true, MyUtils.isLeapYear(2020));
        assertEquals(false, MyUtils.isLeapYear(1900));
        assertEquals(true, MyUtils.isLeapYear(2400));
    }

    @org.junit.jupiter.api.Test
    void testis369() {
        assertEquals("*", MyUtils.is369(3));
        assertEquals("", MyUtils.is369(15));
        assertEquals("**", MyUtils.is369(33));
        assertEquals("***", MyUtils.is369(333));
        assertEquals("****", MyUtils.is369(3369));
    }
}
