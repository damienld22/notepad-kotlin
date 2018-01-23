package damien.com.notepad

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment

/**
 * Created by damien on 23/01/18.
 */
class ConfirmDeleteNoteDialogFragment (val noteTitle: String = ""): DialogFragment() {

    interface ConfirmDeleteDialogListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    var listener: ConfirmDeleteDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Etes vous sur ? ($noteTitle)")
                .setPositiveButton("Supprimer", DialogInterface.OnClickListener{ dialog, i ->  listener?.onDialogPositiveClick()})
                .setNegativeButton("Annuler", DialogInterface.OnClickListener{ dialog, i ->  listener?.onDialogNegativeClick()})

        return builder.create()

    }
}
