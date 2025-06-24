import java.util.Scanner;

public class TextUI {
    private final Scanner scanner;
    private final AppService service;

    public TextUI(AppService service) {
        this.scanner = new Scanner(System.in);
        this.service = service;
    }

    public void start() {
        while (true) {
            this.printMsg(0);
            if (this.receiveCalcInput()) {
                break;
            }
        }
    }

    private void printMsg(int index) {
        System.out.println(this.service.getMsg(index));
    }

    private boolean receiveCalcInput() {
        String input = this.scanner.nextLine();
        String[] words = input.split("\\s+");

        if (!this.service.isNumericRegex(words[0]) || !this.service.isNumericRegex(words[2])) {
            this.printMsg(1);
            return false;
        } else if (!this.service.isOperator(words[1])) {
            this.printMsg(2);
            return false;
        }
        this.service.setCalc(words[0], words[1], words[2]);
        return true;
    }

}
