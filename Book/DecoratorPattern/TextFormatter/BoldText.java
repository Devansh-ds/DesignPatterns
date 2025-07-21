public class BoldText extends TextDecorator {

    public BoldText(Text innerText) {
        super(innerText);
    }

    public String render() {
        return "<b>" + innerText.render() + "</b>";
    }
    
}
