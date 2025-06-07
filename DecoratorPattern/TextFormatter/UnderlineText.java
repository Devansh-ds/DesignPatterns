public class UnderlineText extends TextDecorator {

    public UnderlineText(Text innerText) {
        super(innerText);
    }

    public String render() {
        return "<u>" + innerText.render() + "</u>";
    }
    
}
