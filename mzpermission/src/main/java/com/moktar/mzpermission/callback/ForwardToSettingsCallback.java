package com.moktar.mzpermission.callback;

import androidx.annotation.NonNull;

import com.moktar.mzpermission.request.ForwardScope;
import com.moktar.mzpermission.request.PermissionBuilder;

import java.util.List;

/**
 * Callback for {@link PermissionBuilder#onForwardToSettings(ForwardToSettingsCallback)} method.
 *
 * @author moktar
 * @since 2022/08/10
 */
public interface ForwardToSettingsCallback {

    /**
     * Called when you should tell user to allow these permissions in settings.
     * @param scope
     *          Scope to show rationale dialog.
     * @param deniedList
     *          Permissions that should allow in settings.
     */
    void onForwardToSettings(@NonNull ForwardScope scope, @NonNull List<String> deniedList);

}