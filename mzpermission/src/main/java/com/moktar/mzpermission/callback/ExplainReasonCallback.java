package com.moktar.mzpermission.callback;

import androidx.annotation.NonNull;

import com.moktar.mzpermission.request.ExplainScope;
import com.moktar.mzpermission.request.PermissionBuilder;

import java.util.List;

/**
 * Callback for {@link PermissionBuilder#onExplainRequestReason(ExplainReasonCallback)} method.
 *
 * @author moktar
 * @since 2022/08/10
 */
public interface ExplainReasonCallback {

    /**
     * Called when you should explain why you need these permissions.
     * @param scope
     *          Scope to show rationale dialog.
     * @param deniedList
     *          Permissions that you should explain.
     */
    void onExplainReason(@NonNull ExplainScope scope, @NonNull List<String> deniedList);

}
