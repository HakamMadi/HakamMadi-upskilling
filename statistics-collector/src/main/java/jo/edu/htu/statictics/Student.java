package jo.edu.htu.statictics;

import java.time.Year;

public class Student {
    String id;
    String name;
    Year graduationYear;
    String university;
    String major;
    Gender gender;

    private Student() {

    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Year getGraduationYear() {
        return graduationYear;
    }

    public String getUniversity() {
        return university;
    }

    public String getMajor() {
        return major;
    }

    public Gender getGender() {
        return gender;
    }

    public static class Builder {
        Student student = new Student();

        public Builder setId(String id) {
            student.id = id;
            return this;
        }

        public Builder setName(String name) {
            student.name = name;
            return this;
        }

        public Builder setGraduationYear(Year graduationYear) {
            student.graduationYear = graduationYear;
            return this;
        }

        public Builder setUniversity(String university) {
            student.university = university;
            return this;
        }

        public Builder setMajor(String major) {
            student.major = major;
            return this;
        }

        public Builder setGender(Gender gender) {
            student.gender = gender;
            return this;
        }

        public Student build() {
            return student;
        }
    }
}
