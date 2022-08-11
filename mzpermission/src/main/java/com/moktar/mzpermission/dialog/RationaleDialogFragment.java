package com.moktar.mzpermission.dialog;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.List;

/**
 *  Base DialogFragment class to inherits to display a rationale dialog and show user why you need the permissions that you asked.
 *  Your DialogFragment must have a positive button to proceed request and an optional negative button to cancel request. Override
 *  {@link RationaleDialogFragment#getPositiveButton()} and {@link RationaleDialogFragment#getNegativeButton()} to implement that.
 * @author moktar
 * @since 2022/08/10
 */
public abstract class RationaleDialogFragment extends DialogFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            dismiss();
        }
    }

    /**
     * Return the instance of positive button on the DialogFragment. Your DialogFragment must have
     * a positive button to proceed request.
     * @return The instance of positive button on the DialogFragment.
     */
    abstract public @NonNull View getPositiveButton();

    /**
     * Return the instance of negative button on the DialogFragment.
     * If the permissions that you request are mandatory, your DialogFragment can have no negative button.
     * In this case, you can simply return null.
     * @return The instance of positive button on the DialogFragment, or null if your
     * DialogFragment has no negative button.
     */
    abstract public @Nullable View getNegativeButton();

    /**
     * Provide permissions to request. These permissions should be the ones that shows on your
     * RationaleDialogFragment.
     * @return Permissions list to request.
     */
    abstract public @NonNull List<String> getPermissionsToRequest();

}