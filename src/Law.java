public class Law {

    public boolean law1(Quantifier q1, Quantifier q2, Quantifier q3, int figure){
        int sum = 0;
        switch (figure){
            case 1: sum = q1.getSubject() + q2.getPredicate();
            break;
            case 2: sum = q1.getPredicate() + q2.getPredicate();
            break;
            case 3: sum = q1.getSubject() + q2.getSubject();
            break;
            case 4: sum = q1.getPredicate() + q2.getSubject();
            break;
        }

        if (sum > 5){
            return true;
        }else {
            return false;
        }
    }

    public boolean law2(Quantifier q1, Quantifier q2, Quantifier q3, int figure){
        int index1 = 0;
        int index2 = 0;

        switch (figure){
            case 1: index1 = q2.getSubject();
                    index2 = q1.getPredicate();
                    break;
            case 2: index1 = q2.getSubject();
                index2 = q1.getSubject();
                break;
            case 3: index1 = q2.getPredicate();
                index2 = q1.getPredicate();
                break;
            case 4: index1 = q2.getPredicate();
                index2 = q1.getSubject();
                break;
        }

        if (index1 >= q3.getSubject() && index2 >= q3.getPredicate()){
            return true;
        }else {
            return false;
        }
    }

    public boolean law3(Quantifier q1, Quantifier q2, Quantifier q3){
        if (q1.getQuality() | q2.getQuality()){
            return true;
        }else {
            return false;
        }
    }

    public boolean law4(Quantifier q1, Quantifier q2, Quantifier q3) {

        if (!(q3.getQuality())) {
            if (!(q1.getQuality()) | !(q2.getQuality())) {
                return true;
            } else {
                return false;
            }
        }else {
            if (!(q1.getQuality()) | !(q2.getQuality())) {
                return false;
            }
        }
        return true;
    }

}
