package ru.nsu.medvedev.v;

import org.apache.commons.cli.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotebookCli {
    public static void main(String[] args) throws ParseException, IOException, java.text.ParseException {
        Notebook notebook = new Notebook();
        Options options = new Options();
        Option show = Option.builder("show").hasArgs().optionalArg(true).build();
        options.addOption(show);
        options.addOption("add", true, "add note");
        options.addOption("rm", true, "remove note");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        if (cmd.hasOption("add")) {
            String text = cmd.getOptionValue("add");
            notebook.add(text);
        } else if (cmd.hasOption("rm")) {
            notebook.remove(cmd.getOptionValue("rm"));
        } else if (cmd.hasOption("show")) {
            String[] optValue = cmd.getOptionValues("show");
            if (optValue == null) {
                notebook.show();
            } else {
                String sBefore = optValue[0];
                Date before = new SimpleDateFormat("dd/MM/yyyy").parse(sBefore);
                String sAfter = optValue[1];
                Date after = new SimpleDateFormat("dd/MM/yyyy").parse(sAfter);
                String txt = optValue[2];
                notebook.show(before, after, txt);
            }


        }
    }
}
