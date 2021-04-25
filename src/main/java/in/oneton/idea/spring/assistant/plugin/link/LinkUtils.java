package in.oneton.idea.spring.assistant.plugin.link;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LinkUtils {

    public static final String PLACEHOLDER_REGEX = "^(\\$\\{)(.*)(})";
    public static final String PLACEHOLDER_REGEX_ELSEIF = "^(\"?\\$\\{)(.*)(:?)(.*)(}\"?)";

    public static final String PLACERHOLDER_PREFIX = "${";
    public static final String PLACERHOLDER_SUFIX = "}";

    public static final Pattern PLACEHOLDER_PATTERN_ELSEIF = Pattern.compile(PLACEHOLDER_REGEX_ELSEIF);

    public static Matcher getMatcherKeyToPlaceholder(@NotNull final String valueKey) {
        return PLACEHOLDER_PATTERN_ELSEIF.matcher(valueKey);
    }

    public static String getIndexMatcherKeyToPlaceholder(@NotNull final String valueKey, int index) {
        final var matcher = getMatcherKeyToPlaceholder(valueKey);
        if (matcher.matches()) {
            return matcher.group(index);
        }
        return StringUtils.EMPTY;
    }

    public static String getKeyToPlaceholder(@NotNull final String valueKey) {
        var key = getIndexMatcherKeyToPlaceholder(valueKey, 2);
        final String[] split = key.split("\\:");
        return split[0];
    }

    public static boolean isPlaceholderContainer(@NotNull final String valueKey) {
        return valueKey.matches(PLACEHOLDER_REGEX);
    }


    public static String truncateStringWithEllipsis(final String text, final int length) {
        if (text != null && text.length() > length) {
            return text.substring(0, length - 3) + "...";
        }
        return text;
    }
}
