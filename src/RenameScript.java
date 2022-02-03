import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * Class for renaming files in a folder of a certain extension
 */

public class RenameScript {

    File source;
    File[] original;
    File[] holder;
    File[] replacement;

    public RenameScript(String folder, String name, String extension){
        source = new File(folder);
        original = source.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name){
                return name.endsWith(extension);
            }
        });

        Arrays.sort(original);

        holder = new File[original.length];
        replacement = new File[original.length];

        for(int i = 0; i < original.length; i++){
            holder[i] = new File(original[i].getPath());
            //System.out.println(holder[i].getPath());
            String replacementName = folder + "\\" + name + " ";

            String temp = String.valueOf((i+1));
            String temp2 = String.valueOf((original.length));
            if(temp.length() < temp2.length()){
                for(int j = (temp.length()-temp2.length()); j < 0; j++){
                    replacementName += "0";
                }
            }
            replacementName += i+1;
            replacement[i] = new File(replacementName+extension);
            original[i].renameTo(replacement[i]);
        }
    }

    public RenameScript(String folder, String name, String extension, int first, int total){
        source = new File(folder);
        original = source.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name){
                return name.endsWith(extension);
            }
        });

        Arrays.sort(original);

        replacement = new File[original.length];

        for(int i = 0; i < original.length; i++){
            //System.out.println(original[i].getName());
            String replacementName = folder + "\\" + name + " ";

            String temp = String.valueOf((i+first));
            String temp2 = String.valueOf(total);
            if(temp.length() < temp2.length()){
                for(int j = (temp.length()-temp2.length()); j < 0; j++){
                    replacementName += "0";
                }
            }
            replacementName += i+1;
            replacement[i] = new File(replacementName+extension);
            //System.out.println(replacement[i].getName());
            original[i].renameTo(replacement[i]);
        }
    }

    public void undo(){
        for(int i=0; i<original.length; i++){
            System.out.println(original[i].getPath());
            original[i].renameTo(new File(original[i].getPath()));
        }
    }
}
