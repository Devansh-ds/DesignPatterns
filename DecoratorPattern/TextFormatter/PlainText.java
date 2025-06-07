public class PlainText extends Text {

    private String content;
    
    public PlainText(String content) {
        this.content = content;
    }

    public String render() {
        return content;
    }
    
}
