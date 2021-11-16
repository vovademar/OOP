import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsu.medvedev.v.Notebook;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotebookTest {
    Notebook notebook;

    @Test
    void someTest() throws JsonProcessingException {
        Notebook note = new Notebook();
        note.add("this is not how it should output");
        String res = note.show();
        Assertions.assertEquals("[{\"text\":\"this is not how it should output\",\"time\":\""
                + new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss").format(new Date()) + '"' + "}]", res);
    }
    @Test
    void someDel() throws JsonProcessingException {
        Notebook note = new Notebook();
        note.add("this is not how it should output");
        note.remove("this is not how it should output");
        String res = note.show();
        Assertions.assertEquals("[]", res);
    }
}
