package in.oneton.idea.spring.assistant.plugin.link;

import com.intellij.lang.properties.PropertiesImplUtil;
import com.intellij.lang.properties.psi.impl.PropertyKeyImpl;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.PsiElement;
import org.apache.commons.collections4.CollectionUtils;
import org.jetbrains.annotations.NotNull;

public class LinkPropertiesToJava extends ToJava {

    private static final Logger log = Logger.getInstance(LinkPropertiesToJava.class);

    public static PsiElement[] toJava(@NotNull PsiElement sourceElement) {
        try {
            final String configFullName = ((PropertyKeyImpl) sourceElement).getText();

            if (CollectionUtils.isNotEmpty(PropertiesImplUtil.findPropertiesByKey(sourceElement.getProject(), configFullName))) {
                return getElements(sourceElement, configFullName);
            }

        } catch (final java.lang.ClassCastException classCastException) {
            log.info("No property Key!");
        }
        return DEFAULT_RESULT;
    }

}
