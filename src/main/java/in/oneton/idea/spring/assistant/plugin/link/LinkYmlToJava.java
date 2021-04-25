package in.oneton.idea.spring.assistant.plugin.link;

import com.intellij.openapi.util.Pair;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.yaml.YAMLUtil;
import org.jetbrains.yaml.psi.YAMLFile;
import org.jetbrains.yaml.psi.YAMLPsiElement;
import org.jetbrains.yaml.psi.impl.YAMLPlainTextImpl;

import java.util.Objects;

public final class LinkYmlToJava extends ToJava {


    public static PsiElement[] toJava(@NotNull PsiElement sourceElement) {
        String configFullName = YAMLUtil.getConfigFullName(PsiTreeUtil.getParentOfType(sourceElement, YAMLPsiElement.class));
        Pair<PsiElement, String> value = YAMLUtil.getValue((YAMLFile) sourceElement.getContainingFile(), configFullName.split("\\."));

        if (Objects.isNull(value) || !(value.getFirst() instanceof YAMLPlainTextImpl)) {
            return DEFAULT_RESULT;
        }

        return getElements(sourceElement, configFullName);
    }

}
