public class ItalicText extends TextDecorator {

    public ItalicText(Text innerText) {
        super(innerText);
    }

    public String render() {
        return "<i>" + innerText.render() + "</i>";
    }
    
}
