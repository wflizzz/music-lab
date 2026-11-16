package musicservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// доп тесты
class TrackTest {
//одинак id счит что треки равные даже если назв и исп разные
    @Test
    void equals_sameId_true() {
        Track a = new Track(1, "песня 1", "певец 1");
        Track b = new Track(1, "другое название", "другой певец");
        assertEquals(a, b);
    }
//с разн айди не равны
    @Test
    void equals_differentId_false() {
        Track a = new Track(1, "песня 1", "певец 1");
        Track b = new Track(2, "песня 1", "певец 1");
        assertNotEquals(a, b);
    }
//что сущ трек не равен null
    @Test
    void equals_null_false() {
        Track a = new Track(1, "песня 1", "певец 1");
        assertNotEquals(null, a);
    }
//как трек преобраз в текст
    @Test
    void toString_artistDashTitle() {
        Track t = new Track(1, "песня 1", "певец 1");
        assertEquals("певец 1 - песня 1", t.toString());
    }
}
