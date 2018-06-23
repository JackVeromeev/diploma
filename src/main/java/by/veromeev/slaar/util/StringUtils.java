package by.veromeev.slaar.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

    public boolean changedToNotEmpty(String source, String newString) {
        return !org.springframework.util.StringUtils.isEmpty(newString) &&
                !newString.equals(source);
    }

}
