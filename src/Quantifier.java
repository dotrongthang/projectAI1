public class Quantifier {
    private String sign;
    private String quantity;
    private boolean quality;  //true is affirmative, fale is negative
    private int subject;
    private int predicate;

    public Quantifier() {
    }

    public Quantifier(String sign, String quantity, boolean quality, int subject, int predicate) {
        this.sign = sign;
        this.quantity = quantity;
        this.quality = quality;
        this.subject = subject;
        this.predicate = predicate;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public boolean getQuality() {
        return quality;
    }

    public void setQuality(boolean quality) {
        this.quality = quality;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public int getPredicate() {
        return predicate;
    }

    public void setPredicate(int predicate) {
        this.predicate = predicate;
    }

    @Override
    public String toString() {
        return "Quantifier{" +
                "sign='" + sign + '\'' +
                ", quantity='" + quantity + '\'' +
                ", quality=" + quality +
                ", subject=" + subject +
                ", predicate=" + predicate +
                '}';
    }
}
