package id.phephen.toyotatest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.phephen.toyotatest.databinding.ActivityMainBinding
import id.phephen.toyotatest.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var btnKirim: Button
    private lateinit var etName: EditText
    private lateinit var viewModel: ProfileViewModel
    private var input: String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ProfileViewModel::class.java)

        etName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                input = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        onPostData()
        onPostDataSuccess()
    }

    private fun initView() {
        btnKirim = binding.btnKirim
        etName = binding.etName
    }

    private fun onPostData() {
        btnKirim.setOnClickListener {
            viewModel.postData(input)
        }
    }

    private fun onPostDataSuccess() {
        viewModel.onPostDataSuccess.observe(this, Observer {
            Toast.makeText(this, "data Successfully send " + it.name, Toast.LENGTH_SHORT).show()
        })
    }
}