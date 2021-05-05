import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextFilesSearchAndSortAndCombineContent {
    private static String DIR_NAME = "C:\\Users\\Pavel\\Desktop\\Programm_files";
    private static final String EXTENSION = ".txt";
    private static final List<String> ALL_TEXT_FILES_LIST = new ArrayList<>();
    private static final List<String> SORTED_BY_NAME_ALL_TEXT_FILES_LIST = new ArrayList<>();
    private static final String TEXT_FILE = "textFile.txt";

    public static void main(String[] args) throws IOException {

        try (var bufferedWriter = new BufferedWriter(new FileWriter(TEXT_FILE, StandardCharsets.UTF_8))) {
            func(DIR_NAME, EXTENSION);
            Collections.sort(ALL_TEXT_FILES_LIST);
            System.out.println("Sorted list by full name (include address): ");
            for (int i = 0; i < ALL_TEXT_FILES_LIST.size(); i++) {
                System.out.println((i + 1) + ": " + ALL_TEXT_FILES_LIST.get(i));
                List<String> readFileStringList = readTextFile(ALL_TEXT_FILES_LIST.get(i));
                for (int j = 0; j < readFileStringList.size(); j++) {
                    bufferedWriter.write(readFileStringList.get(j));
                    bufferedWriter.newLine();
                }
            }
            System.out.println("\n Sorted list by only name: ");
            Collections.sort(SORTED_BY_NAME_ALL_TEXT_FILES_LIST);
            for (int i = 0; i < SORTED_BY_NAME_ALL_TEXT_FILES_LIST.size(); i++) {
                System.out.println((i + 1) + ": " + SORTED_BY_NAME_ALL_TEXT_FILES_LIST.get(i));
            }
        }
    }

    private static List<String> readTextFile(String readFile) throws IOException {
        List<String> readFileStringList = new ArrayList<>();
        try (var bufferedReader = new BufferedReader(new FileReader(readFile, StandardCharsets.UTF_8))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                readFileStringList.add(line);
            }
        }
        return readFileStringList;
    }

    private static void func(String directoryName, String extension) {
        List<String> fullTextFileNamesList = textFileListSearch(directoryName, extension);
        List<File> subDirList = subDirectoryListSearch(directoryName);
        ALL_TEXT_FILES_LIST.addAll(fullTextFileNamesList);
        if (!subDirList.isEmpty()) {
            for (int i = 0; i < subDirList.size(); i++) {
                func(subDirList.get(i).toString(), extension);
            }
        }
    }

    private static List<String> textFileListSearch(String directoryName, String extension) {
        File dir = new File(directoryName);
        String[] textFileNamesList = dir.list(new ExtensionFilter(extension));
        List<String> fullFileNamesList = new ArrayList<>();
        if (textFileNamesList != null) {
            for (String textFileName : textFileNamesList) {
                fullFileNamesList.add(dir.getAbsolutePath() + "\\" + textFileName);
                SORTED_BY_NAME_ALL_TEXT_FILES_LIST.add(textFileName);
            }
        }
        return fullFileNamesList;
    }

    private static List<File> subDirectoryListSearch(String directoryName) {
        File[] dirList;
        List<File> subDirList = new ArrayList<>();
        File dir = new File(directoryName);
        dirList = dir.listFiles();
        if (dirList != null) {
            for (int i = 0; i < dirList.length; i++) {
                if (dirList[i].isDirectory()) {
                    subDirList.add(dirList[i]);
                }
            }
        }
        return subDirList;
    }

    private static class ExtensionFilter implements FilenameFilter {
        private final String extension;

        public ExtensionFilter(String ext) {
            extension = ext;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(extension);
        }
    }
}
