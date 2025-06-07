public abstract  class TextDecorator extends Text {

    protected  Text innerText;

    public TextDecorator(Text innerText) {
        this.innerText = innerText;
    }

    public abstract String render();
    
}
