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
        note.add(new Note("test", "this is not how it should output", date));
        String res = note.show().toString();
        Assertions.assertEquals("[\nTitle: test\nNote: this is not how it should output\nTime: " + new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss").format(date) + "\n]", res);
        note.remove("test");
    }


    @Test
    void delTest() throws IOException {
        Notebook note = new Notebook();
        note.add("this is not how it should output", "aaaa");
        note.remove("this is not how it should output");
        String res = note.show().toString();
        Assertions.assertEquals("[]", res);
    }

    @Test
    void someDel() throws IOException {
        Notebook note = new Notebook();
        Date date = new Date();
        note.add(new Note("test", "this is not how it should output", date));
        note.add("testing", "test1");
        note.remove("testing");
        String res = note.show().toString();
        Assertions.assertEquals("[\nTitle: test\nNote: this is not how it should output\nTime: " + new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss").format(date) + "\n]", res);
        note.remove("test");

    }

    @Test
    void showFromTill() throws IOException {
        Notebook notebook = new Notebook();
        Date date = new Date();
        notebook.add(new Note("test1", "text1", new Date(System.currentTimeMillis() - 864000000)));
        notebook.add(new Note("test2", "text2", new Date(System.currentTimeMillis() - 464000000)));
        notebook.add(new Note("test3", "text3", new Date(System.currentTimeMillis() - 264000000)));
        notebook.add(new Note("test", "this is not how it should output", new Date(System.currentTimeMillis())));
        notebook.add(new Note("test5", "text5", new Date(System.currentTimeMillis() + 123)));
        notebook.add(new Note("test6", "text6", new Date(System.currentTimeMillis() + 86400000)));
        notebook.add(new Note("test7", "text7", new Date(System.currentTimeMillis() + 864000000)));
        String[] arr = {"test123", "test", "asdfasda"};
        String result = notebook.show(new Date(System.currentTimeMillis() - 864000001), new Date(System.currentTimeMillis() + 864000001), arr).toString();
        Assertions.assertEquals("[\nTitle: test\nNote: this is not how it should output\nTime: " + new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss").format(date) + "\n]", result);
        notebook.remove("test");
        notebook.remove("test1");
        notebook.remove("test2");
        notebook.remove("test3");
        notebook.remove("test5");
        notebook.remove("test6");
        notebook.remove("test7");

    }

}
