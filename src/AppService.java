import java.util.ArrayList;
import java.util.List;

public class AppService {
    final private List<String> msgs;
    private String x;
    private String operator;
    private String y;

    public AppService() {
        this.msgs = new ArrayList<String>();
        this.msgs.add("Enter an equation");
        this.msgs.add("Do you even know what numbers are? Stay focused!");
        this.msgs.add("Yes ... an interesting math operation. You've slept through all classes, haven't you?");
        this.x = this.operator = this.y = "";
    }

    public String getMsg(int index) {
        if (index >= this.msgs.size()) {
            return "No message found";
        }
        return this.msgs.get(index);
    }

    public void setCalc(String x, String operator, String y) {
        this.x = x;
        this.operator = operator;
        this.y = y;
    }

    public boolean isNumericRegex(String str) {
        return str != null && str.matches("-?\\d+(\\.\\d+)?");
    }

    public boolean isOperator(String str) {
        return str != null && (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }
}
