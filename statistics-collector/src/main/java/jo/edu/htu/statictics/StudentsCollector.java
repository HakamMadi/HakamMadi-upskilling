package jo.edu.htu.statictics;

import java.time.Year;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class StudentsCollector implements StatisticsCollector<Student> {
    @Override
    public Iterable<Statistic> collect(Iterable<Student> cases) {
        Statistic majorCISStatistic = getCISMajor(cases);
        Statistic graduationYearAfter = getGraduationYearAfter(cases);
        Statistic majorCSStatistic = getCSMajor(cases);
        Statistic graduationYearBefore = getGraduationYearBefore(cases);
        Statistic maleStudents = getMaleStudents(cases);
        Statistic femaleStudents = getFemaleStudents(cases);


        return Arrays.asList
                (majorCISStatistic, graduationYearAfter, majorCSStatistic, graduationYearBefore, maleStudents, femaleStudents);
    }

    private Statistic getCISMajor(Iterable<Student> cases) {
        return new Statistic() {
            @Override
            public String name() {
                return "CIS major";
            }

            @Override
            public Integer matchedCases() {
                AtomicInteger matchedCases = new AtomicInteger();
                cases.forEach(student -> {
                    if (student.getMajor().equals("CIS")) {
                        matchedCases.getAndIncrement();
                    }
                });
                return matchedCases.get();
            }

            @Override
            public int compareTo(Statistic o) {
                return 0;
            }
        };
    }

    private Statistic getCSMajor(Iterable<Student> cases) {
        return new Statistic() {
            AtomicReference<String> major = new AtomicReference<>("");

            @Override
            public String name() {
                return "Computer Science major";
            }

            @Override
            public Integer matchedCases() {
                AtomicInteger matchedCases = new AtomicInteger();
                cases.forEach(student -> {
                    if (student.getMajor().equals("Computer Science")) {
                        matchedCases.getAndIncrement();
                    }
                });
                return matchedCases.get();
            }

            @Override
            public int compareTo(Statistic o) {
                return 0;
            }
        };
    }

    private Statistic getGraduationYearAfter(Iterable<Student> cases) {
        return new Statistic() {
            @Override
            public String name() {
                return "graduation year > 2016";
            }

            @Override
            public Integer matchedCases() {
                AtomicInteger matchedCases = new AtomicInteger();
                Year year = Year.of(2016);
                cases.forEach(student -> {
                    if (student.getGraduationYear().isAfter(year)) {
                        matchedCases.getAndIncrement();
                    }
                });
                return matchedCases.get();
            }

            @Override
            public int compareTo(Statistic o) {
                return 0;
            }
        };
    }

    private Statistic getGraduationYearBefore(Iterable<Student> cases) {
        return new Statistic() {
            @Override
            public String name() {
                return "graduation year <= 2016";
            }

            @Override
            public Integer matchedCases() {
                AtomicInteger matchedCases = new AtomicInteger();
                Year year = Year.of(2016);
                cases.forEach(student -> {
                    if (student.getGraduationYear().isBefore(year) || student.getGraduationYear().equals(year)) {
                        matchedCases.getAndIncrement();
                    }
                });
                return matchedCases.get();
            }

            @Override
            public int compareTo(Statistic o) {
                return 0;
            }
        };
    }

    private Statistic getMaleStudents(Iterable<Student> cases) {
        return new Statistic() {
            @Override
            public String name() {
                return "Males";
            }

            @Override
            public Integer matchedCases() {
                AtomicInteger matchedCases = new AtomicInteger();
                Year year = Year.of(2016);
                cases.forEach(student -> {
                    if (student.getGender().equals(Gender.MALE)) {
                        matchedCases.getAndIncrement();
                    }
                });
                return matchedCases.get();
            }

            @Override
            public int compareTo(Statistic o) {
                return 0;
            }
        };
    }

    private Statistic getFemaleStudents(Iterable<Student> cases) {
        return new Statistic() {
            @Override
            public String name() {
                return "Females";
            }

            @Override
            public Integer matchedCases() {
                AtomicInteger matchedCases = new AtomicInteger();
                Year year = Year.of(2016);
                cases.forEach(student -> {
                    if (student.getGender().equals(Gender.FEMALE)) {
                        matchedCases.getAndIncrement();
                    }
                });
                return matchedCases.get();
            }

            @Override
            public int compareTo(Statistic o) {
                return 0;
            }
        };
    }


}