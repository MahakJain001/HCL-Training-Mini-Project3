package MiniProject3;

class Student {
    int eno;
    String name;
    String branch;
    int sem;
    double percentage;

    public Student(int eno, String name, String branch, int sem, double percentage) {
        this.eno = eno;
        this.name = name;
        this.branch = branch;
        this.sem = sem;
        this.percentage = percentage;
    }

    public void display() {
        System.out.println(eno + "  " + name + "  " + branch + "  " + sem + "  " + percentage);
    }
}
