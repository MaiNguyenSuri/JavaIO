import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        listFileIndir(System.getProperty("user.dir"));
    }

    public static void listFileIndir(String path) {
        File file = new File(path);
        System.out.println(file.getAbsolutePath());

        System.out.println("Danh sách các file:");
        printFile(file);

        System.out.println("----------------------------------");

        System.out.println("Danh sách các folder");
        printFolder(file,"");

    }

    public static void printFile(File f) {
        if (f.isFile()) {
            System.out.println(f.getName());
        } else {
            //System.out.println("Folder: " + f.getName());
            File[] arryItem1 = f.listFiles();
            for (File f1 : arryItem1) {
                printFile(f1);
            }
        }
    }

    public static void printFolder(File f, String parentName)
    {
        if (f.isDirectory()) {
            if(parentName != null && !parentName.equals("")){
                parentName += "/";
            }
            System.out.println(parentName + f.getName());

            File[] arryItem1 = f.listFiles();
            for (File f1 : arryItem1) {

                printFolder(f1, parentName +  f.getName());
            }
        }
    }
}