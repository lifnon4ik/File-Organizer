import java.io.File;


public class App {

    static final File currentDirectory = new File(".");

    public static void main(String[] args) throws Exception {
        
        File[] files = currentDirectory.listFiles();
        if (files == null) {
            System.out.println("Error? code 1");
            return;
        } else{
            System.out.println("Ok!");
            
            
        }     
        for (File file : files) {
            String ext = getFileExtension(file);    
            if(file.isFile()){
                System.out.println(file.getName() + " --> " + ext);
            }

        }
        for (File file : files){
            String ext1 = getFileExtension(file);
            File destinationFolder = new File(currentDirectory,ext1);
            if (!destinationFolder.exists()) {

                destinationFolder.mkdir();
                System.out.println("create dir --> " + destinationFolder);

            }

            File newFileLocation = new File(destinationFolder ,file.getName());
            if(file.renameTo(newFileLocation)){
                System.out.println("file "+ file.getName() +"transfer --> " + newFileLocation);
            }else{
                System.out.println("error code 10");
            }

        }

    }

    
    private static String getFileExtension(File file) {
        String filename = file.getName(); 
        int lastindex = filename.lastIndexOf(".");
        
        
        if(lastindex == -1){
            return "";
        } else{
            return filename.substring(lastindex +1);


        }

    }

}