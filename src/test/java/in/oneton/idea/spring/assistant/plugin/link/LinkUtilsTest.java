package in.oneton.idea.spring.assistant.plugin.link;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkUtilsTest {

    @Test
    void getKeyToPlaceholder() {
        Assertions.assertEquals("key.value", LinkUtils.getKeyToPlaceholder("${key.value}"));
        Assertions.assertEquals("key.value", LinkUtils.getKeyToPlaceholder("\"${key.value}\""));
        Assertions.assertEquals("key.value", LinkUtils.getKeyToPlaceholder("${key.value:test}"));
        Assertions.assertEquals("key.value", LinkUtils.getKeyToPlaceholder("\"${key.value:test}\""));
    }

}