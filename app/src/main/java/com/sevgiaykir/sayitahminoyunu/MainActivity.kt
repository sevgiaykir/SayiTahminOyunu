package com.sevgiaykir.sayitahminoyunu

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sevgiaykir.sayitahminoyunu.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var skor=100
        binding.textViewSkor.text="Skorunuz: 100"

        val randomSayi= (1..100).random()
        Log.e("Rastgele Sayı : ", randomSayi.toString())
        binding.buttonTahminEt.setOnClickListener{
            val tahmin=binding.InputEditTextSayi.text.toString().toInt()
            if(InputEditTextSayi!=null){
                if(tahmin<randomSayi){
                    binding.textViewUyari.text= "Lütfen daha büyük bir sayı deneyiniz"
                    skor--
                }
                else if(tahmin>randomSayi){
                    binding.textViewUyari.text= "Lütfen daha küçük bir sayı deneyiniz"
                    skor--
                }
                else{
                    binding.textViewUyari.text= "Tebrikler puanınız: " +skor
                    binding.InputEditTextSayi.visibility=View.INVISIBLE
                }
                binding.textViewSkor.text="Skorunuz: "+skor
            }
            else{
                Toast.makeText(this, "Lütfen bir tahmin giriniz", Toast.LENGTH_SHORT).show()
            }

            if(skor==0){
                binding.textViewUyari.text= "Tahmin hakkınız bitti..."
                binding.buttonTahminEt.setEnabled(false)
            }

            //Toast.makeText(this, "Butona basıldı", Toast.LENGTH_LONG).show()

        }


    }
}