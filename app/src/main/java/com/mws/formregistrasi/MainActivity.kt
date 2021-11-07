package com.mws.formregistrasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        formSubmit()

    }
    private fun formSubmit() {
        val etNama = findViewById<EditText>(R.id.etNama)
        val etJurusan = findViewById<EditText>(R.id.etJurusan)
        val etNPM = findViewById<EditText>(R.id.etNPM)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val rb_male = findViewById<RadioButton>(R.id.rb_male)
        val rb_female = findViewById<RadioButton>(R.id.rb_female)
        val cbOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)
        val cbSeni = findViewById<CheckBox>(R.id.cbSeni)
        val cbBeladiri = findViewById<CheckBox>(R.id.cbBelaDiri)
        val cbRobotika = findViewById<CheckBox>(R.id.cbRobotika)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnSubmit.setOnClickListener {
            var result = ""

            var emptyField = false

            var strEtNama = etNama.text.toString()
            var strEtJurusan = etJurusan.text.toString()
            var strEtNPM = etNPM.text.toString()

            if (strEtNama.isEmpty()) {
                emptyField = true
                etNama.error = "Field Tidak Boleh Kosong"
            }else if (strEtJurusan.isEmpty()) {
                emptyField = true
                etJurusan.error = "Field Tidak Boleh Kosong"
            } else if (strEtNPM.isEmpty()) {
                emptyField = true
                etNPM.error = "Field Tidak Boleh Kosong"
            }
            result += "Nama : "+ strEtNama.toString() + "\n"
            result += "Jurusan : "+ strEtJurusan.toString() + "\n"
            result += "NPM : "+ strEtNPM.toString() + "\n"

            if (rgGender.checkedRadioButtonId != -1){
                result += "Jenis Kelamin : "

                if (rb_male.isChecked) {
                    result += "Laki - Laki\n"
                } else if (rb_female.isChecked) {
                    result += "Perempuan\n"
                }

                result += "Minat Bakat : "

                if (cbOlahraga.isChecked) {
                    result += "Olahraga\n"
                }
                if (cbBeladiri.isChecked) {
                    result += "Bela Diri\n"
                }
                if (cbSeni.isChecked) {
                    result += "Seni\n"
                }
                if (cbRobotika.isChecked) {
                    result += "Robotika"
                }

            }
            if (!emptyField) {
                val moveIntent = Intent (this@MainActivity, SecondActivity::class.java)
                moveIntent.putExtra("KEY_HASIL", result)
                startActivity(moveIntent)
            }
        }

        btnReset.setOnClickListener {

            val strEtNama = etNama.text.toString()
            val strEtJurusan = etJurusan.text.toString()
            val strEtNPM = etNPM.text.toString()

            if (strEtNama.isEmpty()) {
                Toast.makeText(this, "Masukkan Nama!!", Toast.LENGTH_SHORT).show()
            } else if (strEtJurusan.isEmpty()){
                Toast.makeText(this, "Masukkan Jurusan!!", Toast.LENGTH_SHORT).show()
            } else if (strEtNPM.isEmpty()){
                Toast.makeText(this, "Masukkan NPM!!", Toast.LENGTH_SHORT).show()
            } else {
                etNama.setText("")
                etJurusan.setText("")
                etNPM.setText("")
                rgGender.clearCheck()

                if (cbBeladiri.isChecked()){
                    cbBeladiri.setChecked(false)
                }
                if (cbOlahraga.isChecked()){
                    cbOlahraga.setChecked(false)
                }
                if (cbSeni.isChecked()) {
                    cbSeni.setChecked(false)
                }
                if (cbRobotika.isChecked()) {
                    cbRobotika.setChecked(false)
                }

            }
        }
    }


}

