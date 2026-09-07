
public class StatusEvaluator {

    public static void main(String[] args) {
        double attendancePercentage = 70.0; // E
        // 
        // syntax of if-else statement in Java:
        // if (condition) {
        //     // line of code to execute if the condition is true
        // } else {
        //     // line of code to execute if the condtion is false
        // }

        // if, if-else ,nested if-else 
        boolean dispatchAlert;
        if (attendancePercentage < 75.0) {
            dispatchAlert = true;
            System.out.println("Dispatching alert: Attendance below threshold." + dispatchAlert);
        } else {
            dispatchAlert = false;
            System.out.println("Attendance is satisfactory. No alert dispatched.");
        }
    }
}
