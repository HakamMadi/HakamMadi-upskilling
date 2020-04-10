package jo.edu.htu.statictics;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class StringsCollector implements StatisticsCollector<String> {

    @Override
    public Iterable<Statistic> collect(Iterable<String> cases) {
        Statistic countLowerCases = countStringLowerCase(cases);
        Statistic countUpperCases = countStringUpperCase(cases);
        Statistic countSpaces = countStringSpaces(cases);
        Statistic countNonWords = countStringNonWords(cases);

        return Arrays.asList(countLowerCases, countUpperCases, countSpaces, countNonWords);
    }

    private Statistic countStringLowerCase(Iterable<String> cases) {
        return new Statistic() {
            @Override
            public String name() {

                return "lower case letters";
            }

            @Override
            public Integer matchedCases() {
                AtomicInteger matchedCases = new AtomicInteger();
                final char[] chars = new char[300];
                cases.forEach(s -> {
                    for (int i = 0; i < s.length(); i++) {
                        chars[i] = s.charAt(i);
                        if (Character.isLowerCase(chars[i])) {
                            matchedCases.getAndIncrement();
                        }
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

    private Statistic countStringUpperCase(Iterable<String> cases) {
        return new Statistic() {
            @Override
            public String name() {
                return "upper case letters";
            }

            @Override
            public Integer matchedCases() {
                AtomicInteger matchedCases = new AtomicInteger();
                final char[] chars = new char[300];
                cases.forEach(s -> {
                    for (int i = 0; i < s.length(); i++) {
                        chars[i] = s.charAt(i);
                        if (Character.isUpperCase(chars[i])) {
                            matchedCases.getAndIncrement();
                        }
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

    private Statistic countStringSpaces(Iterable<String> cases) {
        return new Statistic() {
            @Override
            public String name() {

                return "spaces count";
            }

            @Override
            public Integer matchedCases() {
                AtomicInteger matchedCases = new AtomicInteger();
                final char[] chars = new char[300];
                cases.forEach(s -> {
                    for (int i = 0; i < s.length(); i++) {
                        chars[i] = s.charAt(i);
                        if (Character.isSpaceChar(chars[i])) {
                            matchedCases.getAndIncrement();
                        }
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

    private Statistic countStringNonWords(Iterable<String> cases) {
        return new Statistic() {
            @Override
            public String name() {

                return "non-word characters";
            }

            @Override
            public Integer matchedCases() {
                AtomicInteger matchedCases = new AtomicInteger();
                final char[] chars = new char[300];
                cases.forEach(s -> {
                    for (int i = 0; i < s.length(); i++) {
                        chars[i] = s.charAt(i);
                        if (!(Character.isLetterOrDigit(chars[i])) && (!(Character.isSpaceChar(chars[i])))) {
                            matchedCases.getAndIncrement();
                        }
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
