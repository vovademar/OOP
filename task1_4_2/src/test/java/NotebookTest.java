import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsu.medvedev.v.Note;
import ru.nsu.medvedev.v.Notebook;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotebookTest {

    @Test
    void addTest() throws IOException {
        Notebook note = new Notebook();
        Date date = new Date();
        note.add(new Note("this is not how it should output",date));
        String res = note.show();
        Assertions.assertEquals("[\nthis is not how it should output " + new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss").format(date) + "\n]", res);
    }


    @Test
    void delTest() throws IOException {
        Notebook note = new Notebook();
        note.add("this is not how it should output");
        note.remove("this is not how it should output");
        String res = note.show();
        Assertions.assertEquals("[]", res);
    }

    @Test
    void someDel() throws IOException {
        Notebook note = new Notebook();
        Date date = new Date();
        note.add("this is not how it should output");
        note.add("testing");
        note.remove("testing");
        Assertions.assertEquals("[\nthis is not how it should output " + new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss").format(date) + "\n]", note.show());
    }

    @Test
    void showFromTill() throws IOException {
        Notebook notebook = new Notebook();
        notebook.add(new Note("text1", new Date(System.currentTimeMillis() - 864000000)));
        notebook.add(new Note("text2", new Date(System.currentTimeMillis() - 464000000)));
        notebook.add(new Note("text3", new Date(System.currentTimeMillis() - 264000000)));
        notebook.add(new Note("text4", new Date(System.currentTimeMillis() - 86400000)));
        notebook.add(new Note("text5", new Date(System.currentTimeMillis())));
        notebook.add(new Note("text6", new Date(System.currentTimeMillis() + 86400000)));
        notebook.add(new Note("text7", new Date(System.currentTimeMillis() + 864000000)));
        String res = notebook.show(new Date(System.currentTimeMillis() - 464000000), new Date(System.currentTimeMillis() + 864000000), "text5");
        System.out.println(res);
        Assertions.assertEquals("[\ntext5 " + new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss").format(new Date()) + "\n]", res);
    }

}
