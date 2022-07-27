package main.design_pattern.behavioral.memento;

public class FileWriterUtil {
    private String fileName ;
    private StringBuilder fileContent;

    public FileWriterUtil(String fileName) {
        this.fileName = fileName;
        this.fileContent = new StringBuilder();
    }

    public void write(String str){
        fileContent.append(str);
    }

    public Memento save(){
        return new Memento(this.fileName,this.fileContent);
    }

    public void undoToLastSave(Object obj){
        Memento memento = (Memento) obj;
        this.fileName= memento.fileName;
        this.fileContent=memento.fileContent;
    }

    @Override
    public String toString() {
        return "FileWriterUtil{" +
                "fileName='" + fileName + '\'' +
                ", fileContent=" + fileContent +
                '}';
    }

    private class Memento {
        private String fileName ;
        private StringBuilder fileContent;

        public Memento(String fileName, StringBuilder fileContent) {
            this.fileName = fileName;
            this.fileContent = new StringBuilder(fileContent);
        }
    }
}
