package com.clean.example.core.usecase.issiminaorhumanusecase;

public class IsSimianOrHumanUseCase {

    public boolean isSimian(String[] arr) {

        for (String dnaElement : arr) {

            int count = 0;
            char last = 0;

            for (int i = 0; i < dnaElement.length(); i++) {

                char item = dnaElement.charAt(i);

                if (count == 3) {
                    return true;
                }

                if (i != 0 && item == last) {
                    count++;
                } else {
                    count = 0;
                }

                last = item;
            }
        }

        return false;
    }


}
