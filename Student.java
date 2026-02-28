class Student {
    private static int counter = 1000;

    String regNo;
    String name;
    int physics, chemistry, maths, biology;

    Student(String name, int p, int c, int m, int b) {
        counter++;
        this.regNo = "SCI" + counter;
        this.name = name;
        physics = p;
        chemistry = c;
        maths = m;
        biology = b;
    }

    int total() { return physics + chemistry + maths + biology; }

    double percentage() { return total() / 4.0; }

    String grade() {
        if (!isPass()) return "FAIL";
        double per = percentage();
        if (per >= 90) return "A+";
        else if (per >= 80) return "A";
        else if (per >= 70) return "B";
        else if (per >= 60) return "C";
        else return "D";
    }

    boolean isPass() {
        return physics >= 35 && chemistry >= 35 && maths >= 35 && biology >= 35;
    }

    void printMarkscard() {
        System.out.println("\n================== MARKS CARD ==================");
        System.out.printf("Register No: %s\n", regNo);
        System.out.printf("Name       : %s\n", name);
        System.out.printf("Physics    : %d\n", physics);
        System.out.printf("Chemistry  : %d\n", chemistry);
        System.out.printf("Maths      : %d\n", maths);
        System.out.printf("Biology    : %d\n", biology);
        System.out.printf("Total      : %d\n", total());
        System.out.printf("Percentage : %.2f\n", percentage());
        System.out.printf("Grade      : %s\n", grade());
        System.out.println("===============================================\n");
    }
}