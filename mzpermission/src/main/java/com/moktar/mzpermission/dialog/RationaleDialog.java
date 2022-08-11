package com.moktar.mzpermission.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 *  Base Dialog class to inherits to display a rationale dialog and show user why you need the permissions that you asked.
 *  Your dialog must have a positive button to proceed request and an optional negative button to cancel request. Override
 *  {@link RationaleDialog#getPositiveButton()} and {@link RationaleDialog#getNegativeButton()} to implement that.
 * @author moktar
 * @since 2022/08/10
 */
public abstract class RationaleDialog extends Dialog {

    public RationaleDialog(@NonNull Context context) {
        super(context);
    }

    public RationaleDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected RationaleDialog(@NonNull Context context, boolean cancelable,
                              @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    /**
     * Return the instance of positive button on the dialog. Your dialog must have
     * a positive button to proceed request.
     * @return The instance of positive button on the dialog.
     */
    abstract public @NonNull View getPositiveButton();

    /**
     * Return the instance of negative button on the dialog.
     * If the permissions that you request are mandatory, your dialog can have no negative button.
     * In this case, you can simply return null.
     * @return The instance of positive button on the dialog, or null if your dialog has no negative button.
     */
    abstract public @Nullable View getNegativeButton();

    /**
     * Provide permissions to request. These permissions should be the ones that shows on your rationale dialog.
     * @return Permissions list to request.
     */
    abstract public @NonNull List<String> getPermissionsToRequest();

}