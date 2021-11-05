import java.util.Scanner;

public class GradeStudent {

    static int totalWeight = 100;

    public static void main(String[] args) {
        begin();
        double midTermWeightScore = midTerm();
        double finalTermWeightScore = finalTerm();
        double homeWorkWeightScore = homeWork();
        report(midTermWeightScore,finalTermWeightScore,homeWorkWeightScore);
    }
    public static void begin() {
        System.out.println("This program reads exam/homework scores \nand reports your overall course grade.");
        System.out.println("**********\n");
    }

    public static double midTerm() {
        Scanner input = new Scanner(System.in);
        System.out.println("Midterm:");

        // Trọng số điểm thi giữa ký.
        System.out.print("Weight (0 - 100)? ");
        int midTermWeight = 0;
        // Set giới hạn trọng số của 3 phần = chính xác 100.
        do {
            midTermWeight = input.nextInt();
        } while (midTermWeight > totalWeight);
            totalWeight = (totalWeight - midTermWeight);

        // Điểm số giũa ký sinh viên đạt.
        System.out.print("Scores earned? ");
        int midTermScore = input.nextInt();

        // Điểm thi sinh viên có được tăng hay không > chọn 1 nếu có, > chọn 2 nếu không.
        // Ví dụ ở đây chọn 2 thì không tăng thêm.
        System.out.print("Were score shifted (1 = yes, 2 = no)? ");
        int midShiftScore = input.nextInt();
        if (midShiftScore == 2) {
            midShiftScore = 0;
        }
        // Tổng điểm giữa ký sinh viên đạt bao gồm điềm điểm tăng thêm.
        double midTermTotalPoint = (midTermScore + midShiftScore);

        // Tổng điểm tối đa là 100, nếu lớn hơn 100 thì cũng chỉ tính 100.
        int midTermTotalPoint_Max = 100;
        if (midTermTotalPoint > midTermTotalPoint_Max) {
            midTermTotalPoint += (midTermTotalPoint_Max - midTermTotalPoint);
        }
        // Điểm số trung bình phần giũa kỳ dựa trên trong số.
        double midTermWeightScore = (midTermTotalPoint / midTermTotalPoint_Max) * midTermWeight;
        midTermWeightScore = Math.round(midTermWeightScore * 10) / 10.0;


        System.out.println("Total points =  " + midTermTotalPoint + " / " + midTermTotalPoint_Max);
        System.out.println("Weighted score = " + midTermWeightScore + " / " + midTermWeight);
        System.out.println("**********\n");
        return midTermWeightScore;
    }

    public static double finalTerm() {
        Scanner input = new Scanner(System.in);
        System.out.println("Finalterm:");

        // Trọng số của điểm thi cuối ký.
        int finalTermWeight = 0;
        System.out.print("Weight (0 - 100)? ");

        // Set giới hạn trọng số của 3 phần = chính xác 100.
        do {
            finalTermWeight = input.nextInt();
        } while (finalTermWeight > totalWeight);
            totalWeight = (totalWeight - finalTermWeight);

        // Điểm số sinh viên đạt được.
        System.out.print("Scores earned? ");
        double finalTermScore = input.nextDouble();

        // Điểm thi sinh viên có được tăng hay không > chọn 1 nếu có, > chọn 2 nếu không.
        System.out.print("Were score shifted (1 = yes, 2 = no)? ");
        double finalShiftScore = input.nextDouble();

        // Nếu chọn 1 thì được tăng và có thêm dòng được tăng bao nhiêu (shift amount). Nếu chọn 2 thì không thêm dòng này.
        double shiftAmount;
        if (finalShiftScore == 2) {
            finalShiftScore = 0;
        } else {
            System.out.print("Shift amount? ");
            shiftAmount = input.nextDouble();
            finalShiftScore = shiftAmount;
        }
        // Tổng điểm số sinh viên đạt gồm điềm thi và điểm được tăng thêm.
        double finalTotalPoint = (finalTermScore + finalShiftScore);

        // Tổng điểm tối cuối kỳ tối đa là 100, nếu cao hơn cũng chỉ tính 100.
        int finalTotalPoint_Max = 100;
        if (finalTotalPoint > finalTotalPoint_Max) {
            finalTotalPoint += (finalTotalPoint_Max - finalTotalPoint);
        }
        // Điểm số trung bình phần cuối ký dựa trên trọng số.
        double finalTermWeightScore = (finalTotalPoint / finalTotalPoint_Max) * finalTermWeight;
        finalTermWeightScore = Math.round(finalTermWeightScore * 10) / 10.0;

        System.out.println("Total points =  " + finalTotalPoint + " / " + finalTotalPoint_Max);
        System.out.println("Weighted score = " + finalTermWeightScore + " / " + finalTermWeight);
        System.out.println("**********\n");
        return finalTermWeightScore;
    }

    public static double homeWork() {
        Scanner input = new Scanner(System.in);
        System.out.println("Homework:");

        // Biến trọng số của phần homwork.
        int homeWorkWeight = totalWeight;
        System.out.print("Weight (0 - 100)? " + totalWeight + "\n");

        System.out.print("Number of Assignments? ");
        int numberAssignment = input.nextInt();

        System.out.print("Assignment 1 score and max? ");
        double scoreAssignment1 = input.nextDouble();
        double maxAssignment1 = input.nextDouble();

        System.out.print("Assignment 2 score and max? ");
        double scoreAssignment2 = input.nextDouble();
        double maxAssignment2 = input.nextDouble();

        System.out.print("Assignment 3 score and max? ");
        double scoreAssignment3 = input.nextDouble();
        double maxAssignment3 = input.nextDouble();

        // Tổng điểm đạt được của các Assignment.
        double scoreAssignment = (scoreAssignment1 + scoreAssignment2 + scoreAssignment3);
        // Tổng điểm tối đa của các bài assignment.
        double maxAssignment = (maxAssignment1 + maxAssignment2 + maxAssignment3);
        // Giới hạn điểm tối đa của phần Assignment là 150, nếu vượt quá thì cũng chỉ tính là 150.
        double scoreAssignmentMax = 150;
        if (scoreAssignment > scoreAssignmentMax && maxAssignment > scoreAssignmentMax) {
            scoreAssignment += (scoreAssignmentMax - scoreAssignment);
            maxAssignment += (scoreAssignmentMax - maxAssignment);
        }
        System.out.print("How many section are your attempt? ");
        int sectionAttend = input.nextInt();
        int sectionPoint = (sectionAttend * 5);

        // Giới hạn phần Attend là 30, nếu vượt quá thì cũng chỉ tính là 30.
        int sectionPointMax = 30;
        if (sectionPoint > sectionPointMax) {
            sectionPoint += (sectionPointMax - sectionPoint);
        }
        // Tổng điểm thực tế sinh viên đặt được.
        double homeWorkTotalPoint = (scoreAssignment + sectionPoint);

        // Tổng điểm tối đa sinh viên có thể đạt.
        int homeWorkTotalPoint_Max = (int) (maxAssignment + sectionPointMax);
        // Điểm số trung bình phần homework dựa trên trọng số.
        double homeWorkWeightScore = (homeWorkTotalPoint / homeWorkTotalPoint_Max) * homeWorkWeight;
        homeWorkWeightScore = Math.round(homeWorkWeightScore * 10) / 10.0;

        System.out.println("Section points? " + sectionPoint + " / " + sectionPointMax);
        System.out.println("Total points? " + homeWorkTotalPoint + " / " + homeWorkTotalPoint_Max);
        System.out.println("Weighted score = " + homeWorkWeightScore + " / " + homeWorkWeight);
        System.out.println("**********\n");
        return homeWorkWeightScore;
    }

    public static void report(double midTermWeightScore,double finalTermWeightScore,double homeWorkWeightScore) {
        // Overall percentage là tổng điểm sinh viên đạt được của 3 môn tính theo thang điểm 100.
        // Ví dụ: ở đây tối đa overall percentage = 20 + 35 + 45 (= 100).
        double overallPercentage = (midTermWeightScore + finalTermWeightScore + homeWorkWeightScore);
        System.out.println("Overall percentage = " + overallPercentage);

        // Student grade min = 3.0 và grade max là 4.0. (sinh viên có thể đạt được dựa vào điểm trung bình).
        // Quy tắc tính min grade: dưới 60%: 0.0;
        double studentGrade60 = 0.0;
        // từ 60% - 74.99%: 0.7;
        double studentGrade61 = 0.7;
        // từ 75% - 84.99%: 2.0;
        double studentGrade75 = 2.0;
        // từ 85% trở lên: 3.0;
        double studentGrade85 = 3.0;
        // từ 95% trở lên: 4.0;
        double studentGrade95 = 4.0;

        if (overallPercentage < 60) {
            System.out.println("Your grade will be at least: " + studentGrade60);
            System.out.println("***** You should try to learn more *****");
        } else if (overallPercentage >= 60 && overallPercentage < 75) {
            System.out.println("Your grade will be at least: " + studentGrade61);
            System.out.println("***** You should try to learn more *****");
        } else if (overallPercentage >= 75 && overallPercentage < 85) {
            System.out.println("Your grade will be at least: " + studentGrade75);
            System.out.println("***** You should try to learn more *****");
        } else if (overallPercentage > 85) {
            System.out.println("Your grade will be at least: " + studentGrade85);
            System.out.println("***** You are a good student *****");
        } else {
            System.out.println("Your grade will be at least: " + studentGrade95);
            System.out.println("***** You are excellent student *****");
        }
    }
}
