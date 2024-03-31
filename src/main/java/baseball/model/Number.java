package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Number {

    private final List<Integer> number;

    public Number(String inputNumber) {
        validation(inputNumber);
        this.number = stringToList(inputNumber);
    }

    public List<Integer> getNumber() {
        return number;
    }

    private void validation(String inputNumber) {
        if (!isNaturalNumber(inputNumber)) {
            throw new IllegalArgumentException("1부터 9까지의 자연수를 입력해주세요.");
        }
        if (!isThreeDigitNumber(inputNumber)) {
            throw new IllegalArgumentException("3자리수를 입력해주세요.");
        }
        if (!isDuplicate(inputNumber)) {
            throw new IllegalArgumentException("중복되지 않은 수를 입력해주세요.");
        }
    }

    private boolean isNaturalNumber(String inputNumber) {
        for (char c : inputNumber.toCharArray()) {
            if (c < '1' || c > '9') {
                return false;
            }
        }

        return true;
    }

    private boolean isThreeDigitNumber(String inputNumber) {
        return inputNumber.length() == 3;
    }

    private boolean isDuplicate(String inputNumber) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            set.add(inputNumber.charAt(i));
        }

        return set.size() == 3;
    }

    private List<Integer> stringToList(String inputNumber) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < inputNumber.length(); i++) {
            list.add((int) inputNumber.charAt(i));
        }

        return list;
    }
}