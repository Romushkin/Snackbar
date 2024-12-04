package com.example.checkboxsnackbar

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var inputTextET: EditText
    private lateinit var outputTextTV: TextView

    private lateinit var saveDataBTN: Button
    private lateinit var deleteDataBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputTextET = findViewById(R.id.inputTextET)
        outputTextTV = findViewById(R.id.outputTextTV)
        saveDataBTN = findViewById(R.id.saveDataBTN)
        deleteDataBTN = findViewById(R.id.deleteDataBTN)
        saveDataBTN.setOnClickListener(this)
        deleteDataBTN.setOnClickListener(this)
    }

    @SuppressLint("ShowToast", "SetTextI18n")
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.saveDataBTN -> outputTextTV.text = inputTextET.text
            R.id.deleteDataBTN -> Snackbar
                .make(
                    v,
                    "Подтвердите удаление",
                    Snackbar.LENGTH_LONG
                )
                .setAction("Удалить") {
                    outputTextTV.text = " "
                    Snackbar.make(v,"Данные удалены", Snackbar.LENGTH_LONG).show()
                }.show()
        }
    }

}
