public class FileFilter {
    private String[] fileNames;
    
    public FileFilter(String []fileNames) {
        this.fileNames = fileNames;
    }
    
    public void filterFiles() {
        System.out.println("Files that start with temp and ends with .txt:-");
        for (String file : fileNames) {
            if (file.startsWith("temp") && file.endsWith(".txt")) {
                System.out.print(file + " ");
            }
        }
    }
    
    
    public static void main(String args[]) {
        String []fileNames = {"temp1.txt", "temp2.txt", "abr.mp3", "man.txt"};
        FileFilter ff = new FileFilter(fileNames);
        ff.filterFiles();
    }
}
