package com.example.dialog_app

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {

    private val catNames = arrayOf("Васька", "Рыжик", "Мурзик")
    private val checkedItems = booleanArrayOf(false, true, false)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Выберите котов")
                .setMultiChoiceItems(catNames, checkedItems) {
                        dialog, which, isChecked ->
                    checkedItems[which] = isChecked
                    val name = catNames[which] // Get the clicked item
                    Toast.makeText(activity, name, Toast.LENGTH_LONG).show()
                }
                .setPositiveButton("Готово"
                ) {
                        dialog, id ->
                    // User clicked OK, so save the selectedItems results somewhere
                    for (i in catNames.indices) {
                        val checked = checkedItems[i]
                        if (checked) {
                            Log.i("Dialog", catNames[i])
                        }
                    }
                }
                .setNegativeButton("Отмена") {
                        dialog, _ ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}