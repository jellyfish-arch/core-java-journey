package Day07;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        String[] words = new String[10];
        words[5] = "Optional is awesome";

        Optional<String> checkNull = Optional.ofNullable(words[5]);
        
        if (checkNull.isPresent()) {
            System.out.println("Word at index 5: " + words[5].toUpperCase());
        } else {
            System.out.println("Word is null");
        }

        // using ifPresent
        checkNull.ifPresent(word -> System.out.println("Using ifPresent: " + word));

        // using orElse
        Optional<String> emptyOptional = Optional.ofNullable(words[0]);
        String defaultValue = emptyOptional.orElse("Default Value");
        System.out.println("Value of emptyOptional: " + defaultValue);
    }
}
