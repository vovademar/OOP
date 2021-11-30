package ru.nsu.medvedev.v;

import org.apache.commons.cli.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class NotebookCli {
    public static void main(String[] args) throws ParseException, IOException, java.text.ParseException {
        Notebook note = new Notebook();
        Options options = new Options();
        Option show = Option.builder("show").hasArgs().optionalArg(true).build();
        Option add = Option.builder("add").hasArgs().optionalArg(true).build();
        options.addOption(show);
        options.addOption(add);
        options.addOption("help", false, "help user");
        options.addOption("rm", true, "remove note");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        if (cmd.hasOption("add")) {
            String[] values = cmd.getOptionValues("add");
            note.add(values[0], values[1]);
        } else if (cmd.hasOption("rm")) {
            note.remove(cmd.getOptionValue("rm"));
        } else if (cmd.hasOption("show")) {
            String[] optValue = cmd.getOptionValues("show");
            if (optValue == null) {
                note.show();
            } else {
                String sBefore = optValue[0];
                Date before = new SimpleDateFormat("dd/MM/yyyy").parse(sBefore);
                String sAfter = optValue[1];
                Date after = new SimpleDateFormat("dd/MM/yyyy").parse(sAfter);
                String[] txt = Arrays.copyOfRange(optValue, 2, optValue.length);
                note.show(before, after, txt);
            }
        } else if (cmd.hasOption("help")) {
            System.out.println("Here some instructions for this program:");
            System.out.println("use -add to add your perfect notes. After flag goes String parameter (usage example: -add \"some wonderful note\")");
            System.out.println("use -rm to remove note. After flag goes String parameter (usage example: -rm \"some not wonderful note\")");
            System.out.println("use -show without parameters to see all notes you added before in date order. (usage example: -show)");
            System.out.println("use -show with 3 parameters first is the date from you want to see notes second is the date before and the third parameter is the key word (usage example: -show 11/10/2020 13/12/2021 \"dog\")");
        }
    }
}
