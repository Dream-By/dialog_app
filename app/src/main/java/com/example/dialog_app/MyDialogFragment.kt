package com.example.dialog_app

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Выбор есть всегда!")
                .setMessage("Покормите кота!")
                .setCancelable(true)
                //.setIcon(R.drawable.hungrycat)
                .setPositiveButton("Вкусная пища") {dialog, id ->
                        Toast.makeText(activity,"Вы сделали правильный выбор",Toast.LENGTH_LONG).show()
                }
                .setNegativeButton("Здоровая Пища",DialogInterface.OnClickListener {dialog, id ->
                    Toast.makeText(activity,"Возможно вы правы",Toast.LENGTH_LONG).show()
                })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}